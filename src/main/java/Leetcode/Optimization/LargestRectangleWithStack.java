package Leetcode.Optimization;

import java.util.Stack;

public class LargestRectangleWithStack {
    public int getMaxRectangle(int[] input) {
        Stack<Integer> stack = new Stack<>();
        stack.push(-1);
        stack.push(0);
        int maxArea = 0;
        int traverseIndex = 1;
        int[] recordMaxInfo = new int[4];
        while (traverseIndex < input.length) {
            if (stack.peek() == -1) {
                stack.push(traverseIndex);
                traverseIndex++;
                continue;
            }
            if (stack.peek() != -1 && (input[traverseIndex] > input[stack.peek()])) {
                stack.push(traverseIndex);
                traverseIndex++;
            } else{
                maxArea = getMaxArea(input, stack, maxArea, traverseIndex, recordMaxInfo);
            }
        }
        while (stack.peek() != -1) {
            maxArea = getMaxArea(input, stack, maxArea, traverseIndex, recordMaxInfo);
        }
        display(recordMaxInfo);
        return maxArea;
    }

    private int getMaxArea(int[] input, Stack<Integer> stack, int maxArea, int traverseIndex, int[] recordMaxInfo) {
        int popIndex = stack.pop();
        int currentArea = input[popIndex] * (traverseIndex - stack.peek() - 1);
        if (currentArea > maxArea) {
            maxArea = currentArea;
            recordMaxInfo[0] = stack.peek();
            recordMaxInfo[1] = traverseIndex;
            recordMaxInfo[2] = popIndex;
            recordMaxInfo[3] = input[popIndex];
        }
        return maxArea;
    }

    private void display(int[] recordMaxInfo) {
        for (int j : recordMaxInfo) {
            System.out.println(j);
        }
    }
}
