package com.duan.fwrp.servlet;

import com.duan.fwrp.dao.RetailerInventoryDAO;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.ServletException;
import java.sql.SQLException;
import java.io.IOException;

@WebServlet("/deleteInventory")
public class DeleteInventoryServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("inventoryId"));
        RetailerInventoryDAO inventoryDAO = new RetailerInventoryDAO();
        try{
            inventoryDAO.deleteInventoryById(id);
            response.sendRedirect("retailerDashboard");
        }catch(SQLException e){
            e.printStackTrace();
        }
    }
}
