package alogorithms.tree;

import alogorithms.structure.TreeNode;

/**
 * Created with IntelliJ IDEA
 * Author: aleng
 * Date  : 2018/7/22
 * Time  : 19:35
 * Description:Given a binary tree, find the maximum path sum.
 **/
public class Code_111_MaxPathSum {

    int maxValue;

    public int maxPathSum(TreeNode root) {
        maxValue = Integer.MIN_VALUE;
        int b = maxPathDown(root);
        return maxValue;
    }

    private int maxPathDown(TreeNode<Integer> node) {
        if (node == null)
            return 0;
        int left = Math.max(0, maxPathDown(node.left));
        int right = Math.max(0, maxPathDown(node.right));
        maxValue = Math.max(maxValue, left + right + node.val);
        return Math.max(left, right) + node.val;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(-1);
//        root.left = new TreeNode(6);
//        root.right = new TreeNode(10);
//        root.left.left = new TreeNode(5);
//        root.left.right = new TreeNode(7);
//        root.right.left = new TreeNode(9);
//        root.right.right = new TreeNode(11);
        root.left = new TreeNode(8);
        root.right = new TreeNode(-1);

        Code_111_MaxPathSum test = new Code_111_MaxPathSum();
        System.out.println(test.maxPathSum(root));
    }
}
/**
 * Given a binary tree, find the maximum path sum.
 * <p>
 * The path may start and end at any node in the tree.
 * <p>
 * For example:
 * Given the below binary tree,
 * <p>
 * 1
 * / \
 * 2   3
 * <p>
 * Return 6.
 */