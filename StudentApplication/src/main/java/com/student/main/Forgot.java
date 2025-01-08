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
@WebServlet("/forgot")
public class Forgot extends HttpServlet{
@Override
protected void doPost(HttpServletRequest req,
HttpServletResponse resp) throws ServletException, IOException {
 //collect the data from user
 String phonenumber=req.getParameter("phone");
 String mail=req.getParameter("mail");
 String password=req.getParameter("password");
 String confirmPassword=req.getParameter("confirm");

 //conversion of datatypes
 long phone=Long.parseLong(phonenumber);
 PrintWriter out=resp.getWriter();

 //JDBC Implementation
 StudentDAO sdao=new StudentDAOImpl();
 Student s1= sdao.resetPin(mail, phone);
 if(s1!=null&&password.equals(confirmPassword))
 {
 s1.setPass(confirmPassword);
 boolean result=sdao.update(s1);
 if(result)
 {
           req.setAttribute("success","forogot successful");
           RequestDispatcher rd=req.getRequestDispatcher("Forgot.jsp");
           rd.forward(req, resp);
	 
 }
 else
 {
            req.setAttribute("fail","failed to forgot password");
            RequestDispatcher rd=req.getRequestDispatcher("Forgot.jsp");
            rd.forward(req, resp);
 }
 }
}
}

