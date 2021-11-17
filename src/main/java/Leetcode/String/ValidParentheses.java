package Leetcode.String;

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

}
