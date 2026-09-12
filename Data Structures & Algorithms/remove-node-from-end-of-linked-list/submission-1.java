/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */

class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        // second solution: fast and slow pointers
        // - put fast n nodes ahead of slow, and when fast 
        //   reaches the end, slow will be at the node we need
        
        ListNode fast = head;
        ListNode slow = head;

        for (int i = 0; i < n; i++) {
            fast = fast.next;
        }

        // check edge case: if fast == null, it means that 
        // we are removing the first node in the list
        if (fast == null) {
            return head.next;
        }

        ListNode prev = head;

        while (fast != null) {
            prev = slow;
            fast = fast.next;
            slow = slow.next; 
        }

        // once we exit this loop, slow will be the one to remove
        prev.next = slow.next;

        return head;
    }
}
