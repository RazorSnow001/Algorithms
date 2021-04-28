package RecursionRelated.Recursion;

import java.util.ArrayList;
import java.util.List;

import static RecursionRelated.Recursion.MergeSort.CombineSortedArrays;

public class MergeSortParallel implements Runnable {
    int[] inputArray;
    int[] resultArray;
    int beginIndex;
    int endIndex;

    public MergeSortParallel(int[] inputArray) {
        this.inputArray = inputArray;
        this.resultArray = new int[inputArray.length];
        this.beginIndex = 0;
        this.endIndex = inputArray.length;
    }

    public int[] getResultArray() {
        return resultArray;
    }

    @Override
    public void run() {
        if (inputArray.length == 1) {
            resultArray = inputArray;
        } else {
            List<Thread> threads = new ArrayList<>();
            int[] leftHalf = new int[inputArray.length / 2];
            System.arraycopy(inputArray, 0, leftHalf, 0, leftHalf.length);
            int[] rightHalf = new int[inputArray.length - leftHalf.length];
            System.arraycopy(inputArray, leftHalf.length, rightHalf, 0, rightHalf.length);
            MergeSortParallel leftSort = new MergeSortParallel(leftHalf);
            MergeSortParallel rightSort = new MergeSortParallel(rightHalf);
            Thread leftTask = new Thread(leftSort);
            Thread rightTask = new Thread(rightSort);
            leftTask.start();
            threads.add(leftTask);
            rightTask.start();
            threads.add(rightTask);
            for (Thread thread : threads) {
                try {
                    thread.join();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            CombineSortedArrays(resultArray, leftSort.resultArray, rightSort.getResultArray());
        }
    }
}
