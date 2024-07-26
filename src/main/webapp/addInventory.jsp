<!DOCTYPE html>
<html>
<head>
    <title>Add Inventory</title>
</head>
<body>
<h1>Add Inventory</h1>
<form action="inventory" method="post">
    <label for="name">Name:</label>
    <input type="text" id="name" name="name"><br>
    <label for="retailerId">Retailer ID:</label>
    <input type="text" id="retailerId" name="retailerId"><br>
    <label for="quantity">Quantity:</label>
    <input type="text" id="quantity" name="quantity"><br>
    <label for="price">Price:</label>
    <input type="text" id="price" name="price"><br>
    <label for="discountRate">Discount Rate:</label>
    <input type="text" id="discountRate" name="discountRate"><br>
    <label for="expireDate">Expire Date:</label>
    <input type="text" id="expireDate" name="expireDate"><br>
    <button type="submit">Add</button>
</form>
</body>
</html>
