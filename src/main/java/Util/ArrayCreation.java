package Util;

import java.util.Random;

public class ArrayCreation {
    public ArrayCreation() {

    }

    public int[] create(int length,int bound) {
        Random random = new Random();
        int[] array = new int[length];
        for (int i = 0; i < length; i++) {
            array[i] = random.nextInt(bound);
        }
        return array;
    }

    public int[][] createTwoDimensionalArrayWith01(int row, int column) {
        int[][] matrix = new int[row][column];
        Random random = new Random();
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {
                matrix[i][j] = random.nextInt(20) > 10 ? 1 : 0;
            }
        }
        return matrix;
    }

    public void displayArray(int[] input) {
        for (int j : input) {
            System.out.printf("%3d", j);
        }
    }
}
