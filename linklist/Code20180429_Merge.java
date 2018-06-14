package alogorithms.linklist;

import alogorithms.structure.ListNode;

/**
 * Created with IntelliJ IDEA
 * Author: aleng
 * Date  : 2018/4/29
 * Time  : 17:19
 * Description:合并两个排序的链表
 **/
public class Code20180429_Merge {

    public ListNode<Integer> merge(ListNode<Integer> list1, ListNode<Integer> list2) {
        if (list1 == null)
            return list2;
        if (list2 == null)
            return list1;
        ListNode<Integer> phead = new ListNode(-1);
        ListNode<Integer> p = phead; //指针指向新建的头节点
        while (list1 != null && list2 != null) {
            if (list1.val < list2.val) {
                p.next = list1;
                list1 = list1.next;
                p = p.next;
            } else {
                p.next = list2;
                list2 = list2.next;
                p = p.next;
            }
        }
        if (list1 != null)
            p.next = list1;
        if (list2 != null)
            p.next = list2;
        return phead.next; //第一个是新建的，不要
    }

    public static ListNode<Integer> merge2(ListNode<Integer> list1, ListNode<Integer> list2) {
        if (list1 == null) {
            return list2;
        }
        if (list2 == null) {
            return list1;
        }
        ListNode first = null;
        if (list1.val < list2.val) {
            first = list1;
            first.next = merge2(list1.next, list2);
        } else {
            first = list2;
            first.next = merge2(list1, list2.next);
        }
        return first;
    }
}
/**
 * 题目:合并两个排序的链表
 * 输入两个递增排序的链表，合并这两个链表并使新链表中的节点仍然是递增排序
 * 的。例如:
 * 1->3->5->7
 * 2->4->6->8
 * 合并后的升序链表为
 * 1->2->3->4->5->6->7->8
 */