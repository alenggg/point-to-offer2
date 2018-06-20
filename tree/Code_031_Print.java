package alogorithms.tree;

import alogorithms.structure.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;

/**
 * Created with IntelliJ IDEA
 * Author: aleng
 * Date  : 2018/5/9
 * Time  : 16:57
 * Description:分行从上到下打印二叉树
 **/
public class Code_031_Print {

    public static ArrayList<ArrayList<Integer>>  print(TreeNode<Integer> pRoot) {

        ArrayList<Integer> list = new ArrayList<>();
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        if (pRoot == null){
            return res;
        }
        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.add(pRoot);
        int start = 0;
        int end = 1;
        while (!queue.isEmpty()){
            TreeNode<Integer> node = queue.poll();
            list.add(node.val);
            start++;
            if (node.left != null){
                queue.addLast(node.left);
            }
            if (node.right != null){
                queue.addLast(node.right);
            }
            if (start == end){
                start = 0;
                end = queue.size();
                res.add(new ArrayList<>(list));
                list.clear();
            }
        }
        return res;
    }
}
/**
 * 5月9号
 * 题目:分行从上到下打印二叉树
 * 从上到下按层打印二叉树，同一层的节点按从左到右的顺序打印，每一层打印到一样。
 *
 */