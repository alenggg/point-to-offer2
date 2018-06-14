package alogorithms.linklist;

import alogorithms.structure.ListNode;

/**
 * Created with IntelliJ IDEA
 * Author: aleng
 * Date  : 2018/6/14
 * Time  : 17:18
 * Description:反转链表
 **/
public class Code20180428_ReverseList {

    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode preNode = null;
        ListNode p = head;
        ListNode nextNode;
        while (p != null) {
            //先存下一个节点
            nextNode = p.next;
            //反转
            p.next = preNode;
            //节点右移
            preNode = p;
            p = nextNode;
        }
        return preNode;
    }
}
/**
 * 题目:反转链表
 * 定义一个函数，输入一个链表的头节点，反转该链表并输出反转后链表的
 * 头节点。
 * ListNode{
 * int value;
 * ListNode next = null;
 * }
 */