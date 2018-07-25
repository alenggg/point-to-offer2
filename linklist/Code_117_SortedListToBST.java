package alogorithms.linklist;

import alogorithms.structure.ListNode;
import alogorithms.structure.TreeNode;

/**
 * Created with IntelliJ IDEA
 * Author: aleng
 * Date  : 2018/7/24
 * Time  : 10:19
 * Description:
 **/
public class Code_117_SortedListToBST {
    public TreeNode sortedListToBST(ListNode head) {
        return toBST(head,null);
    }

    private TreeNode toBST(ListNode head, ListNode tail) {
        if (head == tail){
            return null;
        }
        ListNode slow = head;
        ListNode fast = head;
        while (fast != tail && fast.next != tail){
            slow = slow.next;
            fast = fast.next.next;
        }
        TreeNode node = new TreeNode(slow.val);
        node.left = toBST(head,slow);
        node.right = toBST(slow.next,null);
        return node;
    }

    public TreeNode sortedListToBST2(ListNode head) {
        if (head == null){
            return null;
        }
        int len = 0;
        ListNode cur = head;
        while(cur != null){
            len++;
            cur = cur.next;
        }
        int tou = (len + 1) / 2;
        cur = head;
        ListNode next = null;
        ListNode pre = null;
        pre.next = cur;
        for (int i = 1; i < tou; i++) {
            next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        //cur 指向头节点
        ListNode alsoCur = cur;
        TreeNode phead =  new TreeNode(cur.val);
        TreeNode res = phead;
        cur = cur.next;
        while (cur != null){
            phead.right = new TreeNode(cur.val);
            phead = phead.right;
            cur = cur.next;
        }
        phead = res;
        while (cur != null){
            phead.left = new TreeNode(next.val);
            phead = phead.left;
            next = next.next;
        }
        return res;
    }
}
