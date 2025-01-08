package com.student.main;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;
import com.student.dao.StudentDAO;
import com.student.dao.StudentDAOImpl;
import com.student.dto.Student;

public class Test {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		 Student s=new Student();
		 StudentDAO sdao=new StudentDAOImpl();

		 //get all the data
		 List<Student> students=sdao.getStudent();
		 Iterator<Student> it=students.iterator();
		 while(it.hasNext())
		 {
		 s=it.next();
		 System.out.println(s);
		 }

		 //inserting the student data
		 System.out.println("Enter the name:");
		 String name=sc.next();
		 System.out.println("Enter the Phone number:");
		 long phone=sc.nextLong();
		 System.out.println("Enter the mail ID:");
		 String mail=sc.next();
		 System.out.println("Enter the branch:");
		 String branch=sc.next();
		 System.out.println("Enter your location ID:");
		 int lid=sc.nextInt();
		 System.out.println("Enter your password:");
		 String pass1=sc.next();
		 System.out.println("Confirm your password:");
		 String pass2=sc.next();
		 if(pass1.equals(pass2))
		 {
		 s.setName(name);
		 s.setPhone(phone);
		 s.setMail(mail);
		 s.setBranch(branch);
		 s.setId(lid);
		 s.setPass(pass1);

		 boolean res=sdao.insertStudent(s);
		 if(res)
		 {
		 System.out.println("Signup successful");
		 }
		 else
		 {
		 System.out.println("failed to signup");
		 }
		 }
		//updating student data
		 System.out.println("Enter the phone number to be updated");
		 s.setPhone(sc.nextLong());
		 boolean res=sdao.updateStudent(s);
		 if(res)
		 {
		 System.out.println("phone number updated to"+s.getPhone()+"successfully");
		 }
		 else
		 {
		 System.out.println("failed to update");
		 }

	}

}
