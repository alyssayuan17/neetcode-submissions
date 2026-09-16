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
    public int maxDepth(TreeNode root) {
        // keep track of the max depth
        // traverse the tree on both left and right, updating the max
        // return max

        int depth = 0;

        // if tree is null, depth is 0
        if (root == null) {
            return 0;
        }

        return depthHelper(root, 1); // since depth cannot be 0
    }

    public int depthHelper(TreeNode root, int depth) {

        // base case: if we went past a leaf, return the depth reached
        if (root == null) {
            return depth - 1;
        }

        // continue calling on left and right sides, taking the depth
        // value of both and comparing at the end
        int leftDepth = depthHelper(root.left, depth + 1);
        int rightDepth = depthHelper(root.right, depth + 1);

        // once we are done with our recursive runs, we should have
        // the correct leftDepth and rightDepth
        // return the largest one for our tree's max depth

        return Math.max(leftDepth, rightDepth);
    }
}
