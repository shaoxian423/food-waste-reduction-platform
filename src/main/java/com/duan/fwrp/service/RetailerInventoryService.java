package com.duan.fwrp.service;

import com.duan.fwrp.dao.RetailerInventoryDAO;
import com.duan.fwrp.dao.SurplusFoodDAO;
import com.duan.fwrp.entity.RetailerInventory;
import com.duan.fwrp.entity.SurplusFood;

import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;

public class RetailerInventoryService {
    private RetailerInventoryDAO retailerInventoryDAO = new RetailerInventoryDAO();
    private SurplusFoodDAO surplusFoodDAO = new SurplusFoodDAO();

    public void addInventory(RetailerInventory item) throws SQLException {
        retailerInventoryDAO.addInventory(item);
    }

    public void markAsSurplus(int itemId, boolean isForSale, double discountPrice) throws SQLException {
        surplusFoodDAO.markAsSurplus(itemId, isForSale, discountPrice);
    }

    public List<RetailerInventory> getAllInventory() throws SQLException {
        return retailerInventoryDAO.getAllInventory();
    }

    public void checkAndMarkSurplusItems() throws SQLException {
        List<RetailerInventory> inventoryList = retailerInventoryDAO.getAllInventory();
        LocalDate today = LocalDate.now();
        for (RetailerInventory item : inventoryList) {
            if (item.getExpireDate().isBefore(today.plusWeeks(1))) {
                surplusFoodDAO.markAsSurplus(item.getId(), false, item.getPrice() * (1 - item.getDiscountRate() / 100));
            }
        }
    }

    public List<SurplusFood> getAllSurplusFood() throws SQLException {
        return surplusFoodDAO.getAllSurplusFood();
    }
}

