package config;

import java.io.InputStream;
import java.util.Properties;

public class DatabaseConfig {


    private static Properties properties = new Properties();

    static {
        try(InputStream input = DatabaseConfig.class.getClassLoader().getResourceAsStream("db.properties")){
            properties.load(input);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public static String getProperty(String key){
        return properties.getProperty(key);

    }

    public static Integer getIntProperty(String key){
        return Integer.valueOf(properties.getProperty(key));

    }


}
