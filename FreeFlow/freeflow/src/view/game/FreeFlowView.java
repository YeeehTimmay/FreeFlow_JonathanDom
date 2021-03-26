package view.game;


import javafx.geometry.Pos;
import javafx.scene.canvas.Canvas;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import model.Player;

/**
 * Jonathan Dom
 * 3/19/2021
 */
public class FreeFlowView extends BorderPane {
    private Label lblName;
    private TextArea txtName;
    private Button btnBack;
    private Button btnLevel1;
    private Button btnLevel2;
    private Button btnLevel3;


    public FreeFlowView() {
        initializeNodes();
        layoutNodes();
    }

    private void initializeNodes() {
        lblName = new Label("Name");
        btnBack = new Button("Back");
        btnLevel1 = new Button("Level 1");
        btnLevel2 = new Button("Level 2");
        btnLevel3 = new Button("Level 3");
        txtName = new TextArea();
    }

    private void layoutNodes() {

        this.setTop(btnBack);
        BorderPane.setAlignment(btnBack, Pos.TOP_LEFT);

        HBox hBox = new HBox();
        hBox.getChildren().add(lblName);
        hBox.getChildren().add(txtName);
        hBox.setAlignment(Pos.CENTER);
        txtName.setPrefSize(200,12);

        VBox vBox = new VBox();
        vBox.getChildren().add(hBox);
        vBox.getChildren().add(btnLevel1);
        vBox.getChildren().add(btnLevel2);
        vBox.getChildren().add(btnLevel3);
        this.setCenter(vBox);
        vBox.setAlignment(Pos.CENTER);

        this.setPrefSize(1000,800);

    }

    public Button getBtnBack() {
        return btnBack;
    }
}




