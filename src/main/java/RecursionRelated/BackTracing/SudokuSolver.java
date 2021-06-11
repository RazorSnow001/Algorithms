package RecursionRelated.BackTracing;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.function.Supplier;

public class SudokuSolver {
    List<Set<Integer>> rowLists = new ArrayList<>();
    List<Set<Integer>> columnLists = new ArrayList<>();
    List<List<Set<Integer>>> blockLists = new ArrayList<>();
    int[][] soduku = new int[9][9];
    int assignStep = 0;

    public SudokuSolver() {
        for (int i = 0; i < 9; i++) {
            this.rowLists.add(new HashSet<>());
        }
        for (int i = 0; i < 9; i++) {
            this.columnLists.add(new HashSet<>());
        }
        for (int i = 0; i < 3; i++) {
            blockLists.add(new ArrayList<>());
            for (int j = 0; j < 3; j++) {
                blockLists.get(i).add(new HashSet<>());
            }
        }
    }

    public void getSudoku() {
        if (assignStep == 16) {
            display();
            return;
        }

        for (int row = 0; row < 4; row++) {
            for (int column = 0; column < 4; column++) {
                for (int number = 1; number <= 4; number++) {
                    if (soduku[row][column] == 0 &&
                            !rowLists.get(row).contains(number) &&
                            !columnLists.get(column).contains(number) &&
                            !blockLists.get(row / 2).get(column / 2).contains(number)) {
                        soduku[row][column] = number;
                        rowLists.get(row).add(number);
                        columnLists.get(column).add(number);
                        blockLists.get(row / 2).get(column / 2).add(number);
                        assignStep++;
                        getSudoku();
                        assignStep--;
                        soduku[row][column] = 0;
                        rowLists.get(row).remove(number);
                        columnLists.get(column).remove(number);
                        blockLists.get(row / 2).get(column / 2).remove(number);
                    }
                }
            }
        }
    }

    private void display() {
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                System.out.printf("%3d", soduku[i][j]);
            }
            System.out.println();
        }
        System.out.println();
    }

    public static void main(String[] args) {
        SudokuSolver sudokuSolver = new SudokuSolver();
        sudokuSolver.getSudoku();
    }
}