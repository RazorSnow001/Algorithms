package Leetcode.String;

import org.junit.Test;

import java.util.Stack;

public class ValidParentheses {
    public boolean isValid(String input) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < input.length(); i++) {
            if (input.charAt(i) == '(' || input.charAt(i) == '{' || input.charAt(i) == '[') {
                stack.push(input.charAt(i));
                continue;
            }
            if ((input.charAt(i) == ')' && !stack.isEmpty() && stack.peek() == '(')) {
                stack.pop();
                continue;
            }
            if ((input.charAt(i) == ']' && !stack.isEmpty() && stack.peek() == '[')) {
                stack.pop();
                continue;
            }
            if ((input.charAt(i) == '}' && !stack.isEmpty() && stack.peek() == '{')) {
                stack.pop();
            }
        }
        return stack.isEmpty();
    }

    @Test
    public void test() {
        ValidParentheses validParentheses = new ValidParentheses();
        String input = "(({}))";
        boolean result = validParentheses.isValid(input);
        System.out.println(result);
    }
}
