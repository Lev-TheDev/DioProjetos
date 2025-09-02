import br.com.dio.model.Board;
import br.com.dio.model.Space;
import br.com.dio.util.BoardTemplate;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static br.com.dio.util.BoardTemplate.BOARD_TEMPLATE;
import static java.util.Objects.isNull;
import static java.util.Objects.nonNull;

public class Main {

    private static Board board;
    private final static Scanner scanner = new Scanner(System.in);
    private final static int BOARD_LIMIT = 9;

    public static void main(String[] args) {
        final var positions = Stream.of(args)
                .collect(Collectors.toMap(
                        k -> k.split(";")[0],
                        v -> v.split(";")[1]
                ));
        var option = -1;
        while (true) {
            System.out.println("Select an option:");
            System.out.println("1 - Start new game");
            System.out.println("2 - Place a new number");
            System.out.println("3 - Remove a number");
            System.out.println("4 - Show board");
            System.out.println("5 - Show status of the game");
            System.out.println("6 - Clear board");
            System.out.println("7 - Finish game");
            System.out.println("8 - Exit");
            option = scanner.nextInt();

            switch (option){
                case 1 -> startGame(positions);
                case 2 -> placeNumber();
                case 3 -> removeNumber();
                case 4 -> printBoard();
                case 5 -> showGameStatus();
                case 6 -> clearBoard();
                case 7 -> finishGame();
                case 8 -> {
                    System.out.println("Exiting the game. Goodbye!");
                    System.exit(0);
                }
                default -> System.out.println("Invalid option. Please try again.");
            }
        }
    }


    private static void startGame(Map<String, String> positions) {
        if (nonNull(board)) {
            System.out.println("A game is already in progress. Please finish it before starting a new one.");
            return;
        }
        List<List<Space>> spaces = new ArrayList<>();
        for (int i = 0; i < BOARD_LIMIT; i++) {
            spaces.add(new ArrayList<>());
            for (int j = 0; j < BOARD_LIMIT; j++) {
                var positionConfig = positions.get("%s,%s".formatted(i, j));
                var expected = Integer.parseInt(positionConfig.split(",")[0]);
                var fixed = Boolean.parseBoolean(positionConfig.split(",")[1]);
                var currentSpace = new Space(expected, fixed);
                spaces.get(i).add(currentSpace);
            }
        }
        board = new Board(spaces);
        System.out.println("Game initialized with provided positions.");
    }

    private static void placeNumber() {
        if (isNull(board)) {
            System.out.println("No game in progress. Please start a new game first.");
            return;
        }
        System.out.println("Enter the column to place number:");
        int column = runUntilGetValidInput(0, 8);
        System.out.println("Enter the row to place number:");
        int row = runUntilGetValidInput(0, 8);
        System.out.printf("Enter a number (1-9) to place in position [%s,%s]\n", column, row);
        var number = runUntilGetValidInput(1, 9);
        if (!board.changeValue(column, row, number)) {
            System.out.println("Failed to change number. Position may be fixed or invalid.");
        }
        System.out.println("Number placed successfully!");
    }

    private static void removeNumber() {
        if (isNull(board)) {
            System.out.println("No game in progress. Please start a new game first.");
            return;
        }
        System.out.println("Enter the column to remove number:");
        int column = runUntilGetValidInput(0, 8);
        System.out.println("Enter the row to remove number:");
        int row = runUntilGetValidInput(0, 8);
        if (!board.clearValue(column, row)) {
            System.out.println("Failed to remove number. Position may be fixed or invalid.");
        }
        System.out.println("Number removed successfully!");
    }

    private static void printBoard() {
        if (isNull(board)) {
            System.out.println("No game in progress. Please start a new game first.");
            return;
        }
        var args = new Object[81];
        var argPos = 0;
        for (int i = 0; i < BOARD_LIMIT; i++) {
            for (var column: board.getSpaces()) {
                args[argPos++] = "  " + ((isNull(column.get(i).getActual())) ? "  " : column.get(i).getActual());
            }
        }
        System.out.println("Current Board:");
        System.out.printf((BOARD_TEMPLATE) + "\n", args);
    }

    private static void showGameStatus() {
        if (isNull(board)) {
            System.out.println("No game in progress. Please start a new game first.");
            return;
        }
        if (board.gameIsFinished()) {
            System.out.println("Congratulations! You've completed the board successfully!");
            board = null;
        } else {
            System.out.println("At this moment, the game is: " + board.getStatus().getLabel());
            if (board.hasErrors()) {
                System.out.println("There are errors in the current board.");
            } else {
                System.out.println("No errors detected in the current board.");
            }
        }
    }

    private static void clearBoard() {
        if (isNull(board)) {
            System.out.println("No game in progress. Please start a new game first.");
            return;
        }
        System.out.println("Are you sure you want to clear the board? (Y/N)");
        var confirmation = scanner.next();
        while (!confirmation.equalsIgnoreCase("Y") && !confirmation.equalsIgnoreCase("N")) {
            System.out.println("Please enter 'Y' to confirm or 'N' to cancel:");
            confirmation = scanner.next();
        }
        if (confirmation.equalsIgnoreCase("N")) {
            System.out.println("Clear board operation cancelled.");
            return;
        }
        board.reset();
        System.out.println("Board cleared successfully!");
    }

    private static void finishGame() {
        if (isNull(board)) {
            System.out.println("No game in progress. Please start a new game first.");
            return;
        }
        System.out.println("Are you sure you want to finish the game? (Y/N)");
        var confirmation = scanner.next();
        while (!confirmation.equalsIgnoreCase("Y") && !confirmation.equalsIgnoreCase("N")) {
            System.out.println("Please enter 'Y' to confirm or 'N' to cancel:");
            confirmation = scanner.next();
        }
        if (confirmation.equalsIgnoreCase("N")) {
            System.out.println("Finish game operation cancelled.");
            return;
        }

        if (board.gameIsFinished()) {
            System.out.println("Congratulations! You've completed the board successfully!");
            printBoard();
            board = null;
        } else if (board.hasErrors()) {
            System.out.println("Cannot finish the game. There are errors in the current board.");
        } else {
            System.out.println("Game is incomplete. You forgot to fill one or more spaces. Cannot finish the game yet.");
        }
    }

    private static int runUntilGetValidInput(final int min, final int max) {
        int input = scanner.nextInt();
        while (input < min || input > max) {
            System.out.printf("Enter a number between %d and %d: ", min, max);
            input = scanner.nextInt();
        }
        return input;
    }
}