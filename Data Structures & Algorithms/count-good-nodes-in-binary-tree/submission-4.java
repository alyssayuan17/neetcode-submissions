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
    public int goodNodes(TreeNode root) {
        // dfs approach -> recursive helper to keep track of how many good nodes
        // instead of using a stack and backtracking approach, keep track of 
        // the max value node we have seen 
        // - compare w current node -> if curr is greater, add to result
        // - since int is a primitive data type, updating it on the right doesn't
        //   change it on the left -> keep a maxSoFar
        // time: O(n), visit each node once 
        // space: O(n), worst case -> recursive calls: O(n)

        int maxSoFar = root.val;

        int count = dfs(root, maxSoFar);

        return count;
    }

    public int dfs(TreeNode node, int maxSoFar) {
        // base case -> check null
        if (node == null) {
            return 0;
        }

        int count = 0;

        // compare node w stack.peek -> max
        if (node.val >= maxSoFar) {
            count++;
        } 

        maxSoFar = Math.max(node.val, maxSoFar);

        // recursively call right and left
        count += dfs(node.right, maxSoFar);
        count += dfs(node.left, maxSoFar);

        return count;
    }
}