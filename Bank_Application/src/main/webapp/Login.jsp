<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Login page</title>

 <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f4f4f4;
            display: flex;
            justify-content: center;
            align-items: center;
            height: 100vh;
            margin: 0;
        }
        .login-container {
            background-color: #fff;
            padding: 20px;
            border-radius: 8px;
            box-shadow: 0 4px 6px rgba(0, 0, 0, 0.1);
            width: 300px;
        }
        .login-container h2 {
            margin-bottom: 20px;
            text-align: center;
        }
        .form-group {
            margin-bottom: 15px;
        }
        .form-group label {
            display: block;
            margin-bottom: 5px;
             }
        .form-group input {
            width: 100%;
            padding: 8px;
            box-sizing: border-box;
            border: 1px solid #ccc;
            border-radius: 4px;
        }
        .form-group input:focus {
            outline: none;
            border-color: #007BFF;
        }
        .login-button {
            width: 100%;
            padding: 10px;
            background-color: #007BFF;
            color: #fff;
            border: none;
            border-radius: 4px;
            cursor: pointer;
            font-size: 16px;
        }
        .login-button:hover {
            background-color: #0056b3;
        }
    </style>
</head>
<body >


 <div class="login-container">
        <h2>Customer Login</h2>
        
         <% String fail=(String)request.getAttribute("fail");
        if(fail!=null){%>
        <h3><%=fail%></h3>
        <% }%>
        
        <form action="login" method="POST">
            <div class="form-group">
                <label for="account-number">Account Number</label>
                <input type="text" id="account-number" name="accountNumber" placeholder="Enter your account number" required>
            </div>
            <div class="form-group">
                <label for="pin">PIN</label>
                <input type="password" id="pin" name="pin" placeholder="Enter your PIN" required>
            </div>
            <button type="submit" class="login-button">Login</button>
        </form>
    </div>
</body>
</html>