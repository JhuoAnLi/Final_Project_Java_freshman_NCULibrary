package view.User;

import javax.swing.JOptionPane;

import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;
import view.App;
import javafx.scene.control.*;

public class Login {
    // This class is used to display the login page
    // It will return a GridPane object
    public GridPane createPanel(Object[] stageList, Stage primaryStage, Object[] NavList) {
        // Initialize the GridPane
        GridPane gridPane = new GridPane();
        int width = 400;
        gridPane.setHgap(20);
        gridPane.setVgap(20);
        gridPane.setAlignment(javafx.geometry.Pos.TOP_CENTER);
        gridPane.setPadding(new Insets(20));
        gridPane.setStyle(
                "-fx-background-color: #FFFFFF; -fx-padding: 20; -fx-border-color: #B0C4DE; -fx-border-width: 2; -fx-border-radius: 10; -fx-background-radius: 10;");

        Label titleLabel = new Label("Login Page");
        titleLabel.setFont(Font.font("Arial", FontWeight.BOLD, 24));
        titleLabel.setTextFill(Color.DARKSLATEBLUE);
        gridPane.add(titleLabel, 0, 0, 2, 1);
        GridPane.setHalignment(titleLabel, HPos.CENTER);

        Separator separator = new Separator();
        gridPane.add(separator, 0, 1, 2, 1);

        Label label = new Label("帳號");
        label.setFont(Font.font("Arial", FontWeight.BOLD, 14));
        gridPane.add(label, 0, 2);

        Label label1 = new Label("密碼");
        label1.setFont(Font.font("Arial", FontWeight.BOLD, 14));
        gridPane.add(label1, 0, 3);

        // Create and add choicebox
        ChoiceBox<String> identityField = new ChoiceBox<>();
        identityField.getItems().addAll("學生", "老師", "管理員");
        gridPane.add(identityField, 1, 4);

        // Create and add text fields
        TextField accountField = new TextField();
        accountField.setPromptText("請輸入帳號");
        gridPane.add(accountField, 1, 2);

        PasswordField passwordField = new PasswordField(); // Use PasswordField for password
        passwordField.setPromptText("請輸入密碼");
        gridPane.add(passwordField, 1, 3);

        // Create and add enter button
        Button enterButton = new Button("登入");
        enterButton.setPrefWidth(width / 2);
        enterButton.setFont(Font.font("Arial", FontWeight.BOLD, 14));
        enterButton.setStyle("-fx-background-color: #4CAF50; -fx-text-fill: white; -fx-background-radius: 5;");
        enterButton.setOnMouseEntered(e -> enterButton
                .setStyle("-fx-background-color: #45a049; -fx-text-fill: white; -fx-background-radius: 5;"));
        enterButton.setOnMouseExited(e -> enterButton
                .setStyle("-fx-background-color: #4CAF50; -fx-text-fill: white; -fx-background-radius: 5;"));
        gridPane.add(enterButton, 1, 5);

        // Add error label
        Label errorLabel = new Label("帳號或密碼錯誤");
        errorLabel.setTextFill(Color.RED);
        errorLabel.setFont(Font.font("Arial", FontWeight.BOLD, 14));
        gridPane.add(errorLabel, 1, 6);
        errorLabel.setVisible(false);

        enterButton.setOnAction(e -> {
            // Check the account and password
            if (accountField.getText().isEmpty() && passwordField.getText().isEmpty()) {
                label.setText("帳號 ( 請輸入帳號 ) ");
                label1.setText("密碼 ( 請輸入密碼 ) ");
            } else if (accountField.getText().isEmpty()) {
                label.setText("帳號 ( 請輸入帳號 )");
            } else if (passwordField.getText().isEmpty()) {
                label1.setText("密碼 ( 請輸入密碼 ) ");
            } else if (identityField.getValue() != null) {
                // Perform login logic (pseudo code for demonstration)
                boolean loginSuccess = false;
                if ((identityField.getValue().equals("學生") || identityField.getValue().equals("老師"))
                        && App.MemberLogin(accountField.getText(), passwordField.getText(), stageList) != null) {
                    JOptionPane.showMessageDialog(null, "登入成功");
                    ((MenuBar) NavList[0]).setVisible(true);
                    ((MenuBar) NavList[1]).setVisible(false);
                    ((MenuBar) NavList[2]).setVisible(false);
                    ((GridPane) stageList[3]).setVisible(true);
                    loginSuccess = true;
                } else if (identityField.getValue().equals("管理員")
                        && App.AdminLogin(accountField.getText(), passwordField.getText(), stageList) != null) {
                    JOptionPane.showMessageDialog(null, "登入成功");
                    ((MenuBar) NavList[0]).setVisible(false);
                    ((MenuBar) NavList[1]).setVisible(false);
                    ((MenuBar) NavList[2]).setVisible(true);
                    ((GridPane) stageList[3]).setVisible(true);
                    loginSuccess = true;
                }

                if (!loginSuccess) {
                    errorLabel.setVisible(true);
                }
            } else {
                errorLabel.setVisible(true);
            }
        });

        return gridPane;
    }
    // public GridPane createPanel(Object[] stageList, Stage primaryStage, Object[]
    // NavList) {

