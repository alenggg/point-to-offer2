package alogorithms.linklist;

import alogorithms.structure.ListNode;

/**
 * Created with IntelliJ IDEA
 * Author: aleng
 * Date  : 2018/4/26
 * Time  : 17:15
 * Description:链表中倒数第k个节点
 **/
public class Code20180426_FindKthToTail {
    public static ListNode findKthToTail(ListNode head, int k) {
        if (k <= 0 || head == null)
            return null;
        ListNode p = head;
        ListNode preNode = head;
        int i = 1;
        while (p.next != null) {
            i++;
            p = p.next;
            if (i > k) {
                preNode = preNode.next;
            }
        }
        if (i < k)
            return null;
        return preNode;
    }
}
/**
 *
 * 题目:链表中倒数第k个节点
 * 输入一个链表,输出该链表中倒数第k个节点。
 * 为了符合大多数人都习惯，本题从1开始计数，即链表的尾节点就是倒数第一个节点。
 * 例如，一个链表有6个节点，从头节点开始，他们的值依次是1，2，3，4，5，6.
 * 这个链表的倒数第3个节点是值为4的节点。
 * 链表的定义如下:
 * ListNode{
 * int value;
 * ListNode next = null;
 * }
 */