DROP DATABASE IF EXISTS FWRP;
CREATE DATABASE FWRP;
USE FWRP;

-- 创建 Users 表
CREATE TABLE Users (
                       id INT AUTO_INCREMENT PRIMARY KEY,
                       name VARCHAR(100) NOT NULL,
                       email VARCHAR(100) NOT NULL UNIQUE,
                       password VARCHAR(100) NOT NULL,
                       phone VARCHAR(100),
                       user_type ENUM('retailer', 'consumer', 'charity') NOT NULL
);

-- 创建 Retailer_Inventory 表
CREATE TABLE Retailer_Inventory (
                                    id INT AUTO_INCREMENT PRIMARY KEY,
                                    retailer_id INT,
                                    item_name VARCHAR(100) NOT NULL,
                                    quantity INT NOT NULL,
                                    expiry_date DATE NOT NULL,
                                    price DOUBLE NOT NULL,
                                    discount_rate DOUBLE,
                                    is_surplus BOOLEAN DEFAULT FALSE,
                                    FOREIGN KEY (retailer_id) REFERENCES Users(id)
);

-- 创建 Consumer_Transaction 表
CREATE TABLE Consumer_Transaction (
                                      id INT AUTO_INCREMENT PRIMARY KEY,
                                      timestamp TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
                                      consumer_id INT,
                                      inventory_id INT,
                                      quantity INT NOT NULL,
                                      expiry_date DATE NOT NULL,
                                      price DOUBLE NOT NULL,
                                      discount_rate DOUBLE,
                                      FOREIGN KEY (consumer_id) REFERENCES Users(id),
                                      FOREIGN KEY (inventory_id) REFERENCES Retailer_Inventory(id)
);

-- 创建 Charity_Transaction 表
CREATE TABLE Charity_Transaction (
                                     id INT AUTO_INCREMENT PRIMARY KEY,
                                     timestamp TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
                                     charity_id INT,
                                     inventory_id INT,
                                     quantity INT NOT NULL,
                                     expiry_date DATE NOT NULL,
                                     price DOUBLE NOT NULL,
                                     FOREIGN KEY (charity_id) REFERENCES Users(id),
                                     FOREIGN KEY (inventory_id) REFERENCES Retailer_Inventory(id)
);

-- 创建 Consumer_Subscription 表
CREATE TABLE Consumer_Subscription (
                                       id INT AUTO_INCREMENT PRIMARY KEY,
                                       consumer_id INT,
                                       inventory_id INT,
                                       notification_method ENUM('email', 'phone'),
                                       FOREIGN KEY (consumer_id) REFERENCES Users(id),
                                       FOREIGN KEY (inventory_id) REFERENCES Retailer_Inventory(id)
);

-- 创建 Charity_Subscription 表
CREATE TABLE Charity_Subscription (
                                      id INT AUTO_INCREMENT PRIMARY KEY,
                                      charity_id INT,
                                      inventory_id INT,
                                      notification_method ENUM('email', 'phone'),
                                      FOREIGN KEY (charity_id) REFERENCES Users(id),
                                      FOREIGN KEY (inventory_id) REFERENCES Retailer_Inventory(id)
);

-- 创建 Alerts 表
CREATE TABLE Alerts (
                        id INT AUTO_INCREMENT PRIMARY KEY,
                        user_id INT,
                        location VARCHAR(100),
                        communication_method ENUM('email', 'phone'),
                        food_preference VARCHAR(100),
                        FOREIGN KEY (user_id) REFERENCES Users(id)
);

-- 创建 SurplusFood 表（如需保留）
CREATE TABLE SurplusFood (
                             id INT AUTO_INCREMENT PRIMARY KEY,
                             inventory_id INT,
                             is_for_sale BOOLEAN NOT NULL,
                             discount_price DECIMAL(10, 2),
                             FOREIGN KEY (inventory_id) REFERENCES Retailer_Inventory(id)
);
