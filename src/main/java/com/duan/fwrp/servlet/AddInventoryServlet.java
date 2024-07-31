package com.duan.fwrp.servlet;

import com.duan.fwrp.service.RetailerInventoryService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

//@WebServlet("/AddInventoryServlet")
public class AddInventoryServlet extends HttpServlet {
    private RetailerInventoryService inventoryService;

    @Override
    public void init() throws ServletException {
        super.init();
        inventoryService = new RetailerInventoryService();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String retailerId = request.getParameter("retailerId");
        String itemName = request.getParameter("itemName");
        int quantity = Integer.parseInt(request.getParameter("quantity"));
        String expiryDate = request.getParameter("expiryDate");
        double price = Double.parseDouble(request.getParameter("price"));
        double discountRate = Double.parseDouble(request.getParameter("discountRate"));

        inventoryService.addItem(retailerId, itemName, quantity, expiryDate, price, discountRate);
        response.sendRedirect("retailerDashboard.jsp");
    }
}
