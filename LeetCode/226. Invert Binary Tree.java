package leetcode;

/**
 * 226. Invert Binary Tree
 * https://leetcode.com/problems/invert-binary-tree/submissions/877636032/
 * solved: 2023-01-13
 */
class Solution {
    public TreeNode invertTree(TreeNode root) {
        invertChildNodesOf(root);

        return root;
    }

    private void invertChildNodesOf(TreeNode node) {
        if (node == null) {
            return;
        }

        if (node.left != null) {
            invertChildNodesOf(node.left);
        }

        if (node.right != null) {
            invertChildNodesOf(node.right);
        }

        TreeNode temp = node.left;
        node.left = node.right;
        node.right = temp;
    }
}

// (constraints) Definition for a binary tree node.
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode() {}
    TreeNode(int val) { this.val = val; }
    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}
