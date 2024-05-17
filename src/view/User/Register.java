package view.User;

import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class Register {
    public GridPane createPanel(Object[] stageList, Stage primaryStage) {
        GridPane gridPane = new GridPane();
        // register need account, password, name, age, identity
        Label accountLabel = new Label("帳號");
        gridPane.add(accountLabel, 0, 0);
        TextField accountField = new TextField();
        gridPane.add(accountField, 1, 0);
        Label passwordLabel = new Label("密碼");
        gridPane.add(passwordLabel, 0, 1);
        TextField passwordField = new TextField();
        gridPane.add(passwordField, 1, 1);
        Label nameLabel = new Label("姓名");
        gridPane.add(nameLabel, 0, 2);
        TextField nameField = new TextField();
        gridPane.add(nameField, 1, 2);
        Label ageLabel = new Label("年齡");
        gridPane.add(ageLabel, 0, 3);
        TextField ageField = new TextField();
        gridPane.add(ageField, 1, 3);
        Label identityLabel = new Label("身分");
        gridPane.add(identityLabel, 0, 4);
        // drop down list for identity
        ChoiceBox<String> identityField = new ChoiceBox<>();
        identityField.getItems().addAll("學生", "老師");
        gridPane.add(identityField, 1, 4);
        Button registerButton = new Button("註冊");
        gridPane.add(registerButton, 1, 5);

        // put the content in center, set alignment
        gridPane.setAlignment(javafx.geometry.Pos.CENTER);
        // set the gap between the elements
        gridPane.setHgap(20);
        gridPane.setVgap(20);

        registerButton.setOnAction(e -> {
            register(accountField.getText(), passwordField.getText(), nameField.getText(), Integer.parseInt(ageField.getText()), identityField.getValue());
        });

        return gridPane;
    }
    public static void register(String account, String password, String name, int age, String identity){
        // register the account
        // the account will be stored in the database
        // the account will be used to login
        // the account will have the password, name, age, identity
        // TODO: by SQL maybe?
    }
    
}
