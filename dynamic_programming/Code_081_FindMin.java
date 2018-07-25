package alogorithms.dynamic_programming;

import java.util.Objects;

/**
 * Created with IntelliJ IDEA
 * Author: aleng
 * Date  : 2018/7/9
 * Time  : 9:42
 * Description: 找最短路径
 **/
public class Code_081_FindMin {
    //[2,3,1,1,4]
    public static int findMin(int[] arr) {
        if (arr == null || arr.length <= 1) {
            return 0;
        }
        return findMin(arr, 0, arr.length - 1);
    }

    private static int findMin(int[] arr, int left, int right) {
        if (left == right) {
            return 0;
        }
        int min = arr.length - left - 1;
        for (int i = arr[left]; i >= 1; --i) {
            if (i > arr.length - left - 1) {
                i = arr.length - left - 1;
            }
            int path = 1 + findMin(arr, left + i, right);
            if (path < min)
                min = path;
        }
        return min;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{2, 3, 1, 1, 5};
        int[] arr2 = new int[]{7, 1, 1, 1, 5};
        System.out.println(findMin(arr));
        System.out.println(findMin(arr2));
    }
}
