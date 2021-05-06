package RecursionRelated.BackTracing;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class Permutation {
    public List<List<Integer>> computingPermutation(List<Integer> input, int[] record, int labelNum) {
        List<List<Integer>> resultList = new ArrayList<>();

        for (int i = 0; i < input.size(); i++) {
            if (record[i] == 0 && labelNum == input.size() - 1) {
                List<Integer> single = new ArrayList<>();
                single.add(input.get(i));
                resultList.add(single);
                return resultList;
            }
            if (record[i] == 0 && labelNum != input.size() - 1) {
                int current = input.get(i);
                record[i] = 1;
                labelNum++;
                List<List<Integer>> partList = computingPermutation(input, record, labelNum);
                for (List<Integer> list : partList) {
                    list.add(0, current);
                    resultList.add(list);
                }
                /*core part the backtrace is actually recursion with back ! modify ! revoke the modify
                *  */
                record[i] = 0;
                labelNum--;
            }
        }
        return resultList;
    }

    public List<List<Integer>> getPermutation(List<Integer> input) {
        int[] record = new int[input.size()];
        return computingPermutation(input, record, 0);
    }

    @Test
    public void test() {
        List<Integer> input = new ArrayList<>();
        input.add(1);
        input.add(2);
        input.add(3);
        Permutation permutation = new Permutation();
        System.out.println(permutation.getPermutation(input));
    }
}
