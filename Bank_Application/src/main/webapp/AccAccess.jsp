<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Banking Page</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            margin: 0;
            padding: 0;
            background-color: #f4f4f9;
        }
        header {
            background-color: #4CAF50;
            color: white;
            text-align: center;
            padding: 10px 0;
        }
        main {
            padding: 20px;
            text-align: center;
        }
        button {
            margin: 10px;
            padding: 15px 30px;
            font-size: 16px;
            border: none;
            border-radius: 5px;
            cursor: pointer;
            background-color: #4CAF50;
            color: white;
        }
        button:hover {
            background-color: #45a049;
        }
    </style>
</head>
<body>

<header>
    <h1>Banking Operations</h1>
</header>

<main>
     <button><a href="Deposit.jsp">Deposit</a></button>
    <button><a href="TransferAmount.jsp">Transfer Amount</a></button>
   <button><a href="Passbook.jsp">Passbook</a></button>
    <button><a href="UpdateAcc.jsp">Update Account</a></button>
    <button><a href="ResetPin.jsp">Reset PIN</a></button>
    <button><a href="Dashboard.jsp">Home</a></button>
</main>

</body>
</html>
