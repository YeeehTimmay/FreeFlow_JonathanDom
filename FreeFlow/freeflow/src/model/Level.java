package model;

import java.util.Scanner;

/**
 * Jonathan Dom 12/13/2020
 */
public class Level {
    private Board board;
    private int moves = 0;
    private int maxColors;
    private int completedColor = 0;

    // creates a level with the size you enter.
    public Level(LevelSizes size) {
        createLevel(size);

    }

    // shows the board in the console.
    public void showBoard() {
        System.out.println(board);
    }

    public Board getBoard() {
        return board;
    }

    public int getMoves() {
        return moves;
    }

    public int getCompletedColor() {
        return completedColor;
    }

    // this creates the level with the size that you enter. This also gives you a
    // random level in that size category. In this instance, there are two different
    // levels per category.
    private void createLevel(LevelSizes size) {
        board = new Board(size.getLevelSize());
        switch (size) {
            case size5:
                createLevel5(getRandomNumber(1, 2));
                break;
            case size6:
                createLevel6(getRandomNumber(1, 2));
                break;
            case size7:
                createLevel7(getRandomNumber(1, 2));
                break;
        }

    }

    // This checks if you have completed the board correctly, using the correct
    // colors.
    public boolean checkIfWon() {
        return !board.checkForEmptyFields() && completedColor >= maxColors;
    }

    // This is how you make a move on the board using x and y coordinates as well as
    // the direction you choose to go to.
    // This checks the previous fields that you come from and gets the correct color
    // from that as well.
    public void makeMove() {
        try {
            Scanner scanner = new Scanner(System.in);
            System.out.print("Make a move ( x y direction (n, e, s, w)): ");
            int moveX = scanner.nextInt();
            int moveY = scanner.nextInt();
            if (!(board.checkValidField(moveX, moveY)))
                throw new IllegalArgumentException();
            Direction direction = getDirection(scanner.next().charAt(0), moveX, moveY);
            checkNextField(moveX, moveY, direction);
            switch (direction) {
                case NORTH:
                    board.setField(moveX, moveY - 1, getMoveType(moveX, moveY, direction),
                            board.getField(moveX, moveY).getColor());
                    break;
                case EAST:
                    board.setField(moveX + 1, moveY, getMoveType(moveX, moveY, direction),
                            board.getField(moveX, moveY).getColor());
                    break;
                case SOUTH:
                    board.setField(moveX, moveY + 1, getMoveType(moveX, moveY, direction),
                            board.getField(moveX, moveY).getColor());
                    break;
                case WEST:
                    board.setField(moveX - 1, moveY, getMoveType(moveX, moveY, direction),
                            board.getField(moveX, moveY).getColor());
                    break;
            }
            moves += 1;
        } catch (Exception e) {
            showBoard();
            makeMove();
        }
    }

    // This checks what type the next field should be based on what direction you
    // come from, and will turn a previous field into a corner if necessary.
    // This will also add to a counter that checks if a color is completed.
    private Type getMoveType(int x, int y, Direction direction) {
        switch (direction) {
            case NORTH:
                return checkType(x, y, x, y - 1, Type.VERTICAL);
            case EAST:
                return checkType(x, y, x + 1, y, Type.HORIZONTAL);
            case SOUTH:
                return checkType(x, y, x, y + 1, Type.VERTICAL);
            case WEST:
                return checkType(x, y, x - 1, y, Type.HORIZONTAL);
            default:
                return null;
        }
    }

    private Type checkType(int xStart, int yStart, int xStop, int yStop, Type direction) {
        Field startField = board.getField(xStart, yStart);
        Field stopField = board.getField(xStop, yStop);
        if (stopField.getType() == Type.CIRCLE) {
            if (startField.getColor() == stopField.getColor()) {
                if (startField.getType() != direction)
                    startField.setType(Type.CORNER);
                if (startField.getColor() == stopField.getColor())
                    completedColor += 1;
                return Type.CIRCLE;
            }
        } else if (stopField.getType() == Type.EMPTY) {
            if (startField.getType() != direction && startField.getType() != Type.CIRCLE)
                startField.setType(Type.CORNER);
            if (stopField.getX() == 0 && stopField.getY() == 0)
                return Type.CORNER;
            else if (stopField.getX() == board.getSize() - 1 && stopField.getY() == 0)
                return Type.CORNER;
            else if (stopField.getX() == 0 && stopField.getY() == board.getSize() - 1)
                return Type.CORNER;
            else if (stopField.getX() == board.getSize() - 1 && stopField.getY() == board.getSize() - 1)
                return Type.CORNER;
            else
                return direction;
        }
        return null;
    }

