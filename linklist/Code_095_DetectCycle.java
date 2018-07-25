package alogorithms.linklist;

import alogorithms.structure.ListNode;

/**
 * Created with IntelliJ IDEA
 * Author: aleng
 * Date  : 2018/7/17
 * Time  : 10:59
 * Description: Given a linked list, return the node where the cycle begins. If there is no cycle, return null.
 **/
public class Code_095_DetectCycle {
    public ListNode detectCycle(ListNode head) {
        if (head == null){
            return null;
        }
        ListNode fast = head;
        ListNode slow = head;
        while (fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast){
                break;
            }
        }
        if (fast == null || fast.next == null){
            return null;
        }
        fast = head;
        while (slow != fast){
            fast = fast.next;
            slow = slow.next;
        }
        return slow;
    }
}
/**
 * Given a linked list, return the node where the cycle begins. If there is no cycle, return null.
 *
 * Follow up:
 * Can you solve it without using extra space?
 */