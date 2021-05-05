package Leetcode.String;

import org.junit.Test;

/*  that is hard !*/
public class LongestPalindromicSubstring {
    public String getLongest(String input) {
        if (input.length() == 1) {
            return input;
        }
        int maxLength = 1;
        boolean[][] recordMatrix = new boolean[input.length()][input.length()];
        int[] record = new int[2];
        for (int i = 0; i < input.length(); i++) {
            recordMatrix[i][i] = true;
        }
        /*use the window to search the subString and we set the window length */
        for (int i = 2; i <= input.length(); i++) {
            for (int j = 0; j <= input.length() - i; j++) {
                if (i == 2 && input.charAt(j) == input.charAt(j + 1)) {
                    recordMatrix[j][j + 1] = true;
                    if (i > maxLength) {
                        maxLength = i;
                        record[0] = j;
                        record[1] = j + 1;
                    }
                }
                if (i >= 3 && input.charAt(j) == input.charAt(j + i - 1) && recordMatrix[j + 1][j + i - 2]) {
                    recordMatrix[j][j + i - 1] = true;
                    if (i > maxLength) {
                        maxLength = i;
                        record[0] = j;
                        record[1] = j + i - 1;
                    }
                }
            }
        }
        System.out.println(maxLength);
        return input.substring(record[0], record[1] + 1);
    }

    @Test
    public void test() {
        String input = "aba";
        LongestPalindromicSubstring findLongest = new LongestPalindromicSubstring();
        System.out.println(findLongest.getLongest(input));
    }
}
