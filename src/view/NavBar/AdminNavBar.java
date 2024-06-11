package view.NavBar;

import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import view.App;

public class AdminNavBar {
    public MenuBar createPanel(Object[] stageList, Object[] NavList, Stage primaryStage) {
        MenuBar menuBar = new MenuBar();

        Menu search = new Menu("搜尋");
        search.getItems().add(new MenuItem("搜尋"));

        Menu rank = new Menu("排行榜");
        rank.getItems().add(new MenuItem("排行榜"));

        Menu manageBook = new Menu("管理書籍");
        MenuItem addBook = new MenuItem("增加書籍");
        MenuItem updateBook = new MenuItem("修改書籍");
        MenuItem checkBook = new MenuItem("查看書籍");
        manageBook.getItems().add(addBook);
        manageBook.getItems().add(updateBook);
        manageBook.getItems().add(checkBook);

        Menu memberInfo = new Menu("會員資訊");
        memberInfo.getItems().add(new MenuItem("會員資訊"));

        Menu logout = new Menu("登出");
        logout.getItems().add(new MenuItem("登出"));
        
        menuBar.getMenus().add(search);
        menuBar.getMenus().add(rank);
        menuBar.getMenus().add(manageBook);
        menuBar.getMenus().add(memberInfo);
        menuBar.getMenus().add(logout);

        menuBar.setPrefWidth(800);

        search.setOnAction(e -> {
            setAllStageListInvisible(stageList);
            ((GridPane) stageList[3]).setVisible(true);
        });
        rank.setOnAction(e -> {
            App.updateRankList(stageList);
            setAllStageListInvisible(stageList);
            ((GridPane) stageList[2]).setVisible(true);
            
        });
        addBook.setOnAction(e -> {
            setAllStageListInvisible(stageList);
            ((GridPane) stageList[8]).setVisible(true);
        });
        updateBook.setOnAction(e -> {
            setAllStageListInvisible(stageList);
            ((GridPane) stageList[9]).setVisible(true);
        });
        checkBook.setOnAction(e -> {
            setAllStageListInvisible(stageList);
            ((GridPane) stageList[11]).setVisible(true);
        });
        memberInfo.setOnAction(e -> {
            setAllStageListInvisible(stageList);
            ((GridPane) stageList[10]).setVisible(true);
        });

        logout.setOnAction(e -> {
            App.logout();
            ((MenuBar) NavList[0]).setVisible(false);
            ((MenuBar) NavList[2]).setVisible(false);
            ((MenuBar) NavList[1]).setVisible(true);
            setAllStageListInvisible(stageList);
            ((GridPane) stageList[4]).setVisible(true);
        });

        return menuBar;
    }
    private void setAllStageListInvisible(Object[] stageList) {
        for (int i = 0; i < stageList.length; i++) {
            if(stageList[i] == null) break;
            ((GridPane) stageList[i]).setVisible(false);
        }
    }

}
