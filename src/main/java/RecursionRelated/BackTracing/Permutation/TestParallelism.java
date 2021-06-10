package RecursionRelated.BackTracing.Permutation;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinTask;

public class TestParallelism {
    public static void main(String[] args) {
        long startTime = System.nanoTime();
        List<Integer> input = Arrays.asList(1, 1, 2, 3);
        input.sort(Integer::compareTo);
        ForkJoinTask<List<List<Integer>>> task = new PermutationWithParallelism(input);
        List<List<Integer>> result = new ForkJoinPool().invoke(task);
        System.out.println(result.size());
        long endTime = System.nanoTime();
        System.out.println(endTime - startTime);
    }

}
