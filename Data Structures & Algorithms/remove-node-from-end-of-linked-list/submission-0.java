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
        // calculate length of the linked list
        // len - n = index to remove
        // start from beginning of linked list: if counter == index,
        // remove that node
        // else, counter++, current = current.next

        // find length of linked list
        ListNode current = head;
        int len = 0;

        while (current != null) {
            len++;
            current = current.next;
        }

        int indexToRemove = len - n;

        // if indexToRemove = 0, it means that we can just return
        // the second node
        if (indexToRemove == 0) {
            return head.next;
        }

        int counter = 0;

        current = head;
        ListNode prev = head;
        while (current != null) {
            if (counter == indexToRemove) {
                prev.next = current.next;
                break;
            }
            counter++;
            prev = current; 
            current = current.next;
        }

        return head;
    }
}
