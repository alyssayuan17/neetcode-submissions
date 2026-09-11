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
        // O(n) time solution
        // notice that at the middle of the list is when the numbers
        // split -> use this to weave
        // - to find the middle: use slow and fast pointers
        // - when fast reaches the end, slow will be at the middle
        // - IMPORTANT DSA TRICK: after k iterations:
        //      - slow has moved k nodes
        //      - fast has moved 2k nodes

        ListNode first = head;
        ListNode second = head; // the second half; starting from mid

        ListNode fast = head;
        ListNode slow = head;

        while (fast.next != null && fast.next.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }

        second = slow.next; // because slow is the last node
        // of the first half, not the first node of the second
        slow.next = null;
        ListNode current = second;
        ListNode prev = null;

        // reverse the second half
        while (current != null) {
            ListNode next = current.next;
            current.next = prev;
            prev = current;
            current = next; 
        } 

        second = prev;

        // weave into the first half
        while (second != null) {
            // when second becomes null, there's nothing else to
            // weave in
            ListNode nextFirst = first.next;
            ListNode nextSecond = second.next;
            first.next = second;
            second.next = nextFirst;
            second = nextSecond;
            first = nextFirst;
        }
    }
}
