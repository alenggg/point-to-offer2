package alogorithms.linklist;

/**
 * Created with IntelliJ IDEA
 * Author: aleng
 * Date  : 2018/6/13
 * Time  : 21:01
 * Description: 将链表分为小中大的链表
 **/
public class Code_061_SmallerEqualBigger {

	public static class Node {
		public int value;
		public Node next;

		public Node(int data) {
			this.value = data;
		}
	}

	public static Node listPartition1(Node head, int pivot) {
		if (head == null) {
			return head;
		}
		Node cur = head;
		int i = 0;
		while (cur != null) {
			i++;
			cur = cur.next;
		}
		Node[] nodeArr = new Node[i];
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

	public static void arrPartition(Node[] nodeArr, int pivot) {
		int small = -1;
		int big = nodeArr.length;
		int index = 0;
		while (index != big) {
			if (nodeArr[index].value < pivot) {
				swap(nodeArr, ++small, index++);
			} else if (nodeArr[index].value == pivot) {
				index++;
			} else {
				swap(nodeArr, --big, index);
			}
		}
	}

	public static void swap(Node[] nodeArr, int a, int b) {
		Node tmp = nodeArr[a];
		nodeArr[a] = nodeArr[b];
		nodeArr[b] = tmp;
	}

	public static Node listPartition2(Node head, int pivot) {
		Node smallHead = null; // small head
		Node smallTail = null; // small tail
		Node equalHead = null; // equal head
		Node equalTail = null; // equal tail
		Node bigHead = null; // big head
		Node bigTail = null; // big tail
		Node next = null; // save next node
		while (head != null){
		    next = head.next;
		    head.next = null;
			if (head.value < pivot){
			    if (smallHead == null){
			        smallHead = head;
			        smallTail = smallHead;
                }
			    smallTail.next = head;
			    smallTail = smallTail.next;
            }else if (head.value == pivot){
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

	public static void printLinkedList(Node node) {
		System.out.print("Linked List: ");
		while (node != null) {
			System.out.print(node.value + " ");
			node = node.next;
		}
		System.out.println();
	}

	public static void main(String[] args) {
		Node head1 = new Node(7);
		head1.next = new Node(9);
		head1.next.next = new Node(1);
		head1.next.next.next = new Node(8);
		head1.next.next.next.next = new Node(5);
		head1.next.next.next.next.next = new Node(2);
		head1.next.next.next.next.next.next = new Node(5);
		printLinkedList(head1);
		// head1 = listPartition1(head1, 4);
		head1 = listPartition2(head1, 1);
		printLinkedList(head1);

	}

}
