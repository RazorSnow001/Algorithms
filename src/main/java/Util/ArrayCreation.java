package Util;

import java.util.Random;

public class ArrayCreation {
    public ArrayCreation() {

    }

    public int[] create(int length) {
        Random random = new Random();
        int[] array = new int[length];
        for (int i = 0; i < length; i++) {
            array[i] = random.nextInt(10);
        }
        return array;
    }

    public int[][] createTwoDimensionalArrayWith01(int row, int column) {
        int[][] matrix = new int[row][column];
        Random random = new Random();
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {
                matrix[i][j] = random.nextInt(2);
            }
        }
        return matrix;
    }
}
