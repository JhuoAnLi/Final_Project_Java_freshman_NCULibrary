package view.NavBar;

import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import view.App;

public class NavBar {
    public MenuBar createPanel (Object[] stageList, Stage primaryStage) {
        MenuBar menuBar = new MenuBar();
        Menu login = new Menu("登入");
        login.getItems().add(new MenuItem("登入"));
        Menu register = new Menu("註冊");
        register.getItems().add(new MenuItem("註冊"));
        Menu search = new Menu("搜尋");
        search.getItems().add(new MenuItem("搜尋"));
        Menu rank = new Menu("排行榜");
        rank.getItems().add(new MenuItem("排行榜"));


        login.setOnAction(e -> {
            setAllStageListInvisible(stageList);
            ((GridPane) stageList[0]).setVisible(true);

        });
        register.setOnAction(e -> {
            setAllStageListInvisible(stageList);
            ((GridPane) stageList[1]).setVisible(true);

        });
        rank.setOnAction(e -> {
            setAllStageListInvisible(stageList);
            App.updateRankList(stageList);
            ((GridPane) stageList[2]).setVisible(true);
        });
        search.setOnAction(e -> {
            setAllStageListInvisible(stageList);
            ((GridPane) stageList[3]).setVisible(true);
            
        });
        
        menuBar.getMenus().add(login);
        menuBar.getMenus().add(register);
        menuBar.getMenus().add(search);
        menuBar.getMenus().add(rank);

        menuBar.setPrefWidth(800);
        
        return menuBar;
        
        
    }

    private void setAllStageListInvisible(Object[] stageList) {
        for (int i = 0; i < stageList.length; i++) {
            if(stageList[i] == null) break;
            ((GridPane) stageList[i]).setVisible(false);
        }
    }
    
}
