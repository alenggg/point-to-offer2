package alogorithms.tree;

import alogorithms.structure.TreeNode;

import java.util.Stack;

/**
 * Created with IntelliJ IDEA
 * Author: aleng
 * Date  : 2018/5/4
 * Time  : 16:55
 * Description:二叉树的镜像
 **/
public class Code_026_Mirror {

    public void mirror(TreeNode root) { //非递归做法
        if (root == null) {
            return;
        }
        Stack<TreeNode> stack = new Stack<>();
        while (root != null || !stack.isEmpty()) {
            while (root != null) {
                TreeNode temp = root.left;
                root.left = root.right;
                root.right = temp;
                stack.push(root);
                root = root.left;
            }
            if (!stack.isEmpty()) {
                root = stack.pop();
                root = root.right;
            }
        }
    }
    public void mirror2(TreeNode root){
        if (root == null) {
            return;
        }
        if (root.left == null && root.right == null){
            return;
        }
        //1.反转节点左右孩子
        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;
        //2.递归
        mirror2(root.left);
        mirror2(root.right);
    }
}
/**
 * 5月4号
 * 题目:二叉树的镜像
 * 操作给定的二叉树，将其变换为源二叉树的镜像。
 * 思路：使用递归或非递归方式交换每个节点的左右子树位置
 */