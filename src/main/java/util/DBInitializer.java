package util;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class DBInitializer {

    public static void initializeDatabase() {
        try (Connection conn = DBUtil.getConnection()) {

            // Check if the table exists
            Statement checkStmt = conn.createStatement();
            ResultSet rs = checkStmt.executeQuery("SHOW TABLES LIKE 'Customers'");
            if (rs.next()) {
                System.out.println("Tables already exist, skipping schema creation.");
                return;
            }

            // Execute schema SQL if tables don't exist
            try (BufferedReader reader = new BufferedReader(
                    new InputStreamReader(DBInitializer.class.getResourceAsStream("/schema")))) {
                StringBuilder sql = new StringBuilder();
                String line;
                while ((line = reader.readLine()) != null) {
                    sql.append(line);
                }
                Statement stmt = conn.createStatement();
                stmt.execute(sql.toString());
                System.out.println("Database schema created successfully.");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
