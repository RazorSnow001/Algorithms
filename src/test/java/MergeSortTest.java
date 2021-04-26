import RecursionRelated.Recursion.MergeSort;
import RecursionRelated.Recursion.Sort;
import org.testng.annotations.Test;

public class MergeSortTest {
  @Test
  public void testArray(){
      int[] array = {5,7,1,2,10,6,7,4,9,10};
      Sort mergeSort = new MergeSort();
      mergeSort.sort(array);
      System.out.println();
  }
}
