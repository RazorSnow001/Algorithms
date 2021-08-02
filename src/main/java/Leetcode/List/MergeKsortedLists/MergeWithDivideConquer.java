package Leetcode.List.MergeKsortedLists;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class MergeWithDivideConquer {
    List<Integer[]> input;
    public MergeWithDivideConquer(List<Integer[]> input) {
        this.input = input;
    }

    public List<Integer> execute(int left, int right) {
        if (left == right) {
            return Arrays.stream(input.get(left)).collect(Collectors.toList());
        }
        if (right - left == 1) {
            return mergeTwoList(Arrays.stream(input.get(left)).collect(Collectors.toList()),
                    Arrays.stream(input.get(right)).collect(Collectors.toList()));
        }
        int mid = (left + right) / 2;
        List<Integer> leftResult = execute(left, mid);
        List<Integer> rightResult = execute(mid + 1, right);
        return mergeTwoList(leftResult, rightResult);

    }

    public List<Integer> mergeTwoList(List<Integer> leftResult, List<Integer> rightResult) {
        int leftResultIndex = 0;
        int rightResultIndex = 0;
        List<Integer> result = new ArrayList<>();
        while (leftResultIndex != leftResult.size() && rightResultIndex != rightResult.size()) {
            if (leftResult.get(leftResultIndex) <= rightResult.get(rightResultIndex)) {
                result.add(leftResult.get(leftResultIndex));
                leftResultIndex++;
            } else {
                result.add(rightResult.get(rightResultIndex));
                rightResultIndex++;
            }
        }
        if (leftResultIndex == leftResult.size()) {
            result.addAll(rightResult.subList(rightResultIndex, rightResult.size()));
        } else {
            result.addAll(leftResult.subList(leftResultIndex, leftResult.size()));
        }
        return result;
    }

    public static void main(String[] args) {
        List<Integer[]> input = Arrays.asList(new Integer[]{1, 3, 5}, new Integer[]{7, 11, 16, 22},
                new Integer[]{3, 4, 9, 18, 111}, new Integer[]{1, 2, 7, 9, 10, 33, 56, 67, 89},
                new Integer[]{8, 10, 23, 45, 46});
        MergeWithDivideConquer merge = new MergeWithDivideConquer(input);
        List<Integer> result = merge.execute(0, input.size() - 1);
        System.out.println(result);
    }
}
