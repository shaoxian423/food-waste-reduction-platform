package com.duan.fwrp.service;

import com.duan.fwrp.dao.SubscriptionDAO;
import com.twilio.rest.events.v1.Subscription;
import com.duan.fwrp.entity.UserSubscription;

import java.sql.SQLException;

public class UserSubscriptionService {
    private SubscriptionDAO subscriptionDAO;

    public UserSubscriptionService() {
        subscriptionDAO = new SubscriptionDAO();
    }
    public void addSubscription(int userId, String location, String foodPreference) throws SQLException {
        UserSubscription subscription = new UserSubscription(userId, location, foodPreference);
        subscriptionDAO.insertSubscription(subscription);
    }
}