    // this turns your input into a direction to be used.
    private Direction getDirection(char charAt, int x, int y) {
        switch (Character.toLowerCase(charAt)) {
            case 'n':
                return Direction.NORTH;
            case 'e':
                return Direction.EAST;
            case 's':
                return Direction.SOUTH;
            case 'w':
                return Direction.WEST;
            default:
                if (board.getField(x, y).getType() != Type.CIRCLE)
                    board.clearField(x, y);
                throw new IllegalArgumentException();
        }
    }

    // This checks if the next field is a circle and if it is not empty. If it is a
    // circle or it is not empty, it throws an error.
    // It also checks if the line and the circle are the same color.
    private void checkNextField(int x, int y, Direction direction) {
        Field startField = board.getField(x, y);
        Field stopField = null;
        switch (direction) {
            case NORTH:
                stopField = board.getField(x, y - 1);
                break;
            case EAST:
                stopField = board.getField(x + 1, y);
                break;
            case SOUTH:
                stopField = board.getField(x, y + 1);
                break;
            case WEST:
                stopField = board.getField(x - 1, y);
                break;
        }
        if (stopField.getType() == Type.CIRCLE) {
            if (startField.getColor() != stopField.getColor())
                throw new IllegalArgumentException();
        } else if (stopField.getType() != Type.EMPTY)
            throw new IllegalArgumentException();
    }

    // This creates a "random" level based on the integer that was randomly
    // generated. This also sets the maximum colors for that specific level.
    private void createLevel5(int level) {
        switch (level) {
            case 1:
                maxColors = 5;
                board.setField(0, 0, Type.CIRCLE, Colors.RED);
                board.setField(1, 4, Type.CIRCLE, Colors.RED);
                board.setField(2, 0, Type.CIRCLE, Colors.GREEN);
                board.setField(1, 3, Type.CIRCLE, Colors.GREEN);
                board.setField(2, 1, Type.CIRCLE, Colors.BLUE);
                board.setField(2, 4, Type.CIRCLE, Colors.BLUE);
                board.setField(4, 0, Type.CIRCLE, Colors.YELLOW);
                board.setField(3, 3, Type.CIRCLE, Colors.YELLOW);
                board.setField(4, 1, Type.CIRCLE, Colors.PURPLE);
                board.setField(3, 4, Type.CIRCLE, Colors.PURPLE);
                break;
            case 2:
                maxColors = 4;
                board.setField(0, 4, Type.CIRCLE, Colors.RED);
                board.setField(2, 3, Type.CIRCLE, Colors.RED);
                board.setField(2, 2, Type.CIRCLE, Colors.GREEN);
                board.setField(1, 3, Type.CIRCLE, Colors.GREEN);
                board.setField(0, 3, Type.CIRCLE, Colors.BLUE);
                board.setField(4, 4, Type.CIRCLE, Colors.BLUE);
                board.setField(0, 0, Type.CIRCLE, Colors.YELLOW);
                board.setField(4, 3, Type.CIRCLE, Colors.YELLOW);
                break;
            default:
                throw new IllegalArgumentException();
        }
    }

