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
<body bgcolor="#add8e6">
<div align="center">
    <h1 class="heading">Pentagon Space</h1>
    <h3 class="sub">Update your password here</h3>
    
    <% String success=(String)request.getAttribute("success");
    if(success!=null){%>
    <h3><%=success%></h3> 
    <%}%>
    
    <% String fail=(String)request.getAttribute("fail");
    if(fail!=null){%>
    <h3><%=fail%></h3>
    <% }%>
    
    <form action="forgot" method="post">
        <table>
            <tr>
                <td><b>Enter the Email id:</b></td>
                <td><input type="email" name="mail"></td>
            </tr>
            <tr>
                <td><br></td>
                <td><br></td>
            </tr>
            <tr>
                <td><b>Enter the phone number:</b></td>
                <td><input type="tel" name="phone"></td>
            </tr>
            <tr>
                <td><br></td>
                <td><br></td>
            </tr>
            <tr>
                <td><b>Enter a new password:</b></td>
                <td><input type="password" name="password"></td>
            </tr>
            <tr>
                <td><br></td>
                <td><br></td>
            </tr>
            <tr>
                <td><b>Confirm the password:</b></td>
                <td><input type="password" name="confirm"></td>
            </tr>
            <tr>
                <td><br></td>
                <td><br></td>
            </tr>
            <tr>
                <td><button>Update pin</button></td>
                <td><a href="Login.jsp" >Back</a></td>
            </tr>
        </table>
    </form>
</div>
</body>
</html>
