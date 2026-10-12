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
        // - keep a stack of all the max nodes we have encountered
        // peek at top of the stack for the one we currently need
        // time: O(n), visit each node once without needing to iterate stack
        // space: O(n), worst case -> stack: O(n), recursive calls: O(n)

        Deque<Integer> stack = new ArrayDeque<>();

        stack.push(root.val);

        // the top of our stack will be the max val we've seen thus far
        int count = dfs(root, stack);

        return count;
    }

    public int dfs(TreeNode node, Deque<Integer> stack) {
        // base case -> check null
        if (node == null) {
            return 0;
        }

        int count = 0;

        // compare node w stack.peek -> max
        if (node.val >= stack.peek()) {
            count++;
        } 

        int max = Math.max(node.val, stack.peek());

        stack.push(max);

        // recursively call right and left
        count += dfs(node.right, stack);
        count += dfs(node.left, stack);

        // pop our stack
        stack.pop();

        return count;
    }
}
