package view.Book;

import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import object.Books;
import view.App;

public class AddBook {
    private  GridPane gridPane = new GridPane();
    private  Label nameLabel = new Label("書名");
    private  Label authorLabel = new Label("作者");
    private  Label publisherLabel = new Label("出版社");
    private  Label isbnLabel = new Label("ISBN");
    private  Label categoryLabel = new Label("類別");
    private  TextField nameField = new TextField();
    private  TextField authorField = new TextField();
    private  TextField publisherField = new TextField();
    private  TextField ISBNField = new TextField();
    private  TextField categoryField = new TextField();


    public GridPane createPanel(Object[] stageList, javafx.stage.Stage primaryStage) {
        // draw add book page
        gridPane.setHgap(20);
        gridPane.setVgap(20);
        gridPane.setAlignment(javafx.geometry.Pos.CENTER);
        gridPane.setStyle("-fx-background-color: #FFFFFF;");
        // add label
        gridPane.add(nameLabel, 0, 0);
        gridPane.add(authorLabel, 0, 1);
        gridPane.add(publisherLabel, 0, 2);
        gridPane.add(isbnLabel, 0, 3);
        gridPane.add(categoryLabel, 0, 4);
        
        // add textfield
        gridPane.add(nameField, 1, 0);
        gridPane.add(authorField, 1, 1);
        gridPane.add(publisherField, 1, 2);
        gridPane.add(ISBNField, 1, 3);
        gridPane.add(categoryField, 1, 4);
        
        // add button
        Button enterButton = new Button("新增");
        gridPane.add(enterButton, 1, 5);

        enterButton.setOnAction(e -> {
            // check the input
            // if the input is correct, then add the book to the database
            // if the input is not correct, then show the error message
            // if the input is empty, then show the error message
            if(nameField.getText().equals("")){
                // set label to red
                nameLabel.styleProperty().set("-fx-text-fill: red;");
            }
            if(authorField.getText().equals("")){
                // set label to red
                authorLabel.styleProperty().set("-fx-text-fill: red;");
            }
            if(publisherField.getText().equals("")){
                // set label to red
                publisherLabel.styleProperty().set("-fx-text-fill: red;");
            }
            if(ISBNField.getText().equals("")){
                // set label to red
                isbnLabel.styleProperty().set("-fx-text-fill: red;");
            }
            if(categoryField.getText().equals("")){
                // set label to red
                categoryLabel.styleProperty().set("-fx-text-fill: red;");
            }
            if(!nameField.getText().equals("") && !authorField.getText().equals("") && !publisherField.getText().equals("") && !ISBNField.getText().equals("") && !categoryField.getText().equals("")){
                // add book to database
                // TODO: SQL
                Books book = new Books(nameField.getText(), authorField.getText(), publisherField.getText(), Integer.parseInt(ISBNField.getText()), categoryField.getText(), "Available");
                App.addBook(book);

                // update the add book page
                updatePanel(stageList);
            }
        });

        return gridPane;
        // it will return a GridPane object
    }
    
    public void updatePanel(Object[] stageList){
        // update the add book page
        // clear the textfield
        nameField.clear();
        authorField.clear();
        publisherField.clear();
        ISBNField.clear();
        categoryField.clear();

        // set label to black
        nameLabel.styleProperty().set("-fx-text-fill: black;");
        authorLabel.styleProperty().set("-fx-text-fill: black;");
        publisherLabel.styleProperty().set("-fx-text-fill: black;");
        isbnLabel.styleProperty().set("-fx-text-fill: black;");
        categoryLabel.styleProperty().set("-fx-text-fill: black;");
    }
}
