package alogorithms.stackqueue;

import java.util.Stack;

/**
 * Created with IntelliJ IDEA
 * Author: aleng
 * Date  : 2018/5/7
 * Time  : 19:29
 * Description:栈的压入、弹出序列
 **/
public class Code20180507_IsPopOrder {

    public static boolean IsPopOrder(int [] pushA,int [] popA) {
        if (pushA == null || popA == null){
            return false;
        }
        Stack<Integer> stack = new Stack<>();
        int index = 0;
        for (int i = 0; i < pushA.length; i++) {
            stack.push(pushA[i]);
            while (!stack.isEmpty() && stack.peek() == popA[index]){
                stack.pop();
                index++;
            }
        }
        return stack.isEmpty();
    }
}

/**
 *
 * 题目:栈的压入、弹出序列
 * 输入两个整数序列，第一个序列表示栈的压入顺序，请判断第二个序列是否为该栈的弹出顺序。
 * 假设压入栈的所有数字均不相等。例如序列1,2,3,4,5是某栈的压入顺序，序列4,5,3,2,1是该压栈序列对应的一个弹出
 * 序列，但4,3,5,1,2就不可能是该压栈序列的弹出序列。（注意：这两个序列的长度是相等的）
 * 思路：
 * 利用辅助栈结构
 * 我们可以判断一个序列是不是占的弹出序列的规律:
 * 如果下一个弹出的数字刚好是栈顶数字，那么直接弹出;
 * 如果下一个弹出的数字不在栈顶，则吧压栈序列中还没有入栈的数字压入辅助栈，直到把下一个需要弹出的数字压入栈顶为止;
 * 如果所有数字都压入栈后仍然没有找到下一个弹出的数字，那么该序列不可能是一个弹出序列。
 *
 * 用栈是否为空来判断该序列是否是一个弹出序列。
 */
