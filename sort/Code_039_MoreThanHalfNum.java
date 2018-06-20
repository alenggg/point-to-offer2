package alogorithms.sort;

/**
 * Created with IntelliJ IDEA
 * Author: aleng
 * Date  : 2018/5/21
 * Time  : 16:36
 * Description:数组中出现次数超过一半的数字
 **/
public class Code_039_MoreThanHalfNum {

    public int moreThanHalfNum_Solution(int [] array) {
        int maxCount = array[0];
        int number = array[0];
        int count = 1;
        for (int i = 1; i < array.length; i++) {
            if (number != array[i]) {
                if (count == 0) {
                    number = array[i];//保存下一个数字并把次数设置为1
                    count = 1;
                }else {
                    count--;
                }
            }else {
                count++;
            }
            if (count == 1) {
                maxCount = number;
            }
        }
        //验证
        int num = 0;
        for (int j = 0; j < array.length; j++) {
            if (array[j] == maxCount) {
                num++;
            }
        }
        if (num * 2 > array.length) {
            return maxCount;
        }
        return 0;
    }
}
/**
 *
 * 题目:数组中出现次数超过一半的数字
 * 数组中有一个数字出现的次数超过数组长度的一半，请找出这个数字。
 * 例如，输入一个长度为9的数组{1,2,3,2,2,2,5,4,2},2超过数组长度的一半，输出2
 *
 * 思路:出现的次数超过数组长度的一半，表明这个数字出现的次数比其他数出现的次数的总和还多。
 * 考虑每次删除两个不同的数，那么在剩下的数中，出现的次数仍然超过总数的一般，不断重复该过程，排除掉其他的数，
 * 最终找到那个出现次数超过一半的数字。这个方法的时间复杂度是O(N)，空间复杂度是O(1)。
 *
 * 换个思路，这个可以通过计数实现，而不是真正物理删除。
 * 在遍历数组的过程中，保存两个值，一个是数组中数字，一个是出现次数。
 * 当遍历到下一个数字时,
 * 如果这个数字跟之前保存的数字相同，则次数加1;
 * 如果这个数字跟之前保存的数字不同，则次数减1;
 * 如果次数为0，则保存下一个数字并把次数设置为1，
 * 由于我们要找的数字出现的次数比其他所有数字出现的次数之和还要多，
 * 那么要找的数字肯定是最后一次把次数设为1时对应的数字。
 */