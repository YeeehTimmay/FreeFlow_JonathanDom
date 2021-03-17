import java.util.InputMismatchException;
import java.util.Scanner;

public class IO {
    private final Scanner in = new Scanner(System.in);

    public void show(String str) {
        System.out.println(str);
    }

    public String promptForText(String prompt) {
        System.out.print(prompt + ": ");
        return in.nextLine();
    }

    public boolean promptForBoolean(String prompt) {
        System.out.print(prompt + " (y/n): ");
        String res = in.nextLine();
        while (!(res.equalsIgnoreCase("y") || res.equalsIgnoreCase("n"))) {
            System.out.println("(again)" + prompt + " (y/n): ");
            res = in.nextLine();
        }
        return res.equalsIgnoreCase("y");
    }

    public LevelSizes promptForLevelSize() {
        System.out.print("Choose 5, 6 or 7 for the level size: ");
        try {
            int res = Integer.parseInt(in.nextLine());
            if (res > 7 || res < 5) {
                promptForLevelSize();
            }
            else {
                switch (res) {
                    case 5:
                        return LevelSizes.size5;
                    break;
                    case 6:
                        return LevelSizes.size6;
                    break;
                    case 7:
                        return LevelSizes.size7;
                    break;


                }
            }

        } catch (NumberFormatException e) {
            promptForLevelSize();


        }
        return null;
    }
}