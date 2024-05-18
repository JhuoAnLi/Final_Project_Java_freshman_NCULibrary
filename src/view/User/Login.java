package view.User;
import javax.swing.JOptionPane;

import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.MenuBar;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import view.App;

public class Login {
    // This class is used to display the login page
    // It will return a GridPane object
    public GridPane createPanel(Object[] stageList, Stage primaryStage, Object[] NavList) {
        
        // draw login page
        GridPane gridPane = new GridPane();
        gridPane.setHgap(20);
        gridPane.setVgap(20);
        gridPane.setAlignment(javafx.geometry.Pos.CENTER);
        gridPane.setStyle("-fx-background-color: #FFFFFF;");
        Label label = new Label("帳號");
        gridPane.add(label, 0, 0);
        Label label1 = new Label("密碼");
        gridPane.add(label1, 0, 1);
        // set 身分組 choicebox
        ChoiceBox<String> identityField = new ChoiceBox<>();
        identityField.getItems().addAll("學生", "老師", "管理員");

        TextField accountField = new TextField();
        gridPane.add(accountField, 1, 0);
        TextField passwordField = new TextField();
        gridPane.add(passwordField, 1, 1);
        gridPane.add(identityField, 1, 2);

        // enter button
        Button enterButton = new Button("登入");
        gridPane.add(enterButton, 1, 3);
        
        enterButton.setOnAction(e -> {
            // check the account and password
            // if the account and password are correct, then go to the main page
            // if the account and password are not correct, then show the error message
            // if the account and password are empty, then show the error message
            // if the account is empty, then show the error message
            // if the password is empty, then show the error message
            if(accountField.getText().equals("") && passwordField.getText().equals("")){
                label.setText("帳號(請輸入帳號)");
                label1.setText("密碼(請輸入密碼)");
            }
            else if(accountField.getText().equals("")){
                label.setText("帳號(請輸入帳號)");
            }
            else if(passwordField.getText().equals("")){
                label1.setText("密碼(請輸入密碼)");
            }
            else if(identityField.getValue() != null){
                // do sql here
                // for test, we just use the account and password to check
                if((identityField.getValue().equals("學生") || identityField.getValue().equals("教師")) && App.MemberLogin(accountField.getText(), passwordField.getText(), stageList) != null){
                    JOptionPane.showMessageDialog(null, "登入成功");
                    ((MenuBar) NavList[0]).setVisible(true);
                    ((MenuBar) NavList[1]).setVisible(false);
                    ((GridPane) stageList[3]).setVisible(true);
                }
                else if(identityField.getValue().equals("管理員") && App.AdminLogin(accountField.getText(), passwordField.getText(), stageList) != null){
                    JOptionPane.showMessageDialog(null, "登入成功");
                    ((MenuBar) NavList[0]).setVisible(false);
                    ((MenuBar) NavList[1]).setVisible(false);
                    ((MenuBar) NavList[2]).setVisible(true);
                    ((GridPane) stageList[3]).setVisible(true);
                }
                else{
                    label.setText("帳號或密碼錯誤");
                }
                
            }
            else{
                label.setText("帳號或密碼錯誤");
            }
        });

        return gridPane;

    }
}
