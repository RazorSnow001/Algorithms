package Leetcode.Optimization;

import org.junit.Test;

/*in this problem we find something that is really interesting
 * so the DP or Recursion or some things other the right way to solve a
 * problem is not to just guess the method .but we use the analysis
 * so 1 we need to fully understand the problem
 *    2 as a algorithm we focus on the Input and Output
 *    so we write the  mapping   procedure so that is the key !
 * input : a string with just ( and ) that is great
 * so the output is just the know ... give the number of the max valid for the parentheses
 * that is the key !
 * so we need to analyze the service and create  the  model for it and we will find the right
 * method and the right data structure ! that is the right algorithm
 * ((())) 6 0 0 0 2 4 6 that is actually a math process
 * so the previous char will influence the future !
 * that may indicate  the DP
 * so DP is  actually some method
 * that is handle both now and have the future implicitly perspective !  so we get abstraction from the you know very specific case
 * that is the key
 * ()()()()()() 0 2 2 4 4 6 6 8 8 10 ----- 0 2 0 4 0 6 0 8 0 10 find the max of the record array !
 * ()()((()()()())) so we write all the condition for the right way
 * 0 2 0 4 0 0 0 2 0 4 0 6 0 8 10 16
 * nested and single pair, so we know the string0 is just the char array . so
 * 1 only when the char is ) we may  do the computing the continuity length of the valid parentheses
 *    1  */
public class LongestValidParentheses {
    public int longestValidParentheses(String input) {
        int index = 1;
        int[] record = new int[input.length()];
        for (int i = index; i < input.length(); i++) {
            if (input.charAt(i) == ')') {
                int preNum = record[i - 1];
                if (input.charAt(i - 1) == ')' && preNum != 0 && input.charAt(i - (preNum + 1)) == '(') {
                    record[i] = record[i - 1] + 2;
                }
                if (input.charAt(i - 1) == '(') {
                    record[i] = (i == 1) ? 2 : record[i - 2] + 2;
                }
            }
        }
        int longest = 0;
        for (int j = 0; j < record.length; j++) {
            if (record[j] > longest) {
                longest = record[j];
            }
        }
        return longest;
    }

    @Test
    public void test() {
        LongestValidParentheses longest = new LongestValidParentheses();
        String input = "(((((()()()))";
        int result = longest.longestValidParentheses(input);
        System.out.println(result);
    }
}
