package view.game;


import javafx.geometry.Pos;
import javafx.scene.canvas.Canvas;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.StackPane;
import model.Player;

/**
 * Jonathan Dom
 * 3/19/2021
 */
public class FreeFlowView extends BorderPane {
    private Canvas canvas;
    private Label lblName;
    private Button btnBack;


    public FreeFlowView() {
        initializeNodes();
        layoutNodes();
    }

    private void layoutNodes() {
        super.setCenter(canvas);
        super.setTop(btnBack);
        BorderPane.setAlignment(btnBack, Pos.TOP_LEFT);






    }

    private void initializeNodes() {
        canvas = new Canvas(300, 500);
        lblName = new Label("Name");
        btnBack = new Button("Back");



    }
}




