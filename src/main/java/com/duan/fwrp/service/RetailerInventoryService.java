package com.duan.fwrp.service;

import com.duan.fwrp.dao.RetailerInventoryDAO;
import com.duan.fwrp.entity.RetailerInventory;

import java.sql.SQLException;
import java.util.List;

public class RetailerInventoryService {
    private RetailerInventoryDAO inventoryDAO;

    public RetailerInventoryService() {
        try {
            inventoryDAO = new RetailerInventoryDAO();
        } catch (SQLException e) {
            throw new RuntimeException("Failed to initialize RetailerInventoryDAO", e);
        }
    }

    public void addItem(String retailerId, String itemName, int quantity, String expiryDate, double price, double discountRate) {
        RetailerInventory item = new RetailerInventory(retailerId, itemName, quantity, expiryDate, price, discountRate);
        inventoryDAO.save(item);
    }

    public List<RetailerInventory> getAllItems() {
        return inventoryDAO.findAll();
    }

    public List<RetailerInventory> getAllInventories() {
        return inventoryDAO.getAllRetailerInventories();
    }

    public void markAsSurplus(String itemId) {
        RetailerInventory item = inventoryDAO.findById(itemId);
        if (item != null) {
            item.setSurplus(true);
            inventoryDAO.update(item);
        }
    }
}
