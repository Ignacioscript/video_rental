-- V4__Create_orders_table.sql
CREATE TABLE IF NOT EXISTS Orders (
                                      OrderNumber INT(11) PRIMARY KEY,
    CustomerID INT(11) DEFAULT NULL,
    TapeID INT(11) DEFAULT NULL,
    DueDate DATE DEFAULT NULL,
    Status CHAR(1) DEFAULT NULL,
    FOREIGN KEY (CustomerID) REFERENCES Customer(CustomerId),
    FOREIGN KEY (TapeID) REFERENCES Tapes(TapeID)
    );