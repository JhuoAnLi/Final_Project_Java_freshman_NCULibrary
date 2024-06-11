package view.Book;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Separator;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;
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
    private ComboBox<String> categoryField = new ComboBox<>();


    public GridPane createPanel(Object[] stageList, Stage primaryStage) {
        // Initialize the gridPane
        gridPane.setHgap(20);
        gridPane.setVgap(20);
        gridPane.setAlignment(Pos.TOP_CENTER);
        gridPane.setPadding(new Insets(20));
        gridPane.setStyle("-fx-background-color: #FFFFFF; -fx-padding: 20; -fx-border-color: #B0C4DE; -fx-border-width: 2; -fx-border-radius: 10; -fx-background-radius: 10;");

        // Add title
        Label titleLabel = new Label("Add Book");
        titleLabel.setFont(Font.font("Arial", FontWeight.BOLD, 24));
        titleLabel.setTextFill(Color.DARKSLATEBLUE);
        gridPane.add(titleLabel, 0, 0, 2, 1);
        GridPane.setHalignment(titleLabel, HPos.CENTER);

        // Add a separator below the title
        Separator titleSeparator = new Separator();
        gridPane.add(titleSeparator, 0, 1, 2, 1);

        // Set font and style for labels
        nameLabel.setFont(Font.font("Arial", FontWeight.BOLD, 14));
        authorLabel.setFont(Font.font("Arial", FontWeight.BOLD, 14));
        publisherLabel.setFont(Font.font("Arial", FontWeight.BOLD, 14));
        isbnLabel.setFont(Font.font("Arial", FontWeight.BOLD, 14));
        categoryLabel.setFont(Font.font("Arial", FontWeight.BOLD, 14));

        ObservableList<String> categories = FXCollections.observableArrayList("文學", "歷史", "科技", "數學", "語言", "藝術", "其他");
        categoryField.setItems(categories);

        // Add labels and textfields to gridPane
        gridPane.add(nameLabel, 0, 2);
        gridPane.add(authorLabel, 0, 3);
        gridPane.add(publisherLabel, 0, 4);
        gridPane.add(isbnLabel, 0, 5);
        gridPane.add(categoryLabel, 0, 6);
        gridPane.add(nameField, 1, 2);
        gridPane.add(authorField, 1, 3);
        gridPane.add(publisherField, 1, 4);
        gridPane.add(ISBNField, 1, 5);
        gridPane.add(categoryField, 1, 6);

        // Add enter button
        Button enterButton = new Button("新增");
        enterButton.setFont(Font.font("Arial", FontWeight.BOLD, 14));
        enterButton.setStyle("-fx-background-color: #4CAF50; -fx-text-fill: white; -fx-background-radius: 5;");
        enterButton.setOnMouseEntered(e -> enterButton.setStyle("-fx-background-color: #45a049; -fx-text-fill: white; -fx-background-radius: 5;"));
        enterButton.setOnMouseExited(e -> enterButton.setStyle("-fx-background-color: #4CAF50; -fx-text-fill: white; -fx-background-radius: 5;"));
        gridPane.add(enterButton, 1, 7);

        enterButton.setOnAction(e -> {
            // Check the input
            if (nameField.getText().isEmpty()) {
                nameLabel.setStyle("-fx-text-fill: red;");
            }
            if (authorField.getText().isEmpty()) {
                authorLabel.setStyle("-fx-text-fill: red;");
            }
            if (publisherField.getText().isEmpty()) {
                publisherLabel.setStyle("-fx-text-fill: red;");
            }
            if (ISBNField.getText().isEmpty()) {
                isbnLabel.setStyle("-fx-text-fill: red;");
            }
            if (categoryField.getValue() == null) {
                categoryLabel.setStyle("-fx-text-fill: red;");
            }
        
            if (!nameField.getText().isEmpty() && !authorField.getText().isEmpty() && !publisherField.getText().isEmpty() && !ISBNField.getText().isEmpty() && !categoryField.getValue().isEmpty()) {
                try {
                    // Try to parse the ISBN
                    int isbn = Integer.parseInt(ISBNField.getText());
        
                    // Reset the ISBN label
                    isbnLabel.setText("ISBN");
                    isbnLabel.setStyle("-fx-text-fill: black;");
        
                    // Add book to database
                    Books book = new Books(nameField.getText(), authorField.getText(), publisherField.getText(), isbn, categoryField.getValue(), "Available");
                    App.addBook(book);
        
                    // Update the add book page
                    updatePanel(stageList);
                } catch (NumberFormatException ex) {
                    // Show error message
                    isbnLabel.setText("ISBN 必須是一個有效的整數。");
                    isbnLabel.setStyle("-fx-text-fill: red;");
                }
            }
        });

        return gridPane;
    }

    public void updatePanel(Object[] stageList) {
        // Clear the textfields
        nameField.clear();
        authorField.clear();
        publisherField.clear();
        ISBNField.clear();
        categoryField.setValue(null);

        // Reset label colors
        nameLabel.setStyle("-fx-text-fill: black;");
        authorLabel.setStyle("-fx-text-fill: black;");
        publisherLabel.setStyle("-fx-text-fill: black;");
        isbnLabel.setStyle("-fx-text-fill: black;");
        categoryLabel.setStyle("-fx-text-fill: black;");
    }
}
