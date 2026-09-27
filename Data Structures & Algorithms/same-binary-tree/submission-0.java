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
    public boolean isSameTree(TreeNode p, TreeNode q) {
        // each iteration:
        // - check if both are null
        // - check if one is null and the other is not
        // - check if values are equal
        // - keep recursing on left and right

        if (p == null && q == null) {
            // if we reach this point and haven't returned false
            // yet, then p and q must be equal

            return true;
        }

        if  (p == null && q != null || p != null && q == null) {
            return false;
        }

        if (p.val != q.val) {
            return false;
        }

        return isSameTree(p.right, q.right) && 
                isSameTree(p.left, q.left);
    }
}
