<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Deposit Amount</title>
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
        input[type="number"] {
            padding: 10px;
            font-size: 16px;
            margin: 10px 0;
            border-radius: 5px;
            border: 1px solid #ccc;
            width: 200px;
        }
        button {
            padding: 10px 20px;
            font-size: 16px;
            border-radius: 5px;
            background-color: #4CAF50;
            color: white;
            border: none;
            cursor: pointer;
        }
        button:hover {
            background-color: #45a049;
        }
    </style>
</head>
<body>

<header>
    <h1>Deposit Amount</h1>
</header>

<main>
    <form action="deposit" method="post">
        <label for="amount">Enter Amount to Deposit:</label><br>
        <input type="number" id="amount" name="amount" placeholder="Enter amount" required><br>
        <button type="submit">Submit</button>
    </form>
</main>

</body>
</html>
