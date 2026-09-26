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
        // we need the heights of subtrees to calculate diameter
        // height() explores the whole tree and updates diameter

        height(root);

        return diameter;
    }
 
    public int height(TreeNode node) {
        if (node == null) return 0;

        // get height of left and right subtrees
        int left = height(node.left);
        int right = height(node.right);

        // diameter THROUGH this node = left height + right height
        // keep the biggest diameter we've seen anywhere
        diameter = Math.max(diameter, left + right);

        // return HEIGHT to the parent call
        // this returned value becomes the parent's left/right variable
        return 1 + Math.max(left, right);
    }
}
