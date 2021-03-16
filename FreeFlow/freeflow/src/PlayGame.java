import java.util.Scanner;

/**
 * Jonathan Dom
 * 1/6/2021
 */
public class PlayGame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Player player = new Player("A");
        Board board = new Board();
        Level level = new Level();
        System.out.print("Select level: ");
        board.LevelSelect(scanner.nextInt());
        board.makeMove();



    }
}

