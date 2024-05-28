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

    public static void modifyBook(Books book) {
        try (PreparedStatement stmt = conn.prepareStatement(
                "UPDATE books SET author = ?, publisher = ?, ISBN = ?, category = ?, status = ? WHERE name = ?")) {
            stmt.setString(1, book.getAuthor());
            stmt.setString(2, book.getPublisher());
            stmt.setInt(3, book.getISBN());
            stmt.setString(4, book.getCategory());
            stmt.setString(5, book.getStatus());
            stmt.setString(6, book.getName());

            int rowsUpdated = stmt.executeUpdate();
            if (rowsUpdated > 0) {
                System.out.println("A book was updated successfully!");
            }
        } catch (SQLException e) {
            System.out.println("Failed to update book in database");
            e.printStackTrace();
        }
    }

    public static void addBook(Books book) {
        try (PreparedStatement stmt = conn.prepareStatement(
                "INSERT INTO books (name, author, publisher, ISBN, category, status) VALUES (?, ?, ?, ?, ?, ?)")) {
            stmt.setString(1, book.getName());
            stmt.setString(2, book.getAuthor());
            stmt.setString(3, book.getPublisher());
            stmt.setInt(4, book.getISBN());
            stmt.setString(5, book.getCategory());
            stmt.setString(6, book.getStatus());

            int rowsInserted = stmt.executeUpdate();
            if (rowsInserted > 0) {
                System.out.println("A new book was inserted successfully!");
            }
        } catch (SQLException e) {
            System.out.println("Failed to insert book into database");
            e.printStackTrace();
        }
    }

    public static void borrowBook(Books book) {
        try (PreparedStatement stmt = conn.prepareStatement("UPDATE books SET status = 'Unavailable' WHERE name = ?")) {
            stmt.setString(1, book.getName());

            int rowsUpdated = stmt.executeUpdate();
            if (rowsUpdated > 0) {
                System.out.println("A book was borrowed successfully!");
            }
        } catch (SQLException e) {
            System.out.println("Failed to borrow book from database");
            e.printStackTrace();
        }
    }

    public static void returnBook(Books book) {
        try (PreparedStatement stmt = conn.prepareStatement("UPDATE books SET status = 'Available' WHERE name = ?")) {
            stmt.setString(1, book.getName());

            int rowsUpdated = stmt.executeUpdate();
            if (rowsUpdated > 0) {
                System.out.println("A book was returned successfully!");
            }
        } catch (SQLException e) {
            System.out.println("Failed to return book to database");
            e.printStackTrace();
        }
    }

}
