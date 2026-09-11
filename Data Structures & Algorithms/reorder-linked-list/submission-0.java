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
    public void reorderList(ListNode head) {
        // brute force solution is to find the last node
        // for each node and attach it
        // time: O(n^2), space: O(1)

        ListNode current = head;

        // iterating from the left side
        while (current != null && current.next != null) { 
            // check current.next != null, since we cannot check
            // null.next, it will throw error
            ListNode last = current;
            ListNode toInsert = last;
            // find last node in linked list
            while (last.next != null && last.next.next != null) {
                last = last.next;
            }
            
            toInsert = last.next;
            last.next = null;

            toInsert.next = current.next;
            current.next = toInsert;
            current = current.next.next; // continue
        }
    }
}
