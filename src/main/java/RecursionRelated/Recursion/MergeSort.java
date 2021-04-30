package RecursionRelated.Recursion;

public class MergeSort implements Sort, Runnable {
    public int[] getResultArray() {
        return resultArray;
    }

    private int[] resultArray;
    private int[] inputArray;
    int beginIndex;
    int endIndex;

    public MergeSort(int[] inputArray, int beginIndex, int endIndex) {
        this.inputArray = inputArray;
        this.beginIndex = beginIndex;
        this.endIndex = endIndex;
        this.resultArray = new int[endIndex - beginIndex + 1];
    }

    public MergeSort() {

    }

    @Override
    public int[] sortSerial(int[] array) {
        return mergeSortSerial(array, 0, array.length - 1);
    }

    @Override
    public void run() {
        mergeSortParallel(inputArray, beginIndex, endIndex);
    }

    /*
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
        CombineSortedArrays(resultArray, sortedFirstHalf, sortedLastHalf);
        return resultArray;
    }

    /*something is wrong but we have so many problems but concurrency programming is just
     * so interesting
     *  1 how to use debug to analysis a concurrency program  in idea
     *  2 do we can write some thing in the run method which is a method ? */
    public void mergeSortParallel(int[] array, int beginIndex, int endIndex) {
        if (beginIndex == endIndex) {
            resultArray = new int[]{array[beginIndex]};
            return;
        }
        int middleIndex = (endIndex - beginIndex) / 2;
        MergeSort leftSort = new MergeSort(array, beginIndex, beginIndex + middleIndex);
        MergeSort rightSort = new MergeSort(array, beginIndex + middleIndex + 1, endIndex);
        Thread leftTask = new Thread(leftSort);
        leftTask.start();
        try {
            leftTask.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Thread rightTask = new Thread(rightSort);
        rightTask.start();
        try {
            rightTask.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        int[] sortedFirstHalf = leftSort.resultArray;
        int[] sortedLastHalf = rightSort.resultArray;
        CombineSortedArrays(resultArray, sortedFirstHalf, sortedLastHalf);
    }

    static void CombineSortedArrays(int[] resultArray, int[] sortedFirstHalf, int[] sortedLastHalf) {
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
