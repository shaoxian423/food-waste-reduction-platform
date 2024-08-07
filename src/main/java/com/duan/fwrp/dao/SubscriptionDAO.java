package com.duan.fwrp.dao;

import com.duan.fwrp.entity.UserSubscription;
import com.duan.fwrp.util.DatabaseUtil;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class SubscriptionDAO {

    public void insertSubscription(UserSubscription subscription) throws SQLException {
        String sql = "INSERT INTO user_subscription(user_id, location, food_preference) VALUES (?, ?, ?)";
        Connection connection = DatabaseUtil.getConnection();
        PreparedStatement stmt = connection.prepareStatement(sql);
        stmt.setInt(1, subscription.getUserId());
        stmt.setString(2, subscription.getLocation());
        stmt.setString(3, subscription.getFoodPreference());
        stmt.executeUpdate();
    }
}
