package alogorithms.tree;

import alogorithms.structure.TreeNode;

import java.util.ArrayList;
import java.util.Stack;

/**
 * Created with IntelliJ IDEA
 * Author: aleng
 * Date  : 2018/5/10
 * Time  : 16:58
 * Description:之字形打印二叉树
 **/
public class Code20180510_Print2 {

    public static ArrayList<ArrayList<Integer>> print2(TreeNode pRoot) {
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        if (pRoot == null){
            return res;
        }
        ArrayList<Integer> list = new ArrayList<>();
        Stack<TreeNode> stack1 = new Stack<>();
        Stack<TreeNode> stack2 = new Stack<>();
        stack2.add(pRoot);
        int row = 1;
        int start = 0;
        int end = 1;
        while (!stack1.isEmpty() || !stack2.isEmpty()){
            if (row % 2 == 0){  //当前行是偶数行,开始从右节点存取
                TreeNode<Integer> node = stack1.pop();
                start++;
                list.add(node.val);
                if (node.right != null){
                    stack2.push(node.right);
                }
                if (node.left != null){
                    stack2.push(node.left);
                }
                if (start == end){
                    res.add(new ArrayList<>(list)); //加入结果中
                    start = 0;
                    end = stack2.size();
                    list.clear();
                    row++;
                }
            }else {     //当前行是奇数行,开始从左节点存取
                TreeNode<Integer> node = stack2.pop();
                start++;
                list.add(node.val);
                if (node.left != null){
                    stack1.push(node.left);
                }
                if (node.right != null){
                    stack1.push(node.right);
                }
                if (start == end){
                    res.add(new ArrayList<>(list));
                    start = 0;
                    end = stack1.size();
                    list.clear();
                    row++;
                }
            }
        }
        return res;
    }
}
/**
 *
 * 题目:之字形打印二叉树
 * 请事先要给函数韩兆之字形顺序打印二叉树
 * 即第一行按照从左到右的顺序打印，第二层按照从右到左的顺序打印，以此类推。
 *
 */