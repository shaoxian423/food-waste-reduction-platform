<%--
  Created by IntelliJ IDEA.
  User: SX Duan
  Date: 7/20/2024
  Time: 10:23 PM
  To change this template use File | Settings | File Templates.
--%>
<!DOCTYPE html>
<html>
<head>
    <title>Inventory List</title>
</head>
<body>
<h1>Inventory List</h1>
<table border="1">
    <tr>
        <th>Name</th>
        <th>Quantity</th>
        <th>Expire Date</th>
        <th>Price</th>
        <th>Discount Rate</th>
        <th>Actions</th>
    </tr>
    <c:forEach var="inventory" items="${inventories}">
        <tr>
            <td>${inventory.name}</td>
            <td>${inventory.quantity}</td>
            <td>${inventory.expireDate}</td>
            <td>${inventory.price}</td>
            <td>${inventory.discountRate}</td>
            <td>
                <a href="inventory?action=edit&id=${inventory.id}">Edit</a>
                <a href="inventory?action=delete&id=${inventory.id}">Delete</a>
            </td>
        </tr>
    </c:forEach>
</table>
<a href="inventory?action=add">Add New Inventory</a>
</body>
</html>
