package src;
import javax.swing.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.PreparedStatement;

public class Admin extends User {
    public static Books[] books = new Books[500];

    ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
    java.net.URL resourcec = classLoader.getResource("resources/" + "Check_books.png");
    ImageIcon Check_bookss = new ImageIcon(resourcec);
    java.net.URL resourcece = classLoader.getResource("resources/" + "Money.png");
    ImageIcon Moneyy = new ImageIcon(resourcece);
    java.net.URL resourcecew = classLoader.getResource("resources/" + "Rank.png");
    ImageIcon tgtgg = new ImageIcon(resourcecew);

    public Admin(String name, String account, String password) {
        super(name, account, password);
    }

    private Connection connectToDatabase() throws SQLException {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            System.out.println("MySQL JDBC Driver not found. Include it in your library path ");
            e.printStackTrace();
            return null;
        }
        String url = "jdbc:mysql://localhost:3306/java_final_project";
        String user = "java";
        String password = "java";
        return DriverManager.getConnection(url, user, password);
    }

    public void add_book(String name, String author, String publisher, int ISBN, String category, String status) {
        Books book = new Books(name, author, publisher, ISBN, category, status);
        for (int i = 0; i < books.length; i++) {
            if (books[i] == null) {
                books[i] = book;
                break;
            }
        }

        // Add book to database
        try (Connection conn = connectToDatabase()) {
            System.out.println("Connected to the database");
            String sql = "INSERT INTO books (name, author, publisher, ISBN, category, status) VALUES (?, ?, ?, ?, ?, ?)";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, name);
            pstmt.setString(2, author);
            pstmt.setString(3, publisher);
            pstmt.setInt(4, ISBN);
            pstmt.setString(5, category);
            pstmt.setString(6, status);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public void delete_book(int ISBN) {
        for (int i = 0; i < books.length; i++) {
            if (books[i] != null && books[i].getISBN() == ISBN) {
                books[i] = null;
                break;
            }
        }
    }

    public void update_book_author(String name, String author) {
        for (int i = 0; i < books.length; i++) {
            if (books[i] != null && books[i].getName().equals(name)) {
                books[i].setName(name);
                books[i].setAuthor(author);
                break;
            }
        }
    }

    public void update_book_publisher(String name, String publisher) {
        for (int i = 0; i < books.length; i++) {
            if (books[i] != null && books[i].getName().equals(name)) {
                books[i].setName(name);
                books[i].setPublisher(publisher);
                break;
            }
        }
    }

    public void update_book_ISBN(String name, int ISBN) {
        for (int i = 0; i < books.length; i++) {
            if (books[i] != null && books[i].getName().equals(name)) {
                books[i].setName(name);
                books[i].setISBN(ISBN);
                break;
            }
        }
    }

    public void update_book_category(String name, String category) {
        for (int i = 0; i < books.length; i++) {
            if (books[i] != null && books[i].getName().equals(name)) {
                books[i].setName(name);
                books[i].setCategory(category);
                break;
            }
        }
    }

    public void update_book_status(String name, String status) {
        for (int i = 0; i < books.length; i++) {
            if (books[i] != null && books[i].getName().equals(name)) {
                books[i].setName(name);
                books[i].setStatus(status);
                break;
            }
        }
    }

    public boolean login(String account, String password) {
        if (account.equals(this.account) && password.equals(this.password)) {
            return true;
        } else {
            return false;
        }
    }

    public void check_members(String member_account) {
        String ab = "";
        for (int i = 0; i < App.members.length; i++) {
            if (App.members[i] != null && App.members[i].getAccount().equals(member_account)) {
                ab += "Account: " + App.members[i].getAccount() + "\nName: " + App.members[i].getName() + "\nIdentity: "
                        + App.members[i].getIdentity() + "\nAge: " + App.members[i].getAge() + "\nDeadline: "
                        + App.members[i].getDeadlinee() + " seconds\nFine: " + App.members[i].getFine()
                        + " dollars\nMax_borrow: " + App.members[i].getMax_borrow();
                JOptionPane.showMessageDialog(null, ab);

                break;
            } else if (App.members[i] == null && i == App.members.length - 1) {
                JOptionPane.showMessageDialog(null, "No such member!");
                break;
            }
        }
    }

    public void check_books() {
        String ab = "";
        String abb = "";
        int er = 1;
        String[] hh = { "Available", "Unavailable" };
        String ty = "There is no available books!";
        String tyy = "There is no unavailable books!";
        for (int i = 0; i < books.length; i++) {
            if (books[i] != null && books[i].getStatus().equals("Available")) {
                if (i < 20) {
                    ab += " " + er + ". " + books[i].getName() + "\n";
                    er++;
                }
            }
            if (books[i] != null && books[i].getStatus().equals("Unavailable")) {
                abb += "Name: " + books[i].getName() + "\nBorrower's Account:" + books[i].getBorrower() + "\n";

            }
        }
        int choicee = JOptionPane.showOptionDialog(null, "Please choose the book you want to check: ", "Books",
                JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, Check_bookss, hh, hh[0]);

        if (choicee == 0) {
            if (ab == "") {
                JOptionPane.showMessageDialog(null, ty);

            } else {
                JOptionPane.showMessageDialog(null, ab);

            }

        }
        if (choicee == 1) {
            if (abb == "") {
                JOptionPane.showMessageDialog(null, tyy);
            } else {
                JOptionPane.showMessageDialog(null, abb);
            }

        }
    }

    public void check_fine() {
        int total = 0;
        for (int i = 0; i < App.members.length; i++) {
            if (App.members[i] != null && App.members[i].getTotalFine() > 0) {
                total += App.members[i].getTotalFine();
            }
        }
        JOptionPane.showMessageDialog(null, "Total fine: " + total + " dollar(s)", "Total Fine",
                JOptionPane.INFORMATION_MESSAGE, Moneyy);
    }

    public void ranking() {
        String k = "";
        int[] rank = new int[books.length];
        String[] rank1 = new String[books.length];

        for (int i = 0; i < books.length; i++) {
            if (books[i] != null) {
                rank[i] = books[i].getsearchCount() + books[i].getTotalBorrowNum();
                rank1[i] = books[i].getName();
            } else {
                rank[i] = 0;
                rank1[i] = "";
            }

        }
        for (int h = 0; h < rank.length; h++) {
            for (int j = 0; j < rank.length - 1; j++) {
                if (rank[j] < rank[j + 1]) {

                    int temp = rank[j];
                    rank[j] = rank[j + 1];
                    rank[j + 1] = temp;

                    String temp1 = rank1[j];
                    rank1[j] = rank1[j + 1];
                    rank1[j + 1] = temp1;
                }
            }
        }
        for (int i = 0; i < 5; i++) {
            k += "Top " + (i + 1) + ": " + rank1[i] + " ( " + rank[i] + " )\n";

        }
        JOptionPane.showMessageDialog(null, k, "Ranking", JOptionPane.INFORMATION_MESSAGE, tgtgg);

    }

}
