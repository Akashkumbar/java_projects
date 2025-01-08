package com.student.main;

import java.io.IOException;
import java.io.PrintWriter;

import com.student.dao.StudentDAO;
import com.student.dao.StudentDAOImpl;
import com.student.dto.Student;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/login")
public class Login extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    	
    	HttpSession session=req.getSession();

        // Retrieve parameters from the request
        String mailId = req.getParameter("mail");
        String password = req.getParameter("password");

        // Get the PrintWriter for sending response
        PrintWriter out = resp.getWriter();

        // JDBC Implementation
        StudentDAO sdao = new StudentDAOImpl();
        Student s = sdao.getStudent(mailId, password);

        // Check if student exists and validate credentials
        if (s != null && password.equals(s.getPass())) {
          
        	session.setAttribute("student",s);
        	RequestDispatcher rd=req.getRequestDispatcher("Dashboard.jsp");
        	rd.forward(req, resp);
        	
        	
        } else {
        	 req.setAttribute("fail", "failed to login");
        	 RequestDispatcher rd=req.getRequestDispatcher("Login.jsp");
        	 rd.forward(req, resp);
        }

     
    }
}
