package com.duan.fwrp.servlet;

import com.duan.fwrp.service.RetailerInventoryService;
import com.duan.fwrp.service.TransactionService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.sql.SQLException;

@WebServlet("/purchaseFood")
public class PurchaseFoodServlet extends HttpServlet {
    private RetailerInventoryService inventoryService;
    private TransactionService transactionService;

    @Override
    public void init() throws ServletException {
        super.init();
        try {
            inventoryService = new RetailerInventoryService();
            transactionService = new TransactionService();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String inventoryIdStr = request.getParameter("inventoryId");
        String userIdStr = request.getParameter("userId");
        String quantityStr = request.getParameter("quantity");

        int inventoryId = Integer.parseInt(inventoryIdStr);
        int userId = Integer.parseInt(userIdStr);
        int quantity = Integer.parseInt(quantityStr);

        try{
            int inventoryQuantity = inventoryService.getQuantityById(inventoryId);
            if(inventoryQuantity < quantity){
                request.setAttribute("errorMessage", "Not enough food");
                request.getRequestDispatcher("charityDashboard.jsp").forward(request, response);
            }else{
                transactionService.addTransaction(userId, inventoryId, quantity);
                response.sendRedirect("consumerDashboard");
            }
        }catch(SQLException e){
            e.printStackTrace();
        }

    }
}
