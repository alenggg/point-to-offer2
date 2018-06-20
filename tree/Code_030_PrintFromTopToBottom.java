package alogorithms.tree;

import alogorithms.structure.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;

/**
 * Created with IntelliJ IDEA
 * Author: aleng
 * Date  : 2018/5/8
 * Time  : 16:56
 * Description:从上到下打印二叉树
 **/
public class Code_030_PrintFromTopToBottom {

    public ArrayList<Integer> printFromTopToBottom(TreeNode root) {

        ArrayList<Integer> list = new ArrayList<>();
        if (root == null){
            return list;
        }
        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()){
            TreeNode<Integer> node = queue.poll();
            if (node.left != null){
                queue.addLast(node.left);
            }
            if (node.right != null){
                queue.addLast(node.right);
            }
            list.add(node.val);
        }
        return list;
    }
}
/**
 *
 * 题目:从上到下打印二叉树
 * 不分行从上到下打印二叉树
 * 从上到下打印出二叉树的每个节点，同一层的节点按照从左到右的顺序打印
 *
 * 打印谁就把它的儿子入队列
 */