package RecursionRelated.StringMatching;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class SubstringWithConcatenationOfAllWords {
    public List<Integer> findSubstring(String input, String[] words) {
        if (input == null || words == null) return new ArrayList<>();
        List<Integer> result = new ArrayList<>();
        int n = words.length;
        int m = words[0].length();
        HashMap<String, Integer> map = new HashMap<>();
        for (String str :
                words) {
            map.put(str, map.getOrDefault(str, 0) + 1);
        }
        for (int i = 0; i < input.length() - n * m; i++) {
            HashMap<String, Integer> copy = new HashMap<>(map);
            int k = n;
            int j = i;
            while (k > 0) {
                String str = input.substring(j, j + m);
                if (!copy.containsKey(str) || copy.get(str) < 1) {
                    break;
                }
                copy.put(str, copy.get(str) - 1);
                k--;
                j += m;
            }
            if (k == 0) result.add(i);
        }
        return result;
    }
}
