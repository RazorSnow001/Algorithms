package Leetcode.String;

import java.util.HashSet;

public class LongestSubstringWithoutRepeatingCharacters {
    public int findLongest(String input) {
        int frontIndex = 0;
        int backIndex = 0;
        int max = 0;
        HashSet<Character> set = new HashSet<>();
        while (backIndex != input.length() && frontIndex != input.length()) {
            if (!set.contains(input.charAt(backIndex))) {
                int currentNoRepeatLength = backIndex - frontIndex + 1;
                if (currentNoRepeatLength > max) {
                    max = currentNoRepeatLength;
                }
                set.add(input.charAt(backIndex));
                backIndex++;
            } else {
                set.remove(input.charAt(frontIndex));
                frontIndex++;
            }
        }
        return max;
    }

}
