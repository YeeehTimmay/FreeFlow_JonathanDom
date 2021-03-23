package model;

import java.util.Scanner;

public class IO {
    public final static Scanner IN = new Scanner(System.in);

    private IO() {
        // * this is a utility class and cannot be instantiated
    }

    public static void show(String str) {
        System.out.println(str);
    }

    public static String promptForText(String prompt) {
        System.out.print(prompt + ": ");
        return IN.nextLine();
    }

    // prompts you for the next integer in the console.
    public static int promptForInt(String prompt) {
        try {
            System.out.print(prompt + ": ");
            int res = Integer.parseInt(IN.nextLine());
            return res;
        } catch (Exception e) {
            return promptForInt(prompt);
        }
    }

    // prompts you for a yes or a no in the console.
    public static boolean promptForBoolean(String prompt) {
        System.out.print(prompt + " (y/n): ");
        String res = IN.nextLine();
        while (!(res.equalsIgnoreCase("y") || res.equalsIgnoreCase("n"))) {
            System.out.println("(again)" + prompt + " (y/n): ");
            res = IN.nextLine();
        }
        return res.equalsIgnoreCase("y");
    }

    // prompts you for the size of the level in the console.
    public static LevelSizes promptForLevelSize() {
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