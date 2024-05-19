package view.User;
import java.util.ArrayList;

import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.layout.GridPane;
import object.Member;
import view.App;

public class MembersInfo {
    public GridPane gridPane = new GridPane();
    public GridPane createPanel(Object[] stageList, javafx.stage.Stage primaryStage) {
        // set the gap between the elements
        gridPane.setHgap(20);
        gridPane.setVgap(20);
        // set the alignment
        gridPane.setAlignment(javafx.geometry.Pos.CENTER);
        Label label = new Label("會員資訊");
        gridPane.add(label, 0, 0);
        // add a update button behind the title
        Button updateButton = new Button("更新");
        gridPane.add(updateButton, 1, 0);

        updatePanel();

        updateButton.setOnAction(new javafx.event.EventHandler<javafx.event.ActionEvent>() {
            @Override
            public void handle(javafx.event.ActionEvent event) {
                updatePanel();
            }
        });

        
        return gridPane;
    }
    public void updatePanel(){
        // update the member information
        // get the member list
        ArrayList<Member> members = App.getMembers();
        // clear the gridPane
        gridPane.getChildren().remove(2, gridPane.getChildren().size());
        
        // use tableview
        TableView<Member> table = new TableView<>();

        TableColumn<Member, String> accountColumn = new TableColumn<>("帳號");
        accountColumn.setCellValueFactory(new javafx.scene.control.cell.PropertyValueFactory<>("account"));
        TableColumn<Member, String> nameColumn = new TableColumn<>("姓名");
        nameColumn.setCellValueFactory(new javafx.scene.control.cell.PropertyValueFactory<>("name"));
        TableColumn<Member, Integer> ageColumn = new TableColumn<>("年齡");
        ageColumn.setCellValueFactory(new javafx.scene.control.cell.PropertyValueFactory<>("age"));
        TableColumn<Member, String> identityColumn = new TableColumn<>("身分");
        identityColumn.setCellValueFactory(new javafx.scene.control.cell.PropertyValueFactory<>("identity"));

        table.getColumns().add(accountColumn);
        table.getColumns().add(nameColumn);
        table.getColumns().add(ageColumn);
        table.getColumns().add(identityColumn);

        for(int i = 0; i < members.size(); i++){
            table.getItems().add(members.get(i));
        }

        gridPane.add(table, 0, 1);

    }
}
