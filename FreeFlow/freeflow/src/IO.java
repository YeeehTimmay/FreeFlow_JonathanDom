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

    public int promptForInt(String prompt) {
        try {
            System.out.print(prompt + ": ");
            int res = Integer.parseInt(in.nextLine());
            return res;
        } catch (Exception e) {
            return promptForInt(prompt);
        }
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
        switch (promptForInt("Choose 5, 6 or 7 for the level size")) {
        case 5:
            return LevelSizes.size5;
        case 6:
            return LevelSizes.size6;
        case 7:
            return LevelSizes.size7;
        default:
            return promptForLevelSize();
        }
    }
}