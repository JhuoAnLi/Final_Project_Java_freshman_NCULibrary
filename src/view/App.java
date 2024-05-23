package view;

import java.util.ArrayList;

import javax.swing.JOptionPane;

import javafx.application.Application;
import javafx.scene.control.Button;
import javafx.scene.control.MenuBar;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import object.Admin;
import object.Books;
import object.Member;
import object.Student;
import object.Teacher;
import view.Book.Rank;
import view.NavBar.AdminNavBar;
import view.NavBar.MemberNavBar;
import view.NavBar.NavBar;
import view.User.Login;
import view.User.PersonalInfo;
public class App extends Application{
    private static Member currentLoginMember;
    private static Admin currentLoginAdmin;
    public static ArrayList<Member> members = new ArrayList<Member>();
    public static ArrayList<Admin> admins = new ArrayList<Admin>();
    public static ArrayList<Books> books = new ArrayList<Books>();
    public static void main(String[] args) {
        members.add(new Student("student1", "student1", "student1", "Student", 20));
        members.add(new Teacher("teacher1", "teacher1", "teacher1", "Teacher", 20));
        admins.add(new Admin("admin", "admin", "admin"));
        books.add(new Books("book1", "author1", "category1", 1, "文學", "Available"));
        books.add(new Books("book2", "author2", "category2", 2, "文學", "Available"));
        launch(args);
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
        GridPane membersInfoPanel = new view.User.MembersInfo().createPanel(stageList, primaryStage);
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
            if(stageList[i] == null) break;
            ((GridPane) stageList[i]).setVisible(false);
        }
    }
    private GridPane CreateMainPage(Object[] stageList, Stage primaryStage) {
        // initiallize the gridPane
        GridPane gridPane = new GridPane();
        int width = 800;
        int height = 600;
        gridPane.setPrefWidth(width);
        gridPane.setPrefHeight(height);
        gridPane.setAlignment(javafx.geometry.Pos.CENTER);
        gridPane.setStyle("-fx-background-color: #FFFFFF;");

        // add the buttons
        Button loginButton = new Button("登入");
        loginButton.setPrefWidth(width/2);
        loginButton.setPrefHeight(height/2);
        loginButton.setOnAction(e -> {
            setAllStageListInvisible(stageList);
            ((GridPane) stageList[0]).setVisible(true);
        });
        gridPane.add(loginButton, 0, 1);

        Button registerButton = new Button("註冊");
        registerButton.setPrefWidth(width/2);
        registerButton.setPrefHeight(height/2);
        registerButton.setOnAction(e -> {
            setAllStageListInvisible(stageList);
            ((GridPane) stageList[1]).setVisible(true);
           
        });
        gridPane.add(registerButton, 1, 1);

        Button rankButton = new Button("排行榜");
        rankButton.setPrefWidth(width/2);
        rankButton.setPrefHeight(height/2);
        rankButton.setOnAction(e -> {
            setAllStageListInvisible(stageList);
            ((GridPane) stageList[2]).setVisible(true);
        });
        gridPane.add(rankButton, 0, 2);

        Button searchButton = new Button("搜尋");
        searchButton.setPrefWidth(width/2);
        searchButton.setPrefHeight(height/2);
        searchButton.setOnAction(e -> {
            setAllStageListInvisible(stageList);
            ((GridPane) stageList[3]).setVisible(true);
        });
        gridPane.add(searchButton, 1, 2);

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
        // TODO: SQL
        boolean isExist = false;
        for(Books b : books) {
            if(b.getName().equals(book.getName())) {
                isExist = true;
                break;
            }
        }
        if(!isExist){
            books.add(book);
            JOptionPane.showMessageDialog(null, "新增成功");
        }
        else {
            JOptionPane.showMessageDialog(null, "書籍已存在");
        }
    }
    public static void modifyBook(Books book) {
        // check if the book is in DB
        // TODO: SQL
        boolean isExist = false;
        for(int i = 0; i < books.size(); i++) {
            if(books.get(i).getName().equals(book.getName())) {
                isExist = true;
                books.set(i, book);
                JOptionPane.showMessageDialog(null, "修改成功");
                break;
            }
        }
        if(!isExist) {
            JOptionPane.showMessageDialog(null, "書籍不存在");
        }
    }
    public static void deleteBook(Books book) {
        // check if the book is in DB
        // TODO: SQL
        boolean isExist = false;
        for(int i = 0; i < books.size(); i++) {
            if(books.get(i).getName().equals(book.getName())) {
                isExist = true;
                books.remove(i);
                JOptionPane.showMessageDialog(null, "刪除成功");
                break;
            }
        }
        if(!isExist) {
            JOptionPane.showMessageDialog(null, "書籍不存在");
        }
    }
    public static void register(Member member){
        // check if the account is already in the database
        for(Member m : members) {
            if(m.getAccount().equals(member.getAccount())) {
                JOptionPane.showMessageDialog(null, "帳號已存在");
                return;
            }
        }
        members.add(member);
        JOptionPane.showMessageDialog(null, "註冊成功");
    }
}
