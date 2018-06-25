package alogorithms.linklist;

import alogorithms.structure.ListNode;

/**
 * Created with IntelliJ IDEA
 * Author: aleng
 * Date  : 2018/6/10
 * Time  : 21:01
 * Description: 两个单链表相交的一系列问题
 **/
public class Code_058_FindFirstIntersectNode {

	public static ListNode getIntersectNode(ListNode head1, ListNode head2) {
		if (head1 == null || head2 == null) {
			return null;
		}
		ListNode loop1 = Code_022_EntryNodeOfLoop.entryNodeOfLoop(head1); //入环点
		ListNode loop2 = Code_022_EntryNodeOfLoop.entryNodeOfLoop(head2); //入环点
		if (loop1 == null && loop2 == null) {  //如果两个链表都没有环
			return noLoop(head1, head2);
		}
		if (loop1 != null && loop2 != null) { //如果两个链表都有环
			return bothLoop(head1, loop1, head2, loop2);
		}
		//如果两个链表一个有环，一个没环，不可能相交
		return null;
	}
	//两个没环的相交点
	public static ListNode noLoop(ListNode head1, ListNode head2) {
		if (head1 == null || head2 == null) {
			return null;
		}
        ListNode cur1 = head1,cur2 = head2;
		int len1 = 0, len2 = 0;
		while (cur1 != null){
		    len1++;
		    cur1 = cur1.next;
        }
        while (cur2 != null){
            len2++;
            cur2 = cur2.next;
        }
        int n = len1 - len2;
        cur1 = head1;
        cur2 = head2;
		if (n > 0){
		    while (n != 0){
		        n--;
		        cur1 = cur1.next;
            }
        }
        if (n < 0){
		    n = -n;
            while (n != 0){
                n--;
                cur2 = cur2.next;
            }
        }
        while (cur1 != null && cur2 != null){
		    if (cur1 == cur2){
		        return cur1;
            }
            cur1 = cur1.next;
		    cur2 = cur2.next;
        }
        return null;
	}
    //两个都有环的相交点
	public static ListNode bothLoop(ListNode head1, ListNode loop1, ListNode head2, ListNode loop2) {
		ListNode cur1 = null;
		ListNode cur2 = null;
		if (loop1 == loop2) { //两个入环点相同，又跳到两个没环的相交点的问题
            cur1 = head1;
            cur2 = head2;
		    int len1 = 1, len2 = 1;
            while (cur1 != loop1){
                len1++;
                cur1 = cur1.next;
            }
            while (cur2 != loop2){
                len2++;
                cur2 = cur2.next;
            }
            int n = len1 - len2;
            cur1 = head1;
            cur2 = head2;
            if (n > 0){
                while (n != 0){
                    n--;
                    cur1 = cur1.next;
                }
            }
            if (n < 0){
                n = -n;
                while (n != 0){
                    n--;
                    cur2 = cur2.next;
                }
            }
            while (cur1 != loop1 && cur2 != loop2){
                if (cur1 == cur2){
                    return cur1;
                }
                cur1 = cur1.next;
                cur2 = cur2.next;
            }
            return null;
		} else {
			cur1 = loop1.next;
			while (cur1 != loop1) {
				if (cur1 == loop2) {
					return loop1;
				}
				cur1 = cur1.next;
			}
			return null;
		}
	}

	public static void main(String[] args) {
		// 1->2->3->4->5->6->7->null
		ListNode head1 = new ListNode(1);
		head1.next = new ListNode(2);
		head1.next.next = new ListNode(3);
		head1.next.next.next = new ListNode(4);
		head1.next.next.next.next = new ListNode(5);
		head1.next.next.next.next.next = new ListNode(6);
		head1.next.next.next.next.next.next = new ListNode(7);

		// 0->9->8->6->7->null
		ListNode head2 = new ListNode(0);
		head2.next = new ListNode(9);
		head2.next.next = new ListNode(8);
		head2.next.next.next = head1.next.next.next.next.next; // 8->6
		System.out.println(getIntersectNode(head1, head2).val);

		// 1->2->3->4->5->6->7->4...
		head1 = new ListNode(1);
		head1.next = new ListNode(2);
		head1.next.next = new ListNode(3);
		head1.next.next.next = new ListNode(4);
		head1.next.next.next.next = new ListNode(5);
		head1.next.next.next.next.next = new ListNode(6);
		head1.next.next.next.next.next.next = new ListNode(7);
		head1.next.next.next.next.next.next = head1.next.next.next; // 7->4

		// 0->9->8->2...
		head2 = new ListNode(0);
		head2.next = new ListNode(9);
		head2.next.next = new ListNode(8);
		head2.next.next.next = head1.next; // 8->2
		System.out.println(getIntersectNode(head1, head2).val);

		// 0->9->8->6->4->5->6..
		head2 = new ListNode(0);
		head2.next = new ListNode(9);
		head2.next.next = new ListNode(8);
		head2.next.next.next = head1.next.next.next.next.next; // 8->6
		System.out.println(getIntersectNode(head1, head2).val);

	}

}

/**
 *
 * 在本题中， 单链表可能有环， 也可能无环。 给定两个单链表的头节点
 * head1和head2， 这两个链表可能相交， 也可能不相交。 请实现一个函数，
 * 如果两个链表相交， 请返回相交的第一个节点； 如果不相交， 返回null
 * 即可。
 * 要求： 如果链表1的长度为N， 链表2的长度为M， 时间复杂度请达到
 * O(N+M)， 额外空间复杂度请达到O(1)。
 */
