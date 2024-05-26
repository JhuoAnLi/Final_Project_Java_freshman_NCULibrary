package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import object.Books;

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

    public static ArrayList<Books> getAllBooks() { // 從db抓出來所有東西，再把它開arraylist又全部存在memory，超棒 我懶
        ArrayList<Books> books = new ArrayList<>();
        try (PreparedStatement stmt = conn.prepareStatement("SELECT * FROM books")) {
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                String name = rs.getString("name");
                String author = rs.getString("author");
                String publisher = rs.getString("publisher");
                int ISBN = rs.getInt("ISBN");
                String category = rs.getString("category");
                String status = rs.getString("status");

                Books book = new Books(name, author, publisher, ISBN, category, status);
                books.add(book);
            }
        } catch (SQLException e) {
            System.out.println("Failed to retrieve books from database");
            e.printStackTrace();
        }
        return books;
    }

    public static void deleteBook(String bookName) {
        try (PreparedStatement stmt = conn.prepareStatement("DELETE FROM books WHERE name = ?")) {
            stmt.setString(1, bookName);
            int rowsDeleted = stmt.executeUpdate();
            if (rowsDeleted > 0) {
                System.out.println("A book was deleted successfully!");
            }
        } catch (SQLException e) {
            System.out.println("Failed to delete book from database");
            e.printStackTrace();
        }
    }
}
