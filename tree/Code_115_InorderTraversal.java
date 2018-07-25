package alogorithms.tree;

import alogorithms.structure.TreeNode;

import java.util.ArrayList;
import java.util.Stack;

/**
 * Created with IntelliJ IDEA
 * Author: aleng
 * Date  : 2018/7/23
 * Time  : 15:42
 * Description: Given a binary tree, return the inorder traversal of its nodes' values.
 **/
public class Code_115_InorderTraversal {
    public ArrayList<Integer> inorderTraversal(TreeNode<Integer> root) {
        ArrayList<Integer> res = new ArrayList<>();
        Stack<TreeNode<Integer>> s1 = new Stack<>();
        if (root == null){
            return res;
        }
        while (!s1.isEmpty() || root != null){
            if (root != null){
                s1.push(root);
                root = root.left;
            }else {
                TreeNode<Integer> pop = s1.pop();
                res.add(pop.val);
                s1.add(pop.right);
            }
        }
        return res;
    }

    public static void main(String[] args) {

    }
}
/**
 * Given a binary tree, return the inorder traversal of its nodes' values.
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
 * return[1,3,2].
 *
 * Note: Recursive solution is trivial, could you do it iteratively?
 *
 * confused what"{1,#,2,3}"means? > read more on how binary tree is serialized on OJ.
 *
 *
 * OJ's Binary Tree Serialization:
 * The serialization of a binary tree follows a level order traversal, where '#' signifies a path terminator where no node exists below.
 *
 * Here's an example:
 *
 *    1
 *   / \
 *  2   3
 *     /
 *    4
 *     \
 *      5
 * The above binary tree is serialized as"{1,2,3,#,#,4,#,#,5}".
 */
