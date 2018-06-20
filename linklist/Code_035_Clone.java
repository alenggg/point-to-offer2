package alogorithms.linklist;

import alogorithms.structure.ListNode;

/**
 * Created with IntelliJ IDEA
 * Author: aleng
 * Date  : 2018/5/13
 * Time  : 17:21
 * Description:复杂链表的复制
 **/
public class Code_035_Clone {

    public static ListNode clone2(ListNode pHead) {
        if(pHead == null)
            return null;
        ListNode head = new ListNode(1) ;
        ListNode temp = head ;
        while(pHead.next != null) {
            temp.next = new ListNode(1) ;
            if(pHead.next != null) {
                temp.next = new ListNode(0) ;
            }
            pHead = pHead.next ;
            temp = temp.next ;
        }
        return head ;
    }
}
/**
 *
 * 题目:复杂链表的复制
 * 输入一个复杂链表（每个节点中有节点值，以及两个指针，一个指向下一个节点，另一个特殊指针指向任
 * 意一个节点），返回结果为复制后复杂链表的head。
 * （注意，输出结果中请不要返回参数中的节点引用，否则判题程序会直接返回空）
 **/