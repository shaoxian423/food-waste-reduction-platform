<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.util.List" %>
<%@ page import="com.duan.fwrp.entity.SurplusFood" %>
<html>
<head>
    <title>Retailer Dashboard - Food Waste Reduction Platform</title>
    <link rel="stylesheet" href="styles.css">
</head>
<body>
<%-- 顶部导航栏 --%>
<div class="navbar">
    <a href="#">About Us</a>
    <a href="#">About FWRP</a>
    <div class="navbar-right">
        <a href="register.jsp">Register</a>
        <a href="login.jsp">Login</a>
    </div>
</div>

<h2>Welcome, Retailer!</h2>

<div class="form-container">
    <form action="InventoryServlet" method="post">
        <input type="hidden" name="action" value="addInventory">
        <label for="id">ID:</label>
        <input type="text" id="id" name="id"><br>

        <label for="retailerId">Retailer ID:</label>
        <input type="text" id="retailerId" name="retailerId"><br>

        <label for="itemName">Item Name:</label>
        <input type="text" id="itemName" name="itemName"><br>

        <label for="quantity">Quantity:</label>
        <input type="text" id="quantity" name="quantity"><br>

        <label for="expirationDate">Expiration Date:</label>
        <input type="text" id="expirationDate" name="expirationDate"><br>

        <label for="price">Price:</label>
        <input type="text" id="price" name="price"><br>

        <label for="discountRate">Discount Rate:</label>
        <input type="text" id="discountRate" name="discountRate"><br>

        <input type="submit" value="Add Inventory">
    </form>
</div>

<h2>Surplus Food Items</h2>
<table>
    <thead>
    <tr>
        <th>Item Name</th>
        <th>Quantity</th>
        <th>Expiration Date</th>
        <th>Price</th>
        <th>Discount Rate</th>
        <th>Mark as Surplus</th>
    </tr>
    </thead>
    <tbody>
    <%
        List<SurplusFood> surplusFoodList = (List<SurplusFood>) request.getAttribute("surplusFoodList");
        if (surplusFoodList != null) {
            for (SurplusFood item : surplusFoodList) {
    %>
    <tr>
        <td><%= item.getInventoryId() %></td>
        <td><%= item.isForSale() %></td>
        <td><%= item.getDiscountPrice() %></td>
        <td>
            <form action="InventoryServlet" method="post">
                <input type="hidden" name="action" value="markSurplus">
                <input type="hidden" name="itemId" value="<%= item.getInventoryId() %>">
                <input type="hidden" name="isForSale" value="true">
                <input type="hidden" name="discountPrice" value="<%= item.getDiscountPrice() %>">
                <input type="submit" value="Mark as Surplus">
            </form>
        </td>
    </tr>
    <%
            }
        }
    %>
    </tbody>
</table>
</body>
</html>
