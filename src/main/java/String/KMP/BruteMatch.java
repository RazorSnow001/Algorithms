package String.KMP;

import java.util.ArrayList;
import java.util.List;

public class BruteMatch {
    List<Integer> resultList = new ArrayList<>();

    public void getResult(String text, String pattern) {
        for (int i = 0; i <= text.length() - pattern.length(); i++) {
            int indexOfPattern = 0;
            while (pattern.charAt(indexOfPattern) == text.charAt(i + indexOfPattern)) {
                if (indexOfPattern == pattern.length() - 1) {
                    resultList.add(i);
                    break;
                }
                indexOfPattern++;
            }
        }
    }

    public static void main(String[] args) {
        String text = "AAABCAAABDAAAB";
        String pattern = "AAAB";
        BruteMatch bruteMatch = new BruteMatch();
        bruteMatch.getResult(text, pattern);
        bruteMatch.resultList.forEach(System.out::println);
    }
}
