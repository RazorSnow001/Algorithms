import Leetcode.Optimization.LargestRectangleInHistogram;
import Leetcode.Optimization.LargestRectangleWithStack;
import Leetcode.Optimization.MaximalRectangle;
import Leetcode.Optimization.MaximalRectangleTransform;
import Util.ArrayCreation;


public class OptimizationTest {

    public void testLargestRectangle() {
        int[] input = {2, 1, 5, 6, 5, 2, 3, 3, 3};
        LargestRectangleInHistogram search = new LargestRectangleInHistogram();
        search.bruteFindLargest(input);
    }


    public void testLargestRectangleWithStack() {
        int[] input = {2, 1, 5, 6, 5, 2, 3};
        LargestRectangleWithStack search = new LargestRectangleWithStack();
        System.out.println(search.getMaxRectangle(input));
    }


    public void testMaxArea() {
        ArrayCreation creation = new ArrayCreation();
        int[][] result = creation.createTwoDimensionalArrayWith01(5, 6);
        displayTwoDimensionalArray(result);
        System.out.println();
        MaximalRectangle getMax = new MaximalRectangle();
        System.out.println("max is " + getMax.maximalRectangle(result));
    }


    public void testMaxRectangleTransform() {
        ArrayCreation creation = new ArrayCreation();
        int[][] result = creation.createTwoDimensionalArrayWith01(10, 10);
        displayTwoDimensionalArray(result);
        MaximalRectangleTransform transform = new MaximalRectangleTransform();
        int max = transform.findMax(result);
        System.out.println();
        System.out.println(max);
    }


    public void testStackFindWith0() {
        int[] input = {1, 0, 0, 2, 2};
        LargestRectangleWithStack search = new LargestRectangleWithStack();
        System.out.println(search.getMaxRectangle(input));
        /* and that is very ok ! */
    }


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
        for (int j : input) {
            System.out.printf("%3d", j);
        }
    }
}
