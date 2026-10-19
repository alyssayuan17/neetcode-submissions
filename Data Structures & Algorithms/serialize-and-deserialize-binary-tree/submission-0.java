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

public class Codec {
    int index = 0;

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        // store in preorder: node -> left -> right
        // dfs to traverse
        // if we encounter a null node, store the null node in our string
        // time: O(n) -> each node visited once
        // space: O(n) -> n call stacks + length n of nodeList
        ArrayList<Integer> nodeList = new ArrayList<>();

        dfsSerialize(root, nodeList);

        return nodeList.toString();
    }

    public void dfsSerialize(TreeNode node, ArrayList<Integer> nodeList) {
        if (node == null) {
            nodeList.add(null);
            return;
        } 

        nodeList.add(node.val);

        dfsSerialize(node.left, nodeList);
        dfsSerialize(node.right, nodeList);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        // [1, 2, null, null, 3, 4, null, null, 5, null, null]
        // first val is root
        // what should each dfs call return?
        // - the root to the subtree we just created
        // - base case: if null, return null
        // - the subtree we just created is the left/right of the parent node

        // remove all spaces, [, ]
        data = data.replace("[", "").replace("]", "").replace(" ", "");
        String[] vals = data.split(",");

        return dfsDeserialize(vals);
    }

    public TreeNode dfsDeserialize(String[] vals) {
        String val = vals[index++];
        if (val.equals("null")) {
            return null;
        }

        TreeNode node = new TreeNode(Integer.parseInt(val)); // make new node
        node.left = dfsDeserialize(vals); // left before right
        node.right = dfsDeserialize(vals);

        // return the subtree from this node to parent
        return node;
    }
}
