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
        case size4:
            createLevel4(getRandomNumber(1, 2));
            break;
        }

    }

    private void createLevel4(int level) {
        switch (level) {
        case 1:

            break;
        case 2:
        
            break;
        }
    }

    private int getRandomNumber(int min, int max) {
        return (int) (Math.random() * (max - min + 1) + min);
    }

}
