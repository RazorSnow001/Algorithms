package Leetcode.Optimization;

import java.util.Stack;

public class LargestRectangleWithStack {
    public int getMaxRectangle(int[] input) {
        Stack<Integer> stack = new Stack<>();
       /*  why we record the index of input in the stack ?
            1 we can use the index find the height
            2 with the index we can find the width */
        stack.push(-1); // for the consistent coding
        stack.push(0); // for the first column we don't need to compare just push
        int maxArea = 0;
        int traverseIndex = 1;
        int[] recordMaxInfo = new int[4];
        /* because in the traverse process the index behavior is not consistent . maybe in one step it
            more forward or stay . so we need use the while rather than the for loop
            and how about the = relationship ? we computing the algorithm in our mind
            and find yes that is a great way to ignore the border or small equal condition
            construct the framework and do the detail work . so that is great ! */
        while (traverseIndex < input.length) {
            if (stack.peek() == -1) {
                stack.push(traverseIndex);
                traverseIndex++;
                continue;
            }
            if (stack.peek() != -1 && (input[traverseIndex] > input[stack.peek()])) {
                stack.push(traverseIndex);
                traverseIndex++;
            } else {
                maxArea = getMaxArea(input, stack, maxArea, traverseIndex, recordMaxInfo);
            }
        }
        while (stack.peek() != -1) {
            maxArea = getMaxArea(input, stack, maxArea, traverseIndex, recordMaxInfo);
        }
       /* display(recordMaxInfo);*/
        return maxArea;
    }

    private int getMaxArea(int[] input, Stack<Integer> stack, int maxArea, int traverseIndex, int[] recordMaxInfo) {
        int popIndex = stack.pop();
        int currentArea = input[popIndex] * (traverseIndex - stack.peek() - 1);
        if (currentArea > maxArea) {
            maxArea = currentArea;
            recordMaxInfo[0] = stack.peek(); // record the left border
            recordMaxInfo[1] = traverseIndex; // record the right border
            recordMaxInfo[2] = popIndex; // get the current column index in the input array
            recordMaxInfo[3] = input[popIndex]; // get the current column height
        }
        return maxArea;
    }

    private void display(int[] recordMaxInfo) {
        for (int j : recordMaxInfo) {
            System.out.println(j);
        }
    }
}
