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

    public Colors getColor() {
        return color;
    }

    @Override
    public String toString() {
        return "Field [color=" + color + ", type=" + type + ", x=" + x + ", y=" + y + "]";
    }
}
