package alogorithms.bitwiseoperation;

/**
 * Created with IntelliJ IDEA
 * Author: aleng
 * Date  : 2018/4/19
 * Time  : 16:21
 * Description:二进制中的1的个数
 **/
public class Code20180419_NumberOf1 {

    //可能引起死循环的解法，输入一个负数
    public static int numberOf1(int n){
        int count = 0;
        while (n != 0){
            if ((n & 1) == 0){
                count++;
            }
            n = n >> 1;
        }
        return count;
    }
    //不右移n，左移1，循环的次数等于整数二进制的位数，32位需要循环32次。
    public static int numberOf1_2(int n){
        int count = 0;
        //Unsigned int flag = 1;
        int flag = 1;
        while (flag != 0){
            if ((n & flag) == 0){
                count++;
            }
            flag = flag << 1 ;
        }
        return count;
    }
    /**
     * (1)如果二进制数最后一位为1,减一以后:1变为0
     * (2)如果二进制数最后以为为0,减一以后:最后一位1变为0,后面的0都变为1
     * 所以一个二进制数和该二进制数减一做与运算相当于:二进制数最后一位1变为0，然后循环
     */
    public static int numberOf1_3(int n){
        int count = 0;
        while (n != 0){
            ++count;
            n = (n-1)&n;
        }
        return count;
    }
}
/**
 *
 * 题目:二进制中的1的个数
 * 请实现一个函数，输入一个整数，输出该数二进制表示1的个数。
 * 例如:把9表示成二进制是1001，有两位是1，因此如果输入9，函数返回2.
 *
 * 这是一道很基本的考察二进制和位运算的面试题。
 *
 * 基本思路：(1)先判断整数二进制表示中最右边一位是不是1；
 *          (2)接着把输入的整数右移一位，此时原来处于从右边数起的第二位被移到最右边了，再判断是不是1；
 *          (3)这样每次移动一位，知道整个整数变为0为止。
 * 现在的问题变成了怎么判断一个整数的最右边是不是1.
 * 如果一个整数与1做与运算的结果是1，则表示该整数最右边一位是1，否则是0.
 * 基于这种思路
 */