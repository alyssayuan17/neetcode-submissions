/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList(Node head) {
        // need a hashmap to store nodes we have already seen
        // <old node, copy node>
        HashMap<Node, Node> seen = new HashMap<>();

        // new list
        Node newList = null;

        Node current = head;

        // iterate once to store all copies in hashmap
        while (current != null) {
            if (!seen.containsKey(current)) {
                seen.put(current, new Node(current.val));
                // new node's next and random are null
            }

            current = current.next;
        }

        // on the second pass, connect all the stored copies of nodes
        current = head;
        while (current != null) {
            newList = seen.get(current);
            newList.next = seen.get(current.next);
            newList.random = seen.get(current.random);

            current = current.next;
        }

        return seen.get(head);
    }
}
