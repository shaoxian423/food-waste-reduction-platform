package com.duan.fwrp.servlet;

import com.duan.fwrp.entity.RetailerInventory;
import com.duan.fwrp.service.RetailerInventoryService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;

@WebServlet("/InventoryServlet")
public class InventoryServlet extends HttpServlet {
    private RetailerInventoryService retailerInventoryService;

    @Override
    public void init() throws ServletException {
        super.init();
        retailerInventoryService = new RetailerInventoryService();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<RetailerInventory> inventories = retailerInventoryService.getAllInventories();
        request.setAttribute("inventoryItems", inventories);
        request.getRequestDispatcher("retailerDashboard.jsp").forward(request, response);
    }
}
