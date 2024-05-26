package view.NavBar;

import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import view.App;

public class MemberNavBar {
    public MenuBar createPanel(Object[] stageList, Object[] NavList, Stage primaryStage) {
        MenuBar menuBar = new MenuBar();
        Menu search = new Menu("搜尋");
        search.getItems().add(new MenuItem("搜尋"));
        Menu rank = new Menu("排行榜");
        rank.getItems().add(new MenuItem("排行榜"));
        Menu borrow = new Menu("借書");
        borrow.getItems().add(new MenuItem("借書"));
        Menu returnBook = new Menu("還書");
        returnBook.getItems().add(new MenuItem("還書"));
        Menu personalInfo = new Menu("個人資料");
        personalInfo.getItems().add(new MenuItem("個人資料"));
        Menu logout = new Menu("登出");
        logout.getItems().add(new MenuItem("登出"));
        menuBar.getMenus().add(search);
        menuBar.getMenus().add(rank);
        menuBar.getMenus().add(borrow);
        menuBar.getMenus().add(returnBook);
        menuBar.getMenus().add(personalInfo);
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
        borrow.setOnAction(e -> {
            setAllStageListInvisible(stageList);
            ((GridPane) stageList[5]).setVisible(true);

        });
        returnBook.setOnAction(e -> {
            App.updateReturnBookPanel(stageList);
            setAllStageListInvisible(stageList);
            ((GridPane) stageList[7]).setVisible(true);

        });
        logout.setOnAction(e -> {
            App.logout();
            ((MenuBar) NavList[0]).setVisible(false);
            ((MenuBar) NavList[2]).setVisible(false);
            ((MenuBar) NavList[1]).setVisible(true);
            setAllStageListInvisible(stageList);
            ((GridPane) stageList[0]).setVisible(true);

        });
        personalInfo.setOnAction(e -> {
            // TODO: show personal info
            setAllStageListInvisible(stageList);
            ((GridPane) stageList[6]).setVisible(true);

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
