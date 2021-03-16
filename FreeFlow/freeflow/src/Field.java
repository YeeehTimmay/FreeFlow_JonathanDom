/**
 * Jonathan Dom 12/13/2020
 */
public class Field {
    private int x;
    private int y;
    private Type type;
    private Colors color;

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

    @Override
    public String toString() {
        String typeString;
        switch (type.getType()) {
        case "Circle":
            typeString = "*";
            break;
        case "Line":
            typeString = ":";
            break;
        default:
            typeString = " ";
        }
        return color.getColor() + typeString + "\033[0m";
    }

}
