package alogorithms.array;

/**
 * Created with IntelliJ IDEA
 * Author: aleng
 * Date  : 2018/4/15
 * Time  : 16:10
 * Description:旋转数组的最小数字
 **/
public class Code20180415_MinNumberInRotateArray {

    public static int minNumberInRotateArray(int[] array) {
        if (array == null || array.length <= 0){
            return 0;
        }
        int low = 0; //前面一个指针
        int high = array.length - 1;//末尾一个指针
        int mid = low ; //中间指针,一开始放在0下标
        while (array[low] >= array[high]){
            if (array[low] == array[mid] && array[mid] == array[high]){
                mid = minInOrder(array,low,high);
                break;
            }
            if (high - low == 1){
                mid = high;
                break;
            }
            mid = (low + high) / 2;
            if (array[mid] >= array[low]){
                low = mid;
            }else if (array[mid] <= array[high]){
                high = mid;
            }
        }
        return array[mid];
    }
    public static int minInOrder(int[] array,int low,int high){
        int min = (low + high) / 2;
        for (int i = low ; i <= high ; i++){
            if (array[i] < array[low]){
                min = i;
                break;
            }
        }
        return min;
    }

    public static void main(String[] args) {

    }
}
/**
 *
 * 题目:旋转数组的最小数字
 * 把一个数组最开始的若干个元素搬到数组的末尾，我们称之为数组的旋转。
 * 输入一个递增排序的数组的一个旋转，输出旋转数组的最小元素。
 * 例如，数组{3,4,5,1,2}为{1,2,3,4,5}的一个旋转，该数组的最小值为1.
 *
 * 二分查找
 */