package view.game;

import model.Level;

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
    }

}
