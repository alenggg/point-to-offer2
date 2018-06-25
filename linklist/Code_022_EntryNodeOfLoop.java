package alogorithms.linklist;

import alogorithms.structure.ListNode;
import javafx.scene.control.Skin;

import java.util.List;

/**
 * Created with IntelliJ IDEA
 * Author: aleng
 * Date  : 2018/4/27
 * Time  : 17:17
 * Description:链表中环的入口
 **/
public class Code_022_EntryNodeOfLoop {

    public static ListNode entryNodeOfLoop(ListNode pHead) {
        if (pHead == null)
            return null;
        ListNode slow = pHead;
        ListNode fast = pHead;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                fast = pHead;
                while (fast != slow) {
                    fast = fast.next;
                    slow = slow.next;
                }
                if (fast == slow)
                    return slow;
            }
        }
        return null;
    }

    public static void main(String[] args) {

    }
}
/**
 * 题目：如果一个链表中包含环，如何找出环的入口节点？
 * 分析：
 * (1)如果存在环，找到环的起始结点
 * 当fast指针等于slow指针时，slow指针肯定还没有遍历完整个链表，而此时fast指针已经在环内循环了n圈(n>=1)，
 * 假定从链表头指针开始slow走了s步，则fast走了2s步，fast所走的步数还等于s加上fast指针比slow指针在环内多走的n圈。
 * 设环长为r，则：
 * 2s = s + nr;
 * =>s = nr;
 *
 * (2)设整个链表长度为L，环的入口结点到相遇结点的距离为x, 起点到环的入口结点的距离为a.
 * a + x = nr;
 * => a + x = (n-1)r + L - a;（r=L-a）
 * => a = (n-1)r + (L - a - x);(因为从环入口到相遇点为x,所以相遇点到环入口为r-x => L-a-x)
 * => 由链表的头结点到环入口结点的距离等于n-1圈环的长度+相遇点到环入口结点的距离，
 * 于是，当我们在链表头部和相遇处分别设一指针，每次各走一步，则两指针必定相遇，且相遇的第一个结点即为环的入口结点
 * <p>
 * 第二种
 * 第一次遍历找到环的长度
 * 然后定义两个指针，距离为环的长度，前面的遍历到最后的时候，返回后面的指针就是环的入口点
 */