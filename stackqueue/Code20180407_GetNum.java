package alogorithms.stackqueue;

import java.util.LinkedList;

/**
 * Created with IntelliJ IDEA
 * Author: aleng
 * Date  : 2018/4/7
 * Time  : 11:46
 * Description: 子数组中最大值减去最小值小于或等于num的子数组数量
 **/
public class Code20180407_GetNum {

    public static int getNum(int[] arr,int num){
        if(arr == null || arr.length == 0){
            return 0;
        }
        LinkedList<Integer> qmin = new LinkedList<>();
        LinkedList<Integer> qmax = new LinkedList<>();
        int i = 0;
        int j = 0;
        int res = 0;
        while (i < arr.length){
            while (j < arr.length){
                while (!qmax.isEmpty() && arr[qmax.peekLast()] <= arr[j]){
                    qmax.pollLast();
                }
                qmax.addLast(j);

                while (!qmin.isEmpty() && arr[qmin.peekLast()] >= arr[j]){
                    qmin.pollLast();
                }
                qmin.addLast(j);

                if(arr[qmax.peekFirst()] - arr[qmin.peekFirst()] > num){
                    break;
                }
                j++;
            }

            if(qmax.peekFirst() == i){
                qmax.pollFirst();
            }
            if(qmin.peekFirst() == i){
                qmin.pollFirst();
            }
            System.out.println(j-i);
            res += j-i;
            i++;
        }
        return res;
    }
}

/**
 * 题目:子数组中最大值减去最小值小于或等于num的子数组数量
 * 给定数组arr和整数num,共返回多少个子数组满足如下情况:
 * max(arr[i..j]) - min(arr[i..j]) <= num
 * 如果数组长度为N,请事先时间复杂度为O(N)的算法
 * 如果子数组arr[i..j]满足条件，那么arr[i..j]中的每个子数组都满足条件.
 * 如果子数组arr[i..j]不满足条件，那么包含arr[i..j]的每个子数组都不满足条件。
 */
