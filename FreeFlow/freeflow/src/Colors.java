/**
 * Jonathan Dom 12/13/2020
 */
public enum Colors {
    RED("R"), GREEN("G"), YELLOW("Y"), BLUE("B");

    private String color;

    Colors(String color) {
        this.color = color;
    }

    public String getColor() {
        return color;
    }

}
