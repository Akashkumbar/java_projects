<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Sign-Up Page</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f4f4f9;
            margin: 0;
            padding: 0;
        }
        .signup-container {
            width: 300px;
            margin: 50px auto;
            background: #fff;
            padding: 20px;
            border-radius: 8px;
            box-shadow: 0 2px 5px rgba(0, 0, 0, 0.1);
        }
        .signup-container h2 {
            text-align: center;
            margin-bottom: 20px;
        }
        .form-group {
            margin-bottom: 15px;
        }
        .form-group label {
            display: block;
            margin-bottom: 5px;
            font-weight: bold;
        }
        .form-group input {
            width: 100%;
            padding: 8px;
            box-sizing: border-box;
            border: 1px solid #ccc;
            border-radius: 4px;
        }
        .btn-submit {
            width: 100%;
            padding: 10px;
            background-color: #007BFF;
            border: none;
            color: #fff;
            font-size: 16px;
            border-radius: 4px;
            cursor: pointer;
        }
        .btn-submit:hover {
            background-color: #0056b3;
        }
        .message {
            text-align: center;
            margin-top: 15px;
            font-weight: bold;
        }
    </style>
</head>
<body>
<div class="signup-container">
    <h2>Sign-Up Form</h2>
    <form id="signupForm" action="sigup" method="post">
        <div class="form-group">
            <label for="name">Name:</label>
            <input type="text" id="name" name="name" required>
        </div>
        <div class="form-group">
            <label for="phone">Phone:</label>
            <input type="tel" id="phone" name="phone" required pattern="[0-9]{10}">
        </div>
        <div class="form-group">
            <label for="mail">Email:</label>
            <input type="email" id="mail" name="mail" required>
        </div>
        <div class="form-group">
            <label for="pin">PIN:</label>
            <input type="password" id="pin" name="pin" required minlength="4" maxlength="6">
        </div>
        <div class="form-group">
            <label for="confirmPin">Confirm PIN:</label>
            <input type="password" id="confirmPin" name="confirmPin" required minlength="4" maxlength="6">
        </div>
        <button type="submit" class="btn-submit">Sign Up</button>
    </form>
    <!-- Dynamic message display -->
    <div id="message" class="message">
        <% 
            String message = (String) request.getAttribute("message");
            if (message != null) {
        %>
            <span style="color: <%= (String) request.getAttribute("messageColor") %>;">
                <%= message %>
            </span>
        <% } %>
    </div>
</div>
</body>
</html>
