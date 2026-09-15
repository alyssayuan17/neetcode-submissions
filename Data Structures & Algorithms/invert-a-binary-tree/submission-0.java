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
    public TreeNode invertTree(TreeNode root) {
        // notice that for each node, left and right are swapped
        // - traverse down from each left and right and continue
        //   calling on each node via recursion
        // - if current node is null, return null for that node
        // O(n) time, O(n) space (how many stack frames/recursive
        // calls can be active at the same time)
        // worst case is O(n) space, since n is the worst case height

        // base case: if null
        if (root == null) {
            return null;
        }

        TreeNode right = root.right;
        TreeNode left = root.left;

        // perform swap
        root.right = left;
        root.left = right;

        // call function on each branch
        invertTree(root.right);
        invertTree(root.left);

        return root;
    }
}
