package com.duan.fwrp.service;

import com.duan.fwrp.dao.RetailerInventoryDAO;
import com.duan.fwrp.entity.RetailerInventory;

import java.sql.SQLException;
import java.util.List;

public class RetailerInventoryService {
    private RetailerInventoryDAO inventoryDAO;

    public RetailerInventoryService() throws SQLException {
        inventoryDAO = new RetailerInventoryDAO();
    }

    public void addItem(int retailerId, String itemName, int quantity, java.sql.Date expiryDate, double price, double discountRate, String location, boolean isSurplus, boolean isForDonation) throws SQLException {
        RetailerInventory inventory = new RetailerInventory(retailerId, itemName, quantity, expiryDate, price, discountRate, location, isSurplus, isForDonation);
        inventoryDAO.addInventory(inventory);
    }

    public List<RetailerInventory> getAllItems(int id) throws SQLException {
        return inventoryDAO.getAllRetailerInventoriesById(id);
    }

    public void markAsSurplus(int itemId) throws SQLException {
        RetailerInventory item = inventoryDAO.getInventoryById(itemId);
        if (item != null) {
            item.setSurplus(true);
            inventoryDAO.updateInventory(item);
        }
    }

    public List<RetailerInventory> getAllSurplusFoodById(int id) throws SQLException{
        return inventoryDAO.getAllSurplusInventoriesById(id);
    }

    public List<RetailerInventory> getAllDonationFoodById(int id) throws SQLException{
        return inventoryDAO.getAllDonationInventoriesById(id);
    }

    public List<RetailerInventory> getAllSurplusFood() throws SQLException{
        return inventoryDAO.getAllSurplusInventories();
    }
}
