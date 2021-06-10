package RecursionRelated.BackTracing.Permutation;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinTask;

public class TestParallelism {
    public static void main(String[] args) {
        List<Integer> input = Arrays.asList(1, 2, 1,2);
        ForkJoinTask<List<List<Integer>>> task = new PermutationWithParallelism(input);
        System.out.println(new ForkJoinPool().invoke(task));
    }

}
