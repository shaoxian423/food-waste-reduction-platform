package com.duan.fwrp.servlet;

import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServletRequest;
import com.duan.fwrp.dao.RetailerInventoryDAO;
import com.duan.fwrp.entity.RetailerInventory;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.ServletException;

import java.sql.SQLException;
import java.io.IOException;

@WebServlet("/editInventory")
public class EditInventoryServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("inventoryId"));
        RetailerInventoryDAO retailerInventoryDAO = new RetailerInventoryDAO();
        try{
            RetailerInventory inventory = retailerInventoryDAO.getInventoryById(id);
            request.setAttribute("inventory", inventory);
            request.getRequestDispatcher("editInventory.jsp").forward(request, response);
        }catch(SQLException e){
            e.printStackTrace();
        }


    }
}
