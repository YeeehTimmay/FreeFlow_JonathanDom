package model;

/**
 * Jonathan Dom 1/10/2021
 */
public enum Direction {
    // These are the directions that can be used to move around in the board.
    NORTH("North"), WEST("West"), SOUTH("South"), EAST("East");

    private String direction;

    private Direction(String direction) {
        this.direction = direction;
    }
}
