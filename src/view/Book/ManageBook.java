package view.Book;

import java.util.ArrayList;
import javax.swing.JOptionPane;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;
import view.App;
import object.Books; // 假设你有这个包
import database.Mysql;

public class ManageBook {
    private GridPane gridPane = new GridPane();
    private GridPane searchResultTable = new GridPane();
    private ArrayList<Button> modifyButtons = new ArrayList<>();
    private ArrayList<Button> deleteButtons = new ArrayList<>();

    public GridPane createPanel(Object[] stageList, Stage primaryStage) {
        // Initialize the gridPane
        gridPane.setHgap(20);
        gridPane.setVgap(20);
        gridPane.setAlignment(Pos.TOP_CENTER);
        gridPane.setPadding(new Insets(20));
        gridPane.setStyle("-fx-background-color: #FFFFFF; -fx-padding: 20; -fx-border-color: #B0C4DE; -fx-border-width: 2; -fx-border-radius: 10; -fx-background-radius: 10;");

        // Add title
        Label titleLabel = new Label("Book Management");
        titleLabel.setFont(Font.font("Arial", FontWeight.BOLD, 24));
        titleLabel.setTextFill(Color.DARKSLATEBLUE);
        gridPane.add(titleLabel, 0, 0, 3, 1);

        // Add a separator below the title
        Separator titleSeparator = new Separator();
        gridPane.add(titleSeparator, 0, 1, 3, 1);

        // Set search method, using drop down list
        ChoiceBox<String> searchMethod = new ChoiceBox<>();
        searchMethod.getItems().addAll("類別", "作者", "書名");
        gridPane.add(searchMethod, 0, 2);

        // Add search button
        Button searchButton = new Button("搜尋");
        searchButton.setFont(Font.font("Arial", FontWeight.BOLD, 14));
        searchButton.setStyle("-fx-background-color: #4CAF50; -fx-text-fill: white; -fx-background-radius: 5;");
        searchButton.setOnMouseEntered(e -> searchButton.setStyle("-fx-background-color: #45a049; -fx-text-fill: white; -fx-background-radius: 5;"));
        searchButton.setOnMouseExited(e -> searchButton.setStyle("-fx-background-color: #4CAF50; -fx-text-fill: white; -fx-background-radius: 5;"));
        gridPane.add(searchButton, 1, 2);

        // Add search result table
        searchResultTable.setHgap(20);
        searchResultTable.setVgap(20);
        searchResultTable.setAlignment(Pos.TOP_CENTER);
        searchResultTable.setPadding(new Insets(20));
        searchResultTable.setStyle("-fx-background-color: #F0F8FF; -fx-padding: 20; -fx-border-color: #B0C4DE; -fx-border-width: 2; -fx-border-radius: 10; -fx-background-radius: 10;");
        gridPane.add(searchResultTable, 0, 3, 3, 1);

        searchMethod.setOnAction(event -> {
            gridPane.getChildren().removeIf(node -> GridPane.getRowIndex(node) == 2 && GridPane.getColumnIndex(node) > 1);
        
            if (searchMethod.getValue().equals("類別")) {
                ChoiceBox<String> searchContent = new ChoiceBox<>();
                searchContent.getItems().addAll("文學", "歷史", "科技", "數學", "語言", "藝術", "其他");
                gridPane.add(searchContent, 2, 2); // 放在第二行，第三列
            } else if (searchMethod.getValue().equals("書名") || searchMethod.getValue().equals("作者")) {
                Label searchContentLabel = new Label(searchMethod.getValue());
                TextField searchContentField = new TextField();
                gridPane.add(searchContentLabel, 2, 2); // 放在第二行，第三列
                gridPane.add(searchContentField, 3, 2); // 放在第二行，第四列
            }
        });
        

        searchButton.setOnAction(event -> {
            // Get the search method and search content
            String method = searchMethod.getValue();
            String content = "";
            if (method.equals("類別")) {
                ChoiceBox<String> searchContent = (ChoiceBox<String>) gridPane.getChildren().get(5);
                content = searchContent.getValue();
            } else if (method.equals("書名") || method.equals("作者")) {
                TextField searchContent = (TextField) gridPane.getChildren().get(6);
                content = searchContent.getText();
            }
            // Search the book by the search method and search content
            ArrayList<Books> searchResult = searchBooks(App.getBooks(), method, content);
            updateSearchResult(searchResultTable, searchResult, method, content);
        });

        return gridPane;
    }

    private ArrayList<Books> searchBooks(ArrayList<Books> books, String method, String content) {
        // Search the book by the search method and search content
        ArrayList<Books> searchResult = new ArrayList<>();
        for (Books book : books) {
            if (method.equals("類別") && book.getCategory().equals(content)) {
                searchResult.add(book);
            } else if (method.equals("書名") && book.getName().equals(content)) {
                searchResult.add(book);
            } else if (method.equals("作者") && book.getAuthor().equals(content)) {
                searchResult.add(book);
            }
        }
        return searchResult;
    }

