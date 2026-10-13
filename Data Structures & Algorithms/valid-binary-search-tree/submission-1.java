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
    public boolean isValidBST(TreeNode root) {
        // dfs approach: use a recursive helper to search both left and right fully
        // recursive helper -> returns true if hit null and no false, return false
        // if the current node val is greater/less than the curr max/min
        // update max/min to be the curr node val each time (since going left/right
        // from this curr node would make this the new max/min for the subtree)
        // time: O(n), each node is visited once
        // space: O(n), worst case recursive calls stack to num nodes in tree

        return validHelper(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    public boolean validHelper(TreeNode node, int min, int max) {
        if (node == null) {
            return true;
            // we have hit the end without returning a false
        }

        // check if curr node is in the valid range
        if (node.val >= max || node.val <= min) {
            return false;
        }

        return validHelper(node.right, node.val, max) && 
                validHelper(node.left, min, node.val);
    }
}
