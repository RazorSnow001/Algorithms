package RecursionRelated.DynamicProgramming.GreedyAlgorithm;

import java.util.Arrays;
import java.util.Objects;

/*
 * as we said this problem is also one of the problem which can be solved by DP
 * but as we say that is a quick dp
 * that looks like we jump over the recursion process and get the dp array at first and
 * use the mathematical induction to get the result for
 * assume we get the k value and use the k value to induct the k + 1 value
 * and write the code !
 *　Input: s = ") ( ) ( ) ) ( ) ( ) ( ( ( ) ) )＂
 *            　0 0 2 0 4 0 0 2 0 4 0 0 0 2 4 10
 *
 *             in this dp what the number means ? means the number represent until this position . what is the max value of this sub string ?
 *
 * this method is good for solving the problem which is easy to get result from observe
 * but hard to get the natural recursion ok ?
 * let's do it !
 * ok now we see how to do that
 * */
public class LongestValidParentheses {
    public int getLongestIncreasingSubsequence(String input) {
        int[] record = new int[input.length()];
        for (int i = 0; i < input.length(); i++) {
            if (Objects.equals(input.charAt(i), ')')) {
                if (i - 1 >= 0 && input.charAt(i - 1) == '(') {
                    record[i] = ((i - 2 >= 0 && input.charAt(i - 2) == ')')) ? record[i - 2] + 2 : 2;
                }
                if (i - 1 > 0 && input.charAt(i - 1) == ')' && record[i-1] != 0) {
                    int jump = i - record[i - 1] - 1;
                    int increment = (jump >= 0 && input.charAt(jump) == '(') ? record[i-1] + 2 : 0;
                    record[i] = (increment>0 && jump-1>=0&&input.charAt(jump-1)==')')?record[jump-1]+increment:increment;
                }
            }
        }
        return Arrays.stream(record).max().getAsInt();
    }

    public static void main(String[] args) {
        String input =")()())()())((()))";
        LongestValidParentheses test = new LongestValidParentheses();
        System.out.println(test.getLongestIncreasingSubsequence(input));
    }
}
