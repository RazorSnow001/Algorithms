package Leetcode.Hash;

import java.util.Arrays;

public class DoubleIndex {
    public boolean ifHaveTarget(int[] input, int target) {
        int endIndex = input.length - 1;
        int beginIndex = 0;
        boolean result = false;
        while (beginIndex < endIndex) {
            int current = input[endIndex] + input[beginIndex];
            if (current == target) {
                return true;
            }
            if (current < target) {
                beginIndex++;
            } else {
                endIndex--;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] input = {1, 3, 2, 5, 4, 7, 8, 5, 0};
        Arrays.sort(input);
        DoubleIndex test = new DoubleIndex();
        System.out.println(test.ifHaveTarget(input, 14));
    }
}
