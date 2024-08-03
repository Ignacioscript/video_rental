package util;

import config.DatabaseConfig;

import javax.xml.crypto.Data;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBUtil {

    private static final String URL = DatabaseConfig.getProperty("db.url");
    private static final String USER = DatabaseConfig.getProperty("db.user");
    private static final String PASSWORD = DatabaseConfig.getProperty("db.password");


    public static Connection getConnection(){
        try{

            return DriverManager.getConnection(URL, USER, PASSWORD);
        }catch (SQLException e){
            e.printStackTrace();
            throw new RuntimeException("Operation Failed", e);
        }
    }
}
