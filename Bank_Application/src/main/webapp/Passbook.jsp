<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.*, com.BankProject.DAO.TransactionDAO, com.BankProject.DAO.TransactionDAOImpl, com.BankProject.dto.Transaction, com.BankProject.dto.Customer" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Passbook</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f5f5f5;
            margin: 0;
            padding: 20px;
        }
        .passbook {
            max-width: 800px;
            margin: 0 auto;
            background: #ffffff;
            padding: 20px;
            border-radius: 10px;
            box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);
        }
        h2 {
            text-align: center;
            color: #333;
        }
        table {
            width: 100%;
            border-collapse: collapse;
            margin-top: 20px;
        }
        table th, table td {
            text-align: left;
            padding: 10px;
            border: 1px solid #ddd;
        }
        table th {
            background-color: #f4f4f4;
        }
        .credit {
            color: green;
        }
        .debit {
            color: red;
        }
    </style>
</head>
<body>
    <%
        // Fetch the current customer from the session (update "customer" to your session attribute name)
        Customer currentCustomer = (Customer) session.getAttribute("customer");

        if (currentCustomer == null) {
            // If session is invalid, redirect to login page
            response.sendRedirect("Login.jsp");
            return;
        }

        // Generate the passbook details
        TransactionDAO tdao = new TransactionDAOImpl();
        List<Transaction> passbook = tdao.getTransaction(currentCustomer.getAccno());

        if (passbook == null || passbook.isEmpty()) {
    %>
        <div class="passbook">
            <h2>Passbook</h2>
            <p style="color: gray; text-align: center;">No transactions found.</p>
        </div>
    <%
        } else {
    %>
        <div class="passbook">
            <h2>Passbook</h2>
            <table>
                <thead>
                    <tr>
                        <th>Transaction ID</th>
                        <th>Account Number</th>
                        <th>Transaction Type</th>
                        <th>Transaction Date</th>
                        <th>Amount</th>
                        <th>Current Balance</th>
                    </tr>
                </thead>
                <tbody>
                    <%
                        for (Transaction t : passbook) {
                    %>
                        <tr>
                            <td><%= t.getTransactionId() %></td>
                            <td><%= t.getRec_acc() %></td>
                            <td><%= t.getTransaction() %></td>
                            <td><%= t.getDate() %></td>
                            <td class="<%= t.getTransaction().equals("CREDITED") ? "credit" : "debit" %>">
                                <%= t.getTransaction().equals("CREDITED") ? "+" : "-" %><%= t.getAmount() %>
                            </td>
                            <td><%= t.getBalance() %></td>
                        </tr>
                    <%
                        }
                    %>
                </tbody>
            </table>
        </div>
    <%
        }
    %>
</body>
</html>
