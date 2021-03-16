import java.util.Scanner;

/**
 * Jonathan Dom
 * 12/13/2020
 */
public class Board {
    private int levelNumber;
    private Level level;
    private Field[][] raster;
    Scanner scanner = new Scanner(System.in);



    public Board(Field[][] raster) {
        this.raster = raster;
        createRaster();

    }

    public Board() {

    }

    public Field[][] getRaster() {
        createRaster();
        return raster;
    }

    public void createRaster(){
        raster = new Field[5][5];
    }
    public void LevelSelect(int levelNumber){
        level = new Level();
        level.getLevel(levelNumber);
        showRaster();
    }

    public void showRaster(){
        for (int i = 0; i <= 4; i++) {
            System.out.print("-------------------------------\n|     |     |     |     |     |\n|     |     |     |     |     |\n");
        }
        System.out.print("-------------------------------\n");
    }

    public void makeMove(){
        System.out.println("Give the coordinates and color to make a move.");
        int moveX = scanner.nextInt();
        int moveY = scanner.nextInt();
        char color = scanner.next().charAt(0);


        Colors colorE;
        switch (color){
            case 'R' :  colorE = Colors.RED;break;
            case 'B' :  colorE = Colors.BLUE;break;
            case 'G' :  colorE = Colors.GREEN;break;
            case 'Y' :  colorE = Colors.YELLOW;break;


        }







    }




}
