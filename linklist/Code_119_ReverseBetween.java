package alogorithms.linklist;

import alogorithms.structure.ListNode;

import java.util.LinkedList;

/**
 * Created with IntelliJ IDEA
 * Author: aleng
 * Date  : 2018/7/25
 * Time  : 9:12
 * Description: Reverse a linked list from position m to n. Do it in-place and in one-pass.
 **/
public class Code_119_ReverseBetween {
    public ListNode reverseBetween(ListNode head, int m, int n) {
       ListNode dumy = new ListNode(-1);
       dumy.next = head;
       ListNode start = head;
       ListNode preStart = dumy;
       ListNode next = null;
        for (int i = 1; i < m; i++) {
            preStart = start;
            start = start.next;
        }
        for (int i = 0; i < n - m; i++) {
            next = start.next;
            start.next = next.next;
            next.next = preStart.next;
            preStart.next = next;
        }
        return dumy.next;
    }

    public static void main(String[] args) {

    }
}
/**
 * Reverse a linked list from position m to n. Do it in-place and in one-pass.
 *
 * For example:
 * Given1->2->3->4->5->NULL, m = 2 and n = 4,
 *
 * return1->4->3->2->5->NULL.
 *
 * Note:
 * Given m, n satisfy the following condition:
 * 1 ≤ m ≤ n ≤ length of list.
 */