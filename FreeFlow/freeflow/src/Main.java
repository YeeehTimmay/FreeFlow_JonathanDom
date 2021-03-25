import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import model.IO;
import model.Level;
import model.Player;
import view.start.StartPresenter;
import view.start.StartView;

public class Main extends Application {

    public static void main(String[] args) {
        Application.launch(args);
    }

        @Override
        public void start (Stage stage) throws Exception {
            Player player = new Player(IO.promptForText("Welcome! Enter your name here"));
            Level level = new Level(IO.promptForLevelSize());
            StartView view = new StartView();
            StartPresenter presenter = new StartPresenter(view, level);
            Scene scene = new Scene(view);
            stage.setScene(scene);
            stage.setTitle("Free Flow");
            stage.setWidth(400);
            stage.setHeight(400);
            stage.setResizable(false);
            stage.show();

            level.showBoard();
            while (!level.checkIfWon()) {
                level.makeMove();
                level.showBoard();
            }
            System.out.println("You have completed the level. ");
        }

    }








