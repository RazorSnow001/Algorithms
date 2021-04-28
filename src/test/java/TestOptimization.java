import Leetcode.Optimization.LargestRectangleInHistogram;
import Leetcode.Optimization.LargestRectangleWithStack;
import Leetcode.Optimization.MaximalRectangle;
import Leetcode.Optimization.MaximalRectangleTransform;
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
        displayTwoDimensionalArray(result);
        MaximalRectangle getMax = new MaximalRectangle();
        System.out.println();
        System.out.println(getMax.maximalRectangle(result));

    }

    @Test
    public void testMaxRectangleTransform() {
        ArrayCreation creation = new ArrayCreation();
        int[][] result = creation.createTwoDimensionalArrayWith01(5, 5);
        displayTwoDimensionalArray(result);
        MaximalRectangleTransform transform = new MaximalRectangleTransform();
        int max = transform.findMax(result);
        System.out.println();
        System.out.println(max);
    }

    @Test
    public void testStackFindWith0() {
        int[] input = {1, 0, 0, 2, 2};
        LargestRectangleWithStack search = new LargestRectangleWithStack();
        System.out.println(search.getMaxRectangle(input));
        /* and that is very ok ! */
    }

    @Test
    public void testTwoDimensionalArray() {
        ArrayCreation creation = new ArrayCreation();
        int[][] result = creation.createTwoDimensionalArrayWith01(5, 5);
        displayTwoDimensionalArray(result);
        System.out.println();
        displayArray(result[4]);
    }

    private void displayTwoDimensionalArray(int[][] matrix) {
        for (int[] ints : matrix) {
            for (int j = 0; j < matrix[0].length; j++) {
                System.out.printf("%3d", ints[j]);
            }
            System.out.println();
        }
    }

    private void displayArray(int[] input) {
        for (int i = 0; i < input.length; i++) {
            System.out.printf("%3d", input[i]);
        }
    }
}
