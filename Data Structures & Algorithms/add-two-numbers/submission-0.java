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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        // notice that we can start adding from the back of the list
        // (starting from the ones digit)
        // - if l1 or l2 == null && the other is not null, then 
        //   add the other + carryOver to our new list
        // - case: if l1 + l2 + carryOver > 9, add (l1 + l2) % 10, 
        //         carry over tens digit (l1 + l2) / 10, set carryOver,
        //         l1 = l1.next, l2 = l2.next
        // - else: add l1 + l2 + carryOver to list, set carryOver = 0
        //         l1 = l1.next, l2 = l2.next

        int carryOver = 0; 
        ListNode sum = new ListNode();
        ListNode toReturn = sum;

        while (l1 != null || l2 != null || carryOver != 0) {
            
            if (l1 == null && l2 == null) {
                sum.val = carryOver;
                // set carryOver to 0
                carryOver = 0;
            } else if (l1 != null && l2 == null) {
                int total = l1.val + carryOver;
                sum.val = total % 10;
                carryOver = total / 10;
                l1 = l1.next;
            } else if (l1 == null && l2 != null) {
                int total = l2.val + carryOver;
                sum.val = total % 10;
                carryOver = total / 10;
                l2 = l2.next;
            } else {
                // consider carry over
                int total = l1.val + l2.val + carryOver;
                sum.val = total % 10;
                carryOver = total / 10;
                l1 = l1.next;
                l2 = l2.next;
            }

            // if we still need node for next result, create
            if (l1 != null || l2 != null || carryOver != 0) {
                sum.next = new ListNode();
                sum = sum.next;
            }
        }

        return toReturn;
    }
}
