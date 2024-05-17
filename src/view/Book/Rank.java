package view.Book;
import java.util.ArrayList;

import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import object.Books;

public class Rank {
    public GridPane createPanel(Object[] stageList, javafx.stage.Stage primaryStage, ArrayList<Books> books) {
        GridPane gridPane = new GridPane();
        // draw the rank page
        // set the gap between the elements
        gridPane.setHgap(20);
        gridPane.setVgap(20);
        // set the alignment
        gridPane.setAlignment(javafx.geometry.Pos.CENTER);
        // set the background color
        gridPane.setStyle("-fx-background-color: #FFFFFF;");
        // add the title
        Label label = new Label("排行榜");
        gridPane.add(label, 0, 0);
        // add the rank list
        ArrayList<Books> rankList = getRankList(books);
        for(int i = 0; i < rankList.size(); i++){
            Label rank = new Label("第" + (i + 1) + "名: " + rankList.get(i).getName());
            gridPane.add(rank, 0, i + 1);
        }
        return gridPane;
    }
    private ArrayList<Books> getRankList(ArrayList<Books> books){
        // get the rank list
        // the rank list is the list of books, the books are sorted by the number of borrow times
        // the first book is the most popular book
        // the last book is the least popular book
        // the rank list will be used to display the rank page
        return books;
    }
}
