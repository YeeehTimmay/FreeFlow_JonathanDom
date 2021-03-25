package view.start;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;
import model.Level;
import view.game.FreeFlowPresenter;
import view.game.FreeFlowView;

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

    }

    private void addEventHandlers() {
        view.getBtnStart().setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                FreeFlowView gameview = new FreeFlowView();
                FreeFlowPresenter gamePresenter = new FreeFlowPresenter(model,gameview);
                view.getScene().setRoot(gameview);
                gameview.getScene().getWindow().sizeToScene();
            }
        });
    }
}
