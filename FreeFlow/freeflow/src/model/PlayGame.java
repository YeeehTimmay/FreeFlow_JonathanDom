package model;

/**
 * Jonathan Dom 1/6/2021
 */
public class PlayGame {
    public static void main(String[] args) {
        Player player = new Player(IO.promptForText("Welcome! Enter your name here"));
        Level level = new Level(IO.promptForLevelSize());
        level.showBoard();
        while (!level.checkIfWon()) {

            level.makeMove();
            level.showBoard();

        }

        System.out.println("You have completed the level. ");
    }

}
