package com.duan.fwrp.dao;

import com.duan.fwrp.entity.ConsumerSubscription;
import com.duan.fwrp.entity.CharitySubscription;
import com.duan.fwrp.util.DatabaseUtil;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class SubscriptionDAO {

    // Add a consumer subscription
    public void addConsumerSubscription(ConsumerSubscription subscription) throws SQLException {
        String sql = "INSERT INTO Consumer_Subscription (consumer_id, inventory_id, notification_method) VALUES (?, ?, ?)";
        try (Connection connection = DatabaseUtil.getConnection();
             PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, subscription.getConsumerId());
            stmt.setInt(2, subscription.getInventoryId());
            stmt.setString(3, subscription.getNotificationMethod());
            stmt.executeUpdate();
        }
    }

    // Add a charity subscription
    public void addCharitySubscription(CharitySubscription subscription) throws SQLException {
        String sql = "INSERT INTO Charity_Subscription (charity_id, inventory_id, notification_method) VALUES (?, ?, ?)";
        try (Connection connection = DatabaseUtil.getConnection();
             PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, subscription.getCharityId());
            stmt.setInt(2, subscription.getInventoryId());
            stmt.setString(3, subscription.getNotificationMethod());
            stmt.executeUpdate();
        }
    }

    // Get consumer subscriptions by consumer ID
    public List<ConsumerSubscription> getConsumerSubscriptions(int consumerId) throws SQLException {
        String sql = "SELECT * FROM Consumer_Subscription WHERE consumer_id = ?";
        List<ConsumerSubscription> subscriptions = new ArrayList<>();
        try (Connection connection = DatabaseUtil.getConnection();
             PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, consumerId);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                ConsumerSubscription subscription = new ConsumerSubscription();
                subscription.setId(rs.getInt("id"));
                subscription.setConsumerId(rs.getInt("consumer_id"));
                subscription.setInventoryId(rs.getInt("inventory_id"));
                subscription.setNotificationMethod(rs.getString("notification_method"));
                subscriptions.add(subscription);
            }
        }
        return subscriptions;
    }

    // Get charity subscriptions by charity ID
    public List<CharitySubscription> getCharitySubscriptions(int charityId) throws SQLException {
        String sql = "SELECT * FROM Charity_Subscription WHERE charity_id = ?";
        List<CharitySubscription> subscriptions = new ArrayList<>();
        try (Connection connection = DatabaseUtil.getConnection();
             PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, charityId);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                CharitySubscription subscription = new CharitySubscription();
                subscription.setId(rs.getInt("id"));
                subscription.setCharityId(rs.getInt("charity_id"));
                subscription.setInventoryId(rs.getInt("inventory_id"));
                subscription.setNotificationMethod(rs.getString("notification_method"));
                subscriptions.add(subscription);
            }
        }
        return subscriptions;
    }

    // Remove a consumer subscription
    public void removeConsumerSubscription(int id) throws SQLException {
        String sql = "DELETE FROM Consumer_Subscription WHERE id = ?";
        try (Connection connection = DatabaseUtil.getConnection();
             PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, id);
            stmt.executeUpdate();
        }
    }

    // Remove a charity subscription
    public void removeCharitySubscription(int id) throws SQLException {
        String sql = "DELETE FROM Charity_Subscription WHERE id = ?";
        try (Connection connection = DatabaseUtil.getConnection();
             PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, id);
            stmt.executeUpdate();
        }
    }
}
