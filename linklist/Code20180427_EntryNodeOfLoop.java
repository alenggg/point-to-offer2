package alogorithms.linklist;

import alogorithms.structure.ListNode;

/**
 * Created with IntelliJ IDEA
 * Author: aleng
 * Date  : 2018/4/27
 * Time  : 17:17
 * Description:链表中环的入口
 **/
public class Code20180427_EntryNodeOfLoop {

    public ListNode entryNodeOfLoop(ListNode pHead) {
        if (pHead == null || pHead.next == null)
            return null;
        ListNode slow = pHead;
        ListNode fast = pHead;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                fast = pHead;
            }
            while (fast != slow) {
                fast = fast.next;
                slow = slow.next;
            }
            if (fast == slow)
                return slow;
        }
        return null;
    }
}
/**
 *
 * 题目：如果一个链表中包含环，如何找出环的入口节点？
 */