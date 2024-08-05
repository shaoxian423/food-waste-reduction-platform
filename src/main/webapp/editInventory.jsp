<!DOCTYPE html>
<html>
<head>
    <title>Edit Inventory</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
</head>
<body>
<div class="container">
    <div class="card">
        <h1 class="text-center">Add Inventory</h1>
        <form action="saveInventory" method="post">
            <input type="hidden" name="id" value="${inventory.id}" />
            <input type="hidden" name="retailerId" value="${inventory.retailerId}" /> <!-- Hidden field to preserve the "id" parameter -->
            <div class="form-row">
                <div class="form-group col-md-6">
                    <label for="itemName">Item Name:</label>
                    <input type="text" class="form-control" id="itemName" name="itemName" value="${inventory.itemName}">
                </div>
                <div class="form-group col-md-6">
                    <label for="quantity">Quantity:</label>
                    <input type="text" class="form-control" id="quantity" name="quantity" value="${inventory.quantity}">
                </div>
            </div>
            <div class="form-row">
                <div class="form-group col-md-6">
                    <label for="expiryDate">Expiry Date:</label>
                    <input type="text" class="form-control" id="expiryDate" name="expiryDate" placeholder="yyyy-mm-dd" value="${inventory.expiryDate}">
                </div>
                <div class="form-group col-md-6">
                    <label for="price">Price:</label>
                    <input type="text" class="form-control" id="price" name="price" value="${inventory.price}">
                </div>
            </div>
            <div class="form-row">
                <div class="form-group col-md-6">
                    <label for="discountRate">Discount Rate:</label>
                    <input type="text" class="form-control" id="discountRate" name="discountRate" value="${inventory.discountRate}">
                </div>
                <div class="form-group col-md-6">
                    <label for="discountRate">Surplus Food:</label>
                    <input type="checkbox" class="form-control" id="isSurplus" name="isSurplus" value="true" ${inventory.surplus ? 'checked' : ''}>
                </div>
            </div>
            <button type="submit" class="btn btn-success btn-block">Save</button>
        </form>
    </div>
</div>
</body>
</html>
