package Leetcode.Hash;

import java.util.HashMap;

/**
 * Input: nums = [2,7,11,15], target = 9
 * Output: [0,1]
 * Output: Because nums[0] + nums[1] == 9, we return [0, 1].
 */
public class TwoSum {
    public int[] getIndex(int[] input, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int[] result = new int[2];
        for (int i = 0; i < input.length; i++) {
            if (!map.containsKey(target - input[i])) {
                map.put(input[i], i);
            }
            if (map.containsKey(target - input[i])) {
                result[0] = map.get(target - input[i]);
                result[1] = i;
            }
        }
        return result;
    }
}
