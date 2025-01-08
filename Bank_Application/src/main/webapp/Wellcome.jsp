<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Home Page</title>
 <style>
        body {
            margin: 0;
            font-family: Arial, sans-serif;
        }
        .container {
            display: flex;
            height: 100vh;
        }
        .sidebar {
            width: 250px;
            background-color: #2c3e50;
            color: white;
            display: flex;
            flex-direction: column;
            padding: 20px;
        }
        .sidebar h2 {
            text-align: center;
            margin-bottom: 20px;
        }
        .sidebar a {
            text-decoration: none;
            color: white;
            padding: 10px 15px;
            margin: 5px 0;
            border-radius: 5px;
            display: block;
            transition: background-color 0.3s;
             }
        .sidebar a:hover {
            background-color: #34495e;
        }
        .main-content {
            flex: 1;
            padding: 20px;
            background-color: #ecf0f1;
            background-image: url('image.jpg');
            background-size: cover;
            background-position: center;
            color: #2c3e50;
        }
        .main-content h1 {
            color: #2c3e50;
            background-color: rgba(255, 255, 255, 0.8);
            display: inline-block;
            padding: 10px;
            border-radius: 5px;
        }
    </style>

</head>
<body>
<div class="container">
        <div class="sidebar">
            <h2>Options</h2>
            <a href="Login.jsp">Customer Login</a>
            <a href="Sigup.jsp">New Account Creation</a>
        </div>
        <div class="main-content">
           <center> <h1>Welcome to Karnataka Bank</h1></center>
        </div>
    </div>
</body>
</html>
