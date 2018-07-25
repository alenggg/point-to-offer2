package alogorithms.tree;

import alogorithms.structure.TreeNode;

/**
 * Created with IntelliJ IDEA
 * Author: aleng
 * Date  : 2018/7/21
 * Time  : 21:56
 * Description: Given a binary tree, determine if it is height-balanced.
 **/
public class Code_108_IsBalanced {
    public boolean isBalanced(TreeNode root) {
        int[] depth = new int[1];
        return isBalanced(root,depth);
    }

    private boolean isBalanced(TreeNode root, int[] depth) {
        if (root == null){
            depth[0] = 0;
            return true;
        }
        int []l = new int[1];
        int r[] = new int[1];
        if (isBalanced(root.left,l) && isBalanced(root.right,r)){
            if (l[0] - r[0] > 1 || l[0] - r[0] < -1){
                return false;
            }else {
                depth[0] = l[0] > r[0] ? l[0] + 1 : r[0] + 1;
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {

    }
}
/**
 * Given a binary tree, determine if it is height-balanced.
 *
 * For this problem, a height-balanced binary tree is defined as a binary tree in which the depth of the two subtrees of every node never differ by more than 1.
 */