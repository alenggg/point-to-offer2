package alogorithms.tree;

import alogorithms.structure.TreeLinkNode;
import alogorithms.structure.TreeNode;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * Created with IntelliJ IDEA
 * Author: aleng
 * Date  : 2018/7/22
 * Time  : 23:38
 * Description:Populate each next pointer to point to its next right node. If there is no next right node, the next pointer should be set toNULL.
 **/
public class Code_112_Connect {

    public static void connect(TreeLinkNode root) {
        LinkedList<TreeLinkNode> linkedList = new LinkedList();
        Stack<TreeLinkNode> s = new Stack<>();
        if (root == null) {
            return;
        }
        linkedList.add(root);
        TreeLinkNode next = null;
        TreeLinkNode cur = null;
        int start = 0;
        int end = 1;
        while (!linkedList.isEmpty()) {
            TreeLinkNode temp = linkedList.pollFirst();
            s.push(temp);
            start++;
            if (temp.left != null) {
                linkedList.add(temp.left);
            }
            if (temp.right != null) {
                linkedList.add(temp.right);
            }
            if (start == end){
                while (!s.isEmpty()){
                    cur = s.pop();
                    cur.next = next;
                    next = cur;
                }
                next = null;
                start = 0;
                end = linkedList.size();
            }
        }
    }

    public static void main(String[] args) {
        TreeLinkNode root = new TreeLinkNode(8);
        root.left = new TreeLinkNode(6);
        root.right = new TreeLinkNode(10);
        root.left.left = new TreeLinkNode(5);
        root.left.right = new TreeLinkNode(7);
        root.right.left = new TreeLinkNode(9);
        root.right.right = new TreeLinkNode(11);
        connect(root);
        System.out.println(root.right.next);
    }
}
/**
 * Given a binary tree
 * <p>
 * struct TreeLinkNode {
 * TreeLinkNode *left;
 * TreeLinkNode *right;
 * TreeLinkNode *next;
 * }
 * <p>
 * Populate each next pointer to point to its next right node. If there is no next right node, the next pointer should be set toNULL.
 * <p>
 * Initially, all next pointers are set toNULL.
 * <p>
 * Note:
 * <p>
 * You may only use constant extra space.
 * You may assume that it is a perfect binary tree (ie, all leaves are at the same level, and every parent has two children).
 * <p>
 * For example,
 * Given the following perfect binary tree,
 * <p>
 * 1
 * /  \
 * 2    3
 * / \  / \
 * 4  5  6  7
 * <p>
 * After calling your function, the tree should look like:
 * <p>
 * 1 -> NULL
 * /  \
 * 2 -> 3 -> NULL
 * / \  / \
 * 4->5->6->7 -> NULL
 */
