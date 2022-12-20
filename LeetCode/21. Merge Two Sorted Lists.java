package leetcode;

/**
 * 21. Merge Two Sorted Lists
 * https://leetcode.com/problems/merge-two-sorted-lists/submissions/560216242/
 * solved: 2021-09-24
 */
class Solution {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode mergedList = new ListNode();
        ListNode pointer = mergedList;

        ListNode currNode1 = l1;
        ListNode currNode2 = l2;

        while (currNode1 != null && currNode2 != null) {
            if (currNode1.val > currNode2.val) {
                pointer.next = currNode2;
                currNode2 = currNode2.next;
            } else {
                pointer.next = currNode1;
                currNode1 = currNode1.next;
            }

            pointer = pointer.next;
        }

        // 'while' loop is over means, one of the list is not remaining
        if (currNode1 == null) {
            pointer.next = currNode2;
        } else {
            pointer.next = currNode1;
        }

        return mergedList.next;
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
