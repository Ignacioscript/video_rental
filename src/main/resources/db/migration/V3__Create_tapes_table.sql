-- V3__Create_tapes_table.sql
CREATE TABLE IF NOT EXISTS Tapes (
                                     TapeID INT(11) PRIMARY KEY,
    TitleID INT(11) DEFAULT NULL,
    Type CHAR(3) DEFAULT NULL,
    FOREIGN KEY (TitleID) REFERENCES Titles(TitleID)
    );