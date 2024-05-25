package view.Book;

import java.util.ArrayList;

import javax.swing.JOptionPane;

import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import view.App;

public class ManageBook {
    private GridPane gridPane = new GridPane();
    GridPane searchResultTable = new GridPane();
    private ArrayList<Button> modifyButtons = new ArrayList<>();
    private ArrayList<Button> deleteButtons = new ArrayList<>();

    public GridPane createPanel(Object[] stageList, javafx.stage.Stage primaryStage) {
        // initialize the gridPane
        gridPane.setHgap(20);
        gridPane.setVgap(20);
        gridPane.setAlignment(javafx.geometry.Pos.CENTER);
        gridPane.setStyle("-fx-background-color: #FFFFFF;");
        
        // draw the search part, each row behind a modify and a delete button
        // set search method, using drop down list
        ChoiceBox<String> searchMethod = new ChoiceBox<>();
        searchMethod.getItems().addAll("類別", "作者", "書名");

        // add search result table
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
                    Label searchContent = new Label("書名");
                    TextField searchContentField = new TextField();
                    gridPane.add(searchContent, 0, 1);
                    gridPane.add(searchContentField, 1, 1);
                }
                else if(searchMethod.getValue().equals("作者")){
                    Label searchContent = new Label("作者");
                    TextField searchContentField = new TextField();
                    gridPane.add(searchContent, 0, 1);
                    gridPane.add(searchContentField, 1, 1);
                }
            }
        });

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
                else if(method.equals("書名") || method.equals("作者")){
                    TextField searchContent = (TextField) gridPane.getChildren().get(4);
                    content = searchContent.getText();
                }
                // search the book by the search method and search content
                // the search result will be displayed in the table
                // the table will be displayed in the search page
                ArrayList<object.Books> searchResult = searchBooks(App.getBooks(), method, content);
                updateSearchResult(searchResultTable, searchResult);
            }
        });

        return gridPane;
    }
    private ArrayList<object.Books> searchBooks(ArrayList<object.Books> books, String method, String content){
        // search the book by the search method and search content
        ArrayList<object.Books> searchResult = new ArrayList<>();
        for(object.Books book:books){
            if(method.equals("類別") && book.getCategory().equals(content)){
                searchResult.add(book);
            }
            else if(method.equals("書名") && book.getName().equals(content)){
                searchResult.add(book);
            }
            else if(method.equals("作者") && book.getAuthor().equals(content)){
                searchResult.add(book);
            }
        }
        return searchResult;
    }

    private void updateSearchResult(GridPane searchResultTable, ArrayList<object.Books> searchResult){
        // update the search result table
        // clear the search result table
        while(searchResultTable.getChildren().size() > 1){
            searchResultTable.getChildren().remove(1);
        }
        // clear the modify and delete button
        modifyButtons.clear();
        deleteButtons.clear();

        // add the title
        Label title = new Label("搜尋結果");
        searchResultTable.add(title, 0, 0);
        // add the search result

        for(int i = 0; i < searchResult.size(); i++){
            Label book = new Label("書名: " + searchResult.get(i).getName() + " 作者: " + searchResult.get(i).getAuthor() + " 出版社: " + searchResult.get(i).getPublisher() + " ISBN: " + searchResult.get(i).getISBN() + " 類別: " + searchResult.get(i).getCategory());
            Button modifyButton = new Button("修改");
            Button deleteButton = new Button("刪除");

            searchResultTable.add(book, 0, i + 1);
            searchResultTable.add(modifyButton, 1, i + 1);
            searchResultTable.add(deleteButton, 2, i + 1);

            // add buttons to arrayList
            modifyButtons.add(modifyButton);
            deleteButtons.add(deleteButton);
        }

        // add event handler to modify button
        for(int i = 0; i < modifyButtons.size(); i++){
            int index = i;
            modifyButtons.get(index).setOnAction(new javafx.event.EventHandler<javafx.event.ActionEvent>() {
                @Override
                public void handle(javafx.event.ActionEvent event) {
                    // modify the book
                    modifyBook(searchResult.get(index));
                }
            });
        }
        // add event handler to delete button
        for(int i = 0; i < deleteButtons.size(); i++){
            int index = i;
            deleteButtons.get(index).setOnAction(new javafx.event.EventHandler<javafx.event.ActionEvent>() {
                @Override
                public void handle(javafx.event.ActionEvent event) {
                    // delete the book
                    deleteBook(searchResult.get(index));
                    // update the search result
                    updateSearchResult(searchResultTable, searchResult);
                }
            });
        }
    }
    private void modifyBook(object.Books book){
        // modify the book
        // pop up a window to input the new information
        Scene scene = new Scene(new Group());
        javafx.stage.Stage stage = new javafx.stage.Stage();
        stage.setTitle("修改書籍");
        stage.setWidth(300);
        stage.setHeight(300);
        stage.setScene(scene);
        stage.show();
        GridPane gridPane = new GridPane();
        gridPane.setHgap(20);
        gridPane.setVgap(20);
        gridPane.setAlignment(javafx.geometry.Pos.CENTER);
        gridPane.setStyle("-fx-background-color: #FFFFFF;");
        Label nameLabel = new Label("書名");
        Label authorLabel = new Label("作者");
        Label publisherLabel = new Label("出版社");
        Label isbnLabel = new Label("ISBN");
        Label categoryLabel = new Label("類別");
        TextField nameField = new TextField();
        TextField authorField = new TextField();
        TextField publisherField = new TextField();
        TextField ISBNField = new TextField();
        TextField categoryField = new TextField();
        Button enterButton = new Button("確認");
        gridPane.add(nameLabel, 0, 0);
        gridPane.add(authorLabel, 0, 1);
        gridPane.add(publisherLabel, 0, 2);
        gridPane.add(isbnLabel, 0, 3);
        gridPane.add(categoryLabel, 0, 4);
        gridPane.add(nameField, 1, 0);
        gridPane.add(authorField, 1, 1);
        gridPane.add(publisherField, 1, 2);
        gridPane.add(ISBNField, 1, 3);
        gridPane.add(categoryField, 1, 4);
        gridPane.add(enterButton, 1, 5);
        scene.setRoot(gridPane);
        enterButton.setOnAction(e -> {
            if(nameField.getText().equals("")){
                nameLabel.styleProperty().set("-fx-text-fill: red;");
            }
            if(authorField.getText().equals("")){
                authorLabel.styleProperty().set("-fx-text-fill: red;");
            }
            if(publisherField.getText().equals("")){
                publisherLabel.styleProperty().set("-fx-text-fill: red;");
            }
            if(ISBNField.getText().equals("")){
                isbnLabel.styleProperty().set("-fx-text-fill: red;");
            }
            if(categoryField.getText().equals("")){
                categoryLabel.styleProperty().set("-fx-text-fill: red;");
            }
            if(!nameField.getText().equals("") && !authorField.getText().equals("") && !publisherField.getText().equals("") && !ISBNField.getText().equals("") && !categoryField.getText().equals("")){
                book.setName(nameField.getText());
                book.setAuthor(authorField.getText());
                book.setPublisher(publisherField.getText());
                book.setISBN(Integer.parseInt(ISBNField.getText()));
                book.setCategory(categoryField.getText());
                // update the search result
                App.modifyBook(book);
                updateSearchResult(searchResultTable, App.getBooks());
                stage.close();
            }
        });

    }

    private void deleteBook(object.Books book){
        // delete the book, JOptionPane to check if the user want to delete the book
        int check = JOptionPane.showConfirmDialog(null, "確定要刪除嗎?", "刪除書籍", JOptionPane.YES_NO_OPTION);
        if(check == JOptionPane.YES_OPTION){
            App.deleteBook(book);
            updateSearchResult(searchResultTable, App.getBooks());
        }
    }
}
