package Leetcode.List;

public class AddTwoNumbers {
    /*core logic is just to
     * 1 get the value
     * 2 add
     * 3 get the carry for the next sum operation
     * don't worry how to get the list with number just use the abstraction to finish the core ! and
     * last we will talk about the length problem --- if the two list with different length or
     * with the same length but we have the carry !*/
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode l3 = new ListNode();
        ListNode TraverseIndex = l3;
        int carry = 0;
        int currentSum;
        int digit;
        while (l1 != null && l2 != null) {
            currentSum = l1.val + l2.val + carry;
            l1 = l1.next;
            l2 = l2.next;
            digit = currentSum % 10;
            carry = currentSum / 10;
            TraverseIndex.val = digit;
            ListNode node = new ListNode();
            TraverseIndex.next = node;
            TraverseIndex = node;
        }
        if (carry == 1) {
            TraverseIndex.next = new ListNode(1);
        }
        return l3;
    }
}
