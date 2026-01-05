import java.util.*;
import java.io.*;

class SudokuSolver {

    public static boolean Solver(int[][] sudoku) {
        for(int i = 0; i < 9; i++) {
            for(int j = 0; j < 9; j++) {
                if(sudoku[i][j] == 0) {
                    for(int num = 1; num <= 9; num++) {
                        if(isPossible(sudoku, num, i, j)) {
                            sudoku[i][j] = num;
                            if(Solver(sudoku)) return true;
                            sudoku[i][j] = 0;
                        }
                    }
                    return false;
                }
            }
        }
        return true;
    }

    public static boolean isPossible(int[][] sudoku, int num, int row, int col) {
        int nr = (row / 3) * 3;
        int nc = (col / 3) * 3;

        for(int i = 0; i < 9; i++) {
            if(sudoku[row][i] == num) return false;
            if(sudoku[i][col] == num) return false;

            int r = nr + (i / 3);
            int c = nc + (i % 3);
            if(sudoku[r][c] == num) return false;
        }
        return true;
    }

    public static void printSudoku(int[][] sudoku) {
        for(int i = 0; i < 9; i++) {
            for(int j = 0; j < 9; j++) {
                System.out.print(sudoku[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        int[][] sudoku = {
                {3,0,6,5,0,8,4,0,0},
                {5,2,0,0,0,0,0,0,0},
                {0,8,7,0,0,0,0,3,1},
                {0,0,3,0,1,0,0,8,0},
                {9,0,0,8,6,3,0,0,5},
                {0,5,0,0,9,0,6,0,0},
                {1,3,0,0,0,0,2,5,0},
                {0,0,0,0,0,0,0,7,4},
                {0,0,5,2,0,6,3,0,0}
        };

        Solver(sudoku);
        printSudoku(sudoku);
    }
}
