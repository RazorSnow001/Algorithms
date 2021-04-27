import RecursionRelated.Recursion.MergeSort;
import RecursionRelated.Recursion.Sort;
import Util.ArrayCreation;
import org.testng.annotations.Test;

public class MergeSortTest {
    @Test
    public void testArray() {
        ArrayCreation creation = new ArrayCreation();
        int[] array = creation.create(100000000);
        Sort mergeSort = new MergeSort();
        mergeSort.sort(array);
        System.out.println("test email ");
    }

    private void displayArray(int[] array) {
        for (int j : array) {
            System.out.println(j);
        }
    }
}
