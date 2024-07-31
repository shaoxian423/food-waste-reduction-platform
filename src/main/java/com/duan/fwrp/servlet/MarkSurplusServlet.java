package com.duan.fwrp.servlet;

import com.duan.fwrp.service.RetailerInventoryService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

//@WebServlet("/MarkSurplusServlet")
public class MarkSurplusServlet extends HttpServlet {
    private RetailerInventoryService inventoryService;

    @Override
    public void init() throws ServletException {
        super.init();
        inventoryService = new RetailerInventoryService();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String itemId = request.getParameter("itemId");

        inventoryService.markAsSurplus(itemId);
        response.sendRedirect("retailerDashboard.jsp");
    }
}
