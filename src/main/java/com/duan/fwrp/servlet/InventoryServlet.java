package com.duan.fwrp.servlet;

import com.duan.fwrp.entity.RetailerInventory;
import com.duan.fwrp.entity.SurplusFood;
import com.duan.fwrp.service.RetailerInventoryService;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;

@WebServlet("/InventoryServlet")
public class InventoryServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private RetailerInventoryService inventoryService = new RetailerInventoryService();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");

        try {
            if ("addInventory".equals(action)) {
                int id = Integer.parseInt(request.getParameter("id"));
                int retailerId = Integer.parseInt(request.getParameter("retailerId"));
                String itemName = request.getParameter("itemName");
                int quantity = Integer.parseInt(request.getParameter("quantity"));
                LocalDate expirationDate = LocalDate.parse(request.getParameter("expirationDate"));
                double price = Double.parseDouble(request.getParameter("price"));
                double discountRate = Double.parseDouble(request.getParameter("discountRate"));

                RetailerInventory item = new RetailerInventory(id, retailerId, itemName, quantity, expirationDate, price, discountRate);
                inventoryService.addInventory(item);

                response.sendRedirect("retailerDashboard.jsp");
            } else if ("markSurplus".equals(action)) {
                int itemId = Integer.parseInt(request.getParameter("itemId"));
                boolean isForSale = Boolean.parseBoolean(request.getParameter("isForSale"));
                double discountPrice = Double.parseDouble(request.getParameter("discountPrice"));

                inventoryService.markAsSurplus(itemId, isForSale, discountPrice);
                response.sendRedirect("retailerDashboard.jsp");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            List<RetailerInventory> inventoryList = inventoryService.getAllInventory();
            request.setAttribute("inventoryList", inventoryList);
            List<SurplusFood> surplusFoodList = inventoryService.getAllSurplusFood();
            request.setAttribute("surplusFoodList", surplusFoodList);
            request.getRequestDispatcher("retailerDashboard.jsp").forward(request, response);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
