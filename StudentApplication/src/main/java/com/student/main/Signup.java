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

@WebServlet("/signup")
public class Signup extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
       

        // Collect data from user
        String name = req.getParameter("name");
        String phoneNumber = req.getParameter("phone");
        String mailId = req.getParameter("mail");
        String branch = req.getParameter("branch");
        String loc = req.getParameter("loc");
        String password = req.getParameter("password");
        String confirmPassword = req.getParameter("confirm");

       

       
            long phone = Long.parseLong(phoneNumber);
            PrintWriter out = resp.getWriter();

            Student s = new Student();
            StudentDAO sdao = new StudentDAOImpl();
            // Validate password match
            if (password.equals(confirmPassword)) {
                // Populate Student object
                
                s.setName(name);
                s.setPhone(phone);
                s.setMail(mailId);
                s.setBranch(branch);
                s.setLocation(loc);
                s.setPass(password);

                // Insert Student using DAO
              
                boolean result = sdao.insertStudent(s);

                if (result) {
                	req.setAttribute("success", "sighup successfull");
                	RequestDispatcher rd=req.getRequestDispatcher("Signup.jsp");
                	rd.forward(req, resp);
                	
                }else {
                	req.setAttribute("fail", "failed to signup");
                	RequestDispatcher rd=req.getRequestDispatcher("Signup.jsp");
                	rd.forward(req, resp);
                	
                }
    
       }
}
}
