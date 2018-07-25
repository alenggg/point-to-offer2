package alogorithms.linklist;

import alogorithms.structure.ListNode;

/**
 * Created with IntelliJ IDEA
 * Author: aleng
 * Date  : 2018/7/11
 * Time  : 16:47
 * Description: 两个链表相加
 **/
public class Code_083_AddTwoNumbers {

    public static ListNode addTwoNumbers(ListNode<Integer> l1, ListNode<Integer> l2) {
        if (l1 == null)
            return l2;
        if (l2 == null)
            return l1;
        ListNode head = new ListNode(0);
        ListNode p = head;
        int temp = 0;
        while (l1 != null || l2 != null || temp != 0) {
            if (l1 != null) {
                temp += l1.val;
                l1 = l1.next;
            }
            if (l2 != null) {
                temp += l2.val;
                l2 = l2.next;
            }
            p.next = new ListNode(temp % 10);
            p = p.next;
            temp /= 10;
        }
        return head.next;
    }

    public static ListNode addTwoNumbers1(ListNode<Integer> l1, ListNode<Integer> l2) {
        if (l1 == null || l2 == null) {
            return l1 == null ? l2 : l1;
        }
        int sum = 0;
        int round = 0;
        int trueSum = 0;
        ListNode<Integer> head = l1;
        ListNode<Integer> temp = null;
        while (l1 != null && l2 != null) {
            trueSum = l1.val + l2.val + round;
            round = trueSum > 9 ? 1 : 0;
            sum = trueSum % 10;
            l1.val = sum;
            temp = l1;
            l1 = l1.next;
            l2 = l2.next;
        }
        ListNode pre = null;
        while (l1 != null){
            trueSum = l1.val + round;
            round = trueSum > 9 ? 1 : 0;
            sum = trueSum % 10;
            l1.val = sum;
            pre = l1;
            l1 = l1.next;
        }
        if (l2 != null){
            temp.next = l2;
            temp = temp.next;
            while (temp != null){
                trueSum = temp.val + round;
                round = trueSum > 9 ? 1 : 0;
                sum = trueSum % 10;
                temp.val = sum;
                pre = temp;
                temp = temp.next;
            }
        }
        if (round == 1){
            if (pre == null){
                temp.next = new ListNode<>(1);
            }else {
                pre.next = new ListNode<>(1);
            }
        }
        return head;
    }

    public static void main(String[] args) {
        ListNode<Integer> l1 =  new ListNode<>(1);
        ListNode<Integer> l2 =  new ListNode<>(1);

        ListNode listNode = addTwoNumbers(l1, l2);
        System.out.println(listNode.toString());
    }
}
/**
 * You are given two linked lists representing two non-negative numbers.
 * The digits are stored in reverse order and each of their nodes contain a single digit.
 * Add the two numbers and return it as a linked list.
 *
 * Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
 * Output: 7 -> 0 -> 8
 */