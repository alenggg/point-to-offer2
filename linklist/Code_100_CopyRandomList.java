package alogorithms.linklist;

import alogorithms.structure.RandomListNode;

/**
 * Created with IntelliJ IDEA
 * Author: aleng
 * Date  : 2018/7/18
 * Time  : 10:59
 * Description: deep copy RandomList
 **/
public class Code_100_CopyRandomList {

    public RandomListNode copyRandomList(RandomListNode head) {
        if (head == null){
            return null;
        }
        RandomListNode cur = head;
        RandomListNode next = null;
        while (cur != null){
            next = cur.next;
            RandomListNode cp = new RandomListNode(cur.label);
            cur.next = cp;
            cp.next = next;
            cur = next;
        }
        cur = head;
        RandomListNode fast = head.next;
        while (fast != null){
            fast.random =  cur.random == null ? null :cur.random.next;
            if (fast.next == null){
                break;
            }
            fast = fast.next.next;
            cur = cur.next.next;
        }
        cur = head;
        fast = head.next;
        while (fast != null){
            if (fast.next == null){
                break;
            }
            next = fast.next.next;
            fast.next = next;
            fast = next;
        }
        return cur.next;
    }
}
/**
 * A linked list is given such that each node contains an additional random pointer which could point to any node in the list or null.
 *
 * Return a deep copy of the list.
 *
 *
 */
