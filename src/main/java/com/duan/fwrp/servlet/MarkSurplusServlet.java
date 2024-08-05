package com.duan.fwrp.servlet;

import com.duan.fwrp.dao.RetailerInventoryDAO;
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
        int inventoryId = Integer.parseInt(request.getParameter("inventoryId"));


        RetailerInventoryDAO retailerInventoryDAO = new RetailerInventoryDAO();
        try {
            retailerInventoryDAO.markIsSurplusTrueById(inventoryId);
            response.sendRedirect("retailerDashboard"); // Redirect to the retailer dashboard after marking as surplus
        } catch (SQLException e) {
            e.printStackTrace();
            response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "Error marking item as surplus.");
        }
    }
}
