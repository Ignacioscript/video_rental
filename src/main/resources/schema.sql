

create database if not exists video_rental;

use video_rental;

CREATE TABLE IF NOT EXISTS Customers (
                                         CustomerId INT(11) NOT NULL PRIMARY KEY,
    CustomerName VARCHAR(25),
    CustomerAddress VARCHAR(20),
    CustomerPhone VARCHAR(15)
    );

CREATE TABLE IF NOT EXISTS Titles (
                                      TitleID INT(11) NOT NULL PRIMARY KEY,
    Title VARCHAR(50),
    Year INT(11),
    Price FLOAT,
    URL VARCHAR(50),
    Image BLOB
    );

CREATE TABLE IF NOT EXISTS Orders (
                                      OrderNumber INT(11) NOT NULL PRIMARY KEY,
    CustomerID INT(11),
    TapeID INT(11),
    DueDate DATE,
    Status CHAR(1),
    FOREIGN KEY (CustomerID) REFERENCES Customers(CustomerId),
    FOREIGN KEY (TapeID) REFERENCES Titles(TitleID)
    );

CREATE TABLE IF NOT EXISTS Tapes (
                                     TapeID INT(11) NOT NULL PRIMARY KEY,
    TitleID INT(11),
    Type CHAR(3),
    FOREIGN KEY (TitleID) REFERENCES Titles(TitleID)
    );

