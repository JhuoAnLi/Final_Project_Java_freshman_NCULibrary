package view.User;

import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import object.Member;
import view.App;

public class PersonalInfo {
    Object[] stageList;
    Stage primaryStage;
    public GridPane createPanel(Object[] stageList, Stage primaryStage) {
        this.stageList = stageList;
        this.primaryStage = primaryStage;
        GridPane gridPane = new GridPane();
        // get current user's personal info
        
        Member member = App.getLoginMember();
        if(member == null){
            return gridPane;
        }

        return gridPane;
    }

    public static void updatePanel(Object[] stageList) {
        GridPane gridPane = (GridPane) stageList[6];
        // get current user's personal info
        Member member = App.getLoginMember();
        if(member == null){
            return;
        }
        // set the gap between the elements
        gridPane.setHgap(20);
        gridPane.setVgap(20);
        // set the alignment
        gridPane.setAlignment(javafx.geometry.Pos.CENTER);
        // set the background color
        gridPane.setStyle("-fx-background-color: #FFFFFF;");
        // add the title

        Label label = new Label("個人資料");
        gridPane.add(label, 0, 0);
        // add the personal info
        Label account = new Label("帳號: " + member.getAccount());
        gridPane.add(account, 0, 1);
        Label name = new Label("姓名: " + member.getName());
        gridPane.add(name, 0, 2);
        Label age = new Label("年齡: " + member.getAge());
        gridPane.add(age, 0, 3);
        Label identity = new Label("身分: " + member.getIdentity());
        gridPane.add(identity, 0, 4);
        Label bill = new Label("欠款: " + member.getBill());
        gridPane.add(bill, 0, 5);
    }
}