    // // draw login page
    // GridPane gridPane = new GridPane();
    // gridPane.setHgap(20);
    // gridPane.setVgap(20);
    // gridPane.setAlignment(javafx.geometry.Pos.CENTER);
    // gridPane.setStyle("-fx-background-color: #FFFFFF;");
    // Label label = new Label("帳號");
    // gridPane.add(label, 0, 0);
    // Label label1 = new Label("密碼");
    // gridPane.add(label1, 0, 1);
    // // set 身分組 choicebox
    // ChoiceBox<String> identityField = new ChoiceBox<>();
    // identityField.getItems().addAll("學生", "老師", "管理員");

    // TextField accountField = new TextField();
    // gridPane.add(accountField, 1, 0);
    // TextField passwordField = new TextField();
    // gridPane.add(passwordField, 1, 1);
    // gridPane.add(identityField, 1, 2);

    // // enter button
    // Button enterButton = new Button("登入");
    // gridPane.add(enterButton, 1, 3);

    // enterButton.setOnAction(e -> {
    // // check the account and password
    // // if the account and password are correct, then go to the main page
    // // if the account and password are not correct, then show the error message
    // // if the account and password are empty, then show the error message
    // // if the account is empty, then show the error message
    // // if the password is empty, then show the error message
    // if(accountField.getText().equals("") && passwordField.getText().equals("")){
    // label.setText("帳號(請輸入帳號)");
    // label1.setText("密碼(請輸入密碼)");
    // }
    // else if(accountField.getText().equals("")){
    // label.setText("帳號(請輸入帳號)");
    // }
    // else if(passwordField.getText().equals("")){
    // label1.setText("密碼(請輸入密碼)");
    // }
    // else if(identityField.getValue() != null){
    // // do sql here
    // // for test, we just use the account and password to check
    // if((identityField.getValue().equals("學生") ||
    // identityField.getValue().equals("教師")) &&
    // App.MemberLogin(accountField.getText(), passwordField.getText(), stageList)
    // != null){
    // JOptionPane.showMessageDialog(null, "登入成功");
    // ((MenuBar) NavList[0]).setVisible(true);
    // ((MenuBar) NavList[1]).setVisible(false);
    // ((MenuBar) NavList[2]).setVisible(false);
    // ((GridPane) stageList[3]).setVisible(true);

    // }
    // else if(identityField.getValue().equals("管理員") &&
    // App.AdminLogin(accountField.getText(), passwordField.getText(), stageList) !=
    // null){
    // JOptionPane.showMessageDialog(null, "登入成功");
    // ((MenuBar) NavList[0]).setVisible(false);
    // ((MenuBar) NavList[1]).setVisible(false);
    // ((MenuBar) NavList[2]).setVisible(true);
    // ((GridPane) stageList[3]).setVisible(true);
    // }
    // else{
    // label.setText("帳號或密碼錯誤");
    // }

    // }
    // else{
    // label.setText("帳號或密碼錯誤");
    // }
    // });

    // return gridPane;

    // }
}
