package com.duan.fwrp.servlet;

import com.duan.fwrp.service.SurplusFoodService;
import com.duan.fwrp.entity.SurplusFood;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet("/consumerDashboard")
public class ConsumerDashboardServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        SurplusFoodService surplusFoodService = null;
        try {
            surplusFoodService = new SurplusFoodService();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        List<SurplusFood> surplusFoodList = null;
        try {
            surplusFoodList = surplusFoodService.getAllSurplusFoods();
        } catch (SQLException e) {
            e.printStackTrace();
            throw new ServletException("Error retrieving surplus food list", e);
        }
        request.setAttribute("surplusFoodList", surplusFoodList);
        request.getRequestDispatcher("consumerDashboard.jsp").forward(request, response);
    }
}
