package view.start;

import javafx.geometry.Pos;
import javafx.scene.canvas.Canvas;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.StackPane;


/**
 * // * Jonathan Dom
 * // * 3/19/2021
 * //
 */
public class StartView extends BorderPane {
    private Canvas canvas;
    private Button btnStart;
    private Button btnSettings;
    private Button btnAbout;
    private Button btnHighScores;
    private Label lblTitle;


    public StartView() {
        initializeNodes();
        layoutNodes();
    }

    private void layoutNodes() {
       super.setCenter(new StackPane(canvas, lblTitle));
       super.setBottom(btnAbout);
       BorderPane.setAlignment(btnAbout, Pos.BOTTOM_RIGHT);





    }

    private void initializeNodes() {
        canvas = new Canvas(300, 500);
        btnStart = new Button("Select level");
        btnSettings = new Button("Settings");
        btnAbout = new Button("About");
        btnHighScores = new Button("Highscores");
        lblTitle = new Label("Free Flow");


    }

    public Canvas getCanvas() {
        return canvas;
    }

    public Button getBtnStart() {
        return btnStart;
    }

    public Button getBtnSettings() {
        return btnSettings;
    }

    public Button getBtnAbout() {
        return btnAbout;
    }

    public Button getBtnHighScores() {
        return btnHighScores;
    }

    public Label getLblTitle() {
        return lblTitle;
    }
}


