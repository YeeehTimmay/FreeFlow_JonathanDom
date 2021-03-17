/**
 * Jonathan Dom 12/13/2020
 */
public class Board {
    private int size;
    private Field[][] raster;

    public Board(int size) {
        createRaster(size);
        this.size = size;
    }

    private void createRaster(int size) {
        if (size > 0) {
            raster = new Field[size][size];
            for (int i = 0; i < size; i++) {
                for (int j = 0; j < size; j++) {
                    raster[i][j] = new Field(i, j, Type.EMPTY);
                }
            }
        } else {
            throw new IllegalArgumentException();
        }
    }

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

    public void setField(int x, int y, Type type, Colors color) {
        if (checkValidField(x, y)) {
            raster[x][y].setColor(color);
            raster[x][y].setType(type);
        } else {
            throw new IllegalArgumentException();
        }
    }

    public boolean checkValidField(int x, int y) {
        if ((x >= 0 && x < size) && (y >= 0 && y < size)) {
            return true;
        }
        return false;
    }

    public boolean checkForEmptyFields() {
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (raster[i][j].getType() == Type.EMPTY)
                    return true;
            }
        }
        return false;
    }

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

    @Override
    public String toString() {
        return createRasterString();
    }
}
