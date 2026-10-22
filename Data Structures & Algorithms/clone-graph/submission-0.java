/*
Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/

class Solution {
    public Node cloneGraph(Node node) {
        if (node == null) {
            return null;
        }

        ArrayDeque<Node> queue = new ArrayDeque<>();
        HashMap<Integer, Node> seen = new HashMap<>();
        // insert our first given node into queue
        queue.offer(node);
        // make copy of first node
        Node newNode = new Node(node.val);
        // add into seen 
        seen.put(newNode.val, newNode);
            
        while (!queue.isEmpty()) {
            Node curr = queue.poll();
            // since we are creating copies as we discover them, if they come from the 
            // queue, we have already discovered them, thus, no need to copy again
            // get copy
            Node currCopy = seen.get(curr.val); // have yet to build list for copy yet
            List<Node> neighbours = curr.neighbors;
            List<Node> neighboursCopy = new ArrayList<>();
                    
            for (Node neighbour : neighbours) {
                // process neighbours 
                if (!seen.containsKey(neighbour.val)) {
                    // we have not seen yet → create copy + add to queue
                    Node copy = new Node(neighbour.val);
                    neighboursCopy.add(copy);
                    seen.put(copy.val, copy);
                    queue.offer(neighbour);
                } else { // else, get the copied node stored in map and add to list
                    neighboursCopy.add(seen.get(neighbour.val));
                }
            }

            currCopy.neighbors = neighboursCopy;
        }

        // return copy of the first node given
        return newNode;
    }
}