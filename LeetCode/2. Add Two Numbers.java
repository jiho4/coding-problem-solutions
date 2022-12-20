package leetcode;

/**
 * 2. Add Two Numbers
 * https://leetcode.com/problems/add-two-numbers/submissions/524937482/
 * solved: 2021-07-19
 */
class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummyHeadNode = new ListNode();
        ListNode currentNode = dummyHeadNode;
        int sum = 0;
        int carry = 0;
        int l1Value;
        int l2Value;

        while (l1 != null || l2 != null) {
            l1Value = (l1 != null) ? l1.val : 0;
            l2Value = (l2 != null) ? l2.val : 0;

            sum = l1Value + l2Value + carry;

            currentNode.next = new ListNode(sum % 10);
            carry = sum / 10;

            if (l1 != null) l1 = l1.next;
            if (l2 != null) l2 = l2.next;
            currentNode = currentNode.next;
        }

        if (carry > 0) {
            currentNode.next = new ListNode(carry);
        } else {}

        return dummyHeadNode.next;
    }
}

// (constraint) definition for singly-linked list
class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}
