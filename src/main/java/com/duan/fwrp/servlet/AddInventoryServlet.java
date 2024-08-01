package com.duan.fwrp.servlet;

import com.duan.fwrp.service.RetailerInventoryService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.sql.Date;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;

@WebServlet("/addInventory")
public class AddInventoryServlet extends HttpServlet {
    private RetailerInventoryService inventoryService;

    @Override
    public void init() throws ServletException {
        super.init();
        try {
            inventoryService = new RetailerInventoryService();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String retailerIdStr = request.getParameter("retailerId");
        String itemName = request.getParameter("itemName");
        String quantityStr = request.getParameter("quantity");
        String expiryDateStr = request.getParameter("expiryDate");
        String priceStr = request.getParameter("price");
        String discountRateStr = request.getParameter("discountRate");

        int retailerId = Integer.parseInt(retailerIdStr);
        int quantity = Integer.parseInt(quantityStr);
        double price = Double.parseDouble(priceStr);
        double discountRate = Double.parseDouble(discountRateStr);

        // Ensure the date format is correct
        Date expiryDate = null;
        try {
            java.util.Date utilDate = new SimpleDateFormat("yyyy-MM-dd").parse(expiryDateStr);
            expiryDate = new Date(utilDate.getTime());
        } catch (ParseException e) {
            e.printStackTrace();
            // handle error appropriately
        }

        try {
            inventoryService.addItem(retailerId, itemName, quantity, expiryDate, price, discountRate);
            response.sendRedirect("retailerDashboard.jsp");
        } catch (SQLException e) {
            e.printStackTrace();
            response.sendRedirect("retailerDashboard.jsp?error=Database error, please try again.");
        }
    }
}
