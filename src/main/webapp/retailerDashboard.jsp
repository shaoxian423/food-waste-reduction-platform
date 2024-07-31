<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.util.List" %>
<%@ page import="com.duan.fwrp.entity.SurplusFood" %>
<%@ page import="java.util.List" %>
<%@ page import="com.duan.fwrp.entity.RetailerInventory" %>
<%@ taglib uri="http://jakarta.apache.org/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>




<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Retailer Dashboard</title>
</head>
<body>
<h1>Retailer Dashboard</h1>
<form action="AddInventoryServlet" method="post">
    Retailer ID: <input type="text" name="retailerId"><br>
    Item Name: <input type="text" name="itemName"><br>
    Quantity: <input type="text" name="quantity"><br>
    Expiry Date: <input type="text" name="expiryDate"><br>
    Price: <input type="text" name="price"><br>
    Discount Rate: <input type="text" name="discountRate"><br>
    <input type="submit" value="Add Inventory">
</form>

<h2>Inventory List</h2>
<table border="1">
    <tr>
        <th>Item Name</th>
        <th>Quantity</th>
        <th>Expiry Date</th>
        <th>Price</th>
        <th>Discount Rate</th>
        <th>Mark as Surplus</th>
    </tr>
    <c:forEach var="item" items="${inventoryList}">
        <tr>
            <td>${item.itemName}</td>
            <td>${item.quantity}</td>
            <td>${item.expiryDate}</td>
            <td>${item.price}</td>
            <td>${item.discountRate}</td>
            <td>
                <form action="MarkSurplusServlet" method="post">
                    <input type="hidden" name="itemId" value="${item.id}">
                    <input type="submit" value="Mark as Surplus">
                </form>
            </td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
