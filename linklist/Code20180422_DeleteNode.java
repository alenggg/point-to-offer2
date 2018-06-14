package alogorithms.linklist;
import alogorithms.structure.ListNode;

/**
 * Created with IntelliJ IDEA
 * Author: aleng
 * Date  : 2018/4/22
 * Time  : 17:12
 * Description:删除链表的节点
 **/
public class Code20180422_DeleteNode {

    public static ListNode deleteNode(ListNode head, ListNode listNode) {
        //链表中只有一个节点
        if (head.next == null) {
            return null;
        }
        //删除的是尾节点
        if (listNode.next == null) {
            ListNode temp = head;
            ListNode left = null;
            while (temp != null) {
                left = temp;
                temp = temp.next;
                //如果temp.next == null,说明temp是尾节点
                if (temp.next == null) {
                    left.next = null;
                    break;
                }
            }
            return head;
        }
        //删除的不是尾节点
        listNode.val = listNode.next.val;
        listNode.next = listNode.next.next;
        return head;
    }
}
/**
 * 4月22号
 * 题目:删除链表的节点
 * 在O(1)的时间内删除链表节点
 * 给定单向链表的头指针和一个节点指针，定义一个函数在O(1)时间内删除该节点，链表的
 * 节点和函数的定义如下：
 * ListNode{
 * int value;
 * ListNode next = null;
 * }
 */