package alogorithms.tree;

import alogorithms.structure.TreeNode;

import java.util.Stack;

/**
 * Created with IntelliJ IDEA
 * Author: aleng
 * Date  : 2018/6/7
 * Time  : 11:26
 * Description: 二叉搜索树的第k大节点
 **/
public class Code20180607_KthNode {

    public static TreeNode<Integer> kthNode(TreeNode<Integer> pRoot, int k) {
        //栈顶元素保证一直是cur的父节点
        if (pRoot == null || k < 0)
            return null;
        Stack<TreeNode<Integer>> stack = new Stack<>();
        TreeNode<Integer> cur = pRoot;
        int count = 0;
        while (!stack.isEmpty() || cur != null) {
            if (cur != null) {
                stack.push(cur);
                cur = cur.left;
            } else {
                cur = stack.pop();
                count++;
                if (count == k)
                    return cur;
                cur = cur.right;
            }
        }
        return null;
    }

    public static void main(String[] args) {
        TreeNode<Integer> root = new TreeNode<>(5);
        root.left = new TreeNode<>(3);
        root.left.left = new TreeNode<>(2);
        root.left.right = new TreeNode<>(4);
        root.right = new TreeNode<>(7);
        root.right.left = new TreeNode<>(6);
        root.right.right = new TreeNode<>(8);
        System.out.println(root.toString());
        System.out.println(kthNode(root, 3).val);//4
        System.out.println(kthNode(root, 6).val);//7
        System.out.println(kthNode(root, 8));//null
    }
}
/*
给定一棵二叉搜索树，请找出其中第k大的节点。

其实就是中序遍历 左中右
 */