package view.Book;

import java.util.ArrayList;

import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.*;
import javafx.stage.Stage;
import object.Books;
import object.Student;
import view.App;

public class BookBorrow {
    public GridPane createPanel(Object[] stageList, Stage primaryStage, ArrayList<Books> books) {
        GridPane gridPane = new GridPane();
        gridPane.setHgap(20);
        gridPane.setVgap(20);
        gridPane.setAlignment(Pos.CENTER);
        gridPane.setPadding(new Insets(20));
        gridPane.setStyle("-fx-background-color: #FFFFFF; -fx-padding: 20; -fx-border-color: #B0C4DE; -fx-border-width: 2; -fx-border-radius: 10; -fx-background-radius: 10;");

        // Add the borrow part
        GridPane borrowBook = new GridPane();
        updateBorrowPanel(books, borrowBook, stageList);

        // Add the search part
        GridPane searchBorrowBook = createSearchPanel(books, borrowBook, stageList);

        gridPane.add(searchBorrowBook, 0, 0);
        gridPane.add(borrowBook, 1, 0);

        return gridPane;
    }

    private void updateBorrowPanel(ArrayList<Books> books, GridPane borrowBook, Object[] stageList) {
        borrowBook.setHgap(20);
        borrowBook.setVgap(20);
        borrowBook.setAlignment(Pos.CENTER);
        borrowBook.setPadding(new Insets(20));
        borrowBook.setStyle("-fx-background-color: #F0F8FF; -fx-padding: 20; -fx-border-color: #B0C4DE; -fx-border-width: 2; -fx-border-radius: 10; -fx-background-radius: 10;");

        // Clear existing children
        borrowBook.getChildren().clear();

        // Add title
        Label borrowTitleLabel = new Label("Borrow Books");
        borrowTitleLabel.setFont(Font.font("Arial", FontWeight.BOLD, 24));
        borrowTitleLabel.setTextFill(Color.DARKSLATEBLUE);
        borrowBook.add(borrowTitleLabel, 0, 0, 2, 1);
        GridPane.setHalignment(borrowTitleLabel, HPos.CENTER);

        // Add a separator below the title
        Separator borrowTitleSeparator = new Separator();
        borrowBook.add(borrowTitleSeparator, 0, 1, 2, 1);

        // Add the book list for borrowing
        for (int i = 0; i < books.size(); i++) {
            Books book = books.get(i);
            Label bookLabel = new Label((i + 1) + ". " + book.getName());
            Button borrowButton = new Button("借書");
        
            borrowButton.setOnAction(e -> {
                try {
                    Student.borrow_book(book.getName(), App.getLoginMember().getAccount());
                    updateBorrowPanel(retrieveBooks(), borrowBook, stageList);
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            });
        
            borrowBook.add(bookLabel, 0, i + 2);
            borrowBook.add(borrowButton, 1, i + 2);
        }
    }

    private GridPane createSearchPanel(ArrayList<Books> books, GridPane borrowBook, Object[] stageList) {
        GridPane gridPane = new GridPane();
        gridPane.setHgap(20);
        gridPane.setVgap(20);
        gridPane.setAlignment(Pos.CENTER);
        gridPane.setPadding(new Insets(20));
        gridPane.setStyle("-fx-background-color: #FFFFFF; -fx-padding: 20; -fx-border-color: #B0C4DE; -fx-border-width: 2; -fx-border-radius: 10; -fx-background-radius: 10;");

        // Add title
        Label searchTitleLabel = new Label("Search Books");
        searchTitleLabel.setFont(Font.font("Arial", FontWeight.BOLD, 24));
        searchTitleLabel.setTextFill(Color.DARKSLATEBLUE);
        gridPane.add(searchTitleLabel, 0, 0, 2, 1);
        GridPane.setHalignment(searchTitleLabel, HPos.CENTER);

        // Add a separator below the title
        Separator searchTitleSeparator = new Separator();
        gridPane.add(searchTitleSeparator, 0, 1, 2, 1);

        // Add search method dropdown
        Label searchMethodLabel = new Label("搜尋方式");
        searchMethodLabel.setFont(Font.font("Arial", FontWeight.BOLD, 14));
        gridPane.add(searchMethodLabel, 0, 2);

        ChoiceBox<String> searchMethod = new ChoiceBox<>();
        searchMethod.getItems().addAll("類別", "作者", "書名");
        gridPane.add(searchMethod, 1, 2);

        // Add search content placeholder
        TextField searchField = new TextField();
        searchField.setPromptText("請輸入搜尋條件");
        gridPane.add(searchField, 0, 3, 2, 1);

        // Add search button
        Button searchButton = new Button("搜尋");
        searchButton.setFont(Font.font("Arial", FontWeight.BOLD, 14));
        searchButton.setStyle("-fx-background-color: #4CAF50; -fx-text-fill: white; -fx-background-radius: 5;");
        searchButton.setOnMouseEntered(e -> searchButton.setStyle("-fx-background-color: #45a049; -fx-text-fill: white; -fx-background-radius: 5;"));
        searchButton.setOnMouseExited(e -> searchButton.setStyle("-fx-background-color: #4CAF50; -fx-text-fill: white; -fx-background-radius: 5;"));
        gridPane.add(searchButton, 1, 4);
        GridPane.setHalignment(searchButton, HPos.RIGHT);

        searchButton.setOnAction(e -> {
            String method = searchMethod.getValue();
            String content = searchField.getText();
            ArrayList<Books> searchResult = searchBooks(books, method, content);
            updateBorrowPanel(searchResult, borrowBook, stageList);
        });

        return gridPane;
    }

    private ArrayList<Books> searchBooks(ArrayList<Books> books, String method, String content) {
        ArrayList<Books> filteredBooks = new ArrayList<>();
        for (Books book : books) {
            switch (method) {
                case "類別":
                    if (book.getCategory().equals(content)) {
                        filteredBooks.add(book);
                    }
                    break;
                case "作者":
                    if (book.getAuthor().equals(content)) {
                        filteredBooks.add(book);
                    }
                    break;
                case "書名":
                    if (book.getName().equals(content)) {
                        filteredBooks.add(book);
                    }
                    break;
            }
        }
        return filteredBooks;
    }

    private ArrayList<Books> retrieveBooks() {
        ArrayList<Books> books = new ArrayList<>();
        ArrayList<Books> allBooks = App.getBooks();
        for (Books book : allBooks) {
            if (book.getStatus().equals("Available")) {
                books.add(book);
            }
        }
        return books;
    }
}
