package alogorithms.linklist;

import alogorithms.structure.ListNode;

/**
 * Created with IntelliJ IDEA
 * Author: aleng
 * Date  : 2018/7/17
 * Time  : 10:19
 * Description: Sort a linked list using insertion sort.
 **/
public class Code_092_InsertSortList {
    public ListNode insertionSortList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode<Integer> dumy = new ListNode(Integer.MIN_VALUE);
        ListNode<Integer> cur = head;
        ListNode<Integer> pre = dumy;
        ListNode<Integer> next = null;
        while (cur != null){
            next = cur.next;
            pre = dumy;
            while (pre.next != null && pre.next.val < cur.val){
                pre = pre.next;
            }
            cur.next = pre.next;
            pre.next = cur;
            cur = next;
        }
        return dumy.next;
    }

    public static void main(String[] args) {

    }
}
