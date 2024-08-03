package com.duan.fwrp.dao;

import com.duan.fwrp.entity.SurplusFood;
import com.duan.fwrp.util.DatabaseUtil;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class SurplusFoodDAO {

    public List<SurplusFood> getAllSurplusFoods() throws SQLException {
        List<SurplusFood> surplusFoodList = new ArrayList<>();
        String sql = "SELECT * FROM surplusfood";
        try (Connection connection = DatabaseUtil.getConnection();
             Statement stmt = connection.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                SurplusFood surplusFood = new SurplusFood(
                        rs.getInt("id"),
                        rs.getInt("inventory_id"),
                        rs.getBoolean("is_for_sale"),
                        rs.getDouble("discounted_price"),
                        rs.getString("item_name"),
                        rs.getInt("quantity"),
                        rs.getDate("expiry_date"),
                        rs.getDouble("price")
                );
                surplusFoodList.add(surplusFood);
            }
        }
        return surplusFoodList;
    }

    public void markAsSurplus(int inventoryId, double discountedPrice) throws SQLException {
        String sql = "INSERT INTO surplusfood(inventory_id, discount_price) VALUES(?, ?) ";
        try (Connection connection = DatabaseUtil.getConnection()){
            PreparedStatement pstmt = connection.prepareStatement(sql);
            pstmt.setInt(1, inventoryId);
            pstmt.setDouble(2, discountedPrice);
            pstmt.executeUpdate();
        }
    }

}
