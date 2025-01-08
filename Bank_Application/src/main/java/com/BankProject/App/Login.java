package com.BankProject.App;

import java.io.IOException;
import java.io.PrintWriter;

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
@WebServlet("/login")

public class Login extends HttpServlet {
	protected void doPost(HttpServletRequest req,HttpServletResponse resp)throws ServletException , IOException {
		HttpSession session=req.getSession();
		
		String Accno=req.getParameter("accountNumber");
		String Pin=req.getParameter("pin");
		
		PrintWriter out=resp.getWriter();
		
		long accno=Long.parseLong(Accno);
		 int pin = Integer.parseInt(Pin);
		
		
		CustomerDAO cdao=new CustomerDAOImpl();
		Customer c=cdao.getCustomer(accno, pin);
		
		if(c!=null) {
			
			session.setAttribute("customer", c);
			RequestDispatcher rd=req.getRequestDispatcher("Dashboard.jsp");
			rd.forward(req, resp);
		}else {
			req.setAttribute("fail", "Failed to Login");
			RequestDispatcher rd=req.getRequestDispatcher("Login.jsp");
			rd.forward(req, resp);
		}
		
	}

}
