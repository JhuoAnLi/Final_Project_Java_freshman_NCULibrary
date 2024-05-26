package view.Book;

import java.util.ArrayList;

import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import object.Books;
import object.Member;
import view.App;

public class BookReturn {
    private Object[] stageList;
    private javafx.stage.Stage primaryStage;
    public GridPane createPanel(Object[] stageList, javafx.stage.Stage primaryStage) {
        GridPane gridPane = new GridPane();
        this.stageList = stageList;
        this.primaryStage = primaryStage;

        gridPane.setHgap(20);
        gridPane.setVgap(20);
        // set the alignment
        gridPane.setAlignment(javafx.geometry.Pos.CENTER);
        // set the background color
        gridPane.setStyle("-fx-background-color: #FFFFFF;");

        // add the title
        javafx.scene.control.Label label = new javafx.scene.control.Label("歸還書籍");
        gridPane.add(label, 0, 0);
        
        updatePanel(stageList);

        return gridPane;
    }
    public static void updatePanel(Object[] stageList) {
        GridPane gridPane = (GridPane) stageList[7];
        ArrayList<Books> books = App.getBooks();
        Member currentLoginMember = App.getLoginMember();
        if(currentLoginMember == null){
            return;
        }
        // find the books that are borrowed by the current user
        ArrayList<Books> borrowedBooks = new ArrayList<>();
        for(Books book:books){
            if(book.getStatus().equals("Unavailable") && book.getBorrower().equals(currentLoginMember.getName())){
                borrowedBooks.add(book);
            }
        }

        // clear the gridPane
        gridPane.getChildren().remove(1, gridPane.getChildren().size());
        
        // to show the borrowed books, add title
        gridPane.add(new javafx.scene.control.Label("書名"), 0, 1);
        gridPane.add(new javafx.scene.control.Label("借閱日"), 1, 1);
        gridPane.add(new javafx.scene.control.Label("歸還"), 2, 1);
        // show the borrowed books
        ArrayList<Button> returnButtons = new ArrayList<>();
        for(int i = 0; i < borrowedBooks.size(); i++){
            javafx.scene.control.Label borrowedBook = new javafx.scene.control.Label(borrowedBooks.get(i).getName());
            gridPane.add(borrowedBook, 0, i + 2);
            Label status = new Label(borrowedBooks.get(i).getBorrow_time());
            gridPane.add(status, 1, i + 2);
            Button returnButton = new Button("歸還");
            gridPane.add(returnButton, 2, i + 2);
            // add return button to arrayList
            returnButtons.add(returnButton);
        }
        // set the return button event
        for(int i = 0; i < returnButtons.size(); i++){
            int index = i;
            returnButtons.get(index).setOnAction(new javafx.event.EventHandler<javafx.event.ActionEvent>() {
                @Override
                public void handle(javafx.event.ActionEvent event) {
                    currentLoginMember.return_book(borrowedBooks.get(index).getName(), currentLoginMember.getAccount());
                    // update the return page
                    updatePanel(stageList);
                }
            });
        }
        
    }
}
