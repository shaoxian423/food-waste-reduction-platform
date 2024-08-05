package com.duan.fwrp.servlet;

import com.duan.fwrp.dao.UsersDAO;
import com.duan.fwrp.entity.Users;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.sql.SQLException;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String email = request.getParameter("email");
        String password = request.getParameter("password");

        UsersDAO usersDAO = new UsersDAO();
        Users user = null;
        try {
            user = usersDAO.findByEmail(email);
        } catch (SQLException e) {
            e.printStackTrace();
            response.sendRedirect("login.jsp");
            return;
        }

        if (user != null && user.getPassword().equals(password)) {
            HttpSession session = request.getSession();
            session.setAttribute("user", user);

            switch (user.getUserType()) {
                case "retailer":
                    response.sendRedirect("retailerDashboard");
                    break;
                case "consumer":
                    response.sendRedirect("consumerDashboard");
                    break;
                case "charity":
                    response.sendRedirect("charityDashboard");
                    break;
                default:
                    response.sendRedirect("login");
                    break;
            }
        } else {
            response.sendRedirect("login");
        }
    }
}
