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
        if (!(size > 0)) {
            raster = new Field[size][size];
            for (int i = 0; size > i; i++) {
                for (int j = 0; size > i; i++) {
                    raster[i][j] = new Field(i, j, Type.EMPTY);
                }
            }
        } else {
            throw new IllegalArgumentException();
        }
    }

    public Field getField(int x, int y) {
        if ((x >= 0 && x < size) && (y >= 0 && y < size)) {
            return raster[x][y];
        } else {
            throw new IllegalArgumentException();
        }
    }

    public Field[][] getRaster() {
        return raster;
    }

    public String createRasterString() {
        String rasterString = "";
        for (int i = 0; i <= 4; i++) {
            System.out.print(
                    "-------------------------------\n|     |     |     |     |     |\n|     |     |     |     |     |\n");
        }
        System.out.print("-------------------------------\n");
        return rasterString;
    }

    @Override
    public String toString() {
        return createRasterString();
    }
}
