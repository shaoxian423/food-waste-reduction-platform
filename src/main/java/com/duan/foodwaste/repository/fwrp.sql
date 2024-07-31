DROP DATABASE IF EXISTS FWRP;
CREATE DATABASE FWRP;
USE FWRP;

CREATE TABLE Users (
                       id INT AUTO_INCREMENT PRIMARY KEY,
                       name VARCHAR(100) NOT NULL,
                       email VARCHAR(100) NOT NULL UNIQUE,
                       password VARCHAR(100) NOT NULL,
                       user_type ENUM('retailer', 'consumer', 'charity') NOT NULL
);

CREATE TABLE Inventory (
                           id INT AUTO_INCREMENT PRIMARY KEY,
                           retailer_id INT,
                           food_item VARCHAR(100) NOT NULL,
                           quantity INT NOT NULL,
                           expiration_date DATE NOT NULL,
                           FOREIGN KEY (retailer_id) REFERENCES Users(id)
);

CREATE TABLE SurplusFood (
                             id INT AUTO_INCREMENT PRIMARY KEY,
                             inventory_id INT,
                             is_for_sale BOOLEAN NOT NULL,
                             discount_price DECIMAL(10, 2),
                             FOREIGN KEY (inventory_id) REFERENCES Inventory(id)
);

CREATE TABLE Alerts (
                        id INT AUTO_INCREMENT PRIMARY KEY,
                        user_id INT,
                        location VARCHAR(100),
                        communication_method ENUM('email', 'phone'),
                        food_preference VARCHAR(100),
                        FOREIGN KEY (user_id) REFERENCES Users(id)
);
