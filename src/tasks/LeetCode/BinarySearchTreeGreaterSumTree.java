package tasks.LeetCode;

/**
 * 1038. Binary Search Tree to Greater Sum Tree
 * https://leetcode.com/problems/binary-search-tree-to-greater-sum-tree/
 */

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode() {}
 * TreeNode(int val) { this.val = val; }
 * TreeNode(int val, TreeNode left, TreeNode right) {
 * this.val = val;
 * this.left = left;
 * this.right = right;
 * }
 * }
 */
public class BinarySearchTreeGreaterSumTree {
    private int sum = 0;

    public TreeNode bstToGst(TreeNode root) {
        calculateSum(root);
        return root;
    }

    private void calculateSum(TreeNode currentNode) {
        if (currentNode == null) {
            return;
        }

        calculateSum(currentNode.right);
        sum += currentNode.val;
        currentNode.val = sum;
        calculateSum(currentNode.left);
        return;
    }
}
