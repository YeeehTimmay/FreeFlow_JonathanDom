package view.game;


import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.canvas.Canvas;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import model.Player;

/**
 * Jonathan Dom
 * 3/19/2021
 */
public class GameView extends BorderPane {
    private Label lblName;
    private TextArea txtName;
    private Button btnBack;
    private Button btnLevel1;
    private Button btnLevel2;
    private Button btnLevel3;


    public GameView() {
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
        btnBack.setPrefSize(60,30);


        HBox hBox = new HBox();
        hBox.getChildren().add(lblName);
        hBox.getChildren().add(txtName);
        hBox.setAlignment(Pos.CENTER);
        txtName.setPrefSize(200,12);
        lblName.setTextFill(Color.WHITE);
        lblName.setPadding(new Insets(0,10,0,0));
        btnLevel1.setPrefSize(150,50);
        btnLevel2.setPrefSize(150,50);
        btnLevel3.setPrefSize(150,50);



        VBox vBox = new VBox();
        vBox.getChildren().add(hBox);
        vBox.getChildren().add(btnLevel1);
        vBox.getChildren().add(btnLevel2);
        vBox.getChildren().add(btnLevel3);
        this.setCenter(vBox);
        vBox.setAlignment(Pos.CENTER);
        vBox.setSpacing(15);

        this.setPrefSize(1000,800);
        this.setBackground(new Background(new BackgroundImage(new Image("background.jpg"),
                BackgroundRepeat.NO_REPEAT,
                BackgroundRepeat.NO_REPEAT,
                BackgroundPosition.CENTER,
                new BackgroundSize(100,100,true,true,true,true))));

    }

    public Button getBtnBack() {
        return btnBack;
    }

    public Button getBtnLevel1() {
        return btnLevel1;
    }

    public Button getBtnLevel2() {
        return btnLevel2;
    }

    public Button getBtnLevel3() {
        return btnLevel3;
    }
}




