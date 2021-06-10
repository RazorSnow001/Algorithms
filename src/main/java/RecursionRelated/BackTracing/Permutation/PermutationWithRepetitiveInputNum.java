package RecursionRelated.BackTracing.Permutation;

import java.util.*;

public class PermutationWithRepetitiveInputNum {
    public List<List<Integer>> getPermutation(List<Integer> input) {
        input.sort(Integer::compareTo);
        int[] record = new int[input.size()];
        return computingPermutation(input, record, 0);
    }

    public List<List<Integer>> computingPermutation(List<Integer> input, int[] record, int labelNum) {
        HashSet<Integer> isUsed = new HashSet();
        List<List<Integer>> result = new ArrayList<>();
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
                List<List<Integer>> partialResult = computingPermutation(input, record, labelNum);
                record[i] = 0;
                labelNum--;
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

    public static void main(String[] args) {
        List<Integer> input = Arrays.asList(1, 2, 1,2);
        PermutationWithRepetitiveInputNum permutationWithRepetitiveInputNum
                = new PermutationWithRepetitiveInputNum();
        List<List<Integer>> result = permutationWithRepetitiveInputNum.getPermutation(input);
        System.out.println(result);
    }
}
