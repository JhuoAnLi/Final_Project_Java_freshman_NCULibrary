package view.Book;

import java.util.ArrayList;

import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import object.Books;
import object.Member;
import view.App;

public class BookReturn {
    public GridPane createPanel() {
        GridPane gridPane = new GridPane();

        return gridPane;
    }
    public static void updatePanel(Object[] stageList) {
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
        // draw the return page
        GridPane gridPane = (GridPane) stageList[7];
        // set the gap between the elements
        gridPane.setHgap(20);
        gridPane.setVgap(20);
        // set the alignment
        gridPane.setAlignment(javafx.geometry.Pos.CENTER);
        // set the background color
        gridPane.setStyle("-fx-background-color: #FFFFFF;");
        // add the title
        javafx.scene.control.Label label = new javafx.scene.control.Label("歸還書籍");
        gridPane.add(label, 0, 0);
        // add the borrowed books, add return button after each book

        ArrayList<Button> returnButtons = new ArrayList<>();
        for(int i = 0; i < borrowedBooks.size(); i++){
            javafx.scene.control.Label borrowedBook = new javafx.scene.control.Label("書名: " + borrowedBooks.get(i).getName());
            gridPane.add(borrowedBook, 0, i + 1);
            Button returnButton = new Button("歸還");
            gridPane.add(returnButton, 1, i + 1);
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
