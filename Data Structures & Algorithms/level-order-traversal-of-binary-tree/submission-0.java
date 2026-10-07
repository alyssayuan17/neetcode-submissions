/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */

class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();

        if (root == null) {
            return result;
        }

        // use a queue to keep track of nodes in each level
        Queue<TreeNode> queue = new LinkedList<>();

        // root cannot be null
        queue.offer(root);

        // BFS -> since we explore level by level, iterative solution
        // makes the most sense for this problem, since level by level

        // time: O(n) since each node is visited once
        // space: O(n) since worst case we have n nodes in queue

        while (!queue.isEmpty()) {
            // take a snapshot of the queue size at given level
            int queueSize = queue.size();

            List<Integer> list = new ArrayList<>();

            // build our list for curr level
            for (int i = 0; i < queueSize; i++) {
                TreeNode node = queue.poll();
                list.add(node.val);

                // build queue for next level, since we are processing curr node
                if (node.left != null) {
                    queue.offer(node.left);
                }

                if (node.right != null) {
                    queue.offer(node.right);
                }

                // will continue for nodes further down the tree
                // after this loop, we have added all nodes for the next level
                // into our queue
            }

            result.add(list);
        }

        return result;
    }
}
