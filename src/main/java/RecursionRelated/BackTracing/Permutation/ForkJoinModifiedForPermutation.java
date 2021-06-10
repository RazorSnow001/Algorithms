package RecursionRelated.BackTracing.Permutation;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.concurrent.RecursiveTask;

public class ForkJoinModifiedForPermutation extends RecursiveTask<List<List<Integer>>> {
    private List<List<Integer>> result;
    private List<Integer> input;
    private int[] record;
    private int labelNum;

    private ForkJoinModifiedForPermutation(List<Integer> input, int[] record, int labelNum) {
        this.result = new ArrayList<>();
        this.input = input;
        this.record = record;
        this.labelNum = labelNum;
    }

    public ForkJoinModifiedForPermutation(List<Integer> input) {
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
                int labelCopy = labelNum + 1;
                int[] recordCopy = Arrays.copyOf(record,record.length);
                recordCopy[i]=1;
                ForkJoinModifiedForPermutation task =
                        new ForkJoinModifiedForPermutation(input, recordCopy, labelCopy);
                task.fork();
                List<List<Integer>> partialResult = task.join();
                if (partialResult.size() != 0) {
                    for (List<Integer> list :
                            partialResult) {
                        list.add(0, current);
                        result.add(list);
                    }
                }
            }
        }
        return result;
    }
}
