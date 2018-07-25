package alogorithms.tree;

import alogorithms.structure.TreeNode;

import java.util.ArrayList;
import java.util.Stack;

/**
 * Created with IntelliJ IDEA
 * Author: aleng
 * Date  : 2018/7/16
 * Time  : 10:17
 * Description: 后序遍历二叉树
 **/
public class Code_088_PostOrderTraversal {
    public ArrayList<Integer> postorderTraversal(TreeNode<Integer> root) {
        ArrayList<Integer> res = new ArrayList<>();
        Stack<TreeNode<Integer>> s1 = new Stack<>();
        Stack<TreeNode<Integer>> s2 = new Stack<>();
        if (root == null){
            return res;
        }
        s1.push(root);
        while (!s1.isEmpty()){
            TreeNode pop = s1.pop();
            s2.push(pop);
            if (pop.left != null){
                s1.push(pop.left);
            }
            if (pop.right != null){
                s1.push(pop.right);
            }
        }
        while (!s2.isEmpty()){
            res.add(s2.pop().val);
        }
        return res;
    }
}
/**
 * Given a binary tree, return the postorder traversal of its nodes' values.
 *
 * For example:
 * Given binary tree{1,#,2,3},
 *
 *    1
 *     \
 *      2
 *     /
 *    3
 *
 * return[3,2,1].
 *
 * Note: Recursive solution is trivial, could you do it iteratively?
 */
