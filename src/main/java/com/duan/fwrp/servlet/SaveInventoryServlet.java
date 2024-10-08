package com.duan.fwrp.servlet;

import com.duan.fwrp.dao.RetailerInventoryDAO;
import com.duan.fwrp.entity.RetailerInventory;
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

@WebServlet("/saveInventory")
public class SaveInventoryServlet extends HttpServlet{
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String idStr = request.getParameter("id");
        String retailerIdStr = request.getParameter("retailerId");
        String itemName = request.getParameter("itemName");
        String quantityStr = request.getParameter("quantity");
        String expiryDateStr = request.getParameter("expiryDate");
        String priceStr = request.getParameter("price");
        String discountRateStr = request.getParameter("discountRate");
        String location = request.getParameter("location");
        String isSurplusStr = request.getParameter("isSurplus");
        String isForDonationStr = request.getParameter("isForDonation");

        int id = Integer.parseInt(idStr);
        int retailerId = Integer.parseInt(retailerIdStr);
        int quantity = Integer.parseInt(quantityStr);
        double price = Double.parseDouble(priceStr);
        double discountRate = Double.parseDouble(discountRateStr);
        boolean isSurplus = Boolean.parseBoolean(isSurplusStr);
        boolean isForDonation = Boolean.parseBoolean(isForDonationStr);

        // Ensure the date format is correct
        Date expiryDate = null;
        try {
            java.util.Date utilDate = new SimpleDateFormat("yyyy-MM-dd").parse(expiryDateStr);
            expiryDate = new Date(utilDate.getTime());
        } catch (ParseException e) {
            e.printStackTrace();
            // handle error appropriately
        }

        RetailerInventory inventory = new RetailerInventory(id, retailerId, itemName, quantity, expiryDate, price, discountRate, location, isSurplus, isForDonation);
        RetailerInventoryDAO inventoryDAO = new RetailerInventoryDAO();

        try{
            inventoryDAO.updateInventory(inventory);
            response.sendRedirect("retailerDashboard");
        }catch(SQLException e){
            e.printStackTrace();
        }
    }
}
