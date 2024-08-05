<%--
  Created by IntelliJ IDEA.
  User: SX Duan
  Date: 7/25/2024
  Time: 1:51 PM
  To change this template use File | Settings | File Templates.
--%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Charity Dashboard - Food Waste Reduction Platform</title>
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
    <div class="card">
        <h3>
            <a href="retailerDashboard">All Inventories</a>
            &nbsp;
            <a href="surplusFoodList">Surplus Food</a>
        </h3>
        <table class="table table-striped">
            <thead>
            <tr>
                <th>Item Name</th>
                <th>Quantity</th>
                <th>Expiry Date</th>
                <th>Original Price</th>
                <th>Discount Price</th>
                <th>Edit</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach var="item" items="${surplusFoodList}">
                <tr>
                    <td>${item.itemName}</td>
                    <td>${item.quantity}</td>
                    <td>${item.expiryDate}</td>
                    <td>${item.price}</td>
                    <td>${item.discountRate}</td>
                    <td>
                        <a href="" class="btn btn-link">Claim</a>
                    </td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
    </div>
</div>
</body>
</html>
