package Leetcode.Optimization;

/**
 * give us a two dimensional array with 0 and 1 and we need to find the max rectangle
 */
public class MaximalRectangle {
    /*
     * here we have two methods for solving this problem
     * 1 we can transform this problem into the largestRectangle Problem and use the stack to solve it
     * 2 we can do the 1 record the width of one line, and we can focus on the width and search for the up
     * */
    public int maximalRectangle(int[][] matrix) {
        int[][] recordWidthForRow = new int[matrix.length][matrix[0].length];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] == 1) {
                    recordWidthForRow[i][j] = (j == 0 ? 0 : recordWidthForRow[i][j - 1]) + 1;
                }
            }
        }
        display01TwoDimensionalArray(recordWidthForRow);
        int maxArea = 0;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (recordWidthForRow[i][j] == 0) {
                    continue;
                }
                int maxCommonWidth = recordWidthForRow[i][j];
                for (int k = 0; k <= i; k++) {
                    maxCommonWidth = Math.min(recordWidthForRow[i - k][j], maxCommonWidth);
                    int CurrentArea = maxCommonWidth * (k + 1);
                    if (CurrentArea > maxArea) {
                        maxArea = CurrentArea;
                    }
                }
            }
        }
        return maxArea;
    }

    private void display01TwoDimensionalArray(int[][] matrix) {
        for (int[] ints : matrix) {
            for (int j = 0; j < matrix[0].length; j++) {
                System.out.printf("%3d", ints[j]);
            }
            System.out.println();
        }
    }
}
