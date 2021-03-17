/**
 * Jonathan Dom 12/13/2020
 */
public class Level {
    private Board board;
    private int moves = 0;

    public Level(LevelSizes size) {
        createLevel(size);
    }

    private void createLevel(LevelSizes size) {
        board = new Board(size.getLevelSize());
        switch (size) {
            case size5:
                createLevel5(getRandomNumber(1, 2));
                break;
            case size6:
                createLevel6(getRandomNumber(1, 2));
                break;
            case size7:
                createLevel7(getRandomNumber(1, 2));
                break;
        }

    }

    private void createLevel5(int level) {
        switch (level) {
            case 1:
                board.setField(0,0,Type.CIRCLE, Colors.RED);
                board.setField(1,4,Type.CIRCLE, Colors.RED);
                board.setField(2,0, Type.CIRCLE, Colors.GREEN);
                board.setField(1,3, Type.CIRCLE, Colors.GREEN);
                board.setField(2,1, Type.CIRCLE, Colors.BLUE);
                board.setField(2,4, Type.CIRCLE, Colors.BLUE);
                board.setField(4,0, Type.CIRCLE, Colors.YELLOW);
                board.setField(3,3, Type.CIRCLE, Colors.YELLOW);
                board.setField(4,1,Type.CIRCLE,Colors.PURPLE);
                board.setField(3,4,Type.CIRCLE,Colors.PURPLE);
                break;
            case 2:
                board.setField(0,4,Type.CIRCLE, Colors.RED);
                board.setField(2,3,Type.CIRCLE, Colors.RED);
                board.setField(2,2, Type.CIRCLE, Colors.GREEN);
                board.setField(1,3, Type.CIRCLE, Colors.GREEN);
                board.setField(0,3, Type.CIRCLE, Colors.BLUE);
                board.setField(4,4, Type.CIRCLE, Colors.BLUE);
                board.setField(0,0, Type.CIRCLE, Colors.YELLOW);
                board.setField(4,3, Type.CIRCLE, Colors.YELLOW);
                break;
            default:
                throw new IllegalArgumentException();
        }
    }

    private void createLevel6(int level) {
        switch (level) {
            case 1:
                board.setField(4,0,Type.CIRCLE, Colors.RED);
                board.setField(2,3,Type.CIRCLE, Colors.RED);
                board.setField(0,0, Type.CIRCLE, Colors.GREEN);
                board.setField(0,4, Type.CIRCLE, Colors.GREEN);
                board.setField(0,5, Type.CIRCLE, Colors.BLUE);
                board.setField(2,5, Type.CIRCLE, Colors.BLUE);
                board.setField(1,0, Type.CIRCLE, Colors.YELLOW);
                board.setField(0,5, Type.CIRCLE, Colors.YELLOW);
                board.setField(4,1, Type.CIRCLE, Colors.PURPLE);
                board.setField(2,4, Type.CIRCLE, Colors.PURPLE);
                board.setField(2,0, Type.CIRCLE, Colors.CYAN);
                board.setField(2,2, Type.CIRCLE, Colors.CYAN);

                break;
            case 2:
                board.setField(3,2,Type.CIRCLE, Colors.RED);
                board.setField(1,4,Type.CIRCLE, Colors.RED);
                board.setField(5,0, Type.CIRCLE, Colors.GREEN);
                board.setField(5,2, Type.CIRCLE, Colors.GREEN);
                board.setField(2,0, Type.CIRCLE, Colors.BLUE);
                board.setField(5,3, Type.CIRCLE, Colors.BLUE);
                board.setField(2,2, Type.CIRCLE, Colors.YELLOW);
                board.setField(2,4, Type.CIRCLE, Colors.YELLOW);
                board.setField(1,0, Type.CIRCLE, Colors.PURPLE);
                board.setField(5,4, Type.CIRCLE, Colors.PURPLE);
                board.setField(3,3, Type.CIRCLE, Colors.CYAN);
                board.setField(4,4, Type.CIRCLE, Colors.CYAN);

                break;
            default:
                throw new IllegalArgumentException();
        }
    }

    private void createLevel7(int level) {
        switch (level) {
            case 1:
                board.setField(6,1,Type.CIRCLE, Colors.RED);
                board.setField(4,5,Type.CIRCLE, Colors.RED);
                board.setField(3,3, Type.CIRCLE, Colors.GREEN);
                board.setField(2,4, Type.CIRCLE, Colors.GREEN);
                board.setField(6,0, Type.CIRCLE, Colors.BLUE);
                board.setField(5,6, Type.CIRCLE, Colors.BLUE);
                board.setField(4,4, Type.CIRCLE, Colors.YELLOW);
                board.setField(5,5, Type.CIRCLE, Colors.YELLOW);
                board.setField(1,2, Type.CIRCLE, Colors.PURPLE);
                board.setField(5,1, Type.CIRCLE, Colors.PURPLE);
                board.setField(4,3, Type.CIRCLE, Colors.CYAN);
                board.setField(6,6, Type.CIRCLE, Colors.CYAN);

                break;
            case 2:
                board.setField(2,0,Type.CIRCLE, Colors.RED);
                board.setField(3,6,Type.CIRCLE, Colors.RED);
                board.setField(2,2, Type.CIRCLE, Colors.GREEN);
                board.setField(5,3, Type.CIRCLE, Colors.GREEN);
                board.setField(3,1, Type.CIRCLE, Colors.BLUE);
                board.setField(5,1, Type.CIRCLE, Colors.BLUE);
                board.setField(3,3, Type.CIRCLE, Colors.YELLOW);
                board.setField(4,4, Type.CIRCLE, Colors.YELLOW);
                board.setField(2,1, Type.CIRCLE, Colors.PURPLE);
                board.setField(2,5, Type.CIRCLE, Colors.PURPLE);
                board.setField(2,3, Type.CIRCLE, Colors.CYAN);
                board.setField(5,4, Type.CIRCLE, Colors.CYAN);
                board.setField(1,0, Type.CIRCLE, Colors.WHITE);
                board.setField(2,6, Type.CIRCLE, Colors.WHITE);

                break;
            default:
                throw new IllegalArgumentException();

        }
    }

    private int getRandomNumber(int min, int max) {
        return (int) (Math.random() * (max - min + 1) + min);
    }

}
