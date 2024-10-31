package config;

import io.github.cdimascio.dotenv.Dotenv;

public class DatabaseConfig {

//
//    private static Properties properties = new Properties();
//
//    static {
//        try(InputStream input = DatabaseConfig.class.getClassLoader().getResourceAsStream(".env")){
//            if(input == null){
//                throw new RuntimeException("Unable to find properties");
//            }
//            properties.load(input);
////            properties.setProperty("db.url", System.getenv("DB_URL"));
////            properties.setProperty("db.user", System.getenv("DB_USER"));
////            properties.setProperty("db.password", System.getenv("DB_PASSWORD"));
//
//            Dotenv dotenv = Dotenv.load();
//            properties.setProperty("db.url", dotenv.get("dvurl"));
//            properties.setProperty("db.user", dotenv.get("dvuser"));
//            properties.setProperty("db.password", dotenv.get("dvpassword"));
//
//
//        } catch (Exception e) {
//            throw new RuntimeException("Failed to load properties", e);
//        }
//    }


//

    private static final Dotenv dotenv = Dotenv.configure().load();

    public static String getDbUrl() {
        return dotenv.get("dvurl");
    }

    public static String getDbUser() {
        return dotenv.get("dvuser");
    }

    public static String getDbPassword() {
        return dotenv.get("dvpassword");
    }



//    public static String getProperty(String key){
//        return properties.getProperty(key);
//
//    }
//
//    public static Integer getIntProperty(String key){
//        return Integer.valueOf(properties.getProperty(key));
//
//    }



}
