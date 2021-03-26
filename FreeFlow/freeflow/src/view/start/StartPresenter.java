package view.start;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Alert;
import model.Level;
import view.game.GamePresenter;
import view.game.GameView;

/**
 * Jonathan Dom
 * 3/19/2021
 */
public class StartPresenter {

    private StartView view;
    private Level model;

    public StartPresenter(StartView view, Level model) {
        this.view = view;
        this.model = model;
        addEventHandlers();
        updateView();

    }

    private void updateView() {
        //GraphicsContext gc = view.getCanvas().getGraphicsContext2D();
    }

    private void addEventHandlers() {
        view.getBtnStart().setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                GameView gameview = new GameView();
                GamePresenter gamePresenter = new GamePresenter(model,gameview);
                view.getScene().setRoot(gameview);
                gameview.getScene().getWindow().sizeToScene();
            }
        });

        view.getBtnAbout().setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                showComingSoon();
            }
        });

        view.getBtnHighScores().setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                showComingSoon();
            }
        });

        view.getBtnSettings().setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                showComingSoon();
            }
        });
    }

    private void showComingSoon(){
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Error");
        alert.setHeaderText("Wegens gebrek aan tijd is dit jammer genoeg niet af geraakt.");
        alert.setContentText("Coming soon... Hopefully");
        alert.showAndWait();
    }
}
