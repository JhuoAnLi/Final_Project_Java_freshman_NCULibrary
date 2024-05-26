package view.Book;

import java.util.ArrayList;

import database.Mysql;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

public class Search {

    private void updateSearchResult(TableView<object.Books> table, ArrayList<object.Books> searchResult) {
        ObservableList<object.Books> data = FXCollections.observableArrayList(searchResult);
        table.setItems(data);
    }

    public GridPane createPanel(Object[] stageList, Stage primaryStage, ArrayList<object.Books> books) {
        GridPane gridPane = new GridPane();
        gridPane.setHgap(20);
        gridPane.setVgap(20);
        gridPane.setAlignment(Pos.TOP_CENTER);
        gridPane.setPadding(new Insets(20));
        gridPane.setStyle(
                "-fx-background-color: #FFFFFF; -fx-padding: 20; -fx-border-color: #B0C4DE; -fx-border-width: 2; -fx-border-radius: 10; -fx-background-radius: 10;");

        // Add a title
        Label titleLabel = new Label("Search Page");
        titleLabel.setFont(Font.font("Arial", FontWeight.BOLD, 24));
        titleLabel.setTextFill(Color.DARKSLATEBLUE);
        gridPane.add(titleLabel, 0, 0, 2, 1);
        GridPane.setHalignment(titleLabel, HPos.CENTER);

        // Add a separator
        Separator separator = new Separator();
        gridPane.add(separator, 0, 1, 2, 1);

        // Add search method dropdown
        Label searchMethodLabel = new Label("搜尋方式");
        searchMethodLabel.setFont(Font.font("Arial", FontWeight.BOLD, 14));
        gridPane.add(searchMethodLabel, 0, 2);

        ChoiceBox<String> searchMethod = new ChoiceBox<>();
        searchMethod.getItems().addAll("類別", "作者", "書名", "出版社", "ISBN", "狀態");
        gridPane.add(searchMethod, 1, 2);

        // Add search content placeholder
        TextField searchField = new TextField();
        searchField.setPromptText("請輸入搜尋條件");
        gridPane.add(searchField, 0, 3, 2, 1);

        // Add search button
        Button searchButton = new Button("搜尋");
        searchButton.setFont(Font.font("Arial", FontWeight.BOLD, 14));
        searchButton.setStyle("-fx-background-color: #4CAF50; -fx-text-fill: white; -fx-background-radius: 5;");
        searchButton.setOnMouseEntered(e -> searchButton
                .setStyle("-fx-background-color: #45a049; -fx-text-fill: white; -fx-background-radius: 5;"));
        searchButton.setOnMouseExited(e -> searchButton
                .setStyle("-fx-background-color: #4CAF50; -fx-text-fill: white; -fx-background-radius: 5;"));
        gridPane.add(searchButton, 1, 4);
        GridPane.setHalignment(searchButton, HPos.RIGHT);

        // Add search result table
        TableView<object.Books> searchResultTable = new TableView<>();
        searchResultTable.setPrefWidth(480);
        searchResultTable.setPrefHeight(400);

        TableColumn<object.Books, String> column1 = new TableColumn<>("類別");
        column1.setCellValueFactory(data -> new SimpleStringProperty(data.getValue().getCategory()));

        TableColumn<object.Books, String> column2 = new TableColumn<>("作者");
        column2.setCellValueFactory(data -> new SimpleStringProperty(data.getValue().getAuthor()));

        TableColumn<object.Books, String> column3 = new TableColumn<>("書名");
        column3.setCellValueFactory(data -> new SimpleStringProperty(data.getValue().getName()));

        TableColumn<object.Books, String> column4 = new TableColumn<>("出版社");
        column4.setCellValueFactory(data -> new SimpleStringProperty(data.getValue().getPublisher()));

        TableColumn<object.Books, String> column5 = new TableColumn<>("ISBN");
        column5.setCellValueFactory(data -> new SimpleStringProperty(String.valueOf(data.getValue().getISBN())));

        TableColumn<object.Books, String> column6 = new TableColumn<>("狀態");
        column6.setCellValueFactory(data -> new SimpleStringProperty(data.getValue().getStatus()));

        searchResultTable.getColumns().add(column1);
        searchResultTable.getColumns().add(column2);
        searchResultTable.getColumns().add(column3);
        searchResultTable.getColumns().add(column4);
        searchResultTable.getColumns().add(column5);
        searchResultTable.getColumns().add(column6);

        VBox tableContainer = new VBox(searchResultTable);
        tableContainer.setPadding(new Insets(20, 0, 0, 0));
        gridPane.add(tableContainer, 0, 5, 2, 1);

        ChoiceBox<String> categoryChoiceBox = new ChoiceBox<>();
        categoryChoiceBox.getItems().addAll("文學", "歷史", "科技", "數學", "語言", "藝術", "其他");
        ChoiceBox<String> statusChoiceBox = new ChoiceBox<>();
        statusChoiceBox.getItems().addAll("可借", "不可借");

        searchMethod.setOnAction(e -> {
            gridPane.getChildren().removeIf(node -> GridPane.getRowIndex(node) == 3);
            switch (searchMethod.getValue()) {
                case "類別":
                    gridPane.add(categoryChoiceBox, 0, 3, 2, 1);
                    break;
                case "書名":
                case "作者":
                case "出版社":
                case "ISBN":
                    searchField.setPromptText("請輸入" + searchMethod.getValue());
                    gridPane.add(searchField, 0, 3, 2, 1);
                    break;
                case "狀態":
                    gridPane.add(statusChoiceBox, 0, 3, 2, 1);
                    break;
            }
        });

        searchButton.setOnAction(e -> {
            String method = searchMethod.getValue();
            String content = "";
            if (method.equals("類別")) {
                content = categoryChoiceBox.getValue();
            } else if (method.equals("狀態")) {
                content = statusChoiceBox.getValue();
            } else {
                content = searchField.getText();
            }
            ArrayList<object.Books> searchResult = searchBooks(Mysql.getAllBooks(), method, content);
            updateSearchResult(searchResultTable, searchResult);
        });

        return gridPane;
    }

    private ArrayList<object.Books> searchBooks(ArrayList<object.Books> books, String method, String content) {
        // search the book by the search method and search content
        // return the search result
        ArrayList<object.Books> searchResult = new ArrayList<>();
        if (method.equals("類別")) {
            for (object.Books book : books) {
                if (book.getCategory().equals(content)) {
                    searchResult.add(book);
                }
            }
        } else if (method.equals("書名")) {
            for (object.Books book : books) {
                if (book.getName().equals(content)) {
                    searchResult.add(book);
                }
            }
        } else if (method.equals("作者")) {
            for (object.Books book : books) {
                if (book.getAuthor().equals(content)) {
                    searchResult.add(book);
                }
            }
        } else if (method.equals("出版社")) {
            for (object.Books book : books) {
                if (book.getPublisher().equals(content)) {
                    searchResult.add(book);
                }
            }
        } else if (method.equals("ISBN")) {
            for (object.Books book : books) {
                if (book.getISBN() == Integer.parseInt(content)) {
                    searchResult.add(book);
                }
            }
        } else if (method.equals("狀態")) {
            for (object.Books book : books) {
                if (book.getStatus().equals("Available") && content.equals("可借")) {
                    searchResult.add(book);
                } else if (book.getStatus().equals("Unavailable") && content.equals("不可借")) {
                    searchResult.add(book);
                }
            }
        }
        return searchResult;
    }

}
