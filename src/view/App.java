package view;


import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import database.Mysql;
import javafx.application.Application;
import javafx.scene.control.Button;
import javafx.scene.control.MenuBar;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import object.Admin;
import object.Books;
import object.Member;
import object.Student;
import object.Teacher;
import view.Book.BookReturn;
import view.Book.Rank;
import view.NavBar.AdminNavBar;
import view.NavBar.MemberNavBar;
import view.NavBar.NavBar;
import view.User.Login;
import view.User.PersonalInfo;

public class App extends Application {
    private static Member currentLoginMember;
    private static Admin currentLoginAdmin;
    public static ArrayList<Member> members = new ArrayList<Member>();
    public static ArrayList<Admin> admins = new ArrayList<Admin>();
    public static ArrayList<Books> books = Mysql.getAllBooks();

    public static void main(String[] args) {
        members.add(new Student("student1", "student1", "student1", "Student", 20));
        members.add(new Teacher("teacher1", "teacher1", "teacher1", "Teacher", 20));
        admins.add(new Admin("admin", "admin", "admin"));
        // firstTime();
        Mysql mysql = new Mysql(); // connect to database
        launch(args);
    }

    public static void firstTime() {
        addBook(new Books("To Kill a Mockingbird", "Harper Lee", "J.B. Lippincott & Co.", 978002609, "文學",
                "Available"));
        addBook(new Books("1984", "George Orwell", "Secker & Warburg", 978045135, "文學", "Available"));
        addBook(new Books("Pride and Prejudice", "Jane Austen", "T. Egerton", 978019518, "文學", "Available"));
        addBook(new Books("The Great Gatsby", "F. Scott Fitzgerald", "Charles Scribner's Sons", 978027355, "文學",
                "Available"));
        addBook(new Books("Moby-Dick", "Herman Melville", "Harper & Brothers", 978280786, "文學", "Available"));

        addBook(new Books("Sapiens: A Brief History of Humankind", "Yuval Noah Harari", "Harvill Secker", 978090088,
                "歷史", "Available"));
        addBook(new Books("Guns, Germs, and Steel", "Jared Diamond", "W. W. Norton & Company", 978039558, "歷史",
                "Available"));
        addBook(new Books("The History of the Ancient World", "Susan Wise Bauer", "W. W. Norton & Company", 978039348,
                "歷史", "Available"));

        addBook(new Books("Clean Code", "Robert C. Martin", "Prentice Hall", 132350884, "科技", "Available"));
        addBook(new Books("The Pragmatic Programmer", "Andrew Hunt", "Addison-Wesley", 978616224, "科技", "Available"));

        addBook(new Books("The Art of Computer Programming", "Donald E. Knuth", "Addison-Wesley", 978026847, "數學",
                "Available"));
        addBook(new Books("A Mathematician's Apology", "G. H. Hardy", "Cambridge University Press", 978027067, "數學",
                "Available"));

        addBook(new Books("Learning Python", "Mark Lutz", "O'Reilly Media", 979355739, "語言", "Available"));
        addBook(new Books("The Elements of Style", "William Strunk Jr.", "Pearson", 975309023, "語言", "Available"));

        addBook(new Books("The Story of Art", "E.H. Gombrich", "Phaidon Press", 97832470, "藝術", "Available"));

    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        // test for object books
        ArrayList<Books> books = getBooks();
        Object[] stageList = new Object[15];
        Object[] NavList = new Object[3];

        GridPane loginPanal = new Login().createPanel(stageList, primaryStage, NavList);
        GridPane registerPanal = new view.User.Register().createPanel(stageList, primaryStage);
        GridPane rankPanal = new view.Book.Rank().createPanel(stageList, primaryStage);
        GridPane searchPanal = new view.Book.Search().createPanel(stageList, primaryStage, books);
        GridPane bookBorrowPanal = new view.Book.BookBorrow().createPanel(stageList, primaryStage, books);
        GridPane PersonalInfoPanal = new view.User.PersonalInfo().createPanel(stageList, primaryStage);
        GridPane bookReturnPanal = new view.Book.BookReturn().createPanel(stageList, primaryStage);
        GridPane bookAddPanal = new view.Book.AddBook().createPanel(stageList, primaryStage);
        GridPane manageBookPanel = new view.Book.ManageBook().createPanel(stageList, primaryStage);
        GridPane membersInfoPanel = new view.User.MembersInfo().createPanel();
        GridPane bookStatusPane = new view.Book.BookStatus().createPanel(stageList, primaryStage);
        GridPane mainPage = CreateMainPage(stageList, primaryStage);

        StackPane mainStackPage = new StackPane();
        mainStackPage.getChildren().add(loginPanal);
        mainStackPage.getChildren().add(registerPanal);
        mainStackPage.getChildren().add(rankPanal);
        mainStackPage.getChildren().add(searchPanal);
        mainStackPage.getChildren().add(bookBorrowPanal);
        mainStackPage.getChildren().add(PersonalInfoPanal);
        mainStackPage.getChildren().add(bookReturnPanal);
        mainStackPage.getChildren().add(bookAddPanal);
        mainStackPage.getChildren().add(manageBookPanel);
        mainStackPage.getChildren().add(membersInfoPanel);
        mainStackPage.getChildren().add(bookStatusPane);
        mainStackPage.getChildren().add(mainPage);

        StackPane NavStackPage = new StackPane();
        MenuBar memberNav = new MemberNavBar().createPanel(stageList, NavList, primaryStage);
        MenuBar nav = new NavBar().createPanel(stageList, primaryStage);
        MenuBar adminNav = new AdminNavBar().createPanel(stageList, NavList, primaryStage);
        NavStackPage.getChildren().add(memberNav);
        NavStackPage.getChildren().add(adminNav);
        NavStackPage.getChildren().add(nav);

        stageList[0] = loginPanal;
        stageList[1] = registerPanal;
        stageList[2] = rankPanal;
        stageList[3] = searchPanal;
        stageList[4] = mainPage;
        stageList[5] = bookBorrowPanal;
        stageList[6] = PersonalInfoPanal;
        stageList[7] = bookReturnPanal;
        stageList[8] = bookAddPanal;
        stageList[9] = manageBookPanel;
        stageList[10] = membersInfoPanel;
        stageList[11] = bookStatusPane;

        NavList[0] = memberNav;
        NavList[1] = nav;
        NavList[2] = adminNav;

        // create the main page, contains navbar and stackpane
        VBox wholeView = new VBox();
        wholeView.getChildren().add(NavStackPage);
        wholeView.getChildren().add(mainStackPage);

        // create scene, put view in scene
        javafx.scene.Scene scene = new javafx.scene.Scene(wholeView, 800, 600);
        primaryStage.setScene(scene);
        primaryStage.setTitle("圖書管理系統");
        primaryStage.show();
    }

