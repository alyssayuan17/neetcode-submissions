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

    int diameter = 0; 

    public int diameterOfBinaryTree(TreeNode root) {
        // we need to find height of each subtree
        // use a helper function
        // the diameter is either the height or the sum of 
        // left + right

        height(root);

        return diameter;
    }
 
    public int height(TreeNode node) {
        if (node == null) return 0;

        int left = height(node.left);
        int right = height(node.right);

        // check if height is greater or left + right is greater
        diameter = Math.max(diameter, left + right);

        // return height to the parent call
        // the returned height becomes the left/right var in the 
        // parent call stack
        return 1 + Math.max(left, right);
    }
}
