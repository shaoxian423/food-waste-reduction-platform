<%--
  Created by IntelliJ IDEA.
  User: SX Duan
  Date: 7/25/2024
  Time: 1:50 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page import="java.util.List" %>
<%@ page import="com.duan.fwrp.entity.SurplusFood" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Consumer Dashboard</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
    <style>
        .navbar {
            background-color: #004d40;
        }
        .navbar a {
            color: white !important;
        }
        .container {
            margin-top: 30px;
        }
        .table {
            margin-top: 20px;
        }
        h1 {
            margin-top: 20px;
            color: #004d40;
        }
    </style>
</head>
<body>
<nav class="navbar navbar-expand-lg navbar-dark">
    <a class="navbar-brand" href="#">FWRP</a>
    <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarNav" aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
    </button>
    <div class="collapse navbar-collapse" id="navbarNav">
        <ul class="navbar-nav">
            <li class="nav-item">
                <a class="nav-link" href="#">About Us</a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="#">About FWRP</a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="register.jsp">Register</a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="login.jsp">Login</a>
            </li>
        </ul>
    </div>
</nav>
<div class="container">
    <h1>Welcome, Consumer!</h1>
    <h2>Discounted Surplus Food</h2>
    <table class="table table-striped">
        <thead>
        <tr>
            <th>Item Name</th>
            <th>Quantity</th>
            <th>Expiration Date</th>
            <th>Discounted Price</th>
        </tr>
        </thead>
        <tbody>
        <%
            List<SurplusFood> surplusFoodList = (List<SurplusFood>) request.getAttribute("surplusFoodList");
            if (surplusFoodList != null) {
                for (SurplusFood surplusFood : surplusFoodList) {
        %>
        <tr>
            <td><%= surplusFood.getItemName() %></td>
            <td><%= surplusFood.getQuantity() %></td>
            <td><%= surplusFood.getExpiryDate() %></td>
            <td><%= surplusFood.getDiscountedPrice() %></td>
        </tr>
        <%
                }
            }
        %>
        </tbody>
    </table>
</div>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</body>
</html>
