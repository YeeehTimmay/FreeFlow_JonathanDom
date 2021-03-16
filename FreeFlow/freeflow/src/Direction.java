/**
 * Jonathan Dom 1/10/2021
 */
public enum Direction {
    NORTH("North"), WEST("West"), SOUTH("South"), EAST("East"), NULL("Null");

    private String direction;

    private Direction(String direction) {
        this.direction = direction;
    }
}
