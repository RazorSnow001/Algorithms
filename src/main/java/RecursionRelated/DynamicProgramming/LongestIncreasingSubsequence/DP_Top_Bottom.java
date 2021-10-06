package RecursionRelated.DynamicProgramming.LongestIncreasingSubsequence;

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
 *   we add the space to store the result . so  where to add this cache ?
 * 4 we have to admitted that the previous structure is awful . because we have to use a 0 to begin the whole story .
 !    that leads to some code which is hard to understand . so in our general case . we write codes to represent themselves
 !    so we want to adjust the codes into
      1 for one list of integer we want to get the max sequence of that !
      　
 */
public class DP_Top_Bottom {


}
