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
    public ListNode reverseList(ListNode head) {
        if (head == null) {
            return null;
        }

        if (head.next == null) {
            return head;
        }

        // need to save the curr node, make it the "next" node for the
        // next node, continue
        // if curr node next is null, return that node

        // create new pointer to head to not change head's address
        ListNode current = head; 

        // create node for prev node, start as null
        ListNode prev = null;
        
        while(current != null) {
            // save address for next of curr
            ListNode next = current.next;

            // let current.next = prev
            current.next = prev;

            // save current node as the new prev
            prev = current;
            
            // continue iterating on linked list
            current = next;
            // will be null when reached the end, so next iteration 
            // won't run
        }

        return prev;
    }
}
