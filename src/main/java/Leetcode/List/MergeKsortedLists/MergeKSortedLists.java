package Leetcode.List.MergeKsortedLists;

/*
 * that is the very interesting problem . which describe the
 * you know . the list of the arrays with the sorted numbers
 * and these sorted numbers we want to combine them
 * that is all .
 * so here are a lot of the methods to finish that
 * 1 using the divide and conquer to merge two list
 *   which is the result of the further recursion
 * 2 using the traditional index comparison technique to finish the job
 *   which means for each array in the list we add the index of the current of the array
 *   compare  and get the mini of that . move the index to further execution .
 * 3 ok that is the way !
 *   and here is another way to think about that !
 *   from the step two . so what is the priority queue in the java ?
 *   THE priority queue is very great .
 *   we can put a comparator in the priority queue to tell the detail of what kind of the priority we use !
 *   so we push all the elements of the list of arrays . into the priority queue
 *   and every time we pull the queue we get the elements satisfy the rule .
 * */

import java.util.*;

public class MergeKSortedLists {
    List<int[]> input;
    List<Integer> result = new ArrayList<>();

    public MergeKSortedLists(List<int[]> input) {
        this.input = input;
    }

    public void getSortedMergedList() {
        PriorityQueue<Integer> queue = new PriorityQueue(Comparator.comparingInt(o -> (Integer) o));
        input.forEach(array -> Arrays.stream(array).forEach(
                queue::add
        ));
        while (!queue.isEmpty()) {
            result.add(queue.poll());
        }
    }

    public static void main(String[] args) {
        List<int[]> input = Arrays.asList(new int[]{1, 3, 5}, new int[]{7, 11, 16, 22},
                new int[]{3, 4, 9, 18, 111}, new int[]{1, 2, 7, 9, 10, 33, 56, 67, 89},
                new int[]{8, 10, 23, 45, 46});
        MergeKSortedLists merge = new MergeKSortedLists(input);
        merge.getSortedMergedList();
        System.out.println(merge.result);
    }
}
