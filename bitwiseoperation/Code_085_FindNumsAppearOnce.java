package alogorithms.bitwiseoperation;

/**
 * Created with IntelliJ IDEA
 * Author: aleng
 * Date  : 2018/7/13
 * Time  : 15:17
 * Description: 数组中有两个出现一次的数字，其他数字都出现两次，找出这两个数字
 **/
public class Code_085_FindNumsAppearOnce {

    /**
     * 数组中有两个出现一次的数字，其他数字都出现两次，找出这两个数字
     * 第一个for()循环是把所有数字异或，最终的结果就是那两个出现一次的数字a,b异或的结果。因为a，b不想等，因此结果肯定不为0
     * 第二个for()的意思是：sum的二进制表示中，1的位数，表示的是两个唯一数字二进制表示中不同的位，我们就找出第一个1所在的位数(index)
     * 第三个for()循环中按照这个位将数组分成两个子数组，分组标准是数字在这个位上的值是否为1（此时数字相同的各位也相同，在同一个组中；
     * 不同数字，也就不在同一组里）。
     * 之后按照异或分别找出那两个唯一数即可。
     * <p>
     * 例子:
     * 相关数字的二进制表示为：
     * 2 = 0010       3 = 0011       4 = 0100
     * 5 = 0101       6 = 0110
     * <p>
     * 步骤1 全体异或：2^4^3^6^3^2^5^5 = 4^6 = 0010
     * 步骤2 确定位置：对于0010，从右数的第二位为1，因此可以根据倒数第2位是否为1进行分组
     * 步骤3 进行分组：分成[2,3,6,3,2]和[4,5,5]两组
     * 步骤4 分组异或：2^3^6^3^2 = 6，4^5^5 = 4，因此结果为4，6。
     */
    public static void findNumsAppearOnce(int[] array, int num1[], int num2[]) {
        if (array == null || array.length <= 1) {
            num1[0] = num2[0] = 0;
            return;
        }
        int len = array.length, index = 0, sum = 0;
        for (int i = 0; i < len; i++) {
            sum ^= array[i];
        }
        for (index = 0; index < 32; index++) {
            if ((sum & (1 << index)) != 0) break;
        }
        for (int i = 0; i < len; i++) {
            if ((array[i] & (1 << index)) != 0) {
                num2[0] ^= array[i];
            } else {
                num1[0] ^= array[i];
            }
        }
    }

    /**
     * 数组a中只有一个数出现一次，其他数都出现了2次，找出这个数字
     */
    public static int find1From2(int[] A) {
        int len = A.length, res = 0;
        for (int i = 0; i < len; i++) {
            res = res ^ A[i];
        }
        return res;
    }

    public int singleNumber(int[] A) {
        if (A == null) {
            return -1;
        }
        int len = A.length, res = 0;
        for (int i = 0; i < len; i++) {
            res = res ^ A[i];
        }
        return res;
    }

    /**
     * Given an array of integers, every element appears three times except for one.
     * Find that single one.
     * <p>
     * Note:
     * Your algorithm should have a linear runtime complexity.
     * Could you implement it without using extra memory?
     */
    public static int find1From3(int[] A) {
        int[] bits = new int[32];
        int len = A.length;
        for (int i = 0; i < len; i++) {
            for (int j = 0; j < 32; j++) {
                bits[j] = bits[j] + ((A[i] >>> j) & 1);
            }
        }
        int res = 0;
        for (int i = 0; i < 32; i++) {
            if (bits[i] % 3 != 0) {
                res = res | (1 << i);
            }
        }
        return res;
    }

    public int singleNumber2(int[] A) {
        int ones = 0;//记录只出现过1次的bits
        int twos = 0;//记录只出现过2次的bits
        int threes;
        for (int i = 0; i < A.length; i++) {
            int t = A[i];
            twos |= ones & t;//要在更新ones前面更新twos
            ones ^= t;
            threes = ones & twos;//ones和twos中都为1即出现了3次
            ones &= ~threes;//抹去出现了3次的bits
            twos &= ~threes;
        }
        return ones;
    }

    public static void main(String[] args) {

    }
}
