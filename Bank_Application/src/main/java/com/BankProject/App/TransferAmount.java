package com.BankProject.App;

import com.BankProject.DAO.CustomerDAO;
import com.BankProject.DAO.CustomerDAOImpl;
import com.BankProject.DAO.TransactionDAO;
import com.BankProject.DAO.TransactionDAOImpl;
import com.BankProject.dto.Customer;
import com.BankProject.dto.Transaction;
import com.BankProject.dto.TransactionID;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

@WebServlet("/transferAmount")
public class TransferAmount extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        resp.setContentType("text/html");
        HttpSession session = req.getSession(false);

        // Validate session
        if (session == null || session.getAttribute("customer") == null) {
            resp.getWriter().println("Session expired. Please log in again.");
            return;
        }

        Customer sender = (Customer) session.getAttribute("customer");

        try {
            // Parse input parameters
            double amount = Double.parseDouble(req.getParameter("amount"));
            long receiverAccNo = Long.parseLong(req.getParameter("account"));
            int pin = Integer.parseInt(req.getParameter("pin"));

            // Validate PIN
            if (pin != sender.getPin()) {
                resp.getWriter().println("Invalid PIN. Transaction failed.");
                return;
            }

            // Validate amount
            if (amount <= 0 || sender.getBal() < amount) {
                resp.getWriter().println("Insufficient balance or invalid amount.");
                return;
            }

            // Fetch receiver details
            CustomerDAO customerDAO = new CustomerDAOImpl();
            Customer receiver = customerDAO.getCustomer(receiverAccNo);

            if (receiver == null || receiver.getAccno() == sender.getAccno()) {
                resp.getWriter().println("Invalid beneficiary account number.");
                return;
            }

            // Update balances
            sender.setBal(sender.getBal() - amount);
            receiver.setBal(receiver.getBal() + amount);

            boolean senderUpdated = customerDAO.updateCustomer(sender);
            boolean receiverUpdated = customerDAO.updateCustomer(receiver);

            if (senderUpdated && receiverUpdated) {
                // Record transactions
                TransactionDAO transactionDAO = new TransactionDAOImpl();

                Transaction senderTransaction = new Transaction();
                senderTransaction.setTransactionId(TransactionID.generateTransactionId());
                senderTransaction.setUser(sender.getAccno());
                senderTransaction.setRec_acc(receiver.getAccno());
                senderTransaction.setTransaction("DEBITED");
                senderTransaction.setAmount(amount);
                senderTransaction.setBalance(sender.getBal());
                transactionDAO.insertTransaction(senderTransaction);

                Transaction receiverTransaction = new Transaction();
                receiverTransaction.setTransactionId(senderTransaction.getTransactionId());
                receiverTransaction.setUser(receiver.getAccno());
                receiverTransaction.setRec_acc(sender.getAccno());
                receiverTransaction.setTransaction("CREDITED");
                receiverTransaction.setAmount(amount);
                receiverTransaction.setBalance(receiver.getBal());
                transactionDAO.insertTransaction(receiverTransaction);

                resp.getWriter().println("Transaction successful!");
            } else {
                resp.getWriter().println("Transaction failed. Please try again.");
            }
        } catch (NumberFormatException e) {
            resp.getWriter().println("Invalid input. Please check your details.");
        }
    }
}
