import RecursionRelated.Recursion.QuickSort;
import Util.ArrayCreation;
import org.testng.annotations.Test;

public class TestQuickSort {
    @Test
    public void test() {
        ArrayCreation creation = new ArrayCreation();
        int[] input = creation.create(10, 10);
        creation.displayArray(input);
        QuickSort sort = new QuickSort();
        sort.quickSort(input, 0, input.length - 1);
        System.out.println();
        creation.displayArray(input);
    }
}
