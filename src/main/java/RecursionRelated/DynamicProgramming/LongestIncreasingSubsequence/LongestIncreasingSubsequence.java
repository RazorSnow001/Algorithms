package RecursionRelated.DynamicProgramming.LongestIncreasingSubsequence;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
/*
 *  that is really an easy problem for the DP
 *  1 Input: nums = [10,9,2,5,3,7,101,18]
 *    we have a sequence with some numbers , we want to find the
 *    longest increased sequence ! ok so that is a best solution problem .
 *    optimal solution ?
 *    1 assume we got the solution ! [a1,a5,a7] as an example .
 *      yes you can use the back trace to find all the increased sequence from one node .
 *      so we find the feasible solution and compare and find the max length of the solution set
 *    2 but use the back tracing is bad in the performance and we will explore if the problem have the
 *      optimal structure ?
 *      does it have the optimal structure ?
 *      yes ! ok
 *      if we have the optimal solution set . ax and so on . we say all the subsequence of ax is also an
 *      optimal solution . we say the solution of the sub array except the current node .
 *    3 how to demonstrate we can use the DP
 *      1 as the 2 we say we should find the ok the optimal structure which means the sub problem solution will
 *      contribute to  the bigger problem solution .that is fair . and we can use the anti demonstration to
 *      confirm . it should be the optimal solution of the sub problem to contribute the optimal solution of the
 *      bigger problem . which means . if the current the optimal solution of the current layer is optimal .
 *      for example biggest  , largest  and so on . that is the story . ok why ? if the sub problem the solution is not the optimal
 *      solution or is not one of the optimal solution .what will happen ? we will find another bigger solution to replace the current
 *      solution of the sub problem . and if conflicts with the current bigger problem solution is the optimal solution .
 *      so we want things all right . at least decent  ! so the only way the current bigger problem solution is indeed the optimal solution ?
 *      is  ------------ the sub problem solution is optimal for its stage ! great ！ that is the view --- beautiful !
 *    4 back to this specific problem. how to write the code ?
 *      we all know writing codes is about managing the dependency !   ok that is great  so we highly recommend to using the graph to write
 *      actually  every single line  code
 *      ok  so what is the problem and what is the sub problem ?
 *      great question . for example . when we start at 10 . we traverse for the element --- number ---- which bigger than the 10
 *      we find 101 . and we should know the answer of the sub problem which start at 101 . ok now we know how to do that !
 *      so this paradigm . for one problem . it is one node . traverse all the number which is bigger than current number -- current node .
 *      and we have confirmed that is a DP problem . which we need to 1 use the solution set to check the potential solution  --- all the
 *      algorithms ---- not all ---- most of that is about the traversing --- enumeration  ! so how to enumerate smart is the most important thing !
 *      how to avoid repetition computing . which indeed increase the speed ! ok
 *      so the very first step is check the solution set .
 *      which will lead to the brute traverse ---- and we can make use of the constraint condition to improve the performance a little .
 *      but now . check if the problem . with its feasible solution to check if it has the optimal solution structure or the
 *      overlapping solution features . which leads to the DP solution .
 *      we can use both the bottom to top or the top to bottom solution. these actually the same solution . we do some improvement over the
 *      recursion solution . recursion !  recursion . why we use the recursion . recursion is about the sub problem but don't guarantee the
 *      overlapping sub problem .
 *      ok !
 *      that is quite great !
 *      so that is the approach for the analysis process .but how to write the code ! ?
 * */
public class LongestIncreasingSubsequence {
    public List<Integer> getLongestIncreasingSubsequence(List<Integer> input, int start, int number) {
        if (start == input.size() - 1) {
            List<Integer> increaseSubsequence = new ArrayList<>();
            if (input.get(start) > number) {
                increaseSubsequence.add(input.get(start));
            }
            return increaseSubsequence;
        }
        List<List<Integer>> currentList = new ArrayList<>();
        for (int i = start; i < input.size(); i++) {
            int currentNumber = input.get(i);
            List<Integer> increaseSubsequence = new ArrayList<>();
            if (currentNumber > number) {
                increaseSubsequence.add(input.get(i));
                increaseSubsequence.addAll(getLongestIncreasingSubsequence(input, i, input.get(i)));
            }
            currentList.add(increaseSubsequence);
        }
        return currentList.stream()
                .max(Comparator.comparingInt(List::size)).get();
    }

    public static void main(String[] args) {
        List<Integer> input = Arrays.asList(10, 9, 2, 5, 3, 7, 101, 18);
        LongestIncreasingSubsequence longestIncreaseSubsequence = new LongestIncreasingSubsequence();
        List<Integer> longest = longestIncreaseSubsequence.getLongestIncreasingSubsequence(input, 0, 0);
        System.out.println(longest);
    }

}