    private void createLevel6(int level) {
        switch (level) {
            case 1:
                maxColors = 6;
                board.setField(4, 0, Type.CIRCLE, Colors.RED);
                board.setField(2, 3, Type.CIRCLE, Colors.RED);
                board.setField(0, 0, Type.CIRCLE, Colors.GREEN);
                board.setField(0, 4, Type.CIRCLE, Colors.GREEN);
                board.setField(0, 5, Type.CIRCLE, Colors.BLUE);
                board.setField(2, 5, Type.CIRCLE, Colors.BLUE);
                board.setField(1, 0, Type.CIRCLE, Colors.YELLOW);
                board.setField(0, 5, Type.CIRCLE, Colors.YELLOW);
                board.setField(4, 1, Type.CIRCLE, Colors.PURPLE);
                board.setField(2, 4, Type.CIRCLE, Colors.PURPLE);
                board.setField(2, 0, Type.CIRCLE, Colors.CYAN);
                board.setField(2, 2, Type.CIRCLE, Colors.CYAN);
                break;
            case 2:
                maxColors = 6;
                board.setField(3, 2, Type.CIRCLE, Colors.RED);
                board.setField(1, 4, Type.CIRCLE, Colors.RED);
                board.setField(5, 0, Type.CIRCLE, Colors.GREEN);
                board.setField(5, 2, Type.CIRCLE, Colors.GREEN);
                board.setField(2, 0, Type.CIRCLE, Colors.BLUE);
                board.setField(5, 3, Type.CIRCLE, Colors.BLUE);
                board.setField(2, 2, Type.CIRCLE, Colors.YELLOW);
                board.setField(2, 4, Type.CIRCLE, Colors.YELLOW);
                board.setField(1, 0, Type.CIRCLE, Colors.PURPLE);
                board.setField(5, 4, Type.CIRCLE, Colors.PURPLE);
                board.setField(3, 3, Type.CIRCLE, Colors.CYAN);
                board.setField(4, 4, Type.CIRCLE, Colors.CYAN);
                break;
            default:
                throw new IllegalArgumentException();
        }
    }

    private void createLevel7(int level) {
        switch (level) {
            case 1:
                maxColors = 6;
                board.setField(6, 1, Type.CIRCLE, Colors.RED);
                board.setField(4, 5, Type.CIRCLE, Colors.RED);
                board.setField(3, 3, Type.CIRCLE, Colors.GREEN);
                board.setField(2, 4, Type.CIRCLE, Colors.GREEN);
                board.setField(6, 0, Type.CIRCLE, Colors.BLUE);
                board.setField(5, 6, Type.CIRCLE, Colors.BLUE);
                board.setField(4, 4, Type.CIRCLE, Colors.YELLOW);
                board.setField(5, 5, Type.CIRCLE, Colors.YELLOW);
                board.setField(1, 2, Type.CIRCLE, Colors.PURPLE);
                board.setField(5, 1, Type.CIRCLE, Colors.PURPLE);
                board.setField(4, 3, Type.CIRCLE, Colors.CYAN);
                board.setField(6, 6, Type.CIRCLE, Colors.CYAN);
                break;
            case 2:
                maxColors = 7;
                board.setField(2, 0, Type.CIRCLE, Colors.RED);
                board.setField(3, 6, Type.CIRCLE, Colors.RED);
                board.setField(2, 2, Type.CIRCLE, Colors.GREEN);
                board.setField(5, 3, Type.CIRCLE, Colors.GREEN);
                board.setField(3, 1, Type.CIRCLE, Colors.BLUE);
                board.setField(5, 1, Type.CIRCLE, Colors.BLUE);
                board.setField(3, 3, Type.CIRCLE, Colors.YELLOW);
                board.setField(4, 4, Type.CIRCLE, Colors.YELLOW);
                board.setField(2, 1, Type.CIRCLE, Colors.PURPLE);
                board.setField(2, 5, Type.CIRCLE, Colors.PURPLE);
                board.setField(2, 3, Type.CIRCLE, Colors.CYAN);
                board.setField(5, 4, Type.CIRCLE, Colors.CYAN);
                board.setField(1, 0, Type.CIRCLE, Colors.WHITE);
                board.setField(2, 6, Type.CIRCLE, Colors.WHITE);
                break;
            default:
                throw new IllegalArgumentException();

        }
    }

    // this returns a random integer to be used for "random" level choices.
    private int getRandomNumber(int min, int max) {
        return (int) (Math.random() * (max - min + 1) + min);
    }

}
