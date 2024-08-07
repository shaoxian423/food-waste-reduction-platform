DROP DATABASE IF EXISTS FWRP;
CREATE DATABASE FWRP;
USE FWRP;

CREATE TABLE users (
                       id INT AUTO_INCREMENT PRIMARY KEY,
                       name VARCHAR(100) NOT NULL,
                       email VARCHAR(100) NOT NULL UNIQUE,
                       password VARCHAR(100) NOT NULL,
                       phone VARCHAR(100),
                       communication_method ENUM('email', 'phone'),
                       user_type ENUM('retailer', 'consumer', 'charity') NOT NULL
);

CREATE TABLE retailer_inventory (
                                    id INT AUTO_INCREMENT PRIMARY KEY,
                                    retailer_id INT,
                                    item_name VARCHAR(100) NOT NULL,
                                    quantity INT NOT NULL,
                                    expiry_date DATE NOT NULL,
                                    price DOUBLE NOT NULL,
                                    discount_rate DOUBLE,
                                    location VARCHAR(100) NOT NULL,
                                    is_surplus BOOLEAN DEFAULT FALSE,
                                    is_for_donation BOOLEAN DEFAULT FALSE,
                                    FOREIGN KEY (retailer_id) REFERENCES Users(id)
);

CREATE TABLE transaction (
                             id INT AUTO_INCREMENT PRIMARY KEY,
                             timestamp TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
                             user_id INT,
                             inventory_id INT,
                             quantity INT NOT NULL,
                             FOREIGN KEY (user_id) REFERENCES Users(id),
                             FOREIGN KEY (inventory_id) REFERENCES Retailer_Inventory(id)
);

CREATE TABLE user_subscription (
                                   id INT AUTO_INCREMENT PRIMARY KEY,
                                   user_id INT,
                                   location VARCHAR(100),
                                   food_preference VARCHAR(100),
                                   FOREIGN KEY (user_id) REFERENCES Users(id)
);

CREATE TABLE notifications (
                               id INT AUTO_INCREMENT PRIMARY KEY,
                               user_id INT,
                               inventory_id INT,
                               processed BOOLEAN DEFAULT FALSE,
                               FOREIGN KEY (user_id) REFERENCES Users(id),
                               FOREIGN KEY (inventory_id) REFERENCES Retailer_Inventory(id)
);

DROP TRIGGER IF EXISTS set_surplus_on_insert;
DELIMITER //
CREATE TRIGGER set_surplus_on_insert
    BEFORE INSERT ON retailer_inventory
    FOR EACH ROW
BEGIN
    DECLARE expiry_date_limit DATE;
    SET expiry_date_limit = DATE_ADD(CURDATE(), INTERVAL 7 DAY);

    IF NEW.is_surplus IS TRUE THEN
        SET NEW.is_surplus = TRUE;
    ELSE
        IF NEW.expiry_date <= expiry_date_limit THEN
            SET NEW.is_surplus = TRUE;
        ELSE
            SET NEW.is_surplus = FALSE;
        END IF;
    END IF;
END;
//
DELIMITER ;

DROP TRIGGER IF EXISTS set_surplus_on_update;
DELIMITER //
CREATE TRIGGER set_surplus_on_update
    BEFORE UPDATE ON retailer_inventory
    FOR EACH ROW
BEGIN
    DECLARE expiry_date_limit DATE;
    SET expiry_date_limit = DATE_ADD(CURDATE(), INTERVAL 7 DAY);

    IF NEW.is_surplus IS TRUE THEN
        SET NEW.is_surplus = TRUE;
    ELSE
        IF NEW.expiry_date <= expiry_date_limit THEN
            SET NEW.is_surplus = TRUE;
        ELSE
            SET NEW.is_surplus = FALSE;
        END IF;
    END IF;
END;
//
DELIMITER ;

DROP EVENT IF EXISTS update_surplus_status;
DELIMITER //
CREATE EVENT update_surplus_status
    ON SCHEDULE EVERY 1 DAY
    DO
    BEGIN
        DECLARE expiry_date_limit DATE;
        SET expiry_date_limit = DATE_ADD(CURDATE(), INTERVAL 7 DAY);

        -- Automatically set items as surplus based on expiry date
        UPDATE retailer_inventory
        SET is_surplus = TRUE
        WHERE expiry_date <= expiry_date_limit AND is_surplus = FALSE;

        -- Optionally, reset items not in surplus range if needed
        -- UPDATE retailer_inventory
        -- SET is_surplus = FALSE
        -- WHERE expiry_date > expiry_date_limit AND is_surplus = TRUE;
    END;
//
DELIMITER ;

DROP TRIGGER IF EXISTS deduct_quantity_on_insert;
DELIMITER //

CREATE TRIGGER deduct_quantity_on_insert
    AFTER INSERT ON transaction
    FOR EACH ROW
BEGIN
    UPDATE retailer_inventory
    SET quantity = quantity - NEW.quantity
    WHERE id = NEW.inventory_id;

END;

//
DELIMITER ;

DROP TRIGGER IF EXISTS after_inventory_insert;
DELIMITER //

CREATE TRIGGER after_inventory_insert
    AFTER INSERT ON retailer_inventory
    FOR EACH ROW
BEGIN
    -- Insert notifications for matching user subscriptions based on location or food preference
    INSERT INTO notifications (user_id, inventory_id)
    SELECT user_id, NEW.id
    FROM user_subscription
    WHERE location = NEW.location
       OR NEW.item_name LIKE CONCAT('%', food_preference, '%');
END;
//

DELIMITER ;
