
import Leetcode.String.IsPalindromic;
import org.testng.annotations.Test;

public class TestString {
    @Test
    public void test() {
        String input = "aa";
        IsPalindromic isPalindromic = new IsPalindromic(input);
        boolean result = isPalindromic.check(input, 0, input.length() - 1);
        System.out.println(result);
    }
}
