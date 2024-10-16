-- V1__Create_initial_schema.sql
CREATE TABLE IF NOT EXISTS Customer (
    CustomerId INT(11) PRIMARY KEY,
    CustomerName VARCHAR(25) DEFAULT NULL,
    CustomerAddress VARCHAR(20) DEFAULT NULL,
    CustomerPhone VARCHAR(15) DEFAULT NULL
    );