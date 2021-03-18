/**
 * Jonathan Dom 12/13/2020
 */
public class Board {
    private int size;
    private Field[][] raster;

    // create a board.
    public Board(int size) {
        createRaster(size);
        this.size = size;
    }

    // creates a raster with a double array. The size of the array is the same as
    // the size of your board, and it is filled with Empty fields.
    private void createRaster(int size) {
        if (size > 0) {
            raster = new Field[size][size];
            for (int i = 0; i < size; i++) {
                for (int j = 0; j < size; j++) {
                    raster[i][j] = new Field(j, i, Type.EMPTY);
                }
            }
        } else {
            throw new IllegalArgumentException();
        }
    }

    // calls on a field and checks if it is within the board bounds. Else throws an
    // error.
    public Field getField(int x, int y) {
        if (checkValidField(x, y)) {
            return raster[y][x];
        } else {
            throw new IllegalArgumentException();
        }
    }

    public Field[][] getRaster() {
        return raster;
    }

    public int getSize() {
        return size;
    }

    // If the field is valid, you give that field a type and a color.
    public void setField(int x, int y, Type type, Colors color) {
        if (checkValidField(x, y)) {
            raster[y][x].setColor(color);
            raster[y][x].setType(type);
        } else {
            throw new IllegalArgumentException();
        }
    }

    // checks if the field is in bounds.
    public boolean checkValidField(int x, int y) {
        return (x >= 0 && x < size) && (y >= 0 && y < size);
    }

    // checks if there are empty fields still on the board. Returns true if there
    // are, false if the board is full.
    public boolean checkForEmptyFields() {
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (raster[i][j].getType() == Type.EMPTY)
                    return true;
            }
        }
        return false;
    }

    // clears a field by turning it empty.
    public void clearField(int x, int y) {
        if (checkValidField(x, y)) {
            raster[y][x] = new Field(x, y, Type.EMPTY);
        } else {
            throw new IllegalArgumentException();
        }
    }

    // clears the entire board.
    public void clearBoard() {
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                raster[i][j] = new Field(j, i, Type.EMPTY);
            }
        }
    }

    // creates the raster with strings.
    private String createRasterString() {
        String rasterString = "";
        String line = "";
        for (int i = 0; i < size; i++) {
            line += "------";
        }
        line += "-";
        for (int i = 0; i < size; i++) {
            rasterString += "|";
            for (int j = 0; j < size; j++) {
                rasterString += "  " + raster[i][j] + "  |";
            }
            rasterString += "\n" + line + "\n";
        }
        return line + "\n" + rasterString;
    }

    // shows the raster.
    @Override
    public String toString() {
        return createRasterString();
    }
}
