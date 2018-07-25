package alogorithms.tree;

import alogorithms.structure.TreeNode;

import java.util.ArrayList;
import java.util.Stack;

/**
 * Created with IntelliJ IDEA
 * Author: aleng
 * Date  : 2018/7/16
 * Time  : 10:29
 * Description: Given a binary tree, return the preorder traversal of its nodes' values.
 **/
public class Code_089_PreorderTraversal {
    public ArrayList<Integer> preorderTraversal(TreeNode<Integer> root) {
        ArrayList<Integer> res = new ArrayList<>();
        Stack<TreeNode<Integer>> s1 = new Stack<>();
        if (root == null){
            return res;
        }
        s1.push(root);
        while (!s1.isEmpty()){
            TreeNode<Integer> pop = s1.pop();
            res.add(pop.val);
            if (pop.right != null){
                s1.push(pop.right);
            }
            if (pop.left != null){
                s1.push(pop.left);
            }
        }
        return res;
    }

}
/**
 * Given a binary tree, return the preorder traversal of its nodes' values.
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
 * return[1,2,3].
 *
 * Note: Recursive solution is trivial, could you do it iteratively?
 */