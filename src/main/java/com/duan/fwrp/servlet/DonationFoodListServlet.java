package com.duan.fwrp.servlet;

import com.duan.fwrp.entity.RetailerInventory;
import com.duan.fwrp.entity.Users;
import com.duan.fwrp.service.RetailerInventoryService;
import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet("/donationFoodList")
public class DonationFoodListServlet extends HttpServlet {
    private RetailerInventoryService inventoryService;

    @Override
    public void init(ServletConfig config) throws ServletException {
        inventoryService = new RetailerInventoryService();
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
            List<RetailerInventory> inventoryList = inventoryService.getAllDonationFoodById(Integer.parseInt(id));
            request.setAttribute("inventoryList", inventoryList);
            request.setAttribute("username", username);
            request.setAttribute("id", id);
            request.getRequestDispatcher("retailerDashboard.jsp").forward(request, response);
        } catch (SQLException e) {
            throw new ServletException("Database error", e);
        }
    }
}
