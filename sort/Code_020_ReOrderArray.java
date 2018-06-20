package alogorithms.sort;

/**
 * Created with IntelliJ IDEA
 * Author: aleng
 * Date  : 2018/4/25
 * Time  : 16:29
 * Description: 调整数组顺序使奇数位于偶数前面
 **/
public class Code_020_ReOrderArray {

    public static void reOrderArray(int [] array) {
        if (array == null || array.length == 0){
            return;
        }
        int odd = -1;           //奇数区域
        int even = array.length;//偶数区域
        int i = 0;
        while (even - odd > 1 ){
            if (array[i] % 2 == 0){
                swap(array,i,--even);
            }else if (array[i] % 2 == 1){
                //swap(array,i, ++odd);
                ++odd;
                ++i;
            }
        }
    }

    public static void reOrderArray2(int [] array) {
        if (array == null || array.length == 0){
            return;
        }
        int[] temp = new int[array.length];
        for (int i = 0; i < array.length; i++) {
            temp[i] = array[i];
        }
        int j = temp.length - 1;
        for (int i = temp.length -1; i >= 0 ; i--) {
            if (temp[i] % 2 == 0){
                array[j--] = temp[i];
            }
        }
        j = 0;
        for (int i = 0; i < temp.length; i++) {
            if (temp[i] % 2 == 1){
                array[j++] = temp[i];
            }
        }
    }

    private static void swap(int[] array, int x, int y) {
        int temp = array[x];
        array[x] = array[y];
        array[y] = temp;
    }
}
/**
 *
 * 题目:调整数组顺序使奇数位于偶数前面
 * 输入一个数组数组，实现一个函数来调整该数组中数字的顺序，使得所有奇数位于数组的前半部分
 * 所有偶数部分位于数组的后半部分
 */