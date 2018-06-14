package alogorithms.tree;

import alogorithms.structure.TreeNode;

/**
 * Created with IntelliJ IDEA
 * Author: aleng
 * Date  : 2018/6/8
 * Time  : 16:41
 * Description: 平衡二叉树
 **/
public class code20180609_IsBalanced {

    public static boolean isBalanced(TreeNode<Integer> pRoot) {

        return isBalanced(pRoot, new int[]{0});
    }

    public static boolean isBalanced(TreeNode<Integer> node, int[] depth) {

        if (node == null) {
            depth[0] = 0;
            return true;
        }
        int[] left = new int[]{0};
        int[] right = new int[]{0};
        if (isBalanced(node.left, left) && isBalanced(node.right, right)) {
            int diff = left[0] - right[0];
            if (diff <= 1 && diff >= -1) {
                depth[0] = 1 + (left[0] > right[0] ? left[0] : right[0]);
                return true;
            } else
                return false;
        }
        return false;
    }

    public static void main(String[] args) {

    }
}
/**
 * 利用递归
 * 如果左子树和右子树都是平衡树，再判断
 */
