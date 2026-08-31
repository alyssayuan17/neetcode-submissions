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
    public boolean hasCycle(ListNode head) {
        // O(n) time O(1) space solution
        // use two pointers: one fast one slow
        // - the faster pointer will eventually == the slower poiner
        // - if fast == slow, return true
        // - else, false

        ListNode slow = head;
        ListNode fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;

            if (slow == fast) { 
                // can use "==" since we are comparing references
                return true;
            }
        }

        return false;
    }
}
