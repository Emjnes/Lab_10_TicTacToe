import java.util.Scanner;

public class TicTacToe {
    private static final int ROW = 3;
    private static final int COL = 3;
    private static String[][] board = new String[ROW][COL];
    private static String currentPlayer = "X";

    public static void main(String[] args) {
        clearBoard();
        display();

        Scanner scanner = new Scanner(System.in);

        while (true) {
            int row, col;
            do {
                System.out.println("Player " + currentPlayer + ", enter your move (row and column):");
                row = SafeInput.getRangedInt(scanner, "Enter row (1-3): ", 1, 3);
                col = SafeInput.getRangedInt(scanner, "Enter column (1-3): ", 1, 3);
            } while (!isValidMove(row, col));

            row--;
            col--;

            board[row][col] = currentPlayer;
            display();

            if (isWin(currentPlayer)) {
                System.out.println("Player " + currentPlayer + " wins!");
                break;
            }

            if (isTie()) {
                System.out.println("It's a tie!");
                break;
            }

            togglePlayer();
        }

        scanner.close();
    }

    private static void clearBoard() {
        for (int i = 0; i < ROW; i++) {
            for (int j = 0; j < COL; j++) {
                board[i][j] = " ";
            }
        }
    }

    private static void display() {
        for (int i = 0; i < ROW; i++) {
            for (int j = 0; j < COL; j++) {
                System.out.print(board[i][j]);
                if (j < COL - 1) {
                    System.out.print("|");
                }
            }
            System.out.println();
            if (i < ROW - 1) {
                System.out.println("-----");
            }
        }
    }

    private static boolean isValidMove(int row, int col) {
        if (row < 1 || row > ROW || col < 1 || col > COL) {
            return false;
        }
        row--;
        col--;
        return board[row][col].equals(" ");
    }

    private static boolean isWin(String player) {
        return isRowWin(player) || isColWin(player) || isDiagonalWin(player);
    }

    private static boolean isRowWin(String player) {
        for (int i = 0; i < ROW; i++) {
            if (board[i][0].equals(player) && board[i][1].equals(player) && board[i][2].equals(player)) {
                return true;
            }
        }
        return false;
    }

    private static boolean isColWin(String player) {
        for (int i = 0; i < COL; i++) {
            if (board[0][i].equals(player) && board[1][i].equals(player) && board[2][i].equals(player)) {
                return true;
            }
        }
        return false;
    }

    private static boolean isDiagonalWin(String player) {
        return (board[0][0].equals(player) && board[1][1].equals(player) && board[2][2].equals(player)) ||
                (board[0][2].equals(player) && board[1][1].equals(player) && board[2][0].equals(player));
    }

    private static boolean isTie() {
        for (int i = 0; i < ROW; i++) {
            for (int j = 0; j < COL; j++) {
                if (board[i][j].equals(" ")) {
                    return false;
                }
            }
        }
        return true;
    }

    private static void togglePlayer() {
        currentPlayer = (currentPlayer.equals("X")) ? "O" : "X";
    }
}
