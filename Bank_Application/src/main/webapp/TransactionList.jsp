<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.ArrayList" %>
<%@ page import="com.BankProject.DAO.*" %> <!-- Ensure the correct DAO is imported -->
<%@ page import="com.BankProject.dto.*" %>
<%@ page import="java.util.Iterator"%> 
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Transaction Data</title>
    <style>
        /* Basic styles */
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

        .content-container {
            background-color: #ffffff;
            padding: 30px;
            border-radius: 10px;
            box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);
            width: 800px;
            text-align: center;
        }

        .content-header {
            font-size: 24px;
            margin-bottom: 30px;
            font-weight: bold;
            color: #333;
        }

        table {
            width: 100%;
            border-collapse: collapse;
            margin-bottom: 20px;
        }

        table, th, td {
            border: 1px solid #ddd;
        }

        th, td {
            padding: 10px;
            text-align: left;
        }

        th {
            background-color: #4caf50;
            color: white;
        }

        td {
            background-color: #f9f9f9;
        }

        .back-button {
            margin-top: 20px;
            padding: 10px 20px;
            background-color: #4caf50;
            color: white;
            border: none;
            border-radius: 5px;
            cursor: pointer;
            transition: background-color 0.3s;
        }

        .back-button:hover {
            background-color: #45a049;
        }
    </style>
</head>
<body>
<% 
    // Get the logged-in customer from the session
    Customer c = (Customer) session.getAttribute("customer");

    // Initialize the TransactionDAO to fetch transactions
    TransactionDAO tdao = new TransactionDAOImpl();

    // Fetch all transactions for the logged-in customer (or all transactions in the system)
    ArrayList<Transaction> transactions=(ArrayList<Transaction>)tdao.getTransaction(); 
    Iterator<Transaction> it = transactions.iterator(); 
%> 

<div class="content-container">
    <div class="content-header">All Transaction Data</div>

    <table>
        <tr>
            <th>Transaction ID</th>
            <th>User Account</th>
            <th>Beneficiary Account</th>
            <th>Transaction Type</th>
            <th>Amount</th>
            <th>Balance After Transaction</th>
        </tr>
        <tbody>
            <% 
                while (it.hasNext()) { 
                    Transaction transaction = it.next(); 
            %>
            <tr>
                <td><%= transaction.getTransactionId() %></td>
                <td><%= transaction.getUser() %></td>
                <td><%= transaction.getRec_acc() %></td>
                <td><%= transaction.getTransaction() %></td>
                <td><%= transaction.getAmount() %></td>
                <td><%= transaction.getBalance() %></td>
               
            </tr>
            <% 
                } 
            %>
        </tbody>
    </table>

    <!-- Button to go back to the main menu -->
    <button class="back-button" onclick="window.location.href='Admin.jsp'">Back to Main Menu</button>
</div>

</body>
</html> 
