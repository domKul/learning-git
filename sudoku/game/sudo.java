import java.util.Scanner;

public class Sudoku {
    private int[][] board;

    public Sudoku() {
        this.board = new int[9][9];
    }

    public void setBoard(int[][] board) {
        this.board = board;
    }

    public void printBoard() {
        for (int i = 0; i < 9; i++) {
            if (i % 3 == 0 && i != 0) {
                System.out.println("---------------------");
            }
            for (int j = 0; j < 9; j++) {
                if (j % 3 == 0 && j != 0) {
                    System.out.print("| ");
                }
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
    }

    public boolean isValid(int row, int col, int num) {
        // sprawdzamy czy wiersz nie zawiera już danej liczby
        for (int i = 0; i < 9; i++) {
            if (board[row][i] == num) {
                return false;
            }
        }

        // sprawdzamy czy kolumna nie zawiera już danej liczby
        for (int i = 0; i < 9; i++) {
            if (board[i][col] == num) {
                return false;
            }
        }

        // sprawdzamy czy mała plansza 3x3 nie zawiera już danej liczby
        int boxRow = row - row % 3;
        int boxCol = col - col % 3;
        for (int i = boxRow; i < boxRow + 3; i++) {
            for (int j = boxCol; j < boxCol + 3; j++) {
                if (board[i][j] == num) {
                    return false;
                }
            }
        }

        return true;
    }

    public boolean solve() {
        for (int row = 0; row < 9; row++) {
            for (int col = 0; col < 9; col++) {
                if (board[row][col] == 0) {
                    for (int num = 1; num <= 9; num++) {
                        if (isValid(row, col, num)) {
                            board[row][col] = num;
                            if (solve()) {
                                return true;
                            } else {
                                board[row][col] = 0;
                            }
                        }
                    }
                    return false;
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Sudoku game = new Sudoku();

        System.out.println("Podaj planszę Sudoku: ");
        int[][] board = new int[9][9];
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                board[i][j] = scanner.nextInt();
            }
        }

        game.setBoard(board);
        System.out.println("Plansza Sudoku:");
        game.printBoard();

        if (game.solve()) {
            System.out.println("Rozwiązanie Sudoku:");
            game.printBoard();
        } else {
            System.out.println("Nie znaleziono rozwiązania.");
        }
    }
}




