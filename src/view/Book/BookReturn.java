package view.Book;

import java.util.ArrayList;

import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Separator;
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
        gridPane.setAlignment(javafx.geometry.Pos.TOP_CENTER);
        // set the background color
        gridPane.setStyle("-fx-background-color: #FFFFFF;");
        gridPane.setPadding(new javafx.geometry.Insets(20)); // 添加填充

        // add the title
        Label titleLabel = new Label("Books Return");
        titleLabel.setFont(javafx.scene.text.Font.font("Arial", javafx.scene.text.FontWeight.BOLD, 24));
        titleLabel.setTextFill(javafx.scene.paint.Color.DARKSLATEBLUE);
        gridPane.add(titleLabel, 0, 0, 3, 1); // 合并3列
        GridPane.setHalignment(titleLabel, javafx.geometry.HPos.CENTER); // 居中对齐

        // add a separator below the title
        javafx.scene.control.Separator separator = new javafx.scene.control.Separator();
        gridPane.add(separator, 0, 1, 3, 1);

        updatePanel(stageList);

        return gridPane;
    }

    public static void updatePanel(Object[] stageList) {
        GridPane gridPane = (GridPane) stageList[7];
        ArrayList<Books> books = App.getBooks();
        Member currentLoginMember = App.getLoginMember();
        if (currentLoginMember == null) {
            return;
        }
        // find the books that are borrowed by the current user
        ArrayList<Books> borrowedBooks = new ArrayList<>();
        for (Books book : books) {
            if (book.getBorrower() == null) {
                continue;
            }
            if (book.getStatus().equals("Unavailable") && book.getBorrower().equals(currentLoginMember.getName())) {
                borrowedBooks.add(book);
            }
        }

        // clear the gridPane
        gridPane.getChildren().remove(2, gridPane.getChildren().size());

        // to show the borrowed books, add column headers
        Label nameLabel = new Label("書名");
        nameLabel.setFont(javafx.scene.text.Font.font("Arial", javafx.scene.text.FontWeight.BOLD, 14));
        gridPane.add(nameLabel, 0, 2);
        Label dateLabel = new Label("借閱日");
        dateLabel.setFont(javafx.scene.text.Font.font("Arial", javafx.scene.text.FontWeight.BOLD, 14));
        gridPane.add(dateLabel, 1, 2);
        Label returnLabel = new Label("歸還");
        returnLabel.setFont(javafx.scene.text.Font.font("Arial", javafx.scene.text.FontWeight.BOLD, 14));
        gridPane.add(returnLabel, 2, 2);

        // show the borrowed books
        ArrayList<Button> returnButtons = new ArrayList<>();
        for (int i = 0; i < borrowedBooks.size(); i++) {
            Label borrowedBook = new Label(borrowedBooks.get(i).getName());
            gridPane.add(borrowedBook, 0, i + 3);
            Label status = new Label(borrowedBooks.get(i).getBorrow_time());
            gridPane.add(status, 1, i + 3);
            Button returnButton = new Button("歸還");
            gridPane.add(returnButton, 2, i + 3);
            // add return button to arrayList
            returnButtons.add(returnButton);
        }
        // set the return button event
        for (int i = 0; i < returnButtons.size(); i++) {
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
