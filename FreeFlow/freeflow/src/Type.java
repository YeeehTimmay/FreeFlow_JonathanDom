/**
 * Jonathan Dom 1/6/2021
 */
public enum Type {
    EMPTY(" "), CIRCLE("*"), VERTICAL("|"), HORIZONTAL("-");

    private String type;

    private Type(String type) {
        this.type = type;

    }

    public String getType() {
        return type;
    }
}
