package RecursionRelated.DynamicProgramming.LongestIncreasingSubsequence;

import java.util.*;

/*
 ! Input: nums = [10,9,2,5,3,7,101,18]
 * this the Top to bottom
 * edition that is easy ? but how to add the space to store the result of the middle stage result ?
 * so actually the top to bottom DP is in such logic :
 * 1 if the DPSpace do have the answer . we use that directly !
 * 2 but if here is no result . we do the common recursion to compute ! which means
 *   only one time for the computing for one sub problem .when the next time we find the problem we just get
 *   the answer .
 * 3 so after the analysis . what should we do ? we need to keep the original recursion structure ,but
 *   we add the space to store the result . so  where to add this cache ? */
public class DP_Top_Bottom {
    private Map<Integer, List<Integer>> DPSpace = new HashMap<>();
    private List<Integer> input;

    public DP_Top_Bottom(List<Integer> input) {
        this.input = input;
    }

    public List<Integer> getLongestIncreasingSubsequence(int start, int number) {
        if (start == input.size() - 1) {
            List<Integer> increaseSubsequence = new ArrayList<>();
            if (input.get(start) > number) {
                increaseSubsequence.add(input.get(start));
                DPSpace.put(start, increaseSubsequence);
            }
            return increaseSubsequence;
        }
        List<List<Integer>> currentList = new ArrayList<>();
        for (int i = start; i < input.size(); i++) {
            int currentNumber = input.get(i);
            List<Integer> increaseSubsequence = new ArrayList<>();
            if (currentNumber > number) {
                if (DPSpace.containsKey(i)) {
                    increaseSubsequence.add(input.get(i));

                } else {
                    increaseSubsequence.add(input.get(i));
                    increaseSubsequence.addAll(getLongestIncreasingSubsequence(i, input.get(i)));
                }
            }
            currentList.add(increaseSubsequence);
        }
        List<Integer> longestIncreaseSubsequence = currentList.stream()
                .max(Comparator.comparingInt(List::size)).get();
        DPSpace.put(start, longestIncreaseSubsequence);
        return longestIncreaseSubsequence;
    }

    public static void main(String[] args) {
        List<Integer> input = Arrays.asList(10, 9, 2, 5, 3, 7, 101, 18);
        DP_Top_Bottom DP_Top_Bottom = new DP_Top_Bottom(input);
        List<Integer> longest = DP_Top_Bottom.getLongestIncreasingSubsequence(0, 0);
        System.out.println(longest);
    }
}
