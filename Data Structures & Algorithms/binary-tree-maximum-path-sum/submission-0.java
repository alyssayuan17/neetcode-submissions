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
    int globalMax = Integer.MIN_VALUE;

    public int maxPathSum(TreeNode root) {
        // use dfs to traverse the tree. at each node, take its left and right 
        // - if its left/right is negative, drop it, since it would make sum smaller
        // update globalMax -> this current path sum may be our max: 
        //      node.val + left + right
        // return to parent node -> since we can only return one path left/right,
        // take the max between left and right results from this current node
        // time: O(n) each node is visited once
        // space: O(n) worst case n call stacks

        dfs(root); // should update globalMax

        return globalMax;
    }

    public int dfs(TreeNode node) {
        if (node == null) {
            return 0;
        }

        int left = Math.max(0, dfs(node.left));
        int right = Math.max(0, dfs(node.right));

        globalMax = Math.max(globalMax, node.val + left + right); 
        // calculate curr path sum -> update globalMax

        return node.val + Math.max(left, right);
    }
}
