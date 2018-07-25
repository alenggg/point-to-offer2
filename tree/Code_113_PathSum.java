package alogorithms.tree;

import alogorithms.structure.TreeNode;

import java.util.ArrayList;

/**
 * Created with IntelliJ IDEA
 * Author: aleng
 * Date  : 2018/7/23
 * Time  : 9:55
 * Description: Given a binary tree and a sum, find all root-to-leaf paths where each path's sum equals the given sum.
 **/
public class Code_113_PathSum {
    public ArrayList<ArrayList<Integer>> pathSum(TreeNode<Integer> root, int sum) {
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        ArrayList<Integer> current = new ArrayList<>();
        pathSum(root,sum,current,res);
        return res;
    }

    private void pathSum(TreeNode<Integer> root, int sum, ArrayList<Integer> current, ArrayList<ArrayList<Integer>> res) {
        if (root == null){
            return;
        }
        int curVal = root.val;
        current.add(curVal);
        if (root.left == null && root.right == null && curVal == sum){
            res.add(new ArrayList<>(current));
            current.remove(current.size() - 1);
            return;
        }
        pathSum(root.left,sum-curVal,current,res);
        pathSum(root.right,sum-curVal,current,res);
        current.remove(current.size() - 1);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(-2);
        root.left = new TreeNode(-3);
//        root.right = new TreeNode(10);
//        root.left.left = new TreeNode(15);
//        root.left.right = new TreeNode(7);
//        root.right.left = new TreeNode(9);
//        root.right.right = new TreeNode(11);

        Code_113_PathSum test = new Code_113_PathSum();
        System.out.println(test.pathSum(root, -5));
    }
}
/**
 * Given a binary tree and a sum, find all root-to-leaf paths where each path's sum equals the given sum.
 *
 * For example:
 * Given the below binary tree andsum = 22,
 *               5
 *              / \
 *             4   8
 *            /   / \
 *           11  13  4
 *          /  \    / \
 *         7    2  5   1
 * return
 *
 * [
 *    [5,4,11,2],
 *    [5,8,4,5]
 * ]
 */