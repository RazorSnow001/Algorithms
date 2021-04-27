package Util;

public class TestExecutionTime {
    private void consumeTime() {
        long startTime = System.nanoTime();
        long endTime = System.nanoTime();
        System.out.println("use time : " + (endTime - startTime) + "ns");
        System.out.println((endTime - startTime) / 1000 + " us ");
        System.out.println((endTime - startTime) / 1000000 + " ms ");
        System.out.println("finish merge sort");
    }
}
