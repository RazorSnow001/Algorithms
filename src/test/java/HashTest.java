import Leetcode.Hash.TwoSum;
import Leetcode.String.LongestSubstringWithoutRepeatingCharacters;


import java.util.Arrays;

public class HashTest {

    public void test() {
        TwoSum sum = new TwoSum();
        int[] input = {2, 6, 7, 10};
        int[] result = sum.getIndex(input, 19);
        System.out.println(Arrays.toString(result));
    }


    public void testLongestSubstringWithoutRepeatingCharacters() {
        LongestSubstringWithoutRepeatingCharacters longest = new LongestSubstringWithoutRepeatingCharacters();
        String input = "aaabcccbaabcde";
        int result = longest.findLongest(input);
        System.out.println(result);
    }
}
