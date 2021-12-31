import RecursionRelated.Recursion.QuickSort;
import Util.ArrayCreation;


public class TestQuickSort {

    public void test() {
        ArrayCreation creation = new ArrayCreation();
        int[] input = creation.create(20, 100);
        creation.displayArray(input);
        QuickSort sort = new QuickSort();
        sort.quickSort(input, 0, input.length - 1);
        System.out.println();
        creation.displayArray(input);
    }
}
