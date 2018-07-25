package alogorithms.tree;

import alogorithms.structure.TreeNode;

import javax.naming.LinkLoopException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Stack;

/**
 * Created with IntelliJ IDEA
 * Author: aleng
 * Date  : 2018/7/24
 * Time  : 9:26
 * Description: Given a binary tree, return the bottom-up level order traversal of its nodes' values. (ie, from left to right, level by level from leaf to root).
 **/
public class Code_116_LevelOrderBottom {
    public ArrayList<ArrayList<Integer>> levelOrderBottom(TreeNode root) {
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        ArrayList<Integer> cur = new ArrayList<>();
        Stack<ArrayList> s1 = new Stack<>();
        LinkedList<TreeNode> l1 = new LinkedList<>();
        if (root == null){
            return res;
        }
        l1.add(root);
        int start = 0;
        int end = 1;
        while (!l1.isEmpty()){
            TreeNode<Integer> node = l1.pollFirst();
            start++;
            cur.add(node.val);
            if (node.left != null){
                l1.add(node.left);
            }
            if (node.right != null){
                l1.add(node.right);
            }
            if (start == end){
                s1.push(new ArrayList(cur));
                cur.clear();
                start = 0;
                end = l1.size();
            }
        }
        while (!s1.isEmpty()){
            res.add(s1.pop());
        }
        return res;
    }
}
/**
 * Given a binary tree, return the bottom-up level order traversal of its nodes' values. (ie, from left to right, level by level from leaf to root).
 *
 * For example:
 * Given binary tree{3,9,20,#,#,15,7},
 *
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 *
 * return its bottom-up level order traversal as:
 *
 * [
 *   [15,7]
 *   [9,20],
 *   [3],
 * ]
 */
