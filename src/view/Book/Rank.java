package view.Book;
import java.util.ArrayList;

import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import object.Books;
import view.App;

public class Rank {
    private static GridPane gridPane = new GridPane();
    public GridPane createPanel(Object[] stageList, javafx.stage.Stage primaryStage) {
        ArrayList<Books> books = App.getBooks();
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
        for(int i = 0; i < rankList.size(); i++){
            Label rank = new Label("第" + (i + 1) + "名: " + rankList.get(i).getName());
            gridPane.add(rank, 0, i + 1);
        }

    }   
}
