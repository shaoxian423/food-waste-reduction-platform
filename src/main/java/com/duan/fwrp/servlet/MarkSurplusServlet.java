package com.duan.fwrp.servlet;

import com.duan.fwrp.dao.SurplusFoodDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.sql.SQLException;

@WebServlet("/markAsSurplus")
public class MarkSurplusServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        boolean isSurplus = true; // Assuming this is what you want to set
        double discountedPrice = Double.parseDouble(request.getParameter("discountedPrice")); // Ensure this parameter is passed

        SurplusFoodDAO surplusFoodDAO = new SurplusFoodDAO();
        try {
            surplusFoodDAO.markAsSurplus(id, isSurplus, discountedPrice);
            response.sendRedirect("retailerDashboard"); // Redirect to the retailer dashboard after marking as surplus
        } catch (SQLException e) {
            e.printStackTrace();
            response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "Error marking item as surplus.");
        }
    }
}
