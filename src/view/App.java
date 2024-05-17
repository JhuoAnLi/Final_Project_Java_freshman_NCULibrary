package view;

import java.util.ArrayList;

import javafx.application.Application;
import javafx.scene.control.Button;
import javafx.scene.control.MenuBar;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import object.Books;
import object.Member;
import object.Student;
import view.Book.BookReturn;
import view.NavBar.MemberNavBar;
import view.NavBar.NavBar;
import view.User.Login;
import view.User.PersonalInfo;
public class App extends Application{
    private static Member currentLoginMember;
    public static ArrayList<Member> members = new ArrayList<Member>();
    public static ArrayList<Books> books = new ArrayList<Books>();
    public static void main(String[] args) {
        members.add(new Student("student1", "student1", "student1", "Student", 20));
        books.add(new Books("book1", "author1", "category1", 1, "文學", "Available"));
        books.add(new Books("book2", "author2", "category2", 2, "文學", "Available"));
        launch(args);
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
    public static void setLoginMember(Member member) {
        currentLoginMember = member;
    }
    public static Member getLoginMember() {
        return currentLoginMember;
    }
    public static void logout() {
        currentLoginMember = null;
    }
    public static void updateBookBorrow(Object[] stageList) {
        BookReturn.updatePanel(stageList);
    }

    
    @Override
    public void start(Stage primaryStage) throws Exception {
        // test for object books
        ArrayList<Books> books = getBooks();
        Object[] stageList = new Object[10];
        Object[] NavList = new Object[3];
        GridPane loginPanal = new Login().createPanel(stageList, primaryStage, NavList);
        GridPane registerPanal = new view.User.Register().createPanel(stageList, primaryStage);
        GridPane rankPanal = new view.Book.Rank().createPanel(stageList, primaryStage, books);
        GridPane searchPanal = new view.Book.Search().createPanel(stageList, primaryStage, books);
        GridPane bookBorrowPanal = new view.Book.BookBorrow().createPanel(stageList, primaryStage, books);
        GridPane PersonalInfoPanal = new view.User.PersonalInfo().createPanel(stageList, primaryStage);
        GridPane bookReturnPanal = new view.Book.BookReturn().createPanel();

        
        //add nav bar to the scene

        //create a four block grid for four buttons, each button will lead to a different page
        GridPane mainPage = CreateMainPage(stageList, primaryStage);

        StackPane mainStackPage = new StackPane();
        mainStackPage.getChildren().add(loginPanal);
        mainStackPage.getChildren().add(registerPanal);
        mainStackPage.getChildren().add(rankPanal);
        mainStackPage.getChildren().add(searchPanal);
        mainStackPage.getChildren().add(bookBorrowPanal);
        mainStackPage.getChildren().add(PersonalInfoPanal);
        mainStackPage.getChildren().add(bookReturnPanal);
        mainStackPage.getChildren().add(mainPage);

        StackPane NavStackPage = new StackPane();
        MenuBar memberNav = new MemberNavBar().createPanel(stageList, primaryStage);
        MenuBar nav = new NavBar().createPanel(stageList, primaryStage);
        NavStackPage.getChildren().add(memberNav);
        NavStackPage.getChildren().add(nav);

        stageList[0] = loginPanal;
        stageList[1] = registerPanal;
        stageList[2] = rankPanal;
        stageList[3] = searchPanal;
        stageList[4] = mainPage;
        stageList[5] = bookBorrowPanal;
        stageList[6] = PersonalInfoPanal;
        stageList[7] = bookReturnPanal;

        NavList[0] = memberNav;
        NavList[1] = nav;

        VBox wholeView = new VBox();
        wholeView.getChildren().add(NavStackPage);
        wholeView.getChildren().add(mainStackPage);


        javafx.scene.Scene scene = new javafx.scene.Scene(wholeView, 800, 600);
        
        primaryStage.setScene(scene);

        primaryStage.setTitle("圖書管理系統");
        // add the primary stage to the scene
        primaryStage.show();
    }
    private void setAllStageListInvisible(Object[] stageList) {
        for (int i = 0; i < stageList.length; i++) {
            if(stageList[i] == null) break;
            ((GridPane) stageList[i]).setVisible(false);
        }
    }
    private GridPane CreateMainPage(Object[] stageList, Stage primaryStage) {
        GridPane gridPane = new GridPane();
        // set grid width and height
        int width = 800;
        int height = 600;
        gridPane.setPrefWidth(width);
        gridPane.setPrefHeight(height);
        // set the alignment
        gridPane.setAlignment(javafx.geometry.Pos.CENTER);
        // set the background color
        gridPane.setStyle("-fx-background-color: #FFFFFF;");

        // add the buttons
        Button loginButton = new Button("登入");
        // set loginButton style to full grid
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
            // set visible for the search result table and other to invisible
            setAllStageListInvisible(stageList);
            ((GridPane) stageList[3]).setVisible(true);

        });
        gridPane.add(searchButton, 1, 2);
        return gridPane;
    }
}
