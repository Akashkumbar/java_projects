<%@page import="com.student.dto.Student"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<style>
.heading {
	color: #000080;
}

.sub {
	color: #1e90ff;
}
</style>
</head>
<body bgcolor='#add8e6'>
	<div align="center">
		<h1 class="heading">Pentagon Space</h1>
		<h3 class="sub">Application form</h3>
		
		<%Student s=(Student)session.getAttribute("student"); %>
		
		<%String success=(String)request.getAttribute("success");
		if(success!=null){%>
		<h3><%=success %></h3> 
		<%}%>
		
		<%String fail=(String)request.getAttribute("fail");
		if(fail!=null){%>
		<h3><%=fail%></h3> 
		<%}%>
		
		<form action="updateAcc" method="post">
			<table>
				<tr>
					<td><b>Enter your Name:</b></td>
					<td><input type="text" name="name" value="<%=s.getName()%>"></td>
				</tr>
				<tr>
					<td><br></td>
					<td><br></td>
				</tr>
				<tr>
					<td><b>Enter the Phone number:</b></td>
					<td><input type="tel" name="phone" value="<%=s.getPhone()%>"></td>
				</tr>
				<tr>
					<td><br></td>
					<td><br></td>
				</tr>
				<tr>
					<td><b>Enter the Mail ID:</b></td>
					<td><input type="email" name="mail" value="<%=s.getMail()%>"></td>
				</tr>
				<tr>
					<td><br></td>
					<td><br></td>
				</tr>
				<tr>
					<td><b>Enter the Branch:</b></td>
					<td><input type="text" name="branch" value="<%=s.getBranch()%>"></td>
				</tr>
				<tr>
					<td><br></td>
					<td><br></td>
				</tr>
				<tr>
					<td><b>Enter the Location:</b></td>
					<td><input type="text" name="loc" value="<%=s.getBranch()%>"></td>
				</tr>
				<tr>
					<td><br></td>
					<td><br></td>
				</tr>
				<tr>
					<td><button>Update account</button></td>
					<td><b>already have a account? </b><a href="Login.jsp">login</a></td>
				</tr>
			</table>
			</form>
	</div>
</body>
</html>