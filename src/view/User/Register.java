package view.User;

import javax.swing.JOptionPane;

import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
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

        // register need account, password, name, age, identity
        Label accountLabel = new Label("帳號");
        gridPane.add(accountLabel, 0, 0);
        gridPane.add(accountField, 1, 0);

        Label passwordLabel = new Label("密碼");
        gridPane.add(passwordLabel, 0, 1);
        gridPane.add(passwordField, 1, 1);

        Label nameLabel = new Label("姓名");
        gridPane.add(nameLabel, 0, 2);
        gridPane.add(nameField, 1, 2);

        Label ageLabel = new Label("年齡");
        gridPane.add(ageLabel, 0, 3);
        
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
    public void register(String account, String password, String name, int age, String identity){
        // register the account
        // the account will be stored in the database
        // the account will be used to login
        // the account will have the password, name, age, identity
        // TODO: by SQL maybe?
        // check the field is empty or not
        if(account.equals("") || password.equals("") || name.equals("") || ageField.getText().equals("")){
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
    
}
