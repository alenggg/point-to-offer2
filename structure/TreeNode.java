package alogorithms.structure;

import javax.swing.text.html.HTML;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * Created with IntelliJ IDEA
 * Author: aleng
 * Date  : 2018/5/30
 * Time  : 15:28
 * Description: 树节点
 **/
public class TreeNode<T> {
    public T val;
    public TreeNode<T> left;
    public TreeNode<T> right;

    public TreeNode(T val) {
        this.val = val;
        this.left = null;
        this.right = null;
    }

    //层序遍历
    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder("[");
        Queue<TreeNode<T>> queue = new LinkedList<>();
        queue.offer(this);
        TreeNode<T> temp;
        while (!queue.isEmpty()) {
            temp = queue.poll();
            stringBuilder.append(temp.val);
            stringBuilder.append(",");
            if (temp.left != null)
                queue.offer(temp.left);
            if (temp.right != null)
                queue.offer(temp.right);
        }
        stringBuilder.deleteCharAt(stringBuilder.lastIndexOf(","));
        stringBuilder.append("]");
        return stringBuilder.toString();
    }

    //将二叉树转换为双向链表后，toString无限循环，需使用本函数打印
    public String leftToRight() {
        TreeNode cur = this;
        StringBuilder ret = new StringBuilder();
        while (cur != null) {
            ret.append(cur.val);
            ret.append("\t");
            cur = cur.right;
        }
        return ret.toString();
    }

    public ArrayList<T> preOrder() {
        ArrayList<T> arrayList = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        stack.push(this);
        while (!stack.isEmpty()) {
            TreeNode pop = stack.pop();
            arrayList.add((T) pop.val);
            if (pop.right != null)
                stack.push(pop.right);
            if (pop.left != null)
                stack.push(pop.left);
        }
        return arrayList;
    }

    //中序遍历，左中右
    public ArrayList<T> inOrder() {
        ArrayList<T> arrayList = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode<T> head = this;
        while (!stack.isEmpty() || head != null) {
            if (head != null) {
                stack.push(head);
                head = head.left;
            } else {
                TreeNode pop = stack.pop();
                arrayList.add((T) pop.val);
                head = pop.right;
            }
        }
        return arrayList;
    }

    //后序遍历 左右中 (先把中右左的结果依次存在栈中，再从栈中读取结果就是后序遍历)
    public ArrayList<T> posOrder() {
        ArrayList<T> arrayList = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        Stack<TreeNode> res = new Stack<>();
        stack.push(this);
        while (!stack.isEmpty()) {
            TreeNode pop = stack.pop();
            //arrayList.add((T) pop.val);
            res.push(pop);
            if (pop.left != null)
                stack.push(pop.left);
            if (pop.right != null)
                stack.push(pop.right);

        }
        while (!res.isEmpty()) {
            arrayList.add((T) res.pop().val);
        }
        return arrayList;
    }
}