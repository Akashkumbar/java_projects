package com.BankProject.App;

import java.io.IOException;

import com.BankProject.DAO.CustomerDAOImpl;
import com.BankProject.DAO.TransactionDAOImpl;
import com.BankProject.dto.Customer;
import com.BankProject.dto.Transaction;
import com.BankProject.dto.TransactionID;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/delete")
public class DeletAccount extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String accnoStr = req.getParameter("acc");
        String amountsStr = req.getParameter("amt");

        if (accnoStr == null || amountsStr == null) {
            req.setAttribute("failure", "Account number or amount is missing.");
            RequestDispatcher rd = req.getRequestDispatcher("Admin.jsp");
            rd.forward(req, resp);
            return;
        }

        long accno = Long.parseLong(accnoStr);
        double amount = Double.parseDouble(amountsStr);

        HttpSession session = req.getSession(false);
        if (session == null) {
            req.setAttribute("failure", "Session expired. Please log in again.");
            RequestDispatcher rd = req.getRequestDispatcher("Admin.jsp");
            rd.forward(req, resp);
            return;
        }

        Customer admin = (Customer) session.getAttribute("customer");
        CustomerDAOImpl cdao = new CustomerDAOImpl();
        TransactionDAOImpl tdao = new TransactionDAOImpl();
        Customer c = cdao.getCustomer(accno);

        // Ensure admin does not delete their own account
        if (admin.getAccno() == c.getAccno()) {
            req.setAttribute("failure", "Failed to delete the admin account.");
            RequestDispatcher rd = req.getRequestDispatcher("Admin.jsp");
            rd.forward(req, resp);
            return;
        }

        if (accno == c.getAccno()) {
            // Debit from customer and credit to admin
            c.setBal(c.getBal() - amount);
            boolean s_res = cdao.updateCustomer(c);
            if (s_res) {
                Transaction t1 = new Transaction();
                t1.setTransactionId(TransactionID.generateTransactionId());
                t1.setUser(c.getAccno());
                t1.setRec_acc(admin.getAccno());
                t1.setTransaction("DEBITED");
                t1.setBalance(c.getBal());
                t1.setAmount(amount);
                boolean res1 = tdao.insertTransaction(t1);

                if (res1) {
                    admin.setBal(admin.getBal() + amount);
                    boolean r_res = cdao.updateCustomer(admin);
                    if (r_res) {
                        Transaction t2 = new Transaction();
                        t2.setTransactionId(TransactionID.generateTransactionId());
                        t2.setUser(admin.getAccno());
                        t2.setRec_acc(c.getAccno());
                        t2.setTransaction("CREDITED");
                        t2.setBalance(admin.getBal());
                        t2.setAmount(amount);
                        boolean res2 = tdao.insertTransaction(t2);
                        if (!res2) {
                            req.setAttribute("failure", "Failed to log transaction for admin.");
                        }
                    } else {
                        req.setAttribute("failure", "Failed to update admin balance.");
                    }
                } else {
                    req.setAttribute("failure", "Failed to log transaction for customer.");
                }

                req.setAttribute("success", "Amount transferred successfully.");
            } else {
                req.setAttribute("failure", "Failed to debit customer balance.");
            }

            // Delete customer account
            boolean res = cdao.deleteCustomer(c);
            if (res) {
                req.setAttribute("success", "Successfully deleted account.");
            } else {
                req.setAttribute("failure", "Failed to delete the account.");
            }

            RequestDispatcher rd = req.getRequestDispatcher("Admin.jsp");
            rd.forward(req, resp);
        } else {
            req.setAttribute("failure", "Failed to transfer amount, account mismatch.");
            RequestDispatcher rd = req.getRequestDispatcher("Admin.jsp");
            rd.forward(req, resp);
        }
    }
}
