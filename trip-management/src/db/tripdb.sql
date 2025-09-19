DROP DATABASE IF EXISTS trip_management;

CREATE DATABASE trip_management;
USE trip_management;

CREATE TABLE IF NOT EXISTS Trip (
    trip_id INT PRIMARY KEY AUTO_INCREMENT,
    destination VARCHAR(50) NOT NULL,
    start_date DATE NOT NULL,
    end_date DATE NOT NULL,
    price DECIMAL(10,2) NOT NULL,
    status ENUM('PLANNED','ONGOING','COMPLETED') DEFAULT 'PLANNED',
);