    private void setAllStageListInvisible(Object[] stageList) {
        // set all stage in stageList invisible, simplify the code
        for (int i = 0; i < stageList.length; i++) {
            if (stageList[i] == null)
                break;
            ((GridPane) stageList[i]).setVisible(false);
        }
    }

    private Button createStyledButton(String text, int width, int height) {
        Button button = new Button(text);
        button.setPrefWidth(width / 2);
        button.setPrefHeight(height / 8);
        button.setFont(Font.font("Arial", 22));
        button.setStyle("-fx-background-color: #4CAF50; -fx-text-fill: white; -fx-background-radius: 10;");
        button.setOnMouseEntered(e -> button
                .setStyle("-fx-background-color: #45a049; -fx-text-fill: white; -fx-background-radius: 10;"));
        button.setOnMouseExited(e -> button
                .setStyle("-fx-background-color: #4CAF50; -fx-text-fill: white; -fx-background-radius: 10;"));
        return button;
    }

    private GridPane CreateMainPage(Object[] stageList, Stage primaryStage) {
        // Initialize the GridPane
        GridPane gridPane = new GridPane();
        int width = 800;
        int height = 600;
        gridPane.setPrefWidth(width);
        gridPane.setPrefHeight(height);
        gridPane.setAlignment(javafx.geometry.Pos.TOP_CENTER);
        gridPane.setStyle("-fx-background-color: linear-gradient(to bottom, #ffffff, #e6e6e6);");

        Rectangle background = new Rectangle(width, height);
        background.setFill(Color.LIGHTBLUE);
        gridPane.add(background, 0, 0, 2, 2);

        // Add a title
        Text title = new Text("Main Menu for Library System");
        title.setFont(Font.font("Times New Roman", FontWeight.BOLD, FontPosture.ITALIC, 40));
        title.setFill(Color.DARKSLATEGRAY);

        // Add the title to the gridPane
        gridPane.add(title, 0, 0, 2, 1);
        GridPane.setHalignment(title, javafx.geometry.HPos.CENTER);
        GridPane.setMargin(title, new javafx.geometry.Insets(20, 0, 20, 0));

        // Create buttons
        Button loginButton = createStyledButton("登入", width, height);
        loginButton.setOnAction(e -> {
            setAllStageListInvisible(stageList);
            ((GridPane) stageList[0]).setVisible(true);
        });

        Button registerButton = createStyledButton("註冊", width, height);
        registerButton.setOnAction(e -> {
            setAllStageListInvisible(stageList);
            ((GridPane) stageList[1]).setVisible(true);
        });

        Button rankButton = createStyledButton("排行榜", width, height);
        rankButton.setOnAction(e -> {
            setAllStageListInvisible(stageList);
            ((GridPane) stageList[2]).setVisible(true);
        });

        Button searchButton = createStyledButton("搜尋", width, height);
        searchButton.setOnAction(e -> {
            setAllStageListInvisible(stageList);
            ((GridPane) stageList[3]).setVisible(true);
        });

        // Add buttons to a VBox for better layout

        VBox buttonBox = new VBox(20, loginButton, registerButton, searchButton, rankButton);
        buttonBox.setAlignment(javafx.geometry.Pos.CENTER);
        gridPane.add(buttonBox, 0, 1, 2, 1);

        return gridPane;
    }

    public static ArrayList<Member> getMembers() {
        return members;
    }

    public static ArrayList<Books> getBooks() {
        return books;
    }

    public static Member MemberLogin(String username, String password, Object[] stageList) {
        for (Member member : members) {
            if (member.login(username, password)) {
                setLoginMember(member);
                PersonalInfo.updatePanel(stageList);
                BookReturn.updatePanel(stageList);
                return member;
            }
        }
        return null;
    }

    public static Admin AdminLogin(String username, String password, Object[] stageList) {
        for (Admin member : admins) {
            if (member.login(username, password)) {
                setLoginAdmin(member);
                return member;
            }
        }
        return null;
    }

    public static void setLoginMember(Member member) {
        currentLoginMember = member;
    }

    public static Member getLoginMember() {
        return currentLoginMember;
    }

    public static void setLoginAdmin(Admin admin) {
        currentLoginAdmin = admin;
    }

    public static Admin getLoginAdmin() {
        return currentLoginAdmin;
    }

    public static void logout() {
        currentLoginMember = null;
        currentLoginAdmin = null;
    }

    public static void updateRankList(Object[] stageList) {
        stageList[2] = new Rank().createPanel(stageList, null);
    }

    public static void addBook(Books book) {
        // check if the book is already in the database
        books.add(book);
        try (PreparedStatement stmt = Mysql.conn.prepareStatement("SELECT * FROM books")) {
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                String name = rs.getString("name");
                String author = rs.getString("author");
                String publisher = rs.getString("publisher");
                int ISBN = rs.getInt("ISBN");
                String category = rs.getString("category");
                String status = rs.getString("status");

                Books b = new Books(name, author, publisher, ISBN, category, status);
                if (b.getName().equals(book.getName())) {
                    JOptionPane.showMessageDialog(null, "書籍已存在");
                    return;
                }
            }
        } catch (SQLException e) {
            System.out.println("Failed to retrieve books from database");
            e.printStackTrace();
        }

        // If no matching book is found, add the new book
        Mysql.addBook(book); // call the method to add the book to the database
        JOptionPane.showMessageDialog(null, "新增成功");
    }

    public static void modifyBook(Books book) {
        // check if the book is in DB
        Mysql.modifyBook(book); // call the method to update the book in the database
        JOptionPane.showMessageDialog(null, "更新成功");
    }

    public static void deleteBook(Books book) {
        // check if the book is in DB
        boolean isExist = false;
        books = Mysql.getAllBooks(); // update the books list
        for (int i = 0; i < books.size(); i++) {
            if (books.get(i).getName().equals(book.getName())) {
                isExist = true;
                books.remove(i);
                Mysql.deleteBook(book.getName()); // call the method to delete the book from the database
                JOptionPane.showMessageDialog(null, "刪除成功");
                break;
            }
        }
        if (!isExist) {
            JOptionPane.showMessageDialog(null, "書籍不存在");
        }
    }

    public static void register(Member member) {
        // check if the account is already in the database
        for (Member m : members) {
            if (m.getAccount().equals(member.getAccount())) {
                JOptionPane.showMessageDialog(null, "帳號已存在");
                return;
            }
        }
        members.add(member);
        JOptionPane.showMessageDialog(null, "註冊成功");
    }

    public static void updateReturnBookPanel(Object[] stageList) {
        BookReturn.updatePanel(stageList);
    }

    public static void updateBookStatusPanel(Object[] stageList) {

    }
}
