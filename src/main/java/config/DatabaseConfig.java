package config;

import org.flywaydb.core.Flyway;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.Properties;

public class DatabaseConfig {


    private static Properties properties = new Properties();

    static {
        try(InputStream input = DatabaseConfig.class.getClassLoader().getResourceAsStream("db.properties")){
            if(input == null){
                throw new RuntimeException("Unable to find protperties");
            }
            properties.load(input);
            //properties.setProperty("db.url", System.getenv("DB_URL"));
            properties.setProperty("db.user", System.getenv("DB_USER"));
            properties.setProperty("db.password", System.getenv("DB_PASSWORD"));



        } catch (Exception e) {
            throw new RuntimeException("Failed to load properties", e);
        }
    }



    public static String getProperty(String key){
        return properties.getProperty(key);

    }

    public static Integer getIntProperty(String key){
        return Integer.valueOf(properties.getProperty(key));

    }



}
