/**
 * Jonathan Dom
 * 12/13/2020
 */
public class Level  {
    private Board board ;
    private Field[][] fields;




    public Level() {

    }


    public Field[][] getLevel(int levelNumber){
        this.fields = new Field[5][5];
        switch (levelNumber){
            case 1: fields[0][0] = new Field(0,0,Type.CIRCLE,Colors.YELLOW, Direction.NULL);
                fields[0][2] = new Field(2,0,Type.CIRCLE,Colors.BLUE, Direction.NULL);
                fields[0][3] = new Field(3,0,Type.CIRCLE,Colors.RED, Direction.NULL);
                fields[0][4] = new Field(4,0,Type.CIRCLE,Colors.GREEN, Direction.NULL);
                fields[2][3] = new Field(3,2,Type.CIRCLE,Colors.GREEN, Direction.NULL);
                fields[3][1] = new Field(1,3,Type.CIRCLE,Colors.BLUE, Direction.NULL);
                fields[3][4] = new Field(4,3,Type.CIRCLE,Colors.RED, Direction.NULL);
                fields[4][4] = new Field(4,4,Type.CIRCLE,Colors.YELLOW, Direction.NULL);
                break;
            case 2: fields[0][0] = new Field(0,0,Type.CIRCLE,Colors.BLUE, Direction.NULL);
                fields[0][3] = new Field(2,0,Type.CIRCLE,Colors.YELLOW, Direction.NULL);
                fields[1][0] = new Field(3,0,Type.CIRCLE,Colors.GREEN, Direction.NULL);
                fields[2][0] = new Field(4,0,Type.CIRCLE,Colors.YELLOW, Direction.NULL);
                fields[2][2] = new Field(3,2,Type.CIRCLE,Colors.GREEN, Direction.NULL);
                fields[2][3] = new Field(1,3,Type.CIRCLE,Colors.BLUE, Direction.NULL);
                fields[3][1] = new Field(4,3,Type.CIRCLE,Colors.RED, Direction.NULL);
                fields[3][3] = new Field(4,4,Type.CIRCLE,Colors.RED, Direction.NULL);
                break;

        }
            return fields;

    }
public void makeMove(int x, int y, Colors color){



        fields[x][y] = new Field(x,y,Type.LINE, color, Direction.NORTH);



}




}
