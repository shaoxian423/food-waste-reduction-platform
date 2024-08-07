package com.duan.fwrp.entity;

public class UserSubscription {
    private int id;
    private int userId;
    private String communicationMethod;
    private String location;
    private String foodPreference;

    public UserSubscription(int id, int userId, String communicationMethod, String location, String foodPreference) {
        this.id = id;
        this.userId = userId;
        this.communicationMethod = communicationMethod;
        this.location = location;
        this.foodPreference = foodPreference;
    }

    public UserSubscription(int userId, String communicationMethod, String location, String foodPreference) {
        this.userId = userId;
        this.communicationMethod = communicationMethod;
        this.location = location;
        this.foodPreference = foodPreference;
    }

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public int getUserId() {
        return userId;
    }
    public void setUserId(int userId) {
        this.userId = userId;
    }
    public String getCommunicationMethod() {
        return communicationMethod;
    }
    public void setCommunicationMethod(String communicationMethod) {
        this.communicationMethod = communicationMethod;
    }
    public String getLocation() {
        return location;
    }
    public void setLocation(String location) {
        this.location = location;
    }
    public String getFoodPreference() {
        return foodPreference;
    }
    public void setFoodPreference(String foodPreference) {
        this.foodPreference = foodPreference;
    }
}
