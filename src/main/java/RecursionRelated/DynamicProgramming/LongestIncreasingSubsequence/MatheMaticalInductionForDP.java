package RecursionRelated.DynamicProgramming.LongestIncreasingSubsequence;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

/*
 * in this case we will jump over the recursion and just come as we have finished
 *  the proving process .  now we want to use the k values to get the k+1 value
 *  so for this problem how to do that ?
 *  the key is how we set the DP array and what the value in the DP array represent ?
 *  so let's do it !
 *  Input: nums = [10,9,2,5,3,7,101,18]
 *      records = [1,1,1,2,2,3,4,4]
 *  and now our demand is just find the max length --- actually an int number
 *  so maybe our DP array will store the number which represent the largest length .
 *  but here are two options : 1 the number represents the longest from the number
 *                             2 the number represents the longest end with current number
 *  but with the DP naturally . the bottom to top style . we'd better choose the 2
 *  ok now we write the codes  */
public class MatheMaticalInductionForDP {
    public int[] getLongest(int[] nums) {
        int[] records = new int[nums.length];
        Arrays.fill(records, 1);
        Comparator<NumberPair> compareWithRecord = (p1,p2)->p2.record-p1.record;
        Queue<NumberPair> queue = new PriorityQueue<>(compareWithRecord);
        for (int i = 0; i < nums.length; i++) {
            if (i != 0) {
                boolean isFilled = false;
                for (int j = 0; j < i; j++) {
                    NumberPair newPair = new NumberPair();
                    newPair.setInputNum(nums[j]);
                    newPair.setRecord(records[j]);
                    queue.add(newPair);
                }
                while (!queue.isEmpty() && !isFilled) {
                    NumberPair maxRecordPair = queue.poll();
                    int input = maxRecordPair.getInputNum();
                    if (nums[i] > input ) {
                        records[i] = maxRecordPair.record + 1;
                        isFilled = true;
                    }
                    if (input == nums[i]) {
                        records[i] = maxRecordPair.record;
                        isFilled = true;
                    }
                }
                queue.clear();
            }
        }
        return records;
    }

    public static void main(String[] args) {
        int[] input = {10,9,2,5,3,7,101,18};
        MatheMaticalInductionForDP test = new MatheMaticalInductionForDP();
        int[] records = test.getLongest(input);
        System.out.println(Arrays.toString(records));
    }
}
