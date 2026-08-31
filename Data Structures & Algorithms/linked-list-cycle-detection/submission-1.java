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
        // O(n) space solution would be to store a HashSet with seen
        HashSet<ListNode> seen = new HashSet<>();

        ListNode current = head;

        while (current != null) {
            if (seen.contains(current)) {
                return true;
            }

            seen.add(current);
            current = current.next;
        }

        return false;
    }
}
