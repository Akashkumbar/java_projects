package com.BankProject.App;
import java.io.IOException;
import java.util.*;

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

@WebServlet("/reset")
public class ResetPin extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        String mail = req.getParameter("email");
        String acc = req.getParameter("accountNo");
        long accno = Long.parseLong(acc);
        String phonenum = req.getParameter("phone");
        long phone = Long.parseLong(phonenum);
        String pin = req.getParameter("newPin");
        int pins = Integer.parseInt(pin);
        String conpin = req.getParameter("confirmPin");
        int conpins = Integer.parseInt(conpin);

        Customer c = (Customer) session.getAttribute("customer");
        CustomerDAO cdao = new CustomerDAOImpl();

        if (pins == conpins) {
            c.setPin(pins);
            boolean res = cdao.updateCustomer(c);
            if (res) {
                req.setAttribute("success", "Pin reseted successfully.");
                RequestDispatcher rd = req.getRequestDispatcher("ResetPin.jsp");
                rd.forward(req, resp);
            } else {
                req.setAttribute("failure", "Pin reset failed.");
                RequestDispatcher rd = req.getRequestDispatcher("ResetPin.jsp");
                rd.forward(req, resp);
            }
        } else {
            req.setAttribute("failure", "PIN and Confirm PIN do not match.");
            RequestDispatcher rd = req.getRequestDispatcher("ResetPin.jsp");
            rd.forward(req, resp);
        }
    }
}
