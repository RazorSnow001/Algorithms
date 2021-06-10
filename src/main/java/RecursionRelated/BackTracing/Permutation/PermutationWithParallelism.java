package RecursionRelated.BackTracing.Permutation;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.concurrent.RecursiveTask;

/* ok the permutation is just the usage of the DFS
 *  and the basic mathematical modeling for the back trace
 *  for example 1 2 3 as the input and find the permutation ! */
public class PermutationWithParallelism extends RecursiveTask<List<List<Integer>>> {
    private List<List<Integer>> result;
    private List<Integer> input;
    private int[] record;
    private int labelNum;

    private PermutationWithParallelism(List<Integer> input, int[] record, int labelNum) {
        this.result = new ArrayList<>();
        this.input = input;
        this.record = record;
        this.labelNum = labelNum;
    }

    public PermutationWithParallelism(List<Integer> input) {
        this(input, new int[input.size()], 0);
    }

    @Override
    protected List<List<Integer>> compute() {
        HashSet<Integer> isUsed = new HashSet();
        for (int i = 0; i < input.size(); i++) {
            int current = input.get(i);
            if (record[i] == 0 && labelNum == input.size() - 1 && !isUsed.contains(current)) {
                List<Integer> single = new ArrayList<>();
                single.add(input.get(i));
                result.add(single);
                return result;
            }
            if (record[i] != 1 && labelNum != record.length && !isUsed.contains(current)) {
                isUsed.add(current);
                labelNum++;
                record[i] = 1;
                PermutationWithParallelism task = new PermutationWithParallelism(input, record, labelNum);
                task.fork();
                List<List<Integer>> partialResult = task.join();
                if (partialResult.size() != 0) {
                    for (List<Integer> list :
                            partialResult) {
                        list.add(0, current);
                        result.add(list);
                    }
                }
                record[i] = 0;
                labelNum--;
            }
        }
        return result;
    }
}
