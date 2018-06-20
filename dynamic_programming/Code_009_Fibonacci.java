package alogorithms.dynamic_programming;

/**
 * Created with IntelliJ IDEA
 * Author: aleng
 * Date  : 2018/4/14
 * Time  : 16:08
 * Description:斐波那契数列
 **/
public class Code_009_Fibonacci {

    public static int fibonacci(int n) { //时间复杂度为O(n)
        int[] reslut = {0,1};
        if (n < 2){
            return reslut[n];
        }
        int fibNMinusOne = 1;
        int fibNmunusTwo = 0;
        int fibN = 0;
        for (int i = 2;i <= n; i++){
            fibN = fibNMinusOne + fibNmunusTwo;

            fibNmunusTwo = fibNMinusOne;
            fibNMinusOne = fibN;
        }
        return fibN;
    }

}
/**
 *
 * 斐波那契数列
 * 题目一:求斐波那契数列的第n项
 * 写一个函数，输入n,求斐波那契数列(Fibonacci)数列的第n项.斐波那契而数列的定义如下:
 * 不能用递归
 *
 * f(n) = 0              n=0
 *      = 1              n=1
 *      = f(n-1)+f(n-2)  n>1
 *
 */