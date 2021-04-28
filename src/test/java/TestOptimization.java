import Leetcode.Optimization.LargestRectangleInHistogram;
import Leetcode.Optimization.LargestRectangleWithStack;
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
}
