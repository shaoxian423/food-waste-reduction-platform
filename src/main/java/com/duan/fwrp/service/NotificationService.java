package com.duan.fwrp.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import com.duan.fwrp.entity.Notification;
import com.duan.fwrp.util.DatabaseUtil;

public class NotificationService {

    public List<Notification> getNewNotifications() {
        List<Notification> notifications = new ArrayList<>();

        String query = "SELECT id, user_id, inventory_id, processed FROM notifications WHERE processed = 0";

        try (Connection conn = DatabaseUtil.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                Notification notification = new Notification();
                notification.setId(rs.getInt("id"));
                notification.setUserId(rs.getInt("user_id"));
                notification.setInventoryId(rs.getInt("inventory_id"));
                notification.setProcessed(rs.getBoolean("processed"));
                notifications.add(notification);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return notifications;
    }

    public void markAsProcessed(List<Notification> notifications) {
        String updateQuery = "UPDATE notifications SET processed = 1 WHERE id = ?";

        try (Connection conn = DatabaseUtil.getConnection();
             PreparedStatement stmt = conn.prepareStatement(updateQuery)) {

            for (Notification notification : notifications) {
                stmt.setLong(1, notification.getId());
                stmt.executeUpdate();
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

