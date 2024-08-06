<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Retailer Dashboard</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
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
    <!-- Error Message Alert Box -->
    <c:if test="${not empty errorMessage}">
        <div class="alert alert-danger">
                ${errorMessage}
        </div>
    </c:if>
    <div class="card">
        <h3>
            <a href="">All Donations</a>
            &nbsp;
            <a href="">Claimed Food</a>
        </h3>
        <table class="table table-striped">
            <thead>
            <tr>
                <th>Item Name</th>
                <th>Quantity</th>
                <th>Expiry Date</th>
                <th>Price</th>
                <th>Discount Rate</th>
                <th>Location</th>
                <th>Claim Quantity</th>
                <th>Claim</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach var="item" items="${donationFoodList}">
                <tr>
                    <td>${item.itemName}</td>
                    <td>${item.quantity}</td>
                    <td>${item.expiryDate}</td>
                    <td>${item.price}</td>
                    <td>${item.discountRate}</td>
                    <td>${item.location}</td>
                    <td>
                        <form action="claimFood" method="post">
                            <input type="hidden" name="inventoryId" value="${item.id}">
                            <input type="hidden" name="userId" value="${id}">
                            <input type="number" name="quantity" min="1" max="${item.quantity}" required>
                    </td>
                    <td>
                        <button type="submit" class="btn btn-link">Claim</button>
                        </form>
                    </td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
    </div>
</div>
</body>
</html>
