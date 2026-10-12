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
        // use a dfs approach -> use a recursive helper to build the result list
        // note that the result size is the number of good nodes to return 
        // use a stack (deque) to keep track of nodes to compare values we have seen
        // time: O(n) -> each node is visited once
        // space: O(n) -> worst case result stores all nodes in tree

        List<Integer> result = new ArrayList<>();
        Deque<TreeNode> stack = new ArrayDeque<>();

        dfs(root, result, stack);

        return result.size();
    }

    public void dfs(TreeNode node, List<Integer> result, Deque<TreeNode> stack) {
        // when we see a node, push to our stack
        // when we encounter a node, check against all nodes in the stack and 
        // check if it is greater than all -> push to result list
        // pop the stack after we exit recursive call

        if (node == null) {
            return;
        }

        int size = stack.size();
        boolean valid = true;

        for (TreeNode ancestor : stack) {
            if (node.val < ancestor.val) {
                valid = false;
            }
        }

        if (valid == true) {
            result.add(node.val);
        }

        // call dfs on the next nodes
        stack.push(node);
        
        dfs(node.right, result, stack);
        dfs(node.left, result, stack);
        // if we return on a level, we must pop all nodes as we exit the call
        stack.pop();
    }
}
