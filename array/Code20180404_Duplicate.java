package alogorithms.array;

/**
 * Created with IntelliJ IDEA
 * Author: aleng
 * Date  : 2018/4/4
 * Time  : 11:02
 * Description: 数组中重复的数字
 **/
public class Code20180404_Duplicate {

    public static boolean duplicate(int[] numbers){
        //首先判断是否为空数组或者是为空
        if ( numbers ==null||numbers.length <= 0){
            return false;
        }
        //判断数组内的值都在0~(lenth-1)之间
        for (int i = 0; i < numbers.length; i++) {
            if (numbers[i] < 0 || numbers[i] >= numbers.length){
                return false;
            }
        }
        for (int i = 0; i < numbers.length; i++) {
            while (numbers[i] != i){
                if(numbers[i] == numbers[numbers[i]]){
                    return true;
                }
                int temp = numbers[i];
                numbers[i] = numbers[temp];
                numbers[temp] = temp;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[] a = {1,2,2,4,3};
        System.out.println(duplicate(a));
    }
}
/**
 * 题目:数组中重复的数字
 * 在一个长度为n的数组里所有数字都在0~n-1的范围内。数组中某些数字是重复的，但不知道有几个数字重复了，
 * 也不知道每个数字重复了几次。请找出数组中任意一个重复的数字。例如:如果输入长度为7的数组
 * {2,3,1,0,2,5,3}，那么对应的输出是重复的数字2或者3。
 *
 * 1.将数组排序，需要O(nlogn)
 * 2.将数组放入到哈希表中。时间复杂度O(n),但是哈希表占空间复杂度
 * 3.时间复杂度为O(N)，空间复杂度O(1)
 */
