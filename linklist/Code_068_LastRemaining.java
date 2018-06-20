package alogorithms.linklist;

import alogorithms.structure.ListNode;

/**
 * Created with IntelliJ IDEA
 * Author: aleng
 * Date  : 2018/6/19
 * Time  : 20:23
 * Description:圆圈中最后剩下的数字
 **/
public class Code_068_LastRemaining {

    public static int lastRemaining(int n, int m) {
        if (n < 1 || m < 1) {
            return -1;
        }
        ListNode<Integer> head = new ListNode<>(0);
        ListNode<Integer> cur = head;
        //构造出一个环结构
        for (int i = 1; i < n; i++) {
            ListNode<Integer> node = new ListNode<>(i);
            cur.next = node;
            cur = cur.next;
        }
        cur.next = head;
        cur = head;//cur指向头节点，此时已构造出一个环
        while (true) {
            if (cur.next == cur) {//长度为1结束循环
                return cur.val;
            }
            for (int i = 1; i < m; i++) { //循环m-1次
                cur = cur.next;
            }
            cur.val = cur.next.val; //删除当前节点，因为是一个环，所以不必担心为null
            cur.next = cur.next.next;
        }
    }
    public static void main(String[] args){
        System.out.println(lastRemaining(5,3)); //3
        System.out.println(lastRemaining(6,7)); //4
        System.out.println(lastRemaining(0,7)); //-1
    }

}
/**
 * 题目：0.1...n-1这n个数字排成一个圆圈，从数字0开始，每次从这个圆圈里删除第m个数字，
 * 求出这个圆圈里剩下的最后一个数字。
 */
