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

    public boolean isBalanced(TreeNode root) {
        // implement helper to traverse left and right
        // calculate height, compare at the end

        return balanceHelper(root) != -1;
    }

    public int balanceHelper(TreeNode node) {
        if (node == null) {
            return 0; 
        }

        int lHeight = balanceHelper(node.left);
        int rHeight = balanceHelper(node.right);

        // check if left and right are already unbalanced
        if (lHeight == -1) {
            return -1;
        }

        if (rHeight == -1) {
            return -1;
        }

        if (Math.abs(lHeight - rHeight) > 1) {
            return -1;
        }

        return 1 + Math.max(lHeight, rHeight);
    }
}
