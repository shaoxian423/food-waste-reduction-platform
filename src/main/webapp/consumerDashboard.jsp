<%--
  Created by IntelliJ IDEA.
  User: SX Duan
  Date: 7/25/2024
  Time: 1:50 PM
  To change this template use File | Settings | File Templates.
--%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Consumer Dashboard - Food Waste Reduction Platform</title>
    <style>
        body {
            margin: 0;
            padding: 0;
            font-family: Arial, sans-serif;
            background-color: #f0f0f0;
        }
        .header {
            background-color: #00796b;
            color: white;
            padding: 15px;
            display: flex;
            justify-content: space-between;
            align-items: center;
        }
        .header-left, .header-right {
            display: flex;
            align-items: center;
        }
        .header-left a, .header-right a {
            color: white;
            text-decoration: none;
            margin: 0 10px;
            font-weight: bold;
        }
        .header-right a {
            background-color: #004d40;
            padding: 10px 15px;
            border-radius: 5px;
        }
        .main-content {
            text-align: center;
            margin-top: 50px;
        }
        .main-content h1 {
            font-size: 30px;
            color: #004d40;
        }
        .form-container {
            background-color: white;
            padding: 20px;
            margin: auto;
            width: 500px;
            border-radius: 10px;
            box-shadow: 0px 0px 10px 0px rgba(0, 0, 0, 0.1);
        }
        table {
            width: 100%;
            border-collapse: collapse;
            margin-top: 20px;
        }
        table, th, td {
            border: 1px solid #ccc;
        }
        th, td {
            padding: 10px;
            text-align: left;
        }
        .form-container input[type="text"], .form-container input[type="number"], .form-container input[type="date"] {
            width: calc(100% - 20px);
            padding: 10px;
            margin: 10px 0;
            border: 1px solid #ccc;
            border-radius: 5px;
        }
        .form-container input[type="submit"] {
            background-color: #00796b;
            color: white;
            padding: 10px;
            border: none;
            border-radius: 5px;
            cursor: pointer;
        }
        .form-container input[type="submit"]:hover {
            background-color: #004d40;
        }
    </style>
</head>
<body>
<div class="header">
    <div class="header-left">
        <a href="#">About Us</a>
        <a href="#">About FWRP</a>
    </div>
    <div class="header-right">
        <a href="register.jsp">Register</a>
        <a href="login.jsp">Login</a>
    </div>
</div>
<div class="main-content">
    <h1>Welcome, Consumer!</h1>
    <div class="form-container">
        <h2>Discounted Surplus Food</h2>
        <table>
            <tr>
                <th>Item Name</th>
                <th>Quantity</th>
                <th>Expiration Date</th>
                <th>Discounted Price</th>
            </tr>
            <tr>
                <td>Example Item</td>
                <td>50</td>
                <td>2024-08-01</td>
                <td>$10</td>
            </tr>
            <!-- Add more items here -->
        </table>
    </div>
</div>
</body>
</html>

