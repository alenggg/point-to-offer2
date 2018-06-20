package alogorithms.stackqueue;

import java.util.Stack;

/**
 * Created with IntelliJ IDEA
 * Author: aleng
 * Date  : 2018/5/6
 * Time  : 19:27
 * Description:包含min函数的栈
 **/
public class Code_028_GetMinStack {

    public static class MyStack1 {
        private Stack<Integer> stackData;
        private Stack<Integer> stackMin;

        public MyStack1() {
            this.stackData = new Stack<Integer>();
            this.stackMin = new Stack<Integer>();
        }

        public void push(int newNum) {
            if (this.stackMin.isEmpty()) {
                this.stackMin.push(newNum);
            } else if (newNum <= this.getmin()) {
                this.stackMin.push(newNum);
            }
            this.stackData.push(newNum);
        }

        public int pop() {
            if (this.stackData.isEmpty()) {
                throw new RuntimeException("Your stack is empty.");
            }
            int value = this.stackData.pop();
            if (value == this.getmin()) {
                this.stackMin.pop();
            }
            return value;
        }

        public int getmin() {
            if (this.stackMin.isEmpty()) {
                throw new RuntimeException("Your stack is empty.");
            }
            return this.stackMin.peek();
        }
    }

    public static void main(String[] args) {
        MyStack1 myStack1 = new MyStack1();
    }
}

/**
 * 题目:包含min函数的栈
 * 定义栈的数据结构，请在该类型中时限一个能够得到栈的最小元素的min函数。
 * 在该栈中。调用min,push及pop的时间复杂度都是O(1)
 */