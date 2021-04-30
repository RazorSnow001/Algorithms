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
        ListNode l3 = null;
        ListNode index = null;
        int carry = 0;
        int currentSum;
        int digit;
        while (l1 != null || l2 != null) {
            int val1 = (l1 == null) ? 0 : l1.val;
            int val2 = (l2 == null) ? 0 : l2.val;
            currentSum = val1 + val2 + carry;
            l1 = (l1 == null) ? null : l1.next;
            l2 = (l2 == null) ? null : l2.next;
            digit = currentSum % 10;
            carry = currentSum / 10;
            ListNode node = new ListNode(digit);
            if (l3 == null) {
                l3 = node;
            } else {
                index.next = node;
            }
            index = node;
        }
        if (carry == 1) {
            index.next = new ListNode(1);
        }
        return l3;
    }
}
