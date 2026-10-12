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
    public List<Integer> rightSideView(TreeNode root) {
        // bfs approach -> use a queue to keep track of nodes in each level
        // -> take the last node on each level, since it would be our rightmost
        // time: O(n), visits each node once
        // space: O(n), since we store each node once in queue

        List<Integer> result = new ArrayList<>();

        if (root == null) {
            return result;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            // take the size at this level
            int size = queue.size();

            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();

                // if we are currently at the last node, add to our result list
                if (i == size - 1) {
                    result.add(node.val);
                }

                // add the next level of nodes to our queue
                // offer left side first, so right side stays our last in the level
                if (node.left != null) {
                    queue.offer(node.left);
                }
                
                if (node.right != null) {
                    queue.offer(node.right);
                }
            }
        }

        return result;
    }
}
