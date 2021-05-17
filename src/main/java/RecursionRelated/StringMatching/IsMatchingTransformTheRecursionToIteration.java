package RecursionRelated.StringMatching;

import org.junit.Test;

/*the core part is we need to store the repeating computing result and store it into
 * some table . that can be array one dimensional two dimensional and so on ? but how to
 * do that ?
 * from the top to bottom or from the bottom to the top every one is ok
 * so one way to do the transform is
 * 1 write the recursion program and figure out what the nodes mean
 * 2 from the bottom use the proper data structure to store the result exactly the same as
 *  the you know the recursion style program .
 *  and we say this way is DP and we need to set the base condition exactly as the recursion
 *  so in this problem " "  = " "
 *  so we have two string . and the previous recursion program ask if these two string matches ?
 *  so it indicates that from the begin to the end this two string matches !
 *
 * but why we need to use the DP to modify the original recursion ?
 * because of the overlap problem duplicate computing !
 * */
public class IsMatchingTransformTheRecursionToIteration {
    public boolean isMatchBottomToTop(String input, String pattern) {
        boolean[][] record = new boolean[input.length() + 1][pattern.length() + 1];
        /*set the original or base condition which means empty string matches ! */
        record[input.length()][pattern.length()] = true;
        for (int i = input.length(); i >= 0; i--) {
            for (int j = pattern.length() - 1; j >= 0; j--) {
                boolean firstCheck = (i < input.length()) && (input.charAt(i) == pattern.charAt(j) || pattern.charAt(j) == '.');
                if (j + 1 <= pattern.length() - 1 && pattern.charAt(j + 1) == '*') {
                    record[i][j] = (firstCheck && record[i + 1][j]) || record[i][j + 2];
                } else {
                    record[i][j] = firstCheck && record[i + 1][j + 1];
                }
            }
        }
        display(record);
        return record[0][0];
    }

    private void display(boolean[][] record) {
        for (boolean[] booleans : record) {
            for (int j = 0; j < record[0].length; j++) {
                System.out.printf("%8b", booleans[j]);
            }
            System.out.println();
        }
    }

    @Test
    public void test() {
        IsMatchingTransformTheRecursionToIteration test = new IsMatchingTransformTheRecursionToIteration();
        String input = "";
        String pattern = ".*";
        boolean result = test.isMatchBottomToTop(input, pattern);
        System.out.println(result);
    }
}
