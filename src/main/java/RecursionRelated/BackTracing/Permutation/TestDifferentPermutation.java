package RecursionRelated.BackTracing.Permutation;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinTask;

public class TestDifferentPermutation {
    List<Integer> input = Arrays.asList(1, 1, 2, 3,5,6,7);

    @Test
    public void testSerial() {
        long startTime = System.nanoTime();
        input.sort(Integer::compareTo);
        PermutationWithRepetitiveInputNum permutation = new PermutationWithRepetitiveInputNum();
        List<List<Integer>> result = permutation.getPermutation(input);
        System.out.println(result.size());
        long endTime = System.nanoTime();
        System.out.println(endTime - startTime + " version 0 with Serial");
    }

    @Test
    public void testParallel() {
        long startTime = System.nanoTime();
        input.sort(Integer::compareTo);
        ForkJoinTask<List<List<Integer>>> task = new PermutationWithParallelism(input);
        List<List<Integer>> result = new ForkJoinPool().invoke(task);
        System.out.println(result.size());

        long endTime = System.nanoTime();
        System.out.println(endTime - startTime + " version 1 with shared record and labelNum");
    }

    @Test
    public void testParallelV2() {
        long startTime = System.nanoTime();
        input.sort(Integer::compareTo);
        ForkJoinTask<List<List<Integer>>> task = new ForkJoinModifiedForPermutation(input);
        List<List<Integer>> result = new ForkJoinPool().invoke(task);
        System.out.println(result.size());

        long endTime = System.nanoTime();
        System.out.println(endTime - startTime + " version 2 with copy of record and labelNum ");
    }

}
