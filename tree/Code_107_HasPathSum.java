package alogorithms.tree;

import alogorithms.structure.TreeNode;

/**
 * Created with IntelliJ IDEA
 * Author: aleng
 * Date  : 2018/7/21
 * Time  : 21:43
 * Description:Given a binary tree and a sum, determine if the tree has a root-to-leaf path such that adding up all the values along the path equals the given sum.
 *
 **/
public class Code_107_HasPathSum {
    public boolean hasPathSum(TreeNode<Integer> root, int sum) {
        if (root == null){
            return false;
        }
        int curVal = root.val;
        if (root.left == null && root.right == null && curVal == sum){
            return true;
        }
        return hasPathSum(root.left,sum - curVal) || hasPathSum(root.right,sum - curVal);
    }

    public static void main(String[] args) {

    }
}
/**
 * Given a binary tree and a sum, determine if the tree has a root-to-leaf path such that adding up all the values along the path equals the given sum.
 *
 * For example:
 * Given the below binary tree andsum = 22,
 *               5
 *              / \
 *             4   8
 *            /   / \
 *           11  13  4
 *          /  \      \
 *         7    2      1
 * return true, as there exist a root-to-leaf path5->4->11->2which sum is 22.
 */