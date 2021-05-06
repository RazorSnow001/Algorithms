package RecursionRelated.StringMatching;

import org.junit.Test;

/*  evolution
 *   use the data structure to analysis the code implementation
 *   so here we have different matching rules
 *   and different rules for different pattern and the input
 *   and we use the accumulating strategy to think yes when we say two string is matched
 *   the only way is the local part is matched and global is matched
 *   but compare to the most brute matching we mean one by one  every char are all the same !
 *   here we just have some more options for the matched . which means for one rule we may
 *   fail. but if we satisfy one rule we pass .*/
public class RegularExpressionMatching {
    public boolean isMatch(String input, String pattern) {
        if (pattern.isEmpty()) {
            return input.isEmpty();
        }
        boolean firstCheck = input.charAt(0) == pattern.charAt(0) || pattern.charAt(0) == '.';
        if (pattern.length() >= 2 && pattern.charAt(1) == '*') {
            return firstCheck && isMatch(input.substring(1), pattern) || isMatch(input, pattern.substring(2));
        }
        return firstCheck &&
                isMatch(input.substring(1), pattern.substring(1));
    }

    @Test
    public void test() {
        RegularExpressionMatching test = new RegularExpressionMatching();
        String input = "dsfatiger";
        String pattern = ".*tige.";
        boolean result = test.isMatch(input, pattern);
        System.out.println(result);
    }
}
