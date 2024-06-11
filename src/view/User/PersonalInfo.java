package view.User;

import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;
import object.Member;
import javafx.scene.control.*;
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

        // clear the gridPane
        gridPane.getChildren().remove(0, gridPane.getChildren().size());

        Member member = App.getLoginMember();
        if (member == null) {
            return;
        }

        // Set up the GridPane
        gridPane.setHgap(20);
        gridPane.setVgap(20);
        gridPane.setAlignment(javafx.geometry.Pos.TOP_CENTER);
        gridPane.setPadding(new Insets(20));
        gridPane.setStyle("-fx-background-color: #FFFFFF; -fx-padding: 20; -fx-border-color: #B0C4DE; -fx-border-width: 2; -fx-border-radius: 10; -fx-background-radius: 10;");

        // Add title
        Label titleLabel = new Label("Personal Information");
        titleLabel.setFont(Font.font("Arial", FontWeight.BOLD, 24));
        titleLabel.setTextFill(Color.DARKSLATEBLUE);
        gridPane.add(titleLabel, 0, 0, 2, 1);
        GridPane.setHalignment(titleLabel, HPos.CENTER);

        // Add a separator below the title
        Separator titleSeparator = new Separator();
        gridPane.add(titleSeparator, 0, 1, 2, 1);

        // Add personal info labels
        Label accountLabel = new Label("帳號: " + member.getAccount());
        accountLabel.setFont(Font.font("Arial", FontWeight.NORMAL, 16));
        gridPane.add(accountLabel, 0, 2);

        Label nameLabel = new Label("姓名: " + member.getName());
        nameLabel.setFont(Font.font("Arial", FontWeight.NORMAL, 16));
        gridPane.add(nameLabel, 0, 3);

        Label ageLabel = new Label("年齡: " + member.getAge());
        ageLabel.setFont(Font.font("Arial", FontWeight.NORMAL, 16));
        gridPane.add(ageLabel, 0, 4);

        Label identityLabel = new Label("身分: " + member.getIdentity());
        identityLabel.setFont(Font.font("Arial", FontWeight.NORMAL, 16));
        gridPane.add(identityLabel, 0, 5);

        Label billLabel = new Label("欠款: " + member.getBill());
        billLabel.setFont(Font.font("Arial", FontWeight.NORMAL, 16));
        gridPane.add(billLabel, 0, 6);

        // Add a separator below the personal info
        Separator infoSeparator = new Separator();
        gridPane.add(infoSeparator, 0, 7, 2, 1);
    }
}
