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
    <div class="card">
        <h2 class="text-center">Retailer Dashboard</h2>
        <form action="addInventory" method="post">
            <input type="hidden" name="retailerId" value="${id}" /> <!-- Hidden field to preserve the "id" parameter -->
            <div class="form-row">
                <div class="form-group col-md-6">
                    <label for="itemName">Item Name:</label>
                    <input type="text" class="form-control" id="itemName" name="itemName">
                </div>
                <div class="form-group col-md-6">
                    <label for="quantity">Quantity:</label>
                    <input type="text" class="form-control" id="quantity" name="quantity">
                </div>
            </div>
            <div class="form-row">
                <div class="form-group col-md-6">
                    <label for="expiryDate">Expiry Date:</label>
                    <input type="text" class="form-control" id="expiryDate" name="expiryDate" placeholder="yyyy-mm-dd">
                </div>
                <div class="form-group col-md-6">
                    <label for="price">Price:</label>
                    <input type="text" class="form-control" id="price" name="price">
                </div>
            </div>
            <div class="form-row">
                <div class="form-group col-md-6">
                    <label for="discountRate">Discount Rate:</label>
                    <input type="text" class="form-control" id="discountRate" name="discountRate">
                </div>
                <div class="form-group col-md-6">
                    <label for="discountRate">Surplus Food:</label>
                    <input type="checkbox" class="form-control" id="isSurplus" name="isSurplus" value="true">
                </div>
            </div>
            <button type="submit" class="btn btn-success btn-block">Add Inventory</button>
        </form>
    </div>
    <br>
    <div class="card">
        <h3>Inventory List</h3>
        <table class="table table-striped">
            <thead>
            <tr>
                <th>Item Name</th>
                <th>Quantity</th>
                <th>Expiry Date</th>
                <th>Price</th>
                <th>Discount Rate</th>
                <th>Mark as Surplus</th>
                <th>Edit</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach var="item" items="${inventoryList}">
                <tr>
                    <td>${item.itemName}</td>
                    <td>${item.quantity}</td>
                    <td>${item.expiryDate}</td>
                    <td>${item.price}</td>
                    <td>${item.discountRate}</td>
                    <td>
                        <c:choose>
                            <c:when test="${item.surplus}">
                                Surplus
                            </c:when>
                            <c:otherwise>
                                <a href="markAsSurplus?inventoryId=${item.id}" class="btn btn-link">Mark as Surplus</a>
                            </c:otherwise>
                        </c:choose>
                    </td>
                    <td>
                        <a href="editInventory?inventoryId=${item.id}" class="btn btn-link">Edit</a>
                        <a href="deleteInventory?inventoryId=${item.id}" class="btn btn-link">Delete</a>
                    </td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
    </div>
</div>
</body>
</html>
