/**
 * Jonathan Dom 12/13/2020
 */
public enum Colors {
    //These are all the possible colors that can be used.
    RED("\033[0;31m"), GREEN("\033[0;32m"), YELLOW("\033[0;33m"), BLUE("\033[0;34m"), PURPLE("\033[0;35m"), CYAN("\033[0;36m"), WHITE("\033[0;37m");

    private String color;

    Colors(String color) {
        this.color = color;
    }

    public String getColor() {
        return color;
    }

}