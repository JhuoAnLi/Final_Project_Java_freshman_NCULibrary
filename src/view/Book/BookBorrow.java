package view.Book;

import java.util.ArrayList;

import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import object.Books;
import object.Student;
import view.App;

public class BookBorrow {
    public GridPane createPanel(Object[] stageList, Stage primaryStage, ArrayList<object.Books> books) {
        GridPane gridPane = new GridPane();
        // draw the book borrow page, need search in the left side and check which book to borrow in the right side
        // set the gap between the elements
        gridPane.setHgap(20);
        gridPane.setVgap(20);
        // set the alignment
        gridPane.setAlignment(javafx.geometry.Pos.CENTER);
        // set the background color
        gridPane.setStyle("-fx-background-color: #FFFFFF;");
        
        
        // add the borrow part
        GridPane borrowBook = new GridPane();
        updateBorrowPanel(retrieveBooks(), borrowBook, stageList);
        // add the search part
        GridPane searchBorrowBook = createSearchPanel(retrieveBooks(), borrowBook, stageList);
        gridPane.add(searchBorrowBook, 0, 0);
        gridPane.add(borrowBook, 1, 0);


        return gridPane;
    }
    private ArrayList<Books> retrieveBooks(){
        ArrayList<Books> books = new ArrayList<>();
        // filter the books, only show the books that are available
        ArrayList<Books> allBooks = App.getBooks();
        for(Books book:allBooks){
            if(book.getStatus().equals("Available")){
                books.add(book);
            }
        }
        return books;
    }
    private GridPane createSearchPanel(ArrayList<Books> books, GridPane borrowBook, Object[] stageList){
        GridPane gridPane = new GridPane();
        // draw the search part
        // set the gap between the elements
        gridPane.setHgap(20);
        gridPane.setVgap(20);
        // set the alignment
        gridPane.setAlignment(javafx.geometry.Pos.CENTER);
        // set the background color
        gridPane.setStyle("-fx-background-color: #FFFFFF;");

        // set search method, using drop down list
        ChoiceBox<String> searchMethod = new ChoiceBox<>();
        searchMethod.getItems().addAll("類別", "作者", "書名");
        gridPane.add(searchMethod, 0, 0);
        Button searchButton = new Button("搜尋");
        gridPane.add(searchButton, 0, 2);

        // set the search content, if the search method is "類別", the search content will be the category
        searchMethod.addEventHandler(javafx.event.ActionEvent.ACTION, new javafx.event.EventHandler<javafx.event.ActionEvent>() {
            @Override
            public void handle(javafx.event.ActionEvent event) {
                // clear the gridPane's row 
                while(gridPane.getChildren().size() > 2){
                    gridPane.getChildren().remove(2);
                }
                // when the search method is selected, the search content will be different
                // set the search content, if the search method is "類別", the search content will be the category
                if (searchMethod.getValue().equals("類別")) {
                    ChoiceBox<String> searchContent = new ChoiceBox<>();
                    searchContent.getItems().addAll("文學", "歷史", "科技", "數學", "語言", "藝術", "其他");
                    gridPane.add(searchContent, 0, 1);
                }
                else if(searchMethod.getValue().equals("書名")){
                    TextField searchContent = new TextField();
                    gridPane.add(searchContent, 0, 1);
                }
                else if(searchMethod.getValue().equals("作者")){
                    TextField searchContent = new TextField();
                    gridPane.add(searchContent, 0, 1);
                }
                
            }
        });
        searchButton.addEventHandler(javafx.event.ActionEvent.ACTION, new javafx.event.EventHandler<javafx.event.ActionEvent>() {
            @Override
            public void handle(javafx.event.ActionEvent event) {
                // search the book
                String searchMethod = ((ChoiceBox<String>)gridPane.getChildren().get(0)).getValue();
                ArrayList<Books> searchResult = new ArrayList<>();
                // search the book
                // if the search method is "類別", the search content will be the category
                if (searchMethod.equals("類別")) {
                    // search the book by category
                    String searchContent = ((ChoiceBox<String>)gridPane.getChildren().get(2)).getValue();
                    for(Books book:books){
                        if(book.getCategory().equals(searchContent)){
                            searchResult.add(book);
                        }
                    }
                }
                else if(searchMethod.equals("書名")){
                    // search the book by book name
                    String searchContent = ((TextField)gridPane.getChildren().get(2)).getText();
                    for(Books book:books){
                        if(book.getName().equals(searchContent)){
                            searchResult.add(book);
                        }
                    }
                }
                else if(searchMethod.equals("作者")){
                    // search the book by author
                    String searchContent = ((TextField)gridPane.getChildren().get(2)).getText();
                    for(Books book:books){
                        if(book.getAuthor().equals(searchContent)){
                            searchResult.add(book);
                        }
                    }
                }
                
                updateBorrowPanel(searchResult, borrowBook, stageList);

            }
            
        });
        return gridPane;
    }
    private void updateBorrowPanel(ArrayList<Books> searchResult, GridPane parentGridPane, Object[] stageList){
        GridPane gridPane = new GridPane();
        // draw the borrow part
        // set the gap between the elements
        gridPane.setHgap(20);
        gridPane.setVgap(20);
        // set the alignment
        gridPane.setAlignment(javafx.geometry.Pos.CENTER);
        // set the background color
        gridPane.setStyle("-fx-background-color: #FFFFFF;");

        // clear
        while(gridPane.getChildren().size() > 0){
            gridPane.getChildren().remove(0);
        }
        while(parentGridPane.getChildren().size() > 0){
            parentGridPane.getChildren().remove(0);
        }

        // show searchResult by table, add borrow button at the end of each row
        ArrayList<Button> borrowButtonList = new ArrayList<>();
        for(int i = 0; i < searchResult.size(); i++){
            Label bookName = new Label(searchResult.get(i).getName());
            gridPane.add(bookName, 0, i);
            Button borrowButton = new Button("借書");
            borrowButtonList.add(borrowButton);
            gridPane.add(borrowButton, 1, i);
        }

        for(int i = 0; i < borrowButtonList.size(); i++){
            int index = i;
            borrowButtonList.get(i).addEventHandler(javafx.event.ActionEvent.ACTION, new javafx.event.EventHandler<javafx.event.ActionEvent>() {
                @Override
                public void handle(javafx.event.ActionEvent event) {
                    // borrow the book, by sql manage?
                    // for test, we just remove the book from the searchResult
                    try{
                        Student.borrow_book(searchResult.get(index).getName(), App.getLoginMember().getAccount());
                        App.updateBookBorrow(stageList);
                    }
                    catch(Exception e){
                        System.out.println(e);
                    }
                    ArrayList<Books> updateList = retrieveBooks();
                    updateBorrowPanel(updateList, parentGridPane, stageList);
                }
            });
        }

        parentGridPane.add(gridPane, 1, 0);
    }
}
