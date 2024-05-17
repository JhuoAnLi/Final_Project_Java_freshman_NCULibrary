package view.Book;

import java.util.ArrayList;

import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;

public class Search {
    public GridPane createPanel(Object[] stageList, javafx.stage.Stage primaryStage, ArrayList<object.Books> books) {
        GridPane gridPane = new GridPane();
        // draw the search page
        // set the gap between the elements
        gridPane.setHgap(20);
        gridPane.setVgap(20);
        // set the alignment
        gridPane.setAlignment(javafx.geometry.Pos.CENTER);
        // set the background color
        gridPane.setStyle("-fx-background-color: #FFFFFF;");

        // set search method, using drop down list
        ChoiceBox<String> searchMethod = new ChoiceBox<>();
        searchMethod.getItems().addAll("類別", "作者", "書名", "出版社", "ISBN", "狀態");

        // add search result table
        GridPane searchResultTable = new GridPane();
        searchResultTable.setHgap(20);
        searchResultTable.setVgap(20);
        searchResultTable.setAlignment(javafx.geometry.Pos.CENTER);
        // add the title
        Label title = new Label("搜尋結果");
        searchResultTable.add(title, 0, 0);
        

        // add enter button
        Button searchButton = new Button("搜尋");

        gridPane.add(searchButton, 0, 3);
        gridPane.add(searchResultTable, 3, 0);
        gridPane.add(searchMethod, 0, 0);

        // by the search method, the search content will be different
        // set the search content, if the search method is "類別", the search content will be the category
        searchMethod.addEventHandler(javafx.event.ActionEvent.ACTION, new javafx.event.EventHandler<javafx.event.ActionEvent>() {
            @Override
            public void handle(javafx.event.ActionEvent event) {
                // clear the gridPane's row 
                while(gridPane.getChildren().size() > 3){
                    gridPane.getChildren().remove(3);
                }
                // when the search method is selected, the search content will be different
                // set the search content, if the search method is "類別", the search content will be the category
                if (searchMethod.getValue().equals("類別")) {
                    ChoiceBox<String> searchContent = new ChoiceBox<>();
                    searchContent.getItems().addAll("文學", "歷史", "科技", "數學", "語言", "藝術", "其他");
                    gridPane.add(searchContent, 0, 1);
                }
                else if(searchMethod.getValue().equals("書名")){
                    // if the search method is "書名", the search content will be the book name
                    Label searchLabel = new Label("請輸入書名");
                    TextField searchContent = new TextField();
                    gridPane.add(searchLabel, 0, 1);
                    gridPane.add(searchContent, 1, 1);
                }
                else if(searchMethod.getValue().equals("作者")){
                    // if the search method is "作者", the search content will be the author
                    Label searchLabel = new Label("請輸入作者");
                    TextField searchContent = new TextField();
                    gridPane.add(searchLabel, 0, 1);
                    gridPane.add(searchContent, 1, 1);
                }
                else if(searchMethod.getValue().equals("出版社")){
                    // if the search method is "出版社", the search content will be the publisher
                    Label searchLabel = new Label("請輸入出版社");
                    TextField searchContent = new TextField();
                    gridPane.add(searchLabel, 0, 1);
                    gridPane.add(searchContent, 1, 1);
                }
                else if(searchMethod.getValue().equals("ISBN")){
                    // if the search method is "ISBN", the search content will be the ISBN
                    Label searchLabel = new Label("請輸入ISBN");
                    TextField searchContent = new TextField();
                    gridPane.add(searchLabel, 0, 1);
                    gridPane.add(searchContent, 1, 1);
                }
                else if(searchMethod.getValue().equals("狀態")){
                    // if the search method is "狀態", the search content will be the status
                    ChoiceBox<String> searchContent = new ChoiceBox<>();
                    searchContent.getItems().addAll("可借", "不可借");
                    gridPane.add(searchContent, 0, 1);
                }
                
            }
        });

        // add event handler for the enter button
        searchButton.addEventHandler(javafx.event.ActionEvent.ACTION, new javafx.event.EventHandler<javafx.event.ActionEvent>() {
            @Override
            public void handle(javafx.event.ActionEvent event) {
                // get the search method and search content
                String method = searchMethod.getValue();
                String content = "";
                if (method.equals("類別")) {
                    ChoiceBox<String> searchContent = (ChoiceBox<String>) gridPane.getChildren().get(3);
                    content = searchContent.getValue();
                }
                else if(method.equals("書名") || method.equals("作者") || method.equals("出版社") || method.equals("ISBN")){
                    TextField searchContent = (TextField) gridPane.getChildren().get(4);
                    content = searchContent.getText();
                }
                else if(method.equals("狀態")){
                    ChoiceBox<String> searchContent = (ChoiceBox<String>) gridPane.getChildren().get(4);
                    content = searchContent.getValue();
                }
                // search the book by the search method and search content
                // the search result will be displayed in the table
                // the table will be displayed in the search page
                ArrayList<object.Books> searchResult = searchBooks(books, method, content);
                updateSearchResult(searchResultTable, searchResult);
            }
        });

        return gridPane;
    }
    private ArrayList<object.Books> searchBooks(ArrayList<object.Books> books, String method, String content){
        // search the book by the search method and search content
        // return the search result
        ArrayList<object.Books> searchResult = new ArrayList<>();
        if(method.equals("類別")){
            for(object.Books book: books){
                if(book.getCategory().equals(content)){
                    searchResult.add(book);
                }
            }
        }
        else if(method.equals("書名")){
            for(object.Books book: books){
                if(book.getName().equals(content)){
                    searchResult.add(book);
                }
            }
        }
        else if(method.equals("作者")){
            for(object.Books book: books){
                if(book.getAuthor().equals(content)){
                    searchResult.add(book);
                }
            }
        }
        else if(method.equals("出版社")){
            for(object.Books book: books){
                if(book.getPublisher().equals(content)){
                    searchResult.add(book);
                }
            }
        }
        else if(method.equals("ISBN")){
            for(object.Books book: books){
                if(book.getISBN() == Integer.parseInt(content)){
                    searchResult.add(book);
                }
            }
        }
        else if(method.equals("狀態")){
            for(object.Books book: books){
                if(book.getStatus().equals(content)){
                    searchResult.add(book);
                }
            }
        }
        return searchResult;
    }
    private void updateSearchResult(GridPane searchResultTable, ArrayList<object.Books> searchResult){
        // update the search result table
        // clear the table
        while(searchResultTable.getChildren().size() > 1){
            searchResultTable.getChildren().remove(1);
        }

        // add the search result
        for(int i = 0; i < searchResult.size(); i++){
            Label result = new Label(searchResult.get(i).getName());
            searchResultTable.add(result, 0, i + 1);
        }
    }
}
