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
    int count = 0;
    int result = 0;

    public int kthSmallest(TreeNode root, int k) {
        // dfs -> instead of storing all values in a list, track using a counter
        dfs(root, k);
        return result;
    }

    public void dfs(TreeNode node, int k) {
        // check if node is null or count is invalid
        if (node == null || count >= k) {
            return;
        }

        dfs(node.left, k);

        if (count >= k) {
            return;
        }

        count++; // count current node

        if (count == k) {
            // check if the current count reaches the value we want
            result = node.val;
            return;
        }

        // then check right
        dfs(node.right, k);
    }
}
