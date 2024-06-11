package view.User;

import javax.swing.JOptionPane;

import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.Separator;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;
import object.Student;
import object.Teacher;
import view.App;

public class Register {
    private GridPane gridPane = new GridPane();
    private TextField accountField = new TextField();
    private TextField nameField = new TextField();
    private TextField passwordField = new TextField();
    private TextField ageField = new TextField();
    public GridPane createPanel(Object[] stageList, Stage primaryStage) {
    // Initialize the GridPane
        GridPane gridPane = new GridPane();
        int width = 400;
        int height = 300;
        gridPane.setHgap(20);
        gridPane.setVgap(20);
        gridPane.setAlignment(Pos.TOP_CENTER);
        gridPane.setPadding(new Insets(20));
        gridPane.setStyle("-fx-background-color: #FFFFFF; -fx-padding: 20; -fx-border-color: #B0C4DE; -fx-border-width: 2; -fx-border-radius: 10; -fx-background-radius: 10;");

        // Add a title
        Label titleLabel = new Label("Register Page");
        titleLabel.setFont(Font.font("Arial", FontWeight.BOLD, 24));
        titleLabel.setTextFill(Color.DARKSLATEBLUE);
        gridPane.add(titleLabel, 0, 0, 2, 1);
        GridPane.setHalignment(titleLabel, HPos.CENTER);

        // Add a separator
        Separator separator = new Separator();
        gridPane.add(separator, 0, 1, 2, 1);

        Label accountLabel = new Label("帳號");
        accountLabel.setFont(Font.font("Arial", FontWeight.BOLD, 14));
        gridPane.add(accountLabel, 0, 2);
        TextField accountField = new TextField();
        accountField.setPromptText("請輸入帳號");
        gridPane.add(accountField, 1, 2);

        Label passwordLabel = new Label("密碼");
        passwordLabel.setFont(Font.font("Arial", FontWeight.BOLD, 14));
        gridPane.add(passwordLabel, 0, 3);
        PasswordField passwordField = new PasswordField();
        passwordField.setPromptText("請輸入密碼");
        gridPane.add(passwordField, 1, 3);

        Label nameLabel = new Label("姓名");
        nameLabel.setFont(Font.font("Arial", FontWeight.BOLD, 14));
        gridPane.add(nameLabel, 0, 4);
        TextField nameField = new TextField();
        nameField.setPromptText("請輸入姓名");
        gridPane.add(nameField, 1, 4);

        Label ageLabel = new Label("年齡");
        ageLabel.setFont(Font.font("Arial", FontWeight.BOLD, 14));
        gridPane.add(ageLabel, 0, 5);
        TextField ageField = new TextField();
        ageField.setPromptText("請輸入年齡");
        gridPane.add(ageField, 1, 5);

        Label identityLabel = new Label("身分");
        identityLabel.setFont(Font.font("Arial", FontWeight.BOLD, 14));
        gridPane.add(identityLabel, 0, 6);
        ChoiceBox<String> identityField = new ChoiceBox<>();
        identityField.getItems().addAll("學生", "老師");
        gridPane.add(identityField, 1, 6);

        // Add a register button
        Button registerButton = new Button("註冊");
        registerButton.setPrefWidth(width / 2);
        registerButton.setFont(Font.font("Arial", FontWeight.BOLD, 14));
        registerButton.setStyle("-fx-background-color: #4CAF50; -fx-text-fill: white; -fx-background-radius: 5;");
        registerButton.setOnMouseEntered(e -> registerButton.setStyle("-fx-background-color: #45a049; -fx-text-fill: white; -fx-background-radius: 5;"));
        registerButton.setOnMouseExited(e -> registerButton.setStyle("-fx-background-color: #4CAF50; -fx-text-fill: white; -fx-background-radius: 5;"));
        gridPane.add(registerButton, 1, 7);

        // Add a message label
        Label messageLabel = new Label();
        messageLabel.setFont(Font.font("Arial", FontWeight.BOLD, 14));
        messageLabel.setTextFill(Color.RED);
        gridPane.add(messageLabel, 1, 8);
        messageLabel.setVisible(false);

        registerButton.setOnAction(e -> {
            try {
                String account = accountField.getText();
                String password = passwordField.getText();
                String name = nameField.getText();
                String ageText = ageField.getText();
                String identity = identityField.getValue();
        
                // Check if any field is empty
                if (account.isEmpty() || password.isEmpty() || name.isEmpty() || ageText.isEmpty() || identity == null) {
                    throw new IllegalArgumentException("所有欄位都必須填寫。");
                }
        
                // Try to parse the age
                int age;
                try {
                    age = Integer.parseInt(ageText);
                } catch (NumberFormatException ex) {
                    throw new IllegalArgumentException("年齡必須是一個有效的整數。");
                }
        
                register(account, password, name, age, identity);
                messageLabel.setText("註冊成功！");
                messageLabel.setTextFill(Color.GREEN);
        
                // set page to login page
                setAllStageListInvisible(stageList);
                ((GridPane) stageList[0]).setVisible(true);
                
            } catch (Exception ex) {
                messageLabel.setText(ex.getMessage());
                messageLabel.setTextFill(Color.RED);
            }
            messageLabel.setVisible(true);
        });

        return gridPane;
    }
    public void register(String account, String password, String name, int age, String identity){
        // register the account
        // the account will be stored in the database
        // the account will be used to login
        // the account will have the password, name, age, identity
        // TODO: by SQL maybe?
        // check the field is empty or not
        if(account.equals("") || password.equals("") || name.equals("") || age == 0){
            JOptionPane.showMessageDialog(null, "請輸入完整資料");
        }
        
        if(identity.equals("學生")){
            // register the student
            Student student = new Student(name, account, password, "Student", age);
            App.register(student);
        }else if(identity.equals("老師")){
            // register the teacher
            Teacher teacher = new Teacher(name, account, password, "Teacher", age);
            App.register(teacher);
        }
        clearField();
    }
    private void clearField(){
        accountField.clear();
        passwordField.clear();
        ageField.clear();
        nameField.clear();
    }
    private void setAllStageListInvisible(Object[] stageList) {
        for (int i = 0; i < stageList.length; i++) {
            if(stageList[i] == null) break;
            ((GridPane) stageList[i]).setVisible(false);
        }
    }
    
}
