<%@page import="com.BankProject.dto.Customer"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Customer data</title>
   <style>
        body {
            font-family: Arial, sans-serif;
            margin: 0;
            padding: 0;
            background: #f3f4f6;
            color: #333;
            display: flex;
        }

        .sidebar {
            background: #4caf50;
            color: #fff;
            width: 200px;
            padding: 20px;
            display: flex;
            flex-direction: column;
            gap: 20px;
        }
         .sidebar button {
            background: #fff;
            color: #4caf50;
            border: 1px solid #fff;
            padding: 10px;
            border-radius: 6px;
            cursor: pointer;
            font-size: 16px;
            text-align: left;
            transition: background 0.3s, color 0.3s;
        }

        .sidebar button:hover {
            background: #45a049;
            color: #fff;
        }

        .dashboard {
            flex-grow: 1;
            max-width: 900px;
            margin: 60px auto;
            background: #fff;
            box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);
            border-radius: 10px;
            overflow: hidden;
        }
       .header {
            background: #4caf50;
            color: #fff;
            padding: 25px;
            text-align: center;
        }

        .header h1 {
            margin: 0;
            font-size: 24px;
        }

        .content {
            padding: 25px;
        }

        .content .user-info {
            display: flex;
            flex-direction: column;
            gap: 15px;
            margin-top: 30px;
        }
          .user-info div {
            display: flex;
            justify-content: space-between;
            padding: 15px;
            background: #f9f9f9;
            border: 1px solid #ddd;
            border-radius: 6px;
            font-size: 16px;
        }

        .user-info div span {
            font-weight: bold;
        }
    </style>  
</head>
<body>
<%Customer c=(Customer)session.getAttribute("customer");%>
<div class="dashboard">
    <div class="header">
        <h1>Welcome to  Dashboard</h1>
        <div class="nav-buttons">
            <button><a href="Wellcome.jsp">Home</a></button>
            
             <button class="menu-button">
            <a href="AccAccess.jsp">Access Your Account</a>
        </button>
          
             <% if(c.getAccno()== 1100110011) { %>
            <button><a href="Admin.jsp">Admin</a></button>
            <% } %>
            
            <button><a href="Login.jsp">Logout</a></button>
        </div>
    </div>
    <div class="content">
        <div class="user-info">
            <div><span>Account Number:</span><%=c.getAccno()%></div>
            <div><span>Name:</span><%=c.getName()%></div>
            <div><span>Phone:</span><%=c.getPhone()%></div>
            <div><span>Email:</span><%=c.getMail()%></div>
            <div><span>Balance:</span><%=c.getBal()%></div>
        </div>
    </div>
</div>
</body>
</html>