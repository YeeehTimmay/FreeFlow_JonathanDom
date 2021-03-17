/**
 * Jonathan Dom 12/13/2020
 */
public class Level {
    private Board board;
    private Field[][] fields;

    public Level() {

    }

    /* public Field[][] getLevel(int levelNumber) {
        this.fields = board.createRaster();
        switch (levelNumber) {
        case 1:
            fields[0][0] = new Field(0, 0, Type.CIRCLE, Colors.YELLOW);
            fields[0][2] = new Field(2, 0, Type.CIRCLE, Colors.BLUE);
            fields[0][3] = new Field(3, 0, Type.CIRCLE, Colors.RED);
            fields[0][4] = new Field(4, 0, Type.CIRCLE, Colors.GREEN);
            fields[2][3] = new Field(3, 2, Type.CIRCLE, Colors.GREEN);
            fields[3][1] = new Field(1, 3, Type.CIRCLE, Colors.BLUE);
            fields[3][4] = new Field(4, 3, Type.CIRCLE, Colors.RED);
            fields[4][4] = new Field(4, 4, Type.CIRCLE, Colors.YELLOW);
            break;
        case 2:
            fields[0][0] = new Field(0, 0, Type.CIRCLE, Colors.BLUE);
            fields[0][3] = new Field(2, 0, Type.CIRCLE, Colors.YELLOW);
            fields[1][0] = new Field(3, 0, Type.CIRCLE, Colors.GREEN);
            fields[2][0] = new Field(4, 0, Type.CIRCLE, Colors.YELLOW);
            fields[2][2] = new Field(3, 2, Type.CIRCLE, Colors.GREEN);
            fields[2][3] = new Field(1, 3, Type.CIRCLE, Colors.BLUE);
            fields[3][1] = new Field(4, 3, Type.CIRCLE, Colors.RED);
            fields[3][3] = new Field(4, 4, Type.CIRCLE, Colors.RED);
            break;

        }
        return fields;

    } */

    public void makeMove(int x, int y, Colors color) {

        fields[x][y] = new Field(x, y, Type.VERTICAL, color);

    }

}
