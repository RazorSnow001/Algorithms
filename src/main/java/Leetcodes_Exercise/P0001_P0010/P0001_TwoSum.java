package Leetcodes_Exercise.P0001_P0010;




import com.alibaba.fastjson.JSONObject;

import java.util.HashMap;

/*
 *  1 HashMap - how to use this one ?
 *
 * */
public class P0001_TwoSum {
    public int[] twoSum(int[] numbers, int target) {
        int[] result = new int[2];
        HashMap<Integer, Integer> records = new HashMap<>();

        for (int i = 0; i < numbers.length; i++) {
            int current = numbers[i];
            if (records.containsKey(target - current)) {
                result[1] = i;
                result[0] = records.get(target - current);
                break;
            } else {
                records.put(current, i);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        P0001_TwoSum test = new P0001_TwoSum();
        int[] numbers = {2, 7, 11, 15};
        int[] result = test.twoSum(numbers, 22);
        System.out.println(JSONObject.toJSONString(result));
    }


}
