import RecursionRelated.Recursion.MergeSort;
import RecursionRelated.Recursion.Sort;
import Util.ArrayCreation;
import org.testng.annotations.Test;

public class MergeSortTest {
    @Test
    public void testArray() {
        ArrayCreation creation = new ArrayCreation();
        int[] array = creation.create(1000);
        Sort mergeSort = new MergeSort();
        mergeSort.sort(array);
        System.out.println("commit ? how to count it ?");
    }
}
