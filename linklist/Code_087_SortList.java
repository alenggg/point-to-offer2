package alogorithms.linklist;

import alogorithms.structure.ListNode;

/**
 * Created with IntelliJ IDEA
 * Author: aleng
 * Date  : 2018/7/15
 * Time  : 22:28
 * Description: 对链表进行排序。空间复杂度是常数时间，时间复杂度是O(nlogn)
 **/
public class Code_087_SortList {
    //使用归并排序
    public static ListNode sortList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode slow = head, fast = head, cur = null;
        while (fast != null && fast.next != null) {
            cur = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        cur.next = null;//截断
        ListNode l1 = sortList(head);
        ListNode l2 = sortList((slow));
        return merge(l1, l2);

    }

    //变成了合并链表的问题
    private static ListNode merge(ListNode<Integer> l1, ListNode<Integer> l2) {
        ListNode<Integer> head = new ListNode(0);
        ListNode<Integer> cur = head;
        ListNode<Integer> next = null;
        while (l1 != null && l2 != null) {
            if(l1.val > l2.val){
                next = l2.next;
                l2.next = null;
                cur.next = l2;
                l2 = next;
            }else {
                next = l1.next;
                l1.next = null;
                cur.next = l1;
                l1 = next;
            }
            cur = cur.next;
        }
        if (l1 == null){
            cur.next = l2;
        }
        if (l2 == null){
            cur.next = l1;
        }
        return head.next;
    }

    public static void main(String[] args) {

    }
}
