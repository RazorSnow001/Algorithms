package RecursionRelated.Recursion;

public class MergeSortSerial implements Sort {

    public MergeSortSerial() {

    }

    @Override
    public int[] sort(int[] array) {
        return mergeSortSerial(array, 0, array.length - 1);
    }

    /**
     * what is mergesort we use the mergesort to use the divide and conquer approach !
     * so suppose the mergeSort method do the sort operation
     * and it really does that . so if we use the divide and conquer method
     * the really important part is how to merge the result of the two
     * sorted subarray so that may leads to a extra space consume
     * and we do need to do that ?
     * <p>
     * 1 how to express the divide ? we have some experience for this implementation
     * just transfer the index of the array
     * 2 as the recursion structure program we need to set the end point or base condition of
     * the recursion . so that is the very base condition too simple to solve !
     * 3 the most important part and the most difficult part is how to combine the result of the
     * two  sorted  array  . so in this case we find we can use the while to do that
     * and the most interesting part is to use the difference for example
     * 8 is the array length
     * and 3 is the A length == i  = 3
     * and k = 6
     * so for A all the numbers have been pushed into the result array
     * so the difference is 8-k = 2 which means all the 2 numbers comes from B and is the last 2 number
     * of the B array !
     * 4 we made 3 mistakes :
     * 1 the middle
     * 2 the middle
     * 3 i j
     */
    public int[] mergeSortSerial(int[] array, int beginIndex, int endIndex) {
        if (beginIndex == endIndex) {
            return new int[]{array[beginIndex]};
        }
        int[] resultArray = new int[endIndex - beginIndex + 1];
        int middleIndex = (endIndex - beginIndex) / 2;
        int[] sortedFirstHalf = mergeSortSerial(array, beginIndex, beginIndex + middleIndex);
        int[] sortedLastHalf = mergeSortSerial(array, beginIndex + middleIndex + 1, endIndex);
        combinationOfSortedArrays(resultArray, sortedFirstHalf, sortedLastHalf);
        return resultArray;
    }

    public void combinationOfSortedArrays(int[] resultArray, int[] sortedFirstHalf, int[] sortedLastHalf) {
        int i = 0;
        int j = 0;
        int k = 0;
        while (i != sortedFirstHalf.length && j != sortedLastHalf.length && k != resultArray.length) {
            if (sortedFirstHalf[i] < sortedLastHalf[j]) {
                resultArray[k] = sortedFirstHalf[i];
                i++;
            } else {
                resultArray[k] = sortedLastHalf[j];
                j++;
            }
            k++;
        }
        int difference = resultArray.length - k;
        if (i == sortedFirstHalf.length) {
            if (difference >= 0) System.arraycopy(sortedLastHalf, j, resultArray, k, difference);
        } else {
            if (difference >= 0) System.arraycopy(sortedFirstHalf, i, resultArray, k, difference);
        }
    }


}
