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
    HashMap<Integer, Integer> map = new HashMap<>();
    int preIndex = 0;

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        // preorder: root -> left -> right
        // inorder: left -> root -> right
        // notice that first element in preorder arr is the root
        // spliting the inorder array at the root element, the left are the nodes
        // in the left subtree and the right are the nodes in right subtree
        // repeat for each subtree, the first in the preorder arr is root again
        // use a dfs approach to traverse this tree -> divide and conquer 
        // - num of nodes in left/right are the size of inorder divided
        // - take that many elements from the preorder arr to return
        // time: O(n) -> traverse preorder arr once
        // space: O(n) -> use hashmap for constant lookup for root index + call stacks

        // an entry would be <node, index>

        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i); // store each node and index in inorder arr
        }

        return dfs(0, inorder.length - 1, preorder);
    }

    // only need to pass along indices from the preorder arr we need
    public TreeNode dfs(int left, int right, int[] preorder) {
        if (left > right) {
            // no more nodes to add
            return null;
        }

        TreeNode node = new TreeNode(preorder[preIndex]);

        int partition = map.get(node.val);
        preIndex++;
        // 1, partition - 1 -> left
        // partitio + 1, preorder.length() - 1 -> right

        node.left = dfs(left, partition - 1, preorder);
        node.right = dfs(partition + 1, right, preorder);

        return node;
    }
}
