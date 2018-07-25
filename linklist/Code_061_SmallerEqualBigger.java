package alogorithms.linklist;

import alogorithms.structure.ListNode;

/**
 * Created with IntelliJ IDEA
 * Author: aleng
 * Date  : 2018/6/13
 * Time  : 21:01
 * Description: 将链表分为小中大的链表
 **/
public class Code_061_SmallerEqualBigger {

	public static ListNode listPartition1(ListNode<Integer> head, int pivot) {
		if (head == null) {
			return head;
		}
		ListNode<Integer> cur = head;
		int i = 0;
		while (cur != null) {
			i++;
			cur = cur.next;
		}
		ListNode<Integer>[] nodeArr = new ListNode[i];
		i = 0;
		cur = head;
		for (i = 0; i != nodeArr.length; i++) {
			nodeArr[i] = cur;
			cur = cur.next;
		}
		arrPartition(nodeArr, pivot);
		for (i = 1; i != nodeArr.length; i++) {
			nodeArr[i - 1].next = nodeArr[i];
		}
		nodeArr[i - 1].next = null;
		return nodeArr[0];
	}

	public static void arrPartition(ListNode<Integer>[] nodeArr, int pivot) {
		int small = -1;
		int big = nodeArr.length;
		int index = 0;
		while (index != big) {
			if (nodeArr[index].val < pivot) {
				swap(nodeArr, ++small, index++);
			} else if (nodeArr[index].val == pivot) {
				index++;
			} else {
				swap(nodeArr, --big, index);
			}
		}
	}

	public static void swap(ListNode[] nodeArr, int a, int b) {
		ListNode tmp = nodeArr[a];
		nodeArr[a] = nodeArr[b];
		nodeArr[b] = tmp;
	}

	public static ListNode listPartition2(ListNode<Integer> head, int pivot) {
		ListNode smallHead = null; // small head
		ListNode smallTail = null; // small tail
		ListNode equalHead = null; // equal head
		ListNode equalTail = null; // equal tail
		ListNode bigHead = null; // big head
		ListNode bigTail = null; // big tail
		ListNode next = null; // save next node
		while (head != null){
		    next = head.next;
		    head.next = null;
			if (head.val < pivot){
			    if (smallHead == null){
			        smallHead = head;
			        smallTail = smallHead;
                }
			    smallTail.next = head;
			    smallTail = smallTail.next;
            }else if (head.val == pivot){
			    if (equalHead == null){
			        equalHead = head;
			        equalTail = equalHead;
                }
                equalTail.next = head;
			    equalTail = equalTail.next;;
            }else {
			    if (bigHead == null){
			        bigHead = head;
			        bigTail = bigHead;
                }
                bigTail.next = head;
			    bigTail = bigTail.next;
            }
            head = next;
		}

        if (smallTail != null) {
            smallTail.next = equalHead;
        }
        if (equalTail != null){
		    equalTail.next = bigHead;
        }else {
		    smallTail.next = bigHead;
        }
        return smallHead != null ? smallHead : equalHead != null ? equalHead : bigHead;
	}

	public static void printLinkedList(ListNode node) {
		System.out.print("Linked List: ");
		while (node != null) {
			System.out.print(node.val + " ");
			node = node.next;
		}
		System.out.println();
	}

	public static void main(String[] args) {
		ListNode head1 = new ListNode(7);
		head1.next = new ListNode(9);
		head1.next.next = new ListNode(1);
		head1.next.next.next = new ListNode(8);
		head1.next.next.next.next = new ListNode(5);
		head1.next.next.next.next.next = new ListNode(2);
		head1.next.next.next.next.next.next = new ListNode(5);
		printLinkedList(head1);
		// head1 = listPartition1(head1, 4);
		head1 = listPartition2(head1, 1);
		printLinkedList(head1);

	}

}
