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

    public void markAsSurplus(int id, boolean isSurplus, double discountedPrice) throws SQLException {
        String sql = "UPDATE surplusfood SET is_for_sale = ?, discounted_price = ? WHERE id = ?";
        try (Connection connection = DatabaseUtil.getConnection();
             PreparedStatement pstmt = connection.prepareStatement(sql)) {
            pstmt.setBoolean(1, isSurplus);
            pstmt.setDouble(2, discountedPrice);
            pstmt.setInt(3, id);
            pstmt.executeUpdate();
        }
    }

}
