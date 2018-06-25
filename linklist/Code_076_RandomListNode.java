package alogorithms.linklist;

import alogorithms.structure.RandomListNode;

/**
 * Created with IntelliJ IDEA
 * Author: aleng
 * Date  : 2018/6/25
 * Time  : 16:10
 * Description: 复杂链表的复制
 **/
public class Code_076_RandomListNode {

    public static RandomListNode clone(RandomListNode pHead) {
        if (pHead == null) {
            return null;
        }
        RandomListNode cur = pHead;
        RandomListNode next = null;
        while (cur != null) {
            next = cur.next;
            cur.next = new RandomListNode(cur.label);
            cur.next.next = next;
            cur = next;
        }
        cur = pHead;
        RandomListNode curCopy = null;
        while (cur != null) {
            curCopy = cur.next;
            curCopy.random = cur.random == null ? null : cur.random.next;
            cur = cur.next.next;
        }
        RandomListNode res = pHead.next;
        cur = pHead;
        next = null;
        curCopy = null;
        while (cur != null) {
            next = cur.next.next;
            curCopy = cur.next;
            cur.next = next;
            curCopy.next = next != null ? next.next : null;
            cur = next;
        }
        return res;
    }

    public static void printRandLinkedList(RandomListNode head) {
        RandomListNode cur = head;
        System.out.print("order: ");
        while (cur != null) {
            System.out.print(cur.label + " ");
            cur = cur.next;
        }
        System.out.println();
        cur = head;
        System.out.print("rand:  ");
        while (cur != null) {
            System.out.print(cur.random == null ? "- " : cur.random.label + " ");
            cur = cur.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        RandomListNode head = null;
        RandomListNode res1 = null;
        RandomListNode res2 = null;
        printRandLinkedList(head);
        res1 = clone(head);
        printRandLinkedList(res1);
        res2 = clone(head);
        printRandLinkedList(res2);
        printRandLinkedList(head);
        System.out.println("=========================");

        head = new RandomListNode(1);
        head.next = new RandomListNode(2);
        head.next.next = new RandomListNode(3);
        head.next.next.next = new RandomListNode(4);
        head.next.next.next.next = new RandomListNode(5);
        head.next.next.next.next.next = new RandomListNode(6);

        head.random = head.next.next.next.next.next; // 1 -> 6
        head.next.random = head.next.next.next.next.next; // 2 -> 6
        head.next.next.random = head.next.next.next.next; // 3 -> 5
        head.next.next.next.random = head.next.next; // 4 -> 3
        head.next.next.next.next.random = null; // 5 -> null
        head.next.next.next.next.next.random = head.next.next.next; // 6 -> 4

        printRandLinkedList(head);
        res1 = clone(head);
        printRandLinkedList(res1);
        printRandLinkedList(head);
        System.out.println("=========================");
    }
}
/**
 *
 *
 * 输入一个复杂链表
 * （每个节点中有节点值，以及两个指针，一个指向下一个节点，另一个特殊指针指向任意一个节点），
 * 返回结果为复制后复杂链表的head。
 * （注意，输出结果中请不要返回参数中的节点引用，否则判题程序会直接返回空）
 */