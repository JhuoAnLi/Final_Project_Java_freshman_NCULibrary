package view.Book;

import java.util.ArrayList;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.control.Separator;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;
import object.Books;
import view.App;

public class BookStatus {
    private GridPane gridPane = new GridPane();
    public GridPane createPanel(Object[] stageList, Stage primaryStage) {
        // Set up the GridPane
        gridPane.setHgap(20);
        gridPane.setVgap(20);
        gridPane.setAlignment(Pos.TOP_CENTER);
        gridPane.setPadding(new Insets(20));
        gridPane.setStyle("-fx-background-color: #FFFFFF; -fx-padding: 20; -fx-border-color: #B0C4DE; -fx-border-width: 2; -fx-border-radius: 10; -fx-background-radius: 10;");

        // Add title
        Label label = new Label("Book Status");
        label.setFont(Font.font("Arial", FontWeight.BOLD, 24));
        label.setTextFill(Color.DARKSLATEBLUE);
        gridPane.add(label, 0, 0, 2, 1);
        GridPane.setHalignment(label, HPos.CENTER);

        // Add a separator below the title
        Separator titleSeparator = new Separator();
        gridPane.add(titleSeparator, 0, 1, 2, 1);

        // Add refresh button
        Button refreshButton = new Button("刷新");
        refreshButton.setFont(Font.font("Arial", FontWeight.BOLD, 14));
        refreshButton.setStyle("-fx-background-color: #4CAF50; -fx-text-fill: white; -fx-background-radius: 5;");
        refreshButton.setOnMouseEntered(e -> refreshButton.setStyle("-fx-background-color: #45a049; -fx-text-fill: white; -fx-background-radius: 5;"));
        refreshButton.setOnMouseExited(e -> refreshButton.setStyle("-fx-background-color: #4CAF50; -fx-text-fill: white; -fx-background-radius: 5;"));

        HBox buttonBox = new HBox(refreshButton);
        buttonBox.setAlignment(Pos.CENTER_RIGHT);
        gridPane.add(buttonBox, 1, 0);

        // Fetch and display book status
        fetchBookStatus();

        refreshButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                // Clear the GridPane below the title and button
                gridPane.getChildren().removeIf(node -> GridPane.getRowIndex(node) > 1);
                fetchBookStatus();
            }
        });

        return gridPane;
    }

    private void fetchBookStatus() {
        // Get the book status
        ArrayList<Books> books = App.getBooks();

        TableView<Books> table = new TableView<>();
        table.setPrefWidth(400);

        TableColumn<Books, String> nameColumn = new TableColumn<>("書名");
        nameColumn.setCellValueFactory(new PropertyValueFactory<>("name"));

        TableColumn<Books, String> authorColumn = new TableColumn<>("作者");
        authorColumn.setCellValueFactory(new PropertyValueFactory<>("author"));

        TableColumn<Books, String> publisherColumn = new TableColumn<>("出版社");
        publisherColumn.setCellValueFactory(new PropertyValueFactory<>("publisher"));

        TableColumn<Books, String> borrowerColumn = new TableColumn<>("借閱人");
        borrowerColumn.setCellValueFactory(new PropertyValueFactory<>("borrower"));

        TableColumn<Books, String> statusColumn = new TableColumn<>("狀態");
        statusColumn.setCellValueFactory(new PropertyValueFactory<>("status"));

        table.getColumns().addAll(nameColumn, authorColumn, publisherColumn, borrowerColumn, statusColumn);

        ObservableList<Books> bookList = FXCollections.observableArrayList(books);
        table.setItems(bookList);

        VBox tableContainer = new VBox(table);
        tableContainer.setPadding(new Insets(20, 0, 0, 0));
        gridPane.add(tableContainer, 0, 2, 2, 1);
    }
}
