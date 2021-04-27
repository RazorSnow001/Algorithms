package Leetcode.Optimization;

public class LargestRectangleInHistogram {
    public int bruteFindLargest(int[] inputArray) {
        int maxRectangle = 0;
        int[] recordMaxInfo = new int[4];
        for (int i = 0; i < inputArray.length; i++) {
            int rightExpand = 1;
            int leftExpand = 1;
            while (i + rightExpand < inputArray.length && inputArray[i] <= inputArray[i + rightExpand]) {
                rightExpand++;
            }
            while (i - leftExpand > -1 && inputArray[i] <= inputArray[i - leftExpand]) {
                leftExpand++;
            }
            int currentColumnMaxArea = inputArray[i] * (rightExpand + leftExpand - 1);
            if (currentColumnMaxArea > maxRectangle) {
                maxRectangle = currentColumnMaxArea;
                recordMaxInfo[0] = i-leftExpand;
                recordMaxInfo[1] = i+rightExpand;
                recordMaxInfo[2] = i;
                recordMaxInfo[3] = inputArray[i];
            }
        }
        display(recordMaxInfo);
        System.out.println(maxRectangle);
        return maxRectangle;
    }

    private void display(int[] recordMaxInfo) {
        for (int j : recordMaxInfo) {
            System.out.println(j);
        }
    }
}
