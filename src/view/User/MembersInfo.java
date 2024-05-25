package view.User;
import java.util.ArrayList;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;
import javafx.scene.control.Separator;
import object.Member;
import view.App;

public class MembersInfo {
    public GridPane gridPane = new GridPane();
    public GridPane createPanel(Object[] stageList, Stage primaryStage) {
        // Initialize the gridPane
        gridPane.setHgap(20);
        gridPane.setVgap(20);
        gridPane.setAlignment(Pos.CENTER);
        gridPane.setPadding(new Insets(20));
        gridPane.setStyle("-fx-background-color: #FFFFFF; -fx-padding: 20; -fx-border-color: #B0C4DE; -fx-border-width: 2; -fx-border-radius: 10; -fx-background-radius: 10;");

        // Add title
        Label label = new Label("Members Information");
        label.setFont(Font.font("Arial", FontWeight.BOLD, 24));
        label.setTextFill(Color.DARKSLATEBLUE);
        gridPane.add(label, 0, 0);

        // Add a separator below the title
        Separator titleSeparator = new Separator();
        gridPane.add(titleSeparator, 0, 1, 2, 1);

        // Add update button
        Button updateButton = new Button("更新");
        updateButton.setFont(Font.font("Arial", FontWeight.BOLD, 14));
        updateButton.setStyle("-fx-background-color: #4CAF50; -fx-text-fill: white; -fx-background-radius: 5;");
        updateButton.setOnMouseEntered(e -> updateButton.setStyle("-fx-background-color: #45a049; -fx-text-fill: white; -fx-background-radius: 5;"));
        updateButton.setOnMouseExited(e -> updateButton.setStyle("-fx-background-color: #4CAF50; -fx-text-fill: white; -fx-background-radius: 5;"));
        HBox buttonBox = new HBox(updateButton);
        buttonBox.setAlignment(Pos.CENTER_RIGHT);
        gridPane.add(buttonBox, 1, 0);

        updatePanel();

        updateButton.setOnAction(event -> updatePanel());

        return gridPane;
    }

    public void updatePanel() {
        // Get the member list
        ArrayList<Member> members = App.getMembers();
        // Clear the gridPane below the title and button
        gridPane.getChildren().removeIf(node -> GridPane.getRowIndex(node) > 1);

        // Use TableView to display member information
        TableView<Member> table = new TableView<>();
        table.setPrefWidth(400);

        TableColumn<Member, String> accountColumn = new TableColumn<>("帳號");
        accountColumn.setCellValueFactory(new PropertyValueFactory<>("account"));

        TableColumn<Member, String> nameColumn = new TableColumn<>("姓名");
        nameColumn.setCellValueFactory(new PropertyValueFactory<>("name"));

        TableColumn<Member, Integer> ageColumn = new TableColumn<>("年齡");
        ageColumn.setCellValueFactory(new PropertyValueFactory<>("age"));

        TableColumn<Member, String> identityColumn = new TableColumn<>("身分");
        identityColumn.setCellValueFactory(new PropertyValueFactory<>("identity"));

        table.getColumns().addAll(accountColumn, nameColumn, ageColumn, identityColumn);

        ObservableList<Member> memberList = FXCollections.observableArrayList(members);
        table.setItems(memberList);

        VBox tableContainer = new VBox(table);
        tableContainer.setPadding(new Insets(20, 0, 0, 0));
        gridPane.add(tableContainer, 0, 2, 2, 1);
    }
}
