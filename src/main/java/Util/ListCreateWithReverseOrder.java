package Util;

import Leetcode.List.ListNode;

import java.util.Arrays;

public class ListCreateWithReverseOrder {
    public ListNode list;
    public int[] input;

    public ListCreateWithReverseOrder(int[] input) {
        this.list = null;
        this.input = input;
    }

    public void reverseCreate() {
        for (int i = 0; i < input.length; i++) {
            ListNode node = new ListNode(input[i]);
            if (i != 0) {
                node.next = list;
            }
            list = node;
        }
        displayList();
    }

    private void displayList() {
        System.out.println("the input array is ");
        System.out.println(Arrays.toString(input));
        ListNode listNode = list;
        while (listNode != null) {
            System.out.printf("%3d", listNode.val);
            listNode = listNode.next;
        }
        System.out.println();
    }
}
