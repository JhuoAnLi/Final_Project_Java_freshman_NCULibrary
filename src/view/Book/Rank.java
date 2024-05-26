package view.Book;
import java.util.ArrayList;

import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.scene.control.*;
import javafx.geometry.Pos;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;
import object.Books;
import view.App;

public class Rank {
    private static GridPane gridPane = new GridPane();
    public GridPane createPanel(Object[] stageList, Stage primaryStage) {
        ArrayList<Books> books = App.getBooks();
        
        // Set up the GridPane
        gridPane.setHgap(20);
        gridPane.setVgap(20);
        gridPane.setAlignment(Pos.TOP_CENTER);
        gridPane.setPadding(new Insets(20));
        gridPane.setStyle("-fx-background-color: #FFFFFF; -fx-padding: 20; -fx-border-color: #B0C4DE; -fx-border-width: 2; -fx-border-radius: 10; -fx-background-radius: 10;");

        // Add title
        Label titleLabel = new Label("Rank Page");
        titleLabel.setFont(Font.font("Arial", FontWeight.BOLD, 24));
        titleLabel.setTextFill(Color.DARKSLATEBLUE);
        gridPane.add(titleLabel, 0, 0, 2, 1);
        GridPane.setHalignment(titleLabel, HPos.CENTER);

        // Add a separator below the title
        Separator titleSeparator = new Separator();
        gridPane.add(titleSeparator, 0, 1, 2, 1);

        // Create TableView for ranking
        TableView<Books> rankTable = new TableView<>();
        rankTable.setPrefWidth(600);
        rankTable.setPrefHeight(400);

        TableColumn<Books, String> rankColumn = new TableColumn<>("排名");
        rankColumn.setCellValueFactory(data -> new SimpleStringProperty("第" + (books.indexOf(data.getValue()) + 1) + "名"));

        TableColumn<Books, String> nameColumn = new TableColumn<>("書名");
        nameColumn.setCellValueFactory(data -> new SimpleStringProperty(data.getValue().getName()));

        rankTable.getColumns().add(rankColumn);
        rankTable.getColumns().add(nameColumn);

        // Get rank list and add to table
        ArrayList<Books> rankList = getRankList(books);
        ObservableList<Books> data = FXCollections.observableArrayList(rankList);
        rankTable.setItems(data);

        // Add the TableView to the GridPane
        VBox tableContainer = new VBox(rankTable);
        tableContainer.setPadding(new Insets(20, 0, 0, 0));
        gridPane.add(tableContainer, 0, 3, 2, 1);

        return gridPane;
    }
    private static ArrayList<Books> getRankList(ArrayList<Books> books){
        // get the rank list

        return books;
    }
    public static void updateRankList(){
        // update the rank list
        // get books then calculate the rank list
        // clear gridPane until the title
        ArrayList<Books> books = App.getBooks();
        gridPane.getChildren().remove(1, gridPane.getChildren().size());
        ArrayList<Books> rankList = getRankList(books);
        
        // Sort rankList based on totalBorrowNum in descending order
        rankList.sort((book1, book2) -> book2.getTotalBorrowNum() - book1.getTotalBorrowNum());

        for(int i = 0; i < rankList.size(); i++){
            Label rank = new Label("第" + (i + 1) + "名: " + rankList.get(i).getName());
            gridPane.add(rank, 0, i + 1);
        }
    }
}
