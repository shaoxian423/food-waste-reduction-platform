package com.duan.fwrp.service;

import java.sql.SQLException;
import java.util.List;
import com.duan.fwrp.entity.Notification;
import com.duan.fwrp.entity.Users;
import com.duan.fwrp.entity.RetailerInventory;
import com.duan.fwrp.dao.UsersDAO;
import com.duan.fwrp.dao.RetailerInventoryDAO;

public class NotificationPollingTask {

    private static final NotificationService notificationService = new NotificationService();

    public static void pollNotifications() {
        List<Notification> newNotifications = notificationService.getNewNotifications();
        for (Notification notification : newNotifications) {
            // Perform actions on new notifications
            try{
                int userId = notification.getUserId();
                int inventoryId = notification.getInventoryId();

                UsersDAO usersDAO = new UsersDAO();
                Users user = usersDAO.getUser(userId);
                String communicationMethod = user.getCommunicationMethod();
                String email = user.getEmail();
                String phone = user.getPhone();

                RetailerInventoryDAO retailerInventoryDAO = new RetailerInventoryDAO();
                RetailerInventory inventory = retailerInventoryDAO.getInventoryById(inventoryId);
                String itemName = inventory.getItemName();
                String quantity = String.valueOf(inventory.getQuantity());
                String expiryDate = String.valueOf(inventory.getExpiryDate());
                double price = inventory.getPrice();
                double discount_rate = inventory.getDiscountRate();
                String location = inventory.getLocation();

                StringBuilder sb = new StringBuilder();
                sb.append("New Food Available: ").append(itemName).append("\n");
                sb.append("Quantity: ").append(quantity).append("\n");
                sb.append("Expiry Date: ").append(expiryDate).append("\n");
                sb.append("Price: ").append(price).append("\n");
                sb.append("Discount Rate: ").append(discount_rate).append("\n");
                sb.append("Location: ").append(location).append("\n");
                String message = sb.toString();

                switch (communicationMethod) {
                    case "email":
                        EmailSender.sendEmail(email, "New Food Available", message);
                        System.out.println("Notification sent by email.");
                        break;
                    case "phone":
                        SmsSender.sendMessage(phone, message);
                        System.out.println("Notification sent by phone.");
                        break;
                    default:
                        System.out.println("Notification sent failed.");
                }

            }catch(SQLException e){
                e.printStackTrace();
            }
            // Add your custom logic here
        }
        // Mark notifications as processed
        notificationService.markAsProcessed(newNotifications);
    }
}
