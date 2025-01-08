<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Admin page</title>
    <style>
        /* Body Styling */
        body {
            margin: 0;
            padding: 0;
            font-family: Arial, sans-serif;
            background-color: #f0f0f0;
            display: flex;
            justify-content: center;
            align-items: center;
            height: 100vh;
        }

        /* Container for the buttons */
        .menu-container {
            background-color: #ffffff;
            padding: 30px;
            border-radius: 10px;
            box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);
            width: 300px;
            text-align: center;
        }

        /* Header Text */
        .menu-header {
            font-size: 24px;
            margin-bottom: 30px;
            font-weight: bold;
            color: #333;
        }

        /* Styling the Buttons */
        .menu-button {
            display: block;
            width: 100%;
            padding: 15px;
            margin: 10px 0;
            font-size: 16px;
            color: #fff;
            background-color: #4caf50;
            border: none;
            border-radius: 5px;
            cursor: pointer;
            transition: background 0.3s, transform 0.3s;
        }

        /* Hover Effects */
        .menu-button:hover {
            background-color: #45a049;
            transform: translateY(-5px); /* Lift effect */
        }

        /* Active Button Effect */
        .menu-button:active {
            transform: translateY(2px); /* Push down on click */
        }

        /* Link inside button */
        .menu-button a {
            color: inherit;
            text-decoration: none;
        }
    </style>
</head>
<body>
    <div class="menu-container">
        <div class="menu-header">Admin Dashboard</div>
        
        <button class="menu-button">
            <a href="AccData.jsp">Get Account Data</a>
        </button>

        <button class="menu-button">
            <a href="TransactionList.jsp">Get Transaction List</a>
        </button>


        <button class="menu-button">
            <a href="Dashboard.jsp">Back to Main Menu</a>
        </button>
    </div>


</body>
</html>