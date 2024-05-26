package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Mysql {
    public static Connection conn = null;

    static {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            String url = "jdbc:mysql://localhost:3306/java_final_project";
            String user = "java";
            String password = "java";
            conn = DriverManager.getConnection(url, user, password);
            System.out.println("Connected to the database");
        } catch (ClassNotFoundException e) {
            System.out.println("MySQL JDBC Driver not found. Include it in your library path ");
            e.printStackTrace();
        } catch (SQLException e) {
            System.out.println("Failed to create connection to database");
            e.printStackTrace();
        }
    }
}
