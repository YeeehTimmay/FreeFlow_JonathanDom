/**
 * Jonathan Dom 12/13/2020
 */
public class Field {
    private int x;
    private int y;
    private Type type;
    private Colors color;
    //make a field with x coordinate, y coordinate, a field type and a color.
    public Field(int x, int y, Type type, Colors color) {
        if (x >= 0 && y >= 0) {
            this.x = x;
            this.y = y;
            this.type = type;
            this.color = color;
        } else {
            throw new IllegalArgumentException();
        }
    }
    // calls the first constructor with color null.
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

    public void setType(Type type) {
        this.type = type;
    }

    public void setColor(Colors color) {
        this.color = color;
    }
    // checks if there is a color. If so, we show it with the color, otherwise we don't show a color.
    @Override
    public String toString() {
        if (color != null) {
            return color.getColor() + type.getType() + "\033[0m";
        } else {
            return type.getType();
        }
    }

}
