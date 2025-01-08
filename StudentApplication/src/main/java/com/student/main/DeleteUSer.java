package com.student.main;
import java.io.IOException; 
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
@WebServlet("/deleteUser") 
public class DeleteUSer extends HttpServlet{ 
@Override 
protected void doPost(HttpServletRequest req, 
HttpServletResponse resp) throws ServletException, IOException { 
String id=req.getParameter("id"); 
int sid=Integer.parseInt(id); 
System.out.println(sid+" "+id); 
HttpSession session=req.getSession(false); 
Student admin=(Student)session.getAttribute("student"); 
StudentDAO sdao=new StudentDAOImpl(); 
Student s1=new Student(); 
if(admin.getId()!=sid) 
{ 
s1.setId(sid); 
boolean result=sdao.deleteStudent(s1); 
if(result) 
{ 
req.setAttribute("success","Data deleted successfully"); 
RequestDispatcher rd=req.getRequestDispatcher("Admin.jsp"); 
rd.forward(req, resp); 
} 
else 
{ 
req.setAttribute("failure","Failed to delete the data"); 
RequestDispatcher rd=req.getRequestDispatcher("Admin.jsp"); 
rd.forward(req, resp); 
} 
} 
else 
{ 
req.setAttribute("failure","Admin data cannot be deleted"); 
RequestDispatcher rd=req.getRequestDispatcher("Admin.jsp"); 
rd.forward(req, resp); 
} 
} 
} 