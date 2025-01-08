package com.BankProject.App;

import java.io.IOException;
import com.BankProject.DAO.CustomerDAO;
import com.BankProject.DAO.CustomerDAOImpl;
import com.BankProject.dto.Customer;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/update")
public class UpdateAccount extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        HttpSession session = req.getSession(false);
        if (session == null || session.getAttribute("customer") == null) {
            req.setAttribute("failure", "Session expired. Please log in again.");
            RequestDispatcher rd = req.getRequestDispatcher("Login.jsp");
            rd.forward(req, resp);
            return;
        }

        String accno = req.getParameter("accountNo");
        String phoneno = req.getParameter("phoneNo");
        String mail = req.getParameter("email");
        String pins = req.getParameter("pin");
        String name = req.getParameter("name");

        try {
            long acc = Long.parseLong(accno);
            long phone = Long.parseLong(phoneno);
            int pin = Integer.parseInt(pins);

            Customer c = (Customer) session.getAttribute("customer");

            if (acc == c.getAccno()) {
                c.setPhone(phone);
                c.setMail(mail);
                c.setPin(pin);
                c.setName(name);

                CustomerDAO cdao = new CustomerDAOImpl();
                boolean res = cdao.updateCustomer(c);

                if (res) {
                    req.setAttribute("success", "Account updated successfully.");
                } else {
                    req.setAttribute("failure", "Failed to update account.");
                }

                RequestDispatcher rd = req.getRequestDispatcher("UpdateAcc.jsp");
                rd.forward(req, resp);
            } else {
                req.setAttribute("failure", "Account number mismatch.");
                RequestDispatcher rd = req.getRequestDispatcher("UpdateAcc.jsp");
                rd.forward(req, resp);
            }
        } catch (NumberFormatException e) {
            req.setAttribute("failure", "Invalid input format.");
            RequestDispatcher rd = req.getRequestDispatcher("UpdateAcc.jsp");
            rd.forward(req, resp);
        }
    }
}
