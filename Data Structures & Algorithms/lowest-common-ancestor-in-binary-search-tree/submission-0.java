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
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        // notice that since this is a binary search tree, if the curr node
        // is smaller than one of p and q and larger than the other, it must be
        // the LCA
        // - if root.val > p && root.val > q -> move left
        // - if root.val < p && root.val < q -> move right 
        // no need to consider the case where p and q do not exist 
        // time: O(h), where h is the height of the tree
        // space: O(h), since there will be at most h recursive call stacks

        if (root.val > p.val && root.val > q.val) {
            return lowestCommonAncestor(root.left, p, q);
        } else if (root.val < p.val && root.val < q.val) {
            return lowestCommonAncestor(root.right, p, q);
        } else {
            // else, it must be the LCA
            return root;
        }
    }
}
