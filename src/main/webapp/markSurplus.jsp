<%--
  Created by IntelliJ IDEA.
  User: SX Duan
  Date: 7/25/2024
  Time: 2:41 PM
  To change this template use File | Settings | File Templates.
--%>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Mark Surplus - Food Waste Reduction Platform</title>
    <link rel="stylesheet" href="style.css">
</head>
<body>
<h1>Mark Item as Surplus</h1>
<%
    String itemId = request.getParameter("itemId");
    // Here, you can add logic to mark the item as surplus in the database
    // For now, we're just displaying a message
%>
<p>Item with ID <%= itemId %> has been marked as surplus.</p>
<a href="retailerDashboard.jsp">Back to Dashboard</a>
</body>
</html>
