/**
 * Jonathan Dom 1/6/2021
 */
public class PlayGame {
    public static void main(String[] args) {
        Player player = new Player("A");
        Level level = new Level(IO.promptForLevelSize());
        while (!level.checkIfWon()) {
            level.showBoard();
            System.out.println(Integer.toString(level.getCompletedColor()));
            level.makeMove();
        }
    }

}
