package alogorithms.stackqueue;

import java.util.Stack;

/**
 * Created with IntelliJ IDEA
 * Author: aleng
 * Date  : 2018/7/16
 * Time  : 10:55
 * Description:Evaluate the value of an arithmetic expression in Reverse Polish Notation. (逆波兰式（Reverse Polish notation，RPN，或逆波兰记法），也叫后缀表达式（将运算符写在操作数之后）)
 **/
public class Code_091_EvalRPN {

    public static int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<Integer>();
        for (int i = 0; i < tokens.length; i++) {
            try {
                int num = Integer.parseInt(tokens[i]);
                stack.add(num);
            } catch (Exception e) {
                int b = stack.pop();
                int a = stack.pop();
                stack.add(get(a, b, tokens[i]));
            }
        }
        return stack.pop();
    }

    private static int get(int a, int b, String operator) {
        switch (operator) {
            case "+":
                return a + b;
            case "-":
                return a - b;
            case "*":
                return a * b;
            case "/":
                return a / b;
            default:
                return 0;
        }
    }

    public static void main(String[] args) {
        System.out.println(evalRPN(new String[]{"4", "3", "-"}));
    }
}

/**
 * Valid operators are+,-,*,/. Each operand may be an integer or another expression.
 * <p>
 * Some examples:
 * <p>
 * ["2", "1", "+", "3", "*"] -> ((2 + 1) * 3) -> 9
 * ["4", "13", "5", "/", "+"] -> (4 + (13 / 5)) -> 6
 */
