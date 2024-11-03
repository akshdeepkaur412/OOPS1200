//Name: Akshdeep Kaur
//Student ID: 100958941
//Date: 2-11-2024

import java.util.Random;
import java.util.Scanner;

public class Assignment3 {

    private static final int SIZE = 9;

    // Function to generate a complete Sudoku board
    public static int[][] generateCompleteBoard() {
        int[][] board = new int[SIZE][SIZE];
        fillBoard(board);
        return board;
    }

    // Helper function to check if placing a number is allowed
    private static boolean canPlace(int[][] board, int number, int row, int col) {
        // Validate the row and column
        for (int i = 0; i < SIZE; i++) {
            if (board[row][i] == number || board[i][col] == number) {
                return false;
            }
        }

        // Validate the 3x3 subgrid
        int subGridRow = row - row % 3;
        int subGridCol = col - col % 3;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (board[subGridRow + i][subGridCol + j] == number) {
                    return false;
                }
            }
        }
        return true;
    }

    // Recursive function to populate the board
    private static boolean fillBoard(int[][] board) {
        for (int row = 0; row < SIZE; row++) {
            for (int col = 0; col < SIZE; col++) {
                if (board[row][col] == 0) {
                    for (int number = 1; number <= SIZE; number++) {
                        if (canPlace(board, number, row, col)) {
                            board[row][col] = number;
                            if (fillBoard(board)) {
                                return true;
                            }
                            board[row][col] = 0;
                        }
                    }
                    return false;
                }
            }
        }
        return true;
    }

    // Function to create a puzzle by clearing cells in a completed board
    public static int[][] createPuzzle(int[][] completeBoard) {
        int[][] puzzleBoard = new int[SIZE][SIZE];
        for (int row = 0; row < SIZE; row++) {
            System.arraycopy(completeBoard[row], 0, puzzleBoard[row], 0, SIZE);
        }

        int cellsToErase = 40;  // Adjusted based on desired difficulty
        Random randomGen = new Random();
        while (cellsToErase > 0) {
            int row = randomGen.nextInt(SIZE);
            int col = randomGen.nextInt(SIZE);
            if (puzzleBoard[row][col] != 0) {
                puzzleBoard[row][col] = 0;
                cellsToErase--;
            }
        }
        return puzzleBoard;
    }

    // Function to display the Sudoku board
    public static void displayBoard(int[][] board) {
        for (int row = 0; row < SIZE; row++) {
            for (int col = 0; col < SIZE; col++) {
                System.out.print(board[row][col] == 0 ? ". " : board[row][col] + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        int[][] completeBoard = generateCompleteBoard();
        int[][] puzzleBoard = createPuzzle(completeBoard);
        Scanner input = new Scanner(System.in);

        while (true) {
            System.out.println("\nSudoku Puzzle:");
            displayBoard(puzzleBoard);

            System.out.println("\nOptions:");
            System.out.println("a) Show solution");
            System.out.println("b) Generate a new puzzle");
            System.out.println("c) Exit");

            System.out.print("Select an option: ");
            String choice = input.nextLine().trim().toLowerCase();

            switch (choice) {
                case "a":
                    System.out.println("\nSudoku Solution:");
                    displayBoard(completeBoard);
                    break;
                case "b":
                    completeBoard = generateCompleteBoard();
                    puzzleBoard = createPuzzle(completeBoard);
                    break;
                case "c":
                    System.out.println("Thank you for playing!");
                    input.close();
                    return;
                default:
                    System.out.println("Invalid choice. Please choose again.");
            }
        }
    }
}
