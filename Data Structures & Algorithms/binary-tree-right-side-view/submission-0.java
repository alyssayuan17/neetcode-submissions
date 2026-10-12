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
    public List<Integer> rightSideView(TreeNode root) {
        // dps approach -> search right most side fully 
        // helper function to help find all on the right 
        // record the depth we have searched 
        // call recursive function on left after right has run
        // time: O(n) -> visit each node once
        // space: O(h) -> worst case we stack h (height) number of recursive calls

        List<Integer> result = new ArrayList<>();

        if (root == null) {
            return result;
        }

        // dfs should update result list
        dfs(root, 0, result);

        return result;
    }

    public void dfs(TreeNode node, int depth, List<Integer> result) {
        if (node == null) {
            // if node is null -> return, since we cannot keep searching
            return;
        }

        // check if it is the first time we have encountered a node at this depth
        if (depth == result.size()) {
            // add it to our result list
            result.add(node.val);
        }

        // search right first
        // then search left after we have hit null on the right
        dfs(node.right, depth + 1, result);
        dfs(node.left, depth + 1, result);
    }
}
