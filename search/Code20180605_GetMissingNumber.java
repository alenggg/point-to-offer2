package alogorithms.search;

/**
 * Created with IntelliJ IDEA
 * Author: aleng
 * Date  : 2018/6/5
 * Time  : 20:16
 * Description: 0~n-1中缺失的数字
 **/
public class Code20180605_GetMissingNumber {

    public static int getMissingNumber(int[] arr){
        if (arr == null || arr.length <= 0){
            return -1;
        }
        return getMissingNumber(arr,0,arr.length - 1 );
    }

    private static int getMissingNumber(int[] arr, int l, int r) {

        if (l == r && arr[l] == l){
            return l + 1;
        }
        int mid = l + (r - l) / 2;
        if (arr[mid] == mid){
            return getMissingNumber(arr,mid + 1,r);
        }
        if (arr[mid] > mid && mid - 1 >= l && arr[mid - 1] > mid - 1){
            return getMissingNumber(arr, l,mid - 1);
        }
        return mid;
    }

    public static void main(String[] args) {
        int[] data0 = new int[]{0};
        int[] data1 = new int[]{0,1,2,3,4,5}; //6
        int[] data2 = new int[]{0,1,3,4,5};   //2
        int[] data3 = new int[]{1,2};         //0
        System.out.println(getMissingNumber(data0));
        System.out.println(getMissingNumber(data1));
        System.out.println(getMissingNumber(data2));
        System.out.println(getMissingNumber(data3));
    }
}

/**
 * 一个长度为n-1的递增排序数组中的所有数字都是唯一的，并且每个数字都在范围0~n-1之内。
 * 在范围n-1内的n个数字有且只有一个数字不在该数字中，请找出这个数字
 *
 * 问题可以转换成在排序数组中找出第一个值和下标不相等的元素。
 */
