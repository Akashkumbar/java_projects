<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Bank Transfer</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f5f5f5;
            margin: 0;
            padding: 0;
            display: flex;
            justify-content: center;
            align-items: center;
            height: 100vh;
        }
        .transfer-form {
            background: #ffffff;
            border-radius: 10px;
            box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);
            padding: 20px 30px;
            width: 100%;
            max-width: 400px;
        }
        .transfer-form h2 {
            margin-bottom: 20px;
            color: #333;
            text-align: center;
        }
        .form-group {
            margin-bottom: 15px;
        }
        .form-group label {
            display: block;
            font-weight: bold;
            margin-bottom: 5px;
            color: #555;
        }
        .form-group input {
            width: 100%;
            padding: 10px;
            border: 1px solid #ccc;
            border-radius: 5px;
            font-size: 16px;
        }
        .form-group input:focus {
            outline: none;
            border-color: #007bff;
            box-shadow: 0 0 5px rgba(0, 123, 255, 0.5);
        }
        .btn-submit {
            width: 100%;
            padding: 10px;
            background-color: #007bff;
            border: none;
            color: #fff;
            font-size: 16px;
            font-weight: bold;
            border-radius: 5px;
            cursor: pointer;
            transition: background-color 0.3s;
        }
        .btn-submit:hover {
            background-color: #0056b3;
        }
    </style>
</head>
<body>
    <div class="transfer-form">
        <h2>Transfer Funds</h2>
        <form action="transferAmount" method="POST">
            <div class="form-group">
                <label for="amount">Enter the Amount to be Transferred:</label>
                <input type="number" id="amount" name="amount" placeholder="e.g., 5000" required>
            </div>
            <div class="form-group">
                <label for="account">Enter the Beneficiary Account Number:</label>
                <input type="text" id="account" name="account" placeholder="e.g., 123456789" required>
            </div>
            <div class="form-group">
                <label for="pin">Enter Your PIN:</label>
                <input type="password" id="pin" name="pin" placeholder="****" required>
            </div>
            <button type="submit" class="btn-submit">Submit</button>
        </form>
    </div>
</body>
</html>
