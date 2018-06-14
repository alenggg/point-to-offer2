package alogorithms.linklist;

import alogorithms.structure.ListNode;

/**
 * Created with IntelliJ IDEA
 * Author: aleng
 * Date  : 2018/4/23
 * Time  : 17:13
 * Description:删除链表中重复的节点
 **/
public class Code20180423_DeleteDuplication {

    public static ListNode deleteDuplication(ListNode pHead) {
        if (pHead == null || pHead.next == null)
            return pHead;
        ListNode curNode = pHead;
        ListNode preNode = pHead;
        boolean isDuplicate = false;
        while (curNode.next != null) {
            if (curNode.val == curNode.next.val) {//如果重复curNode指针右移,preNode不动
                isDuplicate = true;
                curNode = curNode.next;
            } else if (!isDuplicate) {//如果不重复curNode和preNode都右移
                preNode = curNode;
                curNode = curNode.next;
            } else if (isDuplicate && curNode.next != null && curNode.val != curNode.next.val) {//重复到不重复，删除节点
                isDuplicate = false;
                if (preNode.val == curNode.val) { //如果头节点就重复
                    curNode = curNode.next;
                    preNode = curNode;
                    pHead = curNode;
                } else {
                    curNode = curNode.next;
                    preNode.next = curNode;
                }
            }
        }
        if (pHead.val == curNode.val) {
            return null;
        } else if (isDuplicate) {
            preNode.next = null;
        }
        return pHead;
    }

    public static ListNode deleteDuplication2(ListNode<Integer> pHead) {
        if (pHead == null)
            return null;
        ListNode<Integer> first = new ListNode(-1);
        first.next = pHead;
        ListNode<Integer> p = pHead;
        ListNode<Integer> preNode = first;
        while (p != null && p.next != null) {
            if (p.val == p.next.val) {
                int val = p.val;
                while (p != null && p.val == val) {
                    p = p.next;
                }
                preNode.next = p;
            } else {
                preNode = p;
                p = p.next;
            }
        }
        return first.next;
    }

    public static void main(String[] args) {
        ListNode listNode1 = new ListNode(1);
        ListNode listNode2 = new ListNode(2);
        ListNode listNode3 = new ListNode(3);
        ListNode listNode4 = new ListNode(4);
        ListNode listNode5 = new ListNode(4);
        ListNode listNode6 = new ListNode(5);
        listNode1.next = listNode2;
        listNode2.next = listNode3;
        listNode3.next = listNode4;
        listNode4.next = listNode5;
        listNode5.next = listNode6;

        ListNode listNode = deleteDuplication2(listNode1);
    }
}
/**
 *
 * 题目:删除链表中重复的节点
 * 在一个排序的链表中，如何删除重复的节点？
 * 例如：1->2->3->3->4->4->5删除之后1->2->5
 * preNode总记录重复节点的前一个不重复节点
 * 1.curNode和preNode指针同时指向头节点
 * 2.判断curNode和curNode.next的值是否相等
 * 相等：curNode右移，preNode不动
 * 不相等:curNode和preNode同时右移
 * 同时isDuplicate记录当前是否是重复
 * 3.从重复再到不重复，就preNode.next = curNode
 */