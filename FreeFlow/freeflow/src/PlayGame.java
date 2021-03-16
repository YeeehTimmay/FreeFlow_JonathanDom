import java.util.Scanner;

/**
 * Jonathan Dom 1/6/2021
 */
public class PlayGame {
    public static void main(String[] args) {
        // ! remove board and add makeMove to level and change constructor
        Scanner scanner = new Scanner(System.in);
        Player player = new Player("A");
        Board board = new Board(5);
        Level level = new Level();
        System.out.print("Select level: ");
    }
}
