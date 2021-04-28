import Leetcode.Optimization.LargestRectangleInHistogram;
import Leetcode.Optimization.LargestRectangleWithStack;
import Leetcode.Optimization.MaximalRectangle;
import Util.ArrayCreation;
import org.testng.annotations.Test;

public class TestOptimization {
    @Test
    public void testLargestRectangle() {
        int[] input = {2, 1, 5, 6, 5, 2, 3, 3, 3};
        LargestRectangleInHistogram search = new LargestRectangleInHistogram();
        search.bruteFindLargest(input);
    }

    @Test
    public void testLargestRectangleWithStack() {
        int[] input = {2, 1, 5, 6, 5, 2, 3};
        LargestRectangleWithStack search = new LargestRectangleWithStack();
        System.out.println(search.getMaxRectangle(input));
    }

    @Test
    public void testMaxArea() {
        ArrayCreation creation = new ArrayCreation();
        int[][] result = creation.createTwoDimensionalArrayWith01(5, 6);
        display01TwoDimensionalArray(result);
        MaximalRectangle getMax = new MaximalRectangle();
        System.out.println();
        System.out.println( getMax.maximalRectangle(result));

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
