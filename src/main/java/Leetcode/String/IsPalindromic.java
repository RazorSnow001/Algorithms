package Leetcode.String;

public class IsPalindromic {
    String input;
    int begin;
    int end;

    public IsPalindromic(String input) {
        this.input = input;
        this.begin = 0;
        this.end = input.length() - 1;
    }

    public boolean check(String input, int begin, int end) {
        if (begin <= end) {
            if (begin == end) {
                return true;
            }
            boolean check = input.charAt(begin) == input.charAt(end);
            if (end - begin == 1 && check) {
                return true;
            }
            if (check && check(input, begin + 1, end - 1)) {
                return true;
            }
        }
        return false;
    }
}
