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

@WebServlet("/deposit")
public class Deposit extends HttpServlet {

    protected void doPost(HttpServletRequest req, HttpServletResponse resp) {
        try {
            HttpSession session = req.getSession(false);
            Customer c = (Customer) session.getAttribute("customer");

            double amount = Double.parseDouble(req.getParameter("amount"));
            c.setBal(c.getBal() + amount);

            CustomerDAO cdao = new CustomerDAOImpl();
            boolean res = cdao.updateCustomer(c);

            if (res) {
                TransactionDAO tdao = new TransactionDAOImpl();
                Transaction t = new Transaction();

                t.setTransactionId(TransactionID.generateTransactionId());
                t.setUser(c.getAccno());
                t.setRec_acc(c.getAccno());
                t.setTransaction("CREDITED");
                t.setAmount(amount);
                t.setBalance(c.getBal());

                if (tdao.insertTransaction(t)) {
                    resp.getWriter().println("Amount of Rs." + amount + " deposited successfully!");
                    resp.getWriter().println("Updated balance: Rs." + c.getBal());
                } else {
                    resp.getWriter().println("Transaction failed. Try again later.");
                }
            } else {
                resp.getWriter().println("Failed to update customer balance. Try again later.");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
