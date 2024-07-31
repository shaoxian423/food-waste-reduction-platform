package com.duan.fwrp.dao;

import com.duan.fwrp.entity.SurplusFood;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import com.duan.fwrp.util.DatabaseUtil;


public class SurplusFoodDAO {
    public List<SurplusFood> getAllSurplusFoods() {
        List<SurplusFood> surplusFoods = new ArrayList<>();
        try (Connection connection = DatabaseUtil.getConnection();
             PreparedStatement statement = connection.prepareStatement("SELECT * FROM SurplusFood");
             ResultSet resultSet = statement.executeQuery()) {

            while (resultSet.next()) {
                SurplusFood food = new SurplusFood();
                food.setId(resultSet.getInt("id"));
                food.setInventoryId(resultSet.getInt("inventory_id"));
                food.setRetailerId(resultSet.getInt("retailer_id"));
                food.setFoodItem(resultSet.getString("food_item"));
                food.setQuantity(resultSet.getInt("quantity"));
                food.setExpireDate(resultSet.getDate("expire_date"));
                food.setPrice(resultSet.getDouble("price"));
                food.setDiscountRate(resultSet.getDouble("discount_rate"));
                food.setIsForSale(resultSet.getBoolean("is_for_sale"));
                surplusFoods.add(food);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return surplusFoods;
    }
    public void markAsSurplus(int inventoryId, boolean isForSale, double discountRate) throws SQLException {
        String sql = "UPDATE SurplusFood SET is_for_sale = ?, discount_rate = ? WHERE inventory_id = ?";
        try (Connection connection = DatabaseUtil.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setBoolean(1, isForSale);
            statement.setDouble(2, discountRate);
            statement.setInt(3, inventoryId);
            statement.executeUpdate();
        } catch (SQLException e) {
            throw new SQLException("Error marking as surplus", e);
        }
    }
}


