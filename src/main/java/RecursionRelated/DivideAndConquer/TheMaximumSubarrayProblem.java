package RecursionRelated.DivideAndConquer;

import java.util.Arrays;
import java.util.Random;

public class TheMaximumSubarrayProblem {
    private int[] inputArray;

    public TheMaximumSubarrayProblem(int[] inputArray) {
        this.inputArray = inputArray;
    }

    public int[] getMax(int low, int high) {
        if(low==high){
            return new int[]{low,high,inputArray[low]};
        }
        int[] solution = new int[3];
        int mid = (low + high) / 2;
        int[] leftSolution = getMax(low, mid);
        int[] rightSolution = getMax(mid + 1, high);
        int[] crossMidSolution = linearCrossMid(mid, low, high);

        int leftResult = leftSolution[2];
        int rightResult = rightSolution[2];
        int crossMidResult = crossMidSolution[2];

        if (leftResult >= rightResult && leftResult >= crossMidResult) {
            solution = leftSolution;
        }
        if (rightResult >= leftResult && rightResult >= crossMidResult) {
            solution = rightSolution;
        }
        if (crossMidResult >= rightResult && crossMidResult >= leftResult) {
            solution = crossMidSolution;
        }
        return solution;
    }

    public int[] linearCrossMid(int mid, int low, int high) {
        int[] solution = new int[3];
        int leftSum = 0;
        int rightSum = 0;
        int leftMax = 0;
        int rightMax = 0;
        int resultLeftIndex = mid;
        int resultRightIndex = mid + 1;
        int leftIndex = mid;
        int rightIndex = mid + 1;
        while (leftIndex != low - 1) {
            leftSum = leftSum + inputArray[leftIndex];
            if (leftSum >= leftMax) {
                leftMax = leftSum;
                resultLeftIndex = leftIndex;
            }
            leftIndex--;
        }

        while (rightIndex != high + 1) {
            rightSum = rightSum + inputArray[rightIndex];
            if (rightSum >= rightMax) {
                rightMax = rightSum;
                resultRightIndex = rightIndex;
            }
            rightIndex++;
        }

        int maxSum = 0;
        for (int i = resultLeftIndex; i <= resultRightIndex; i++) {
            maxSum = maxSum + inputArray[i];
        }
        solution[0] = resultLeftIndex;
        solution[1] = resultRightIndex;
        solution[2] = maxSum;
        return solution;
    }

    public static void main(String[] args) {
        int[] numbers = new Random().ints(-20, 20).limit(20).toArray();
        System.out.println(Arrays.toString(numbers));
        TheMaximumSubarrayProblem findMax = new TheMaximumSubarrayProblem(numbers);
        System.out.println(Arrays.toString(findMax.getMax(0, numbers.length - 1)));
    }
}
