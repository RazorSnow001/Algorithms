package RecursionRelated.DynamicProgramming;

import java.util.List;

/*
*  that is really a easy problem for the DP
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
*      if we have the optimal solution set . ax and so on . we say all the sub sequence of ax is also a
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
*      actully every code
*
*
* */
public class LongestIncreasingSubsequence {

    public List<Integer> getLongestIncreasingSubsequence(List<Integer> input, int start){

    }


}
