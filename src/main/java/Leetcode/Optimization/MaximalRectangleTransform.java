package Leetcode.Optimization;

/**
 * with different set standard
 * we can now transfer the 0085 problem  into the 0084 problem
 * so
 */
public class MaximalRectangleTransform {
    public int findMax(int[][] input) {
        int column = input[0].length;
        int row = input.length;
        int[][] recordContinuity = new int[row][column];
        for (int i = 0; i < column; i++) {
            for (int j = 0; j < row; j++) {
                if (input[j][i] != 0) {
                    recordContinuity[j][i] = (j == 0 ? 0 : recordContinuity[j - 1][i]) + 1;
                }
            }
        }
        System.out.println();
        displayTwoDimensionalArray(recordContinuity);
        int maxArea = 0;
        LargestRectangleWithStack findMax = new LargestRectangleWithStack();
        for (int i = 0; i < row; i++) {
            int currentLayerMax = findMax.getMaxRectangle(recordContinuity[i]);
            if (currentLayerMax > maxArea) {
                maxArea = currentLayerMax;
            }
        }
        return maxArea;
    }

    private void displayTwoDimensionalArray(int[][] matrix) {
        for (int[] ints : matrix) {
            for (int j = 0; j < matrix[0].length; j++) {
                System.out.printf("%3d", ints[j]);
            }
            System.out.println();
        }
    }

}
