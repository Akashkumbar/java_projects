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

@WebServlet("/updateAcc")

public class UpdateAcc extends HttpServlet {
	 protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	       

	        // Collect data from user
		 HttpSession session=req.getSession(false);
		 
	        String name = req.getParameter("name");
	        String phoneNumber = req.getParameter("phone");
	        String mailId = req.getParameter("mail");
	        String branch = req.getParameter("branch");
	        String loc = req.getParameter("loc");
	      
	       
	            long phone = Long.parseLong(phoneNumber);
	            PrintWriter out = resp.getWriter();

	            Student s = new Student();
	            StudentDAO sdao = new StudentDAOImpl();
	            Student s1=(Student)session.getAttribute("student");
	            // Validate password match
	            if (s1!=null) {
	                // Populate Student object
	                
	                s1.setName(name);
	                s1.setPhone(phone);
	                s1.setMail(mailId);
	                s1.setBranch(branch);
	                s1.setLocation(loc);
	              

	                // Insert Student using DAO
	              
	                boolean result = sdao.updateStudent(s1);

	                if (result) {
	                	req.setAttribute("success", "Update successfull");
	                	RequestDispatcher rd=req.getRequestDispatcher("Login.jsp");
	                	rd.forward(req, resp);
	                	
	                }else {
	                	req.setAttribute("fail", "Failed to Update");
	                	RequestDispatcher rd=req.getRequestDispatcher("Login.jsp");
	                	rd.forward(req, resp);
	                	
	                }
	    
	       }
	}

}
