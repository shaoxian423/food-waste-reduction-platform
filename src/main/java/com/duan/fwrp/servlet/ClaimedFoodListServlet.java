package com.duan.fwrp.servlet;

import com.duan.fwrp.entity.TransactionInventory;
import com.duan.fwrp.entity.Users;
import com.duan.fwrp.service.TransactionService;
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

@WebServlet("/claimedFoodList")
public class ClaimedFoodListServlet extends HttpServlet {
    private TransactionService transactionService;

    @Override
    public void init(ServletConfig config) throws ServletException {
        try {
            transactionService = new TransactionService();
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
            List<TransactionInventory> claimedFoodList = transactionService.getAllClaimedFoodByUserId(Integer.parseInt(id));
            request.setAttribute("claimedFoodList", claimedFoodList);
            request.setAttribute("username", username);
            request.setAttribute("id", id);
            request.getRequestDispatcher("claimedFoodList.jsp").forward(request, response);
        } catch (SQLException e) {
            throw new ServletException("Database error", e);
        }
    }
}
