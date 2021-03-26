package view.game;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Alert;
import model.Level;
import model.LevelSizes;
import view.start.StartPresenter;
import view.start.StartView;

/**
 * Jonathan Dom
 * 3/19/2021
 */
public class GamePresenter {
    private Level model;
    private GameView view;

    public GamePresenter(Level model, GameView view) {
        this.model = model;
        this.view = view;
        addEventHandlers();
        updateView();
    }

    private void updateView() {
    }

    private void addEventHandlers() {
        view.getBtnBack().setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                StartView startView = new StartView();
                StartPresenter startPresenter = new StartPresenter(startView,model);
                view.getScene().setRoot(startView);

                startView.getScene().getWindow().sizeToScene();
            }
        });
        view.getBtnLevel1().setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
            model = new Level(LevelSizes.size5);
            showComingSoon();


            }
        });
        view.getBtnLevel2().setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                model = new Level(LevelSizes.size6);
                showComingSoon();
            }
        });
        view.getBtnLevel3().setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                model = new Level(LevelSizes.size7);
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
