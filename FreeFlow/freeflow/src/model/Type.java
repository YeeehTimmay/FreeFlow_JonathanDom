package model;

/**
 * Jonathan Dom 1/6/2021
 */
public enum Type {
    // These are the types of fields that are used in the game.
    EMPTY(" "), CIRCLE("*"), VERTICAL("|"), HORIZONTAL("-"), CORNER("+");

    private String type;

    private Type(String type) {
        this.type = type;

    }

    public String getType() {
        return type;
    }
}
