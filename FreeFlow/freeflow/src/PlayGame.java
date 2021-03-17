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
        board.setField(0,0,Type.CIRCLE,Colors.BLUE);
        board.setField(0,1,Type.VERTICAL,Colors.BLUE);
        board.setField(1,0,Type.HORIZONTAL,Colors.BLUE);

        System.out.println(board.getField(0,1).getType());
        System.out.println(board);

        board.clearBoard();
        System.out.println(board);
    }
}
