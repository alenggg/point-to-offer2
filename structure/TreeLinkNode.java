package alogorithms.structure;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created with IntelliJ IDEA
 * Author: aleng
 * Date  : 2018/6/5
 * Time  : 10:00
 * Description: 树节点带指向父亲节点的指针
 **/
public class TreeLinkNode<T> {
    public T val;
    public TreeLinkNode<T> left;
    public TreeLinkNode<T> right;
    public TreeLinkNode<T> next;
    public TreeLinkNode(T val) {
        this.val = val;
        this.left = null;
        this.right = null;
        this.next = null;
    }

    //层序遍历
    @Override
    public String toString() {

        StringBuilder stringBuilder = new StringBuilder("[");
        Queue<TreeLinkNode<T>> queue = new LinkedList<>();
        queue.offer(this);
        TreeLinkNode<T> temp;
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
}
