package alogorithms.dynamic_programming;

/**
 * Created with IntelliJ IDEA
 * Author: aleng
 * Date  : 2018/5/23
 * Time  : 16:40
 * Description:连续子数组的最大和
 **/
public class Code_041_FindGreatestSumOfSubArray {

    public static int findGreatestSumOfSubArray(int[] arr){
        if (arr == null || arr.length == 0){
            return 0;
        }
        int sum = arr[0];
        int max = sum;
        for (int i = 1; i < arr.length; i++) {
            sum = Math.max(sum+arr[i],arr[i]);
            if (max < sum){
                max = sum;
            }
        }
        return max;
    }
}
/**
 *
 * 题目:连续子数组的最大和
 * 输入一个整形数组，数组里有正数也有负数。数组中的一个或连续多个整数组成的一个子数组。
 * 求所有子数组的和的最大值。要求时间复杂度为O(n)。
 *
 * 例如 {1,-2,3,10,-4,7,2,-5}
 * 思路:我们从头开始累加数组的元素，初始值sum为0 。
 * 第一步把1累加则sum = 1,
 * 接着-2累加sum = -1，
 * 再接着3累加sum = 2，
 * 但是此时我们发现 sum < 3，
 * 也就是说从第一个元素开始累加到第三个元素的和sum比第三个元素还要小，
 * 那么我们舍去前面的累加值，从第三个元素开始累加,此时sum=3。
 * 用max记录当前最大和，如果加完比max小，max不变,否则max等于当前和
 * 继续上述步骤，直至遍历到数组的最后一个元素
 */
