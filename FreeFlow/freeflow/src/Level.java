import java.util.Scanner;

/**
 * Jonathan Dom 12/13/2020
 */
public class Level {
    private Board board;
    private int moves = 0;
    private int maxColors;
    private int completedColor = 0;

    public Level(LevelSizes size) {
        createLevel(size);

    }

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

    public boolean checkIfWon() {
        return !board.checkForEmptyFields() && completedColor >= maxColors;
    }

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

    private Type getMoveType(int x, int y, Direction direction) {
        switch (direction) {
        case NORTH:
            y -= 1;
            if ((x == 0 || x == board.getSize() - 1) && y == 0)
                return Type.CORNER;
            else if (board.getField(x, y).getType() == Type.CIRCLE) {
                if (board.getField(x, y + 1).getColor() == board.getField(x, y).getColor()) {
                    if (board.getField(x, y + 1).getType() != Type.VERTICAL)
                        board.setField(x, y + 1, Type.CORNER, board.getField(x, y + 1).getColor());
                    completedColor += 1;
                }
                return Type.CIRCLE;
            } else if (board.getField(x, y + 1).getType() != Type.VERTICAL) {
                if (board.getField(x, y + 1).getType() != Type.CIRCLE)
                    board.setField(x, y + 1, Type.CORNER, board.getField(x, y + 1).getColor());
            }
            return Type.VERTICAL;
        case EAST:
            x += 1;
            if ((y == 0 || y == board.getSize() - 1) && x == board.getSize() - 1)
                return Type.CORNER;
            else if (board.getField(x, y).getType() == Type.CIRCLE) {
                if (board.getField(x - 1, y).getColor() == board.getField(x, y).getColor()) {
                    if (board.getField(x - 1, y).getType() != Type.HORIZONTAL)
                        board.setField(x - 1, y, Type.CORNER, board.getField(x - 1, y).getColor());
                    completedColor += 1;
                }
                return Type.CIRCLE;
            } else if (board.getField(x - 1, y).getType() != Type.HORIZONTAL) {
                if (board.getField(x - 1, y).getType() != Type.CIRCLE)
                    board.setField(x - 1, y, Type.CORNER, board.getField(x - 1, y).getColor());
            }
            return Type.HORIZONTAL;
        case SOUTH:
            y += 1;
            if ((x == 0 || x == board.getSize() - 1) && y == board.getSize() - 1)
                return Type.CORNER;
            else if (board.getField(x, y).getType() == Type.CIRCLE) {
                if (board.getField(x, y - 1).getColor() == board.getField(x, y).getColor()) {
                    if (board.getField(x, y - 1).getType() != Type.VERTICAL)
                        board.setField(x, y - 1, Type.CORNER, board.getField(x, y - 1).getColor());
                    completedColor += 1;
                }
                return Type.CIRCLE;
            } else if (board.getField(x, y - 1).getType() != Type.VERTICAL) {
                if (board.getField(x, y - 1).getType() != Type.CIRCLE)
                    board.setField(x, y - 1, Type.CORNER, board.getField(x, y - 1).getColor());
            }
            return Type.VERTICAL;
        case WEST:
            x -= 1;
            if ((y == 0 || y == board.getSize() - 1) && x == 0)
                return Type.CORNER;
            else if (board.getField(x, y).getType() == Type.CIRCLE) {
                if (board.getField(x + 1, y).getColor() == board.getField(x, y).getColor()) {
                    if (board.getField(x + 1, y).getType() != Type.HORIZONTAL)
                        board.setField(x + 1, y, Type.CORNER, board.getField(x + 1, y).getColor());
                    completedColor += 1;
                }
                return Type.CIRCLE;
            } else if (board.getField(x + 1, y).getType() != Type.HORIZONTAL) {
                if (board.getField(x + 1, y).getType() != Type.CIRCLE)
                    board.setField(x + 1, y, Type.CORNER, board.getField(x + 1, y).getColor());
            }
            return Type.HORIZONTAL;
        default:
            return null;
        }
    }

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

    private int getRandomNumber(int min, int max) {
        return (int) (Math.random() * (max - min + 1) + min);
    }

}
