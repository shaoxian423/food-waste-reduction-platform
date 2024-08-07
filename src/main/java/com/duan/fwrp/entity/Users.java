package com.duan.fwrp.entity;

public class Users {
    private int id;
    private String name;
    private String email;
    private String password;
    private String phone;
    private String communicationMethod;
    private String user_type; // Changed from userType

    // Getters and Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getUserType() {
        return user_type; // Ensure this matches the database and is used correctly
    }

    public void setUserType(String userType) {
        this.user_type = userType; // Ensure this matches the database
    }

    public String getCommunicationMethod() {
        return communicationMethod;
    }
    public void setCommunicationMethod(String communicationMethod) {
        this.communicationMethod = communicationMethod;
    }
}
