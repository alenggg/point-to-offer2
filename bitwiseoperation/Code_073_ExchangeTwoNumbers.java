package alogorithms.bitwiseoperation;

/**
 * Created with IntelliJ IDEA
 * Author: aleng
 * Date  : 2018/6/20
 * Time  : 11:39
 * Description: 不使用新的变量，交换两个变量的值
 **/
public class Code_073_ExchangeTwoNumbers {
    public static void main(String[] args) {

        //基于加减法
        int a = 3;
        int b = 5;
        a = a + b;
        b = a - b;
        a = a - b;
        System.out.println("a=" + a + ",b=" + b);

        //基于异或法
        a = 3;
        b = 5;
        a = a ^ b;
        b = a ^ b;
        a = a ^ b;
        System.out.println("a=" + a + ",b=" + b);
    }
}
