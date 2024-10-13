package util;

import config.DatabaseConfig;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

public class DBUtil {

//    private static final HikariConfig config = new HikariConfig();
//    private static final HikariDataSource ds;

  private static final String URL = DatabaseConfig.getProperty("db.url");
  private static final String USER = DatabaseConfig.getProperty("db.user");
  private static final String PASSWORD = DatabaseConfig.getProperty("db.password");
  private static final String CACHE_PREP = DatabaseConfig.getProperty("dataSource.cachePrepStmts");
  private static final String CACHE_STMT_SIZE = DatabaseConfig.getProperty("dataSource.prepStmtCacheSize");
  private static final String CACHE_STMT_SQL_LIMIT = DatabaseConfig.getProperty("dataSource.prepStmtCacheSqlLimit");
  private static final String POOL_SIZE = DatabaseConfig.getProperty("maximumPoolSize");

//    static {
//        config.setJdbcUrl(URL);
//        config.setUsername(USER);
//        config.setPassword(PASSWORD);
//        config.addDataSourceProperty("cachePrepStmts", CACHE_PREP);
//        config.addDataSourceProperty("prepStmtCacheSize", CACHE_STMT_SIZE);
//        config.addDataSourceProperty("prepStmtCacheSqlLimit", CACHE_STMT_SQL_LIMIT);
//        config.setMaximumPoolSize(Integer.parseInt(POOL_SIZE));
//
//        ds =new HikariDataSource(config);
//}
    public static Connection getConnection(){
        try{

           return DriverManager.getConnection(URL, USER, PASSWORD);  //TODO reiew how different work Driver Manager and Hiraki go to NOTION and restore de Driver Manager code
           //return ds.getConnection();
        }catch (SQLException e){
            e.printStackTrace();
            throw new RuntimeException("Operation Failed", e);
        }
    }
}
