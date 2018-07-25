package alogorithms.linklist;

import alogorithms.structure.ListNode;

/**
 * Created with IntelliJ IDEA
 * Author: aleng
 * Date  : 2018/7/17
 * Time  : 10:28
 * Description:Given a singly linked list L: L 0→L 1→…→L n-1→L n,
 * reorder it to: L 0→L n →L 1→L n-1→L 2→L n-2→…
 **/
public class Code_094_ReorderList {
    public void reorderList(ListNode head) {
        if (head == null)
            return;
        ListNode slow = head;
        ListNode fast = head;
        while (fast.next != null && fast.next.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        ListNode pre = null;
        ListNode cur = slow.next;
        ListNode next =  null;
        slow.next = null;
        while (cur != null){
            next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        merge(head,pre);
    }

    public void merge(ListNode head1, ListNode head2) {
        ListNode cur1 = head1;
        ListNode cur2 = head2;
        ListNode next1 = null;
        ListNode next2 = null;
        while (cur1 != null && cur2 != null){
            next1 = cur1.next;
            next2 = cur2.next;
            cur2.next = next1;
            cur1.next = cur2;
            cur1 = next1;
            cur2 = next2;
        }
    }

    public static void main(String[] args) {

    }
}
/**
 * Given a singly linked list L: L 0→L 1→…→L n-1→L n,
 * reorder it to: L 0→L n →L 1→L n-1→L 2→L n-2→…
 * <p>
 * You must do this in-place without altering the nodes' values.
 * <p>
 * For example,
 * Given{1,2,3,4}, reorder it to{1,4,2,3}.
 *
 * 前插法反转后面的链表。
 * slow的值是不变的，总是指向中间节点（也就是前半链表的最后一个节点），
 * pre开始是后半链表的第一个节点，
 * 每次把nex这个节点插入到slow的后面，
 * 这就是前插法反转链表的过程
 */
