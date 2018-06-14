package alogorithms.search;

/**
 * Created with IntelliJ IDEA
 * Author: aleng
 * Date  : 2018/6/6
 * Time  : 20:53
 * Description: 数组中数字和下标相等的元素
 **/
public class Code20180606_GetNumberSameAsIndex {

    public static int getNumberSameAsIndex(int[] arr){
        if (arr == null || arr.length <= 0){
            return -1;
        }
      return GetNumberSameAsIndex(arr,0,arr.length-1);
    }

    private static int GetNumberSameAsIndex(int[] arr, int l, int r) {

        int mid = l + (r - l) / 2;
        if (mid - 1 >= l && arr[mid] > mid){
            return GetNumberSameAsIndex(arr,l,mid - 1);//容易越界
        }
        if (mid + 1 <= r && arr[mid] < mid){
            return GetNumberSameAsIndex(arr,mid + 1,r);
        }
        return arr[mid] == mid ? mid : -1;
    }

    public static void main(String[] args) {
        System.out.println(getNumberSameAsIndex(new int[]{-3})); //3
        System.out.println(getNumberSameAsIndex(new int[]{-3,-1,1,3,5})); //3
        System.out.println(getNumberSameAsIndex(new int[]{0,1,2,3,4}));   //0~4
        System.out.println(getNumberSameAsIndex(new int[]{4,5,6,7,8}));   //-1
    }
}
/**
 * 假设一个单调递增的数组里的每个元素都是整数并且是唯一的。请编程实现一个函数。
 * 找出数组中任意一个数值等于其下标的元素。
 * 例如:在数组{-3,-1-1,3,5}中，数组3和它的下标相等。
 *
 * 二分查找
 */

