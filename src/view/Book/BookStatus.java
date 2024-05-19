package view.Book;

import java.util.ArrayList;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.GridPane;
import object.Books;
import view.App;

public class BookStatus {
    private GridPane gridPane = new GridPane();
    public GridPane createPanel(Object[] stageList, javafx.stage.Stage primaryStage) {
        
        // draw the book status page
        // set the gap between the elements
        gridPane.setHgap(20);
        gridPane.setVgap(20);
        // set the alignment
        gridPane.setAlignment(javafx.geometry.Pos.CENTER);
        // set the background color
        gridPane.setStyle("-fx-background-color: #FFFFFF;");

        // add title
        Label label = new Label("書籍狀態");
        gridPane.add(label, 0, 0);
        // add refresh button
        Button refreshButton = new Button("Refresh");
        gridPane.add(refreshButton, 1, 0);

        fetchBookStatus();
        

        refreshButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                // clear the girPane
                gridPane.getChildren().remove(2, gridPane.getChildren().size());
                fetchBookStatus();
            }
        });

        return gridPane;
    }
    private void fetchBookStatus(){
        // get the book status
        ArrayList<Books> books = App.getBooks();
        TableView<Books> table = new TableView<>();
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

        table.getColumns().add(nameColumn);
        table.getColumns().add(statusColumn);
        table.getColumns().add(authorColumn);
        table.getColumns().add(publisherColumn);
        table.getColumns().add(borrowerColumn);

        for(int i = 0; i < books.size(); i++){
            table.getItems().add(books.get(i));
        }
        gridPane.add(table, 0, 1);
    }
}
