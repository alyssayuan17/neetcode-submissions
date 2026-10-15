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
    public int kthSmallest(TreeNode root, int k) {
        // notice we prioritize: left -> node -> right
        // use a list to track all the nodes in the tree in ascending order
        // take the k-1 th element
        // dfs to traverse left first, then node, then right
        // time: O(n), each node visited once
        // space: O(n), each node is stored once O(n) + O(n) = O(n) -> recursion

        ArrayList<Integer> seen = new ArrayList<>();

        dfs(root, seen);

        return seen.get(k-1);
    }

    public void dfs(TreeNode node, List<Integer> seen) {
        if (node == null) {
            return;
        }

        // call left side, then store current node, then call right side
        dfs(node.left, seen);

        seen.add(node.val); 

        dfs(node.right, seen);
    }
}
