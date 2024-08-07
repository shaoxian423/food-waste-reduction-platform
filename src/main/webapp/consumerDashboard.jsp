<%--
  Created by IntelliJ IDEA.
  User: SX Duan
  Date: 7/25/2024
  Time: 1:50 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
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
        body {
            background-color: #f8f9fa;
        }
        .container {
            margin-top: 50px;
        }
        .card {
            padding: 20px;
            border-radius: 10px;
        }
        table {
            width: 100%;
        }
        th, td {
            text-align: left;
            padding: 8px;
        }
        th {
            background-color: #004d40;
            color: white;
        }
    </style>
</head>
<body>
<nav class="navbar navbar-expand-lg">
    <a class="navbar-brand" href="#">FWRP</a>
    <div class="collapse navbar-collapse">
        <ul class="navbar-nav mr-auto">
            <li class="nav-item">
                <a class="nav-link" href="index.jsp">About Us</a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="index.jsp">About FWRP</a>
            </li>
        </ul>
        <ul class="navbar-nav">
            <li class="nav-item">
                <a class="nav-link" href="#">Welcome, ${username}!</a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="login.jsp">Sign Out</a>
            </li>
        </ul>
    </div>
</nav>
<div class="container">
    <h3>
        <a href="consumerDashboard">All Surplus Food</a>
        &nbsp;
        <a href="purchasedFoodList">Purchased Food</a>
    </h3>
    <table class="table table-striped">
        <thead>
        <tr>
            <th>Item Name</th>
            <th>Quantity</th>
            <th>Expiration Date</th>
            <th>Discounted Price</th>
            <th>Location</th>
            <th>Purchase Quantity</th>
            <th>Purchase</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach var="item" items="${surplusFoodList}">
        <tr>
            <td>${item.itemName}</td>
            <td>${item.quantity}</td>
            <td>${item.expiryDate}</td>
            <td><c:out value="${item.price * item.discountRate}"/></td>
            <td>${item.location}</td>
            <td>
                <form action="purchaseFood" method="post">
                    <input type="hidden" name="inventoryId" value="${item.id}">
                    <input type="hidden" name="userId" value="${id}">
                    <input type="number" name="quantity" min="1" max="${item.quantity}" required>
            </td>
            <td>
                <button type="submit" class="btn btn-link">Purchase</button>
            </form>
            </td>
        </tr>
        </c:forEach>
        </tbody>
    </table>
</div>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</body>
</html>