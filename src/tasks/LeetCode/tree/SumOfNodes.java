package tasks.LeetCode.tree;

/**
 * 1315. Sum of Nodes with Even-Valued Grandparent
 * https://leetcode.com/problems/sum-of-nodes-with-even-valued-grandparent/
 */

/**
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
public class SumOfNodes {
    public int sumEvenGrandparent(TreeNode root) {
        return calculateSubSum(root, -103, -103);
    }

    private int calculateSubSum(TreeNode currentNode, int parentValue, int grandParentValue) {
        int subResult = 0;
        if (grandParentValue % 2 == 0) {
            subResult += currentNode.val;
        }
        if (currentNode.left != null) {
            subResult += calculateSubSum(currentNode.left, currentNode.val, parentValue);
        }
        if (currentNode.right != null) {
            subResult += calculateSubSum(currentNode.right, currentNode.val, parentValue);
        }
        return subResult;
    }
}