    private void updateSearchResult(GridPane searchResultTable, ArrayList<Books> searchResult, String method, String content) {
        // Clear the search result table
        searchResultTable.getChildren().clear();

        // Add the title
        Label title = new Label("搜尋結果");
        title.setFont(Font.font("Arial", FontWeight.BOLD, 18));
        searchResultTable.add(title, 0, 0, 3, 1);

        // Add the search results
        for (int i = 0; i < searchResult.size(); i++) {
            Label bookLabel = new Label("書名: " + searchResult.get(i).getName() + " 作者: " + searchResult.get(i).getAuthor() + " 出版社: " + searchResult.get(i).getPublisher() + " ISBN: " + searchResult.get(i).getISBN() + " 類別: " + searchResult.get(i).getCategory());
            Button modifyButton = new Button("修改");
            Button deleteButton = new Button("刪除");

            searchResultTable.add(bookLabel, 0, i + 1);
            searchResultTable.add(modifyButton, 1, i + 1);
            searchResultTable.add(deleteButton, 2, i + 1);

            // Add buttons to arrayList
            modifyButtons.add(modifyButton);
            deleteButtons.add(deleteButton);
        }

        // Add event handler to modify button
        for (int i = 0; i < modifyButtons.size(); i++) {
            int index = i;
            modifyButtons.get(index).setOnAction(event -> modifyBook(searchResult.get(index), method, content));
        }

        // Add event handler to delete button
        for (int i = 0; i < deleteButtons.size(); i++) {
            int index = i;
            deleteButtons.get(index).setOnAction(event -> {
                deleteBook(searchResult.get(index), method, content);
            });
        }
    }

    private void modifyBook(Books book, String method, String content) {
        // Modify the book
        // Pop up a window to input the new information
        Stage stage = new Stage();
        stage.setTitle("修改書籍");
        stage.setWidth(400);
        stage.setHeight(400);

        GridPane gridPane = new GridPane();
        gridPane.setHgap(20);
        gridPane.setVgap(20);
        gridPane.setAlignment(Pos.TOP_CENTER);
        gridPane.setPadding(new Insets(20));
        gridPane.setStyle("-fx-background-color: #FFFFFF; -fx-padding: 20; -fx-border-color: #B0C4DE; -fx-border-width: 2; -fx-border-radius: 10; -fx-background-radius: 10;");

        Label nameLabel = new Label("書名");
        Label authorLabel = new Label("作者");
        Label publisherLabel = new Label("出版社");
        Label isbnLabel = new Label("ISBN");
        Label categoryLabel = new Label("類別");

        TextField nameField = new TextField(book.getName());
        TextField authorField = new TextField(book.getAuthor());
        TextField publisherField = new TextField(book.getPublisher());
        TextField ISBNField = new TextField(String.valueOf(book.getISBN()));
        TextField categoryField = new TextField(book.getCategory());

        Button enterButton = new Button("確認");
        enterButton.setFont(Font.font("Arial", FontWeight.BOLD, 14));
        enterButton.setStyle("-fx-background-color: #4CAF50; -fx-text-fill: white; -fx-background-radius: 5;");
        enterButton.setOnMouseEntered(e -> enterButton.setStyle("-fx-background-color: #45a049; -fx-text-fill: white; -fx-background-radius: 5;"));
        enterButton.setOnMouseExited(e -> enterButton.setStyle("-fx-background-color: #4CAF50; -fx-text-fill: white; -fx-background-radius: 5;"));

        gridPane.add(nameLabel, 0, 0);
        gridPane.add(authorLabel, 0, 1);
        gridPane.add(publisherLabel, 0, 2);
        gridPane.add(isbnLabel, 0, 3);
        gridPane.add(categoryLabel, 0, 4);
        gridPane.add(nameField, 1, 0);
        gridPane.add(authorField, 1, 1);
        gridPane.add(publisherField, 1, 2);
        gridPane.add(ISBNField, 1, 3);
        gridPane.add(categoryField, 1, 4);
        gridPane.add(enterButton, 1, 5);

        Scene scene = new Scene(gridPane);
        stage.setScene(scene);
        stage.show();

        enterButton.setOnAction(e -> {
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
            if (categoryField.getText().isEmpty()) {
                categoryLabel.setStyle("-fx-text-fill: red;");
            }
            if (!nameField.getText().isEmpty() && !authorField.getText().isEmpty() && !publisherField.getText().isEmpty() && !ISBNField.getText().isEmpty() && !categoryField.getText().isEmpty()) {
                book.setName(nameField.getText());
                book.setAuthor(authorField.getText());
                book.setPublisher(publisherField.getText());
                book.setISBN(Integer.parseInt(ISBNField.getText()));
                book.setCategory(categoryField.getText());
                App.modifyBook(book);
                updateSearchResult(searchResultTable, searchBooks(App.getBooks(), method, content), method, content);
                stage.close();
            }
        });
    }

    private void deleteBook(Books book, String method, String content) {
        // Delete the book, JOptionPane to check if the user wants to delete the book
        int check = JOptionPane.showConfirmDialog(null, "確定要刪除嗎?", "刪除書籍", JOptionPane.YES_NO_OPTION);
        if (check == JOptionPane.YES_OPTION) {
            App.deleteBook(book);
            updateSearchResult(searchResultTable, searchBooks(App.getBooks(), method, content), method, content);
        }
    }
}
