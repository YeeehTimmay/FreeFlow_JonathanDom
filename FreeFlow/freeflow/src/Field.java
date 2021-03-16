/**
 * Jonathan Dom 12/13/2020
 */
public class Field {
    private int x;
    private int y;
    private Type type;
    private Colors color;

    public Field(int x, int y, Type type, Colors color) {
        this.x = x;
        this.y = y;
        this.type = type;
        this.color = color;
    }

    public Field(int x, int y, Type type) {
        this(x, y, type, null);
    }

    public Colors getColor() {
        return color;
    }

    public Type getType() {
        return type;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
}
