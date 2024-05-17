package view.NavBar;

import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import view.App;

public class AdminNavBar {
    public MenuBar createPanel(Object[] stageList, Stage primaryStage) {
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

        Menu logout = new Menu("登出");
        logout.getItems().add(new MenuItem("登出"));
        menuBar.getMenus().add(search);
        menuBar.getMenus().add(rank);
        menuBar.getMenus().add(manageBook);
        menuBar.getMenus().add(logout);

        menuBar.setPrefWidth(800);

        search.setOnAction(e -> {
            setAllStageListInvisible(stageList);
            ((GridPane) stageList[3]).setVisible(true);
        });
        rank.setOnAction(e -> {
            setAllStageListInvisible(stageList);
            ((GridPane) stageList[2]).setVisible(true);
            
        });
        addBook.setOnAction(e -> {
            setAllStageListInvisible(stageList);
        });
        updateBook.setOnAction(e -> {
            setAllStageListInvisible(stageList);
        });
        checkBook.setOnAction(e -> {
            setAllStageListInvisible(stageList);
        });
        logout.setOnAction(e -> {
            App.logout();
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
