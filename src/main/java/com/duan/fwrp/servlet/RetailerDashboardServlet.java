package com.duan.fwrp.servlet;

import com.duan.fwrp.entity.RetailerInventory;
import com.duan.fwrp.service.RetailerInventoryService;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import com.duan.fwrp.entity.Users;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

// @WebServlet("/retailerDashboard")
public class RetailerDashboardServlet extends HttpServlet {
    private RetailerInventoryService inventoryService;

    @Override
    public void init() throws ServletException {
        try {
            inventoryService = new RetailerInventoryService();
        } catch (SQLException e) {
            throw new ServletException("Failed to initialize RetailerInventoryService", e);
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        Users user = (Users) session.getAttribute("user");

        if (user == null) {
            response.sendRedirect("login.jsp");
            return;
        }
        String id = String.valueOf(user.getId());
        String username = user.getName();


        try {
            List<RetailerInventory> inventoryList = inventoryService.getAllItems();
            request.setAttribute("inventoryList", inventoryList);
            request.setAttribute("username", username);
            request.setAttribute("id", id);
            request.getRequestDispatcher("retailerDashboard.jsp").forward(request, response);
        } catch (SQLException e) {
            throw new ServletException("Database error", e);
        }
    }

}
