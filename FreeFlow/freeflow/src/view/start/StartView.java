package view.start;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.canvas.Canvas;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import javafx.scene.text.Font;


/**
 * // * Jonathan Dom
 * // * 3/19/2021
 * //
 */
public class StartView extends BorderPane {
    //private Canvas canvas;
    private Button btnStart;
    private Button btnSettings;
    private Button btnAbout;
    private Button btnHighScores;
    private Label lblTitle;
    ToolBar toolBar;
//    MenuItem miAbout = new MenuItem();
//    MenuItem miHighScores = new MenuItem();

    public StartView() {
        initializeNodes();
        layoutNodes();
    }

    private void initializeNodes() {
        btnStart = new Button("Select level");
        btnSettings = new Button("Settings");
        btnAbout = new Button("About");
        btnHighScores = new Button("Highscores");
        lblTitle = new Label("Free Flow");
        toolBar = new ToolBar();
         toolBar.getItems().add(btnHighScores);
         toolBar.getItems().add(btnAbout);





    }

    private void layoutNodes() {
//       super.setCenter(new StackPane(canvas, lblTitle));
//       super.setBottom(btnAbout);
//       BorderPane.setAlignment(btnAbout, Pos.BOTTOM_RIGHT);
//       BorderPane.setMargin(btnAbout, new Insets(10));
        VBox vbox = new VBox();

        vbox.getChildren().add(lblTitle);
        vbox.getChildren().add(btnStart);
        vbox.getChildren().add(btnSettings);

        //this.setTop(lblTitle);
        this.setTop(toolBar);
        this.setCenter(vbox);

        lblTitle.setFont(new Font(150));

        btnStart.setPrefSize(400,200);
        btnSettings.setPrefSize(400,200);

        this.setAlignment(lblTitle,Pos.CENTER);
        this.setAlignment(vbox,Pos.CENTER);
        vbox.setAlignment(Pos.CENTER);
        //this.setPadding(new Insets(30,30,30,30));
        //btnStart.setPadding(new Insets(30,30,30,30));
        this.setBackground(new Background(new BackgroundImage(new Image("shrek.png"),
                BackgroundRepeat.NO_REPEAT,
                BackgroundRepeat.NO_REPEAT,
                BackgroundPosition.CENTER,
                new BackgroundSize(100,100,true,true,true,true))));
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
}


