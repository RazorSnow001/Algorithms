import Leetcode.Optimization.LargestRectangleInHistogram;
import org.testng.annotations.Test;

public class TestOptimization {
    @Test
    public void testLargestRectangle() {
        int[] input = {2, 1, 5, 6, 5, 2, 3, 3, 3, 3, 3, 3};
        LargestRectangleInHistogram search = new LargestRectangleInHistogram();
        search.bruteFindLargest(input);
        System.out.println(" test ssh without ssr ");
    }
}
