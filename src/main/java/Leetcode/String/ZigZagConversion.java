package Leetcode.String;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class ZigZagConversion {
    public String convert(String input, int numRows) {
        if (numRows == 1) return input;
        List<StringBuilder> rows = new ArrayList<>();
        for (int i = 0; i < Math.min(numRows, input.length()); i++) {
            rows.add(new StringBuilder());
        }
        int cur = 0;
        boolean down = true;
        for (int i = 0; i < input.length(); i++) {
            rows.get(cur).append(input.charAt(i));
            if (cur == rows.size() - 1) {
                down = false;
            }
            if (cur == 0) {
                down = true;
            }
            cur += (down) ? 1 : -1;
        }
        StringBuilder result = new StringBuilder();
        for (StringBuilder row : rows) result.append(row);
        return result.toString();
    }

    @Test
    public void test() {
        ZigZagConversion conversion = new ZigZagConversion();
        String input = "abcdef";
        String result = conversion.convert(input, 3);
        System.out.println(result);
    }
}
