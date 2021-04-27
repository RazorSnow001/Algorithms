import RecursionRelated.Recursion.MergeSortParallel;
import RecursionRelated.Recursion.MergeSortSerial;
import RecursionRelated.Recursion.Sort;
import Util.ArrayCreation;
import org.testng.annotations.Test;

public class MergeSortTest {
    @Test
    public void testArray() {
        ArrayCreation creation = new ArrayCreation();
        int[] array = creation.create(100000000);
        Sort mergeSort = new MergeSortSerial();
        mergeSort.sort(array);
    }

    @Test
    public void testParallel() {
        ArrayCreation creation = new ArrayCreation();
        int[] array = creation.create(10);
        MergeSortParallel task = new MergeSortParallel(array);
        Thread thread = new Thread(task);
        thread.start();
        try {
            thread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        int[] result = task.getResultArray();
        displayArray(result);
    }

    @Test
    public void compare() {
        ArrayCreation creation = new ArrayCreation();
        int[] array = creation.create(15);
        long startTime = System.nanoTime();
        Sort mergeSort = new MergeSortSerial();
        int[] serialResult = mergeSort.sort(array);
        long endTime = System.nanoTime();
        System.out.println();
        System.out.println("use time : " + (endTime - startTime) + "ns");
        System.out.println((endTime - startTime) / 1000 + " us ");
        System.out.println((endTime - startTime) / 1000000 + " ms ");
        System.out.println("finish merge sort serial");
        System.out.println();

        long start = System.nanoTime();
        MergeSortParallel task = new MergeSortParallel(array);
        Thread thread = new Thread(task);
        thread.start();
        try {
            thread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        long end = System.nanoTime();
        System.out.println();
        System.out.println("use time : " + (end - start) + "ns");
        System.out.println((end - start) / 1000 + " us ");
        System.out.println((end - start) / 1000000 + " ms ");
        System.out.println("finish merge sort parallel");
        System.out.println();
        int[] parallelResult = task.getResultArray();
        if (isSame(serialResult, parallelResult)) {
            displayArray(parallelResult);
        }

    }

    private void displayArray(int[] array) {
        for (int j : array) {
            System.out.println(j);
        }
    }

    private boolean isSame(int[] result, int[] result2) {
        for (int i = 0; i < result.length; i++) {
            if (result[i] != result2[i]) {
                return false;
            }
        }
        return true;
    }
}
