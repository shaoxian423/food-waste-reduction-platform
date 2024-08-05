<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Register - Food Waste Reduction Platform</title>
    <style>
        body {
            margin: 0;
            padding: 0;
            font-family: Arial, sans-serif;
            background-color: #f0f0f0;
        }
        .header {
            background-color: #00796b;
            color: white;
            padding: 15px;
            display: flex;
            justify-content: space-between;
            align-items: center;
        }
        .header-left, .header-right {
            display: flex;
            align-items: center;
        }
        .header-left a, .header-right a {
            color: white;
            text-decoration: none;
            margin: 0 10px;
            font-weight: bold;
        }
        .header-right a {
            background-color: #004d40;
            padding: 10px 15px;
            border-radius: 5px;
        }
        .main-content {
            text-align: center;
            margin-top: 100px;
        }
        .main-content h1 {
            font-size: 50px;
            color: #004d40;
        }
        .form-container {
            background-color: white;
            padding: 20px;
            margin: auto;
            width: 300px;
            border-radius: 10px;
            box-shadow: 0px 0px 10px 0px rgba(0, 0, 0, 0.1);
        }
        .form-container input[type="text"], .form-container input[type="password"], .form-container input[type="tel"], .form-container select {
            width: 100%;
            padding: 10px;
            margin: 10px 0;
            border: 1px solid #ccc;
            border-radius: 5px;
        }
        .form-container input[type="submit"] {
            background-color: #00796b;
            color: white;
            padding: 10px;
            border: none;
            border-radius: 5px;
            cursor: pointer;
        }
        .form-container input[type="submit"]:hover {
            background-color: #004d40;
        }
    </style>
</head>
<body>
<div class="header">
    <div class="header-left">
        <a href="#">About Us</a>
        <a href="#">About FWRP</a>
    </div>
    <div class="header-right">
        <a href="register.jsp">Register</a>
        <a href="login.jsp">Login</a>
    </div>
</div>
<div class="main-content">
    <h1>FOOD WASTE REDUCTION PLATFORM</h1>
    <div class="form-container">
        <form action="register" method="post">
            <label for="name">Name:</label>
            <input type="text" id="name" name="name" required>
            <label for="email">Email:</label>
            <input type="text" id="email" name="email" required>
            <label for="password">Password:</label>
            <input type="password" id="password" name="password" required>
            <label for="phone">Phone:</label>
            <input type="tel" id="phone" name="phone" required>
            <label for="userType">User Type:</label>
            <select id="userType" name="userType">
                <option value="Retailer">Retailer</option>
                <option value="Consumer">Consumer</option>
                <option value="Charity">Charity</option>
            </select>
            <input type="submit" value="Register">
        </form>
    </div>
</div>
</body>
</html>

