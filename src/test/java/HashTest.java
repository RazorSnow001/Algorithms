import Leetcode.Hash.TwoSum;
import org.testng.annotations.Test;

import java.util.Arrays;

public class HashTest {
    @Test
    public void test() {
        TwoSum sum = new TwoSum();
        int[] input = {2, 6, 7, 10};
        int[] result = sum.getIndex(input, 19);
        System.out.println(Arrays.toString(result));
    }
}
