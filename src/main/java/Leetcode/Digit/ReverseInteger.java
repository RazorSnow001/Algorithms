package Leetcode.Digit;

import org.junit.Test;

import java.util.LinkedList;
import java.util.Queue;

public class ReverseInteger {
    public int reverse(int x) {
        if (x / 10 == 0) {
            return x;
        }
        Queue<Integer> queue = new LinkedList<>();
        while (x / 10 != 0) {
            queue.add(x % 10);
            x = x / 10;
        }
        queue.add(x);
        int result = 0;
        while (!queue.isEmpty()) {
            result += queue.poll() * Math.pow(10, queue.size());
        }
        return result;
    }

    @Test
    public void test() {
        ReverseInteger reverseInteger = new ReverseInteger();
        int result = reverseInteger.reverse(120);
        System.out.println(result);
    }
}
