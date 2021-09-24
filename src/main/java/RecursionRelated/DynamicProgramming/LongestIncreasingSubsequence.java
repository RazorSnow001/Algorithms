package RecursionRelated.DynamicProgramming;

import java.util.List;

/*
*  that is really a easy problem for the DP
*  1 Input: nums = [10,9,2,5,3,7,101,18]
*    we have a sequence with some numbers and we want to find the
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
*      反证法 可以轻松 判断出最优子结构 就是说如果除去当前数字之后的子数组 的最大子序列 和当前数一起构成了最大的递增序列
*      这是事实 更好一点说就是说 ok 以当前数字开头的子数组的最大序列。应该更确切的说就是 包含当前数的序列是最大
*      那么其中后一个数和这个数开头的子序列也是最大的 因为如果它不是最大或者不是最大之一，那么意味着我可以找到一组也是以这个节点开始
*      的更长的单调递增子序列，那么这个子序列因为也是以这个数字开头的所以可以完美做替代和前面一个数字组成单调递增子序列
*      那么就得到一个更大的结果 这和我们说的一开始的结论或者说前提 就是当前解是一个最优解 是矛盾的
*      因此我们不能这样做！ 所以说有最优子结构 也就是 子问题的最优解会直接为更大问题的最优解贡献 ok
*      这当然没有一点问题啦 ok 这个可以
*      那么 重叠子问题 ? 这个好判断 就是说 对于一个确定长度或者说 开头确定的子数组 假设我们已经知道了它的最优解。那么根据最优子结构。
*      我们可以进行复用! 我其实已经解决这个问题了
*      就是比如我们目前的数字是10 找 后续的比10大的数字 找到以后呢 这个数字开头的 最大我们认为已经有答案了 。
*      那么其实是可以用list list 来做的 list 的下表跟我们的input 的下标对齐就好了
*
* */
public class LongestIncreasingSubsequence {

    public List<Integer> getLongestIncreasingSubsequence(List<Integer> input, int start){

    }


}
