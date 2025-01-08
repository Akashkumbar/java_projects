package com.BankProject.App;

import com.BankProject.DAO.CustomerDAO;
import com.BankProject.DAO.CustomerDAOImpl;
import com.BankProject.dto.Customer;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/sigup")
public class Sigup extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        // Set content type for response

        try {
            // Retrieve form parameters
            String name = req.getParameter("name");
            String phoneString = req.getParameter("phone");
            String mail = req.getParameter("mail");
            String pinString = req.getParameter("pin");
            String confirmPinString = req.getParameter("confirmPin");

            // Convert phone and PIN to numeric values
            long phone = Long.parseLong(phoneString);
            int pin = Integer.parseInt(pinString);
            int confirmPin = Integer.parseInt(confirmPinString);

            // Check if PINs match
            if (pin != confirmPin) {
                resp.getWriter().write("<div style='text-align:center; color:red; font-weight:bold;'>"
                    + "PINs do not match. Please try again.</div>");
                return;
            }

            // Create a new Customer object
            Customer customer = new Customer();
            customer.setName(name);
            customer.setPhone(phone);
            customer.setMail(mail);
            customer.setPin(pin);

            // Insert the customer using DAO
            CustomerDAO cdao = new CustomerDAOImpl();
            boolean isInserted = cdao.insertCustomer(customer);

            // Show message based on the result
            if (isInserted) {
                resp.getWriter().write("<div style='text-align:center; color:green; font-weight:bold;'>"
                    + "Sign-up successful! Welcome, " + name + ".</div>");
            } else {
                resp.getWriter().write("<div style='text-align:center; color:red; font-weight:bold;'>"
                    + "Sign-up failed. Please try again later.</div>");
            }
        } catch (NumberFormatException e) {
            e.printStackTrace();
            resp.getWriter().write("<div style='text-align:center; color:red; font-weight:bold;'>"
                + "Invalid input. Please enter valid data.</div>");
        } catch (Exception e) {
            e.printStackTrace();
            resp.getWriter().write("<div style='text-align:center; color:red; font-weight:bold;'>"
                + "An error occurred. Please try again.</div>");
        }
    }
}
