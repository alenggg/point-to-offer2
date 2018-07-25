package alogorithms.tree;

import alogorithms.structure.TreeNode;

/**
 * Created with IntelliJ IDEA
 * Author: aleng
 * Date  : 2018/7/15
 * Time  : 21:38
 * Description: 找出树的最小深度
 **/
public class Code_086_GetMinimumDepth {

    public static int run(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = run(root.left);
        int right = run(root.right);
        return (left == 0 || right == 0) ? left + right + 1 : left > right ? right + 1 : left + 1;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(8);
        root.left = new TreeNode(6);
        root.right = new TreeNode(10);
        root.left.left = new TreeNode(5);
        root.left.right = new TreeNode(7);
        System.out.println(run(root));

    }
}
