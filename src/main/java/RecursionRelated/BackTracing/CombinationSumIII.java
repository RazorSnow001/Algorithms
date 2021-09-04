package RecursionRelated.BackTracing;


import java.util.ArrayList;
import java.util.List;

/* ! this is a problem of the leetcode 216
 *  and we do have the thoughts my bro
 *  1 we have the no repeat number so we can use this for the
 *    branches decrease operation !
 *  2 we use the back tracing to handle this
 *    search problem
 *    as the master say : we use the back tracing algorithm to
 *    find all the solution feasible !
 *    satisfy the constraint condition !
 *  */
public class CombinationSumIII {
    boolean[] records = new boolean[10];
    List<Integer> currentPath = new ArrayList<>();
    List<List<Integer>> result = new ArrayList<>();

    public CombinationSumIII() {
        records[0] = true;
    }

    public void searchTheCombination(int number, int target, int begin) {
        if (begin == 10) {
            return;
        }

        if (number == 0 && target != 0) {
            return;
        }

        if (number != 0 && target == 0) {
            return;
        }

        if (number == 0) {
            result.add(List.copyOf(currentPath));
        }

        int index = begin;

        while ((index <= 9) && !records[index]) {
            records[index] = true;
            currentPath.add(index);
            searchTheCombination(number - 1, target - index, index + 1);
            currentPath.remove(currentPath.size() - 1);
            records[index] = false;
            index++;
        }
    }

    public static void main(String[] args) {
        CombinationSumIII execution = new CombinationSumIII();
        execution.searchTheCombination(4, 12, 1);
        System.out.println(execution.result);
    }

}
