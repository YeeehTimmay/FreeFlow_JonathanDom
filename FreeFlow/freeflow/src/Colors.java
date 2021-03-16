/**
 * Jonathan Dom 12/13/2020
 */
public enum Colors {
    RED("\033[0;31m"), GREEN("\033[0;32m"), YELLOW("\033[0;33m"), BLUE("\033[0;34m");

    private String color;

    Colors(String color) {
        this.color = color;
    }

    public String getColor() {
        return color;
    }

}