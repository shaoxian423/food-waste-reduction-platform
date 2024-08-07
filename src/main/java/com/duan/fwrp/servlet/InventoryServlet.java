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

@WebServlet("/inventoryServlet")
public class InventoryServlet extends HttpServlet {
    private RetailerInventoryService inventoryService;

    @Override
    public void init() throws ServletException {
        super.init();
        inventoryService = new RetailerInventoryService();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int retailerId = Integer.parseInt(request.getParameter("retailerId"));
        String itemName = request.getParameter("itemName");
        int quantity = Integer.parseInt(request.getParameter("quantity"));
        Date expiryDate = Date.valueOf(request.getParameter("expiryDate"));
        double price = Double.parseDouble(request.getParameter("price"));
        double discountRate = Double.parseDouble(request.getParameter("discountRate"));
        String location = request.getParameter("location");
        boolean isSurplus = Boolean.parseBoolean(request.getParameter("isSurplus"));
        boolean isForDonation = Boolean.parseBoolean(request.getParameter("isForDonation"));

        try {
            inventoryService.addItem(retailerId, itemName, quantity, expiryDate, price, discountRate, location, isSurplus, isForDonation);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        response.sendRedirect("retailerDashboard.jsp");
    }
}
