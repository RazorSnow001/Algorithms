package Leetcode.Digit;


import org.junit.jupiter.api.Test;

public class ReverseIntegerAdvanced {
    public int reverse(int x) {
        long result = 0;
        while (x != 0) {
            result = result * 10 + x % 10;
            x /= 10;
            if (result > Integer.MAX_VALUE || result < Integer.MIN_VALUE) return 0;
        }
        return (int) result;
    }
    @Test
    public void test() {
        ReverseIntegerAdvanced reverseInteger = new ReverseIntegerAdvanced();
        int result = reverseInteger.reverse(120);
        System.out.println(result);
    }
}
