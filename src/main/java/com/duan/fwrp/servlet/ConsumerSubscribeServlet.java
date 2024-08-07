package com.duan.fwrp.servlet;

import com.duan.fwrp.service.UserSubscriptionService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.sql.SQLException;

@WebServlet("/subscribe")
public class ConsumerSubscribeServlet extends HttpServlet {
    private UserSubscriptionService  userSubscriptionService;

    @Override
    public void init() throws ServletException {
        super.init();
        userSubscriptionService = new UserSubscriptionService();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String userIdStr = request.getParameter("userId");
        String communicationMethod = request.getParameter("communicationMethod");
        String location = request.getParameter("location");
        String foodPreference = request.getParameter("foodPreference");

        int userId = Integer.parseInt(userIdStr);

        try {
            userSubscriptionService.addSubscription(userId, communicationMethod, location, foodPreference);
            response.sendRedirect("consumerDashboard");
        } catch (SQLException e) {
            e.printStackTrace();
            response.sendRedirect("retailerDashboard.jsp?error=Database error, please try again.");
        }
    }
}
