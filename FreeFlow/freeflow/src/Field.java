/**
 * Jonathan Dom
 * 12/13/2020
 */
public class Field {
    private int x;
    private int y;
    private Type type;
    private Colors color;
    private Direction direction;

    public Field(int x, int y, Type type, Colors color, Direction direction ) {
        this.x = x;
        this.y = y;
        this.type = type;
        this.color = color;
        this.direction = direction;
    }

    public Colors getColor() {
        return color;
    }

    public Direction getDirection() {
        return direction;
    }
}


