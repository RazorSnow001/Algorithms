package Search;

import java.util.Arrays;

public class MedianOfTwoSortedArrays {
    /*in this implementation we actually want to
     * search the cut point of the inputA or inputB
     * because we use the property
     * suppose we have the combination array C which contains all the elements of A and B
     * and sorted too . so we use one cut line to find the median . and we find A and B itself is
     * sorted respectively . so if the cut line can be divided into two lines . and we find . for
     *  example
     *  1 2 4
     *  3 5 6
     *  1 2 3  |  4 5 6
     *  can be divided into
     *  1 2 | 4
     *  3 | 5 6
     *
     *  1 2 4| max
     *  min  |  5 6
     *
     *  ok and we find if we find the cut line of the A and we find the cut line of the
     *  B . that is great ! ? so why binary search for  this task .
     *  ? linear search is good ? too ? yes . we use the binary search to search the line position
     *  so for the binary search we need the condition for the normal case we search one specific
     *  key or value but now we search a position . a satisfied condition .
     *   A. left < B .right and B.left < A. right both satisfy  !
     *   and what is the condition indicates we need to move the index !?
     *   B. left < A .right ! so we need to move left !
     *   A . left < B .right indicates move right !
     *   and the border condition  ? */
    public double findMedian(int[] inputA, int[] inputB) {
        int[] newA = new int[inputA.length + 2];
        int[] newB = new int[inputB.length + 2];
        newA[0] = newB[0] = -10000;
        newA[newA.length - 1] = newB[newB.length - 1] = 1000000;
        System.arraycopy(inputA, 0, newA, 1, inputA.length);
        System.arraycopy(inputB, 0, newB, 1, inputB.length);
        double median = 0;
        int sumLength = inputA.length + inputB.length;
        int beginIndex = 0;
        int endIndex = inputA.length + 1;
        int cutOfA = (endIndex - beginIndex) / 2 + beginIndex;
        int cutOfB = sumLength / 2 - cutOfA;
        while (beginIndex <= endIndex) {
            if (newA[cutOfA] <= newB[cutOfB + 1] && newB[cutOfB] <= newA[cutOfA + 1]) {
                int maxLeft = Math.max(newA[cutOfA], newB[cutOfB]);
                median = (sumLength % 2 == 0) ? (double) (maxLeft + Math.min(newA[cutOfA + 1], newB[cutOfB + 1])) / 2
                        : maxLeft;
                return median;
            }
            if (newA[cutOfA + 1] < newB[cutOfB]) {
                beginIndex = cutOfA + 1;
            }
            if (newA[cutOfA] > newB[cutOfB + 1]) {
                endIndex = cutOfA - 1;
            }
            cutOfA = (endIndex - beginIndex) / 2 + beginIndex;
            cutOfB = sumLength / 2 - cutOfA;
        }
        return median;
    }

}
