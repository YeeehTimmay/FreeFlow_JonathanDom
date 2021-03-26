package model;

import java.util.*;

/**
 * Jonathan Dom 12/13/2020
 */
public class FreeFlow {
    public static void main(String[] args) {
        Player player = new Player(IO.promptForText("Welcome! Enter your name here"));
        Level level = new Level(IO.promptForLevelSize());
        level.showBoard();
        while (!level.checkIfWon()) {
            System.out.print(player.getName() + ", ");
            level.makeMove();
            level.showBoard();
        }

        System.out.println("You have completed the level. ");
    }

    }


