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
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        // since both lists are already sorted into ascending order,
        // the head of each should be the next lowest number to insert
        // compare the two:
        // - if list1.val < list2.val -> current.next = list1,
        //   current = current.next, continue
        // - else, current.next = list2, current = current.next, ...

        // check edge cases:
        // - if list1 is null
        // - if list2 is null
        if (list1 == null) {
            return list2;
        } 

        if (list2 == null) {
            return list1;
        } 

        ListNode current; 

        // start off with the smallest head of the two
        if (list1.val < list2.val) {
            current = list1;
            list1 = list1.next;
        } else {
            current = list2;
            list2 = list2.next;
        }

        // new node to point to the beginning (for return)
        ListNode merged = current;

        // iterate while both are not null
        while (list1 != null && list2 != null) {
            if (list1.val < list2.val) { // if so, link list1 next
                current.next = list1;
                current = current.next;
                list1 = list1.next;
            } else {
                current.next = list2;
                current = current.next;
                list2 = list2.next;
            }
        }

        // check if list1 is null, if not, add everything remaining
        // since list2 must be null then
        if (list1 != null) {
            current.next = list1;
        }
        
        // same for list2
        if (list2 != null) {
            current.next = list2;
        }

        return merged;
    }
}