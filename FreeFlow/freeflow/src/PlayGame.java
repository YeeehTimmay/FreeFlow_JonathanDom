/**
 * Jonathan Dom 1/6/2021
 */
public class PlayGame {
    public static void main(String[] args) {
        IO io = new IO();
        Player player = new Player("A");
        Level level = new Level(LevelSizes.size5);
        io.show(Integer.toString(io.promptForInt("int")));
    }

}
