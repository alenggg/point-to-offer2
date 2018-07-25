package alogorithms.linklist;

import alogorithms.structure.ListNode;

/**
 * Created with IntelliJ IDEA
 * Author: aleng
 * Date  : 2018/7/17
 * Time  : 10:20
 * Description: Given a linked list, determine if it has a cycle in it.
 **/
public class Code_093_HasCycle {
    public boolean hasCycle(ListNode head) {
        if (head == null){
            return false;
        }
        ListNode fast = head;
        ListNode slow = head;
        while (fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast){
                fast = head;
                while (true){
                    fast = fast.next;
                    slow = slow.next;
                    if (slow == fast){
                        return true;
                    }
                }

            }
        }
        return false;
    }

}
/**
 * Given a linked list, determine if it has a cycle in it.
 *
 * Follow up:
 * Can you solve it without using extra space?
 */