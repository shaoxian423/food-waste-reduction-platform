package com.duan.fwrp.servlet;

import com.duan.fwrp.entity.RetailerInventory;
import com.duan.fwrp.entity.Users;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import com.duan.fwrp.service.RetailerInventoryService;
import jakarta.servlet.http.HttpSession;

@WebServlet("/consumerDashboard")
public class ConsumerDashboardServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private RetailerInventoryService inventoryService;

    @Override
    public void init() throws ServletException {
        inventoryService = new RetailerInventoryService();
    }

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
            List<RetailerInventory> surplusFoodList = inventoryService.getAllSurplusFood();
            request.setAttribute("surplusFoodList", surplusFoodList);
            request.setAttribute("username", username);
            request.setAttribute("id", id);
            request.getRequestDispatcher("consumerDashboard.jsp").forward(request, response);
        } catch (SQLException e) {
            e.printStackTrace();
            throw new ServletException("Database error", e);
        }
    }
}
