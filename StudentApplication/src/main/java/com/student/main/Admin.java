package com.student.main;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

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

@WebServlet("/admin")

public class Admin extends HttpServlet {
	 protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	       

	        // Collect data from user
		 HttpSession session=req.getSession(false);
		 
		    String Id = req.getParameter("ID");
		    String name = req.getParameter("name");
	        String phoneNumber = req.getParameter("phone");
	        String mailId = req.getParameter("mail");
	        String branch = req.getParameter("branch");
	        String loc = req.getParameter("loc");
	        String Password = req.getParameter("password");
	        String Date = req.getParameter("Date");
	      
	       
	            long phone = Long.parseLong(phoneNumber);
	            PrintWriter out = resp.getWriter();

	            Student s1=(Student)session.getAttribute("student");
	          
	            
	            
	            Student s = new Student();
	            StudentDAO sdao = new StudentDAOImpl();
	            ArrayList<Student> students=(ArrayList<Student>)sdao.getStudent();

	            Iterator<Student> itr=students.iterator();
	           
	           
	            while (itr.hasNext()) { 
	                Student s11 = itr.next(); // Correctly assign the next Student object
	                System.out.println("ID: " + s11.getId());
	                System.out.println("Name: " + s11.getName());
	                System.out.println("Phone: " + s11.getPhone());
	                System.out.println("Mail: " + s11.getMail());
	                System.out.println("Branch: " + s11.getBranch());
	                System.out.println("Location: " + s11.getLocation());
	                System.out.println("Password: " + s11.getPass());
	                System.out.println("Date: " + s11.getDate());
	            }
	    
	       }
	}


