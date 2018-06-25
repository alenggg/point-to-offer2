package alogorithms.dynamic_programming;

import alogorithms.structure.ListNode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA
 * Author: aleng
 * Date  : 2018/6/24
 * Time  : 15:46
 * Description: 青蛙跳台阶
 **/
public class Code_075_JumpFloor {
    //f(n) = f(n-1) + f(n-2)
    public static int jumpFloor(int target) {
        if (target <= 0) {
            return 0;
        }
        if (target == 1) {
            return 1;
        }
        int[] res = new int[target];
        res[0] = 1;
        res[1] = 2;
        for (int i = 2; i < res.length; i++) {
            res[i] = res[i - 1] + res[i - 2];
        }
        return res[target - 1];
    }

    //f(n) = f(n-1) + f(n-2) +...+f(1) + 1
    //每个台阶都有跳与不跳两种情况（除了最后一个台阶），最后一个台阶必须跳。所以共用2^(n-1)中情况
    public int jumpFloorII(int target) {
        if (target <= 0) {
            return 0;
        }
        if (target == 1) {
            return 1;
        }
        int[] res = new int[target];
        res[0] = 1;
        res[1] = 2;
        int temp = res[0] + res[1];
        for (int i = 2; i < res.length; i++) {
            res[i] = temp + 1;
            temp += res[i];
        }
        return res[target - 1];
    }

    public int RectCover(int target) {
        if (target <= 0) {
            return 0;
        }
        if (target == 1) {
            return 1;
        }
        int[] res = new int[target];
        res[0] = 1;
        res[1] = 2;
        for (int i = 2; i < res.length; i++) {
            res[i] = res[i - 1] + res[i - 2];
        }
        return res[target - 1];
    }

    public static void main(String[] args) {
        System.out.println(jumpFloor(0));
        System.out.println(jumpFloor(1));
        System.out.println(jumpFloor(2));
        System.out.println(jumpFloor(3));
        System.out.println(jumpFloor(4));
        System.out.println(jumpFloor(5));
    }
}
/**
 * 一只青蛙一次可以跳上1级台阶，也可以跳上2级。
 * 求该青蛙跳上一个n级的台阶总共有多少种跳法。
 * <p>
 * 一只青蛙一次可以跳上1级台阶，也可以跳上2级……它也可以跳上n级。
 * 求该青蛙跳上一个n级的台阶总共有多少种跳法。
 *
 * 我们可以用2*1的小矩形横着或者竖着去覆盖更大的矩形。
 * 请问用n个2*1的小矩形无重叠地覆盖一个2*n的大矩形，总共有多少种方法？
 */
