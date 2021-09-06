package RecursionRelated.DivideAndConquer;

import java.util.Arrays;
/*
 *  this algorithm use the character of the  merge sort witch
 *  have two already sorted sub array .
 *  so in the combination stage .
 *  we can get the reversed num of the specific number
 *  we use a different view . now we consider how much
 *  reversed num this element contributes
 *  that is the idea.
 *  so in the end
 *  we use the recursion to cover partial of the execution to get the reversed num
 *  but we also need the combination stage to cover the other part
 *  that is very crucial !
 *  so 1 we need to use the merge sort
 *     2 we need modify the combination stage to get the reversed num of the bigger
 *
 *  so after the analysis
 *  that is just the mergesort + the reversed num statics
 *  so in the merge sort we use extra space to handle the combination !
 *  that may be the core part !
 * */
public class TheReverseNumOfTheNumberArray {
    public int getReverseNum(int[] input, int head, int end) {
        if (head == end) {
            return 0;
        }

        int mid = (head + end) / 2;
        int leftReversedNum = getReverseNum(input, head, mid);
        int rightReversedNum = getReverseNum(input, mid + 1, end);
        int reversedNumFromCombination = combination(input, head, mid, end);
        return leftReversedNum + rightReversedNum + reversedNumFromCombination;
    }

    /*
     *  example
     *  1 | 3 5 7            ----------- length is 4  ----------- length - (index+1)
     *  0 4 6 8
     *  so
     *  1 < 2 normal order will lead to no attribute to the result
     *  2 < 3 will attribute 3 because of 3 5 7 is already sorted so if the 2 < 3 and 2 < 5 , 2 < 7
     *
     * */
    public int combination(int[] input, int head, int mid, int end) {
        int reversedNumFromCombination = 0;
        int[] left = Arrays.copyOfRange(input, head, mid + 1);
        int[] right = Arrays.copyOfRange(input, mid + 1, end + 1);

        int leftIndex = 0;
        int rightIndex = 0;
        int inputIndex = head;
        while (leftIndex <= left.length - 1 && rightIndex <= right.length - 1 && inputIndex <= end) {
            if (left[leftIndex] <= right[rightIndex]) {
                input[inputIndex] = left[leftIndex];
                leftIndex++;
            } else {
                reversedNumFromCombination += left.length - (leftIndex);
                input[inputIndex] = right[rightIndex];
                rightIndex++;
            }
            inputIndex++;
        }

        /*if we one array's index touch the bound we just need to push all the numbers of the other arrays to the input to
         * do the replacement operation ? but how to do that ? */
        if (leftIndex == left.length) {
            while (rightIndex <= right.length - 1 && inputIndex <= end) {
                input[inputIndex] = right[rightIndex];
                rightIndex++;
                inputIndex++;
            }
        }
        if (rightIndex == right.length) {
            while (leftIndex <= left.length - 1 && inputIndex <= end) {
                input[inputIndex] = left[leftIndex];
                leftIndex++;
                inputIndex++;
            }
        }
        return reversedNumFromCombination;
    }

    public static void main(String[] args) {
        int[] input = {4, 4, 3, 2, 1, 0};
        TheReverseNumOfTheNumberArray execution = new TheReverseNumOfTheNumberArray();
        int result = execution.getReverseNum(input, 0, input.length - 1);
        System.out.println(result);
    }
}
