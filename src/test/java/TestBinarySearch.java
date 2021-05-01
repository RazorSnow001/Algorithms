import Search.BinarySearch;
import Util.ArrayCreation;
import org.testng.annotations.Test;

public class TestBinarySearch {
    @Test
    public void testSearch() {
        ArrayCreation creation = new ArrayCreation();
        int[] input = creation.create(15, 20);
        creation.displayArray(input);
        BinarySearch search = new BinarySearch(input, 7);
        int result = search.search();
        System.out.println();
        System.out.println(result);
    }
}
