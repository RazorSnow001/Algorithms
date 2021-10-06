package RecursionRelated.DynamicProgramming.RussianDollEnvelopes.LongestIncreasingSubsequence;

import java.util.*;

/*
 *
 * so we have finished the analysis and the easy recursion solution . but we don't use the
 * DynamicProgramming why ? the recursion solution have the problem for overlapping sub problem and
 * hence leads to the repetition computing ! that is ugly . so how to fix that ?
 * so we need to find right data structure to store the result of the sub problem .
 * and use the dependency to make sure the smaller sub problem's result will be stored at first . ok ?
 * so what we need to store . in our modified version we want to store the list of the specific node
 * a number which means
 * for example Input: nums = [10,9,2,5,3,7,101,18]
 * when we got the 101 node we get 101
 * when we got the 7 node we get either 101 or the 18 ok ?
 * that is easy so how to find the max ?
 * because we use the bottom to top actually we have deleted all the repetition branches . that is very sure !
 * so we can just compare the list for every single number
 * and return the max . ok that is great !
 *
 * */
public class DP_Bottom_Top {
    public List<Integer> getLongestIncreasingSubsequence(List<Integer> input) {
        Map<Integer, List<Integer>> DPSpace = new HashMap<>();
        for (int i = input.size() - 1; i >= 0; i--) {
            if (Objects.equals(input.size() - 1, i)) {
                DPSpace.put(i, List.of(input.get(i)));
                continue;
            }
            int current = input.get(i);
            List<Integer> currentList = new ArrayList<>();
            currentList.add(current);
            Map<Integer, List<Integer>> tempMap = new HashMap<>();
            for (int j = i; j < input.size(); j++) {
                if (current < input.get(j)) {
                    tempMap.put(j, DPSpace.get(j));
                }
            }
            if (!tempMap.isEmpty()) {
                currentList.addAll(Collections.max(tempMap.entrySet(), Comparator.comparingInt(o -> o.getValue().size())).getValue());
            }
            DPSpace.put(i, currentList);
        }
        return Collections.max(DPSpace.entrySet(), Comparator.comparingInt(o -> o.getValue().size())).getValue();
    }

    public static void main(String[] args) {
        List<Integer> input = Arrays.asList(10, 9, 2, 5, 3, 7, 101, 18, 107, 110);
        DP_Bottom_Top test = new DP_Bottom_Top();
        List<Integer> result = test.getLongestIncreasingSubsequence(input);
        System.out.println(result);
    }
}
