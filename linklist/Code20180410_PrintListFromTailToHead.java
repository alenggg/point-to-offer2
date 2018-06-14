package alogorithms.linklist;
import alogorithms.structure.ListNode;

import java.util.ArrayList;
import java.util.Stack;

/**
 * Created with IntelliJ IDEA
 * Author: aleng
 * Date  : 2018/4/10
 * Time  : 17:09
 * Description:反转链表
 **/
public class Code20180410_PrintListFromTailToHead {

    public static ArrayList<Integer> printListFromTailToHead(ListNode<Integer> listNode) {
        ArrayList<Integer> arrayList = new ArrayList<Integer>();
        Stack<ListNode<Integer>> stack = new Stack<ListNode<Integer>>();
        if (listNode == null) {
            return arrayList;
        }
        while (listNode != null) {
            stack.push(listNode);
            listNode = listNode.next;
        }
        while (!stack.isEmpty()) {
            arrayList.add(stack.pop().val);
        }
        return arrayList;
    }

    /**
     * 利用递归
     */
    public static ArrayList<Integer> printListFromTailToHead2(ListNode<Integer> listNode) {
        ArrayList<Integer> arrayList = new ArrayList<Integer>();
        if (listNode != null) {
            if (listNode.next != null) {
                arrayList = printListFromTailToHead2(listNode.next);
                arrayList.add(listNode.val);
            } else {
                arrayList.add(listNode.val);
            }
        }

        return arrayList;
    }
}
/**
 *
 * 题目:输入一个链表的头节点，从尾到头反过来打印出每个节点的值。
 * (1)将链表中的链接节点的指针反转过来，改变链表的方向，但是这种方法会海标链表的结构
 * (2)不允许改变链表的结构
 * 利用栈结构实现反转
 */