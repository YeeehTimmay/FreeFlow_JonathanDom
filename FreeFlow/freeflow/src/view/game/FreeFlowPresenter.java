package view.game;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import model.Level;
import view.start.StartPresenter;
import view.start.StartView;

/**
 * Jonathan Dom
 * 3/19/2021
 */
public class FreeFlowPresenter {
    private Level model;
    private FreeFlowView view;

    public FreeFlowPresenter(Level model, FreeFlowView view) {
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
    }

}
