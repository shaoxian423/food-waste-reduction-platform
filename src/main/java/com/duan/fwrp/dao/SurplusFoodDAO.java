package com.duan.fwrp.dao;

import com.duan.fwrp.entity.SurplusFood;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import com.duan.fwrp.util.DatabaseUtil;

public class SurplusFoodDAO {
    public void markAsSurplus(int inventoryId, boolean isForSale, double discountPrice) throws SQLException {
        String query = "INSERT INTO SurplusFood (inventory_id, is_for_sale, discount_price) VALUES (?, ?, ?)";
        try (Connection conn = DatabaseUtil.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setInt(1, inventoryId);
            stmt.setBoolean(2, isForSale);
            stmt.setDouble(3, discountPrice);
            stmt.executeUpdate();
        }
    }

    public List<SurplusFood> getAllSurplusFood() throws SQLException {
        List<SurplusFood> surplusFoodList = new ArrayList<>();
        String query = "SELECT * FROM SurplusFood";
        try (Connection conn = DatabaseUtil.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(query)) {
            while (rs.next()) {
                int id = rs.getInt("id");
                int inventoryId = rs.getInt("inventory_id");
                boolean isForSale = rs.getBoolean("is_for_sale");
                double discountPrice = rs.getDouble("discount_price");
                SurplusFood surplusFood = new SurplusFood(id, inventoryId, isForSale, discountPrice);
                surplusFoodList.add(surplusFood);
            }
        }
        return surplusFoodList;
    }
}

