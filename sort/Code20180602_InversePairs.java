package alogorithms.sort;

/**
 * Created with IntelliJ IDEA
 * Author: aleng
 * Date  : 2018/6/2
 * Time  : 15:06
 * Description: 数组中的逆序对
 **/
public class Code20180602_InversePairs {

    //数组中的逆序对
    //利用归并排序求逆序对
    public static int InversePairs(int[] array) {
        if (array == null || array.length < 2) {
            return 0;
        }
        return mergeHelp(array, 0, array.length - 1);
    }

    private static int mergeHelp(int[] array, int l, int r) {
        if (l == r) {
            return 0;
        }
        int mid = l + ((r - l) >> 1);
        return mergeHelp(array, l, mid) +
                mergeHelp(array, mid + 1, r) +
                merge(array, l, mid, r);
    }

    private static int merge(int[] array, int l, int m, int r) {
        int[] help = new int[r - l + 1];
        int p1 = l;
        int p2 = m + 1;
        int i = 0;
        int res = 0;
        //是逆序对就加1，不是就不加
        //两者要保持一致
        while (p1 <= m && p2 <= r) {
            res += array[p1] > array[p2] ? (r - p2 + 1) : 0;
            help[i++] = array[p1] > array[p2] ? array[p1++] : array[p2++];
        }
        while (p1 <= m) {
            help[i++] = array[p1++];
        }
        while (p2 <= r) {
            help[i++] = array[p2++];
        }
        for (int j = 0; j < help.length; j++) {
            array[l + j] = help[j];
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(InversePairs(new int[]{7,5,6,4}));
        System.out.println(InversePairs(new int[]{5,6,7,8,1,2,3,4}));
        System.out.println(InversePairs(new int[]{6,5,4,3,2,1}));
    }
}
/*
题目要求：
如果前面一个数字大于后面的数字，则这两个数字组成一个逆序对。
输入一个数组，求出这个数组中的逆序对总数。
例如输入{7,5,6,4}，一共有5个逆序对，分别是(7,6)，(7,5)，(7,4)，(6,4)，(5,4)。

解题思路：
思路1：暴力解决。
顺序扫描数组，对于每个元素，与它后面的数字进行比较，因此这种思路的时间复杂度为o(n^2)。

思路2：
在比较之后可以进行局部的排序，从而降低比较的次数，降低时间复杂度。
可通过如下步骤求逆序对个数：
先把数组逐步分隔成长度为1的子数组，统计出子数组内部的逆序对个数，
然后再将相邻两个子数组合并成一个有序数组并统计数组之间的逆序对数目，
直至合并成一个大的数组。其实，这是二路归并的步骤，只不过在归并的同事要多进行一步统计。
因此时间复杂度o(nlogn)，空间复杂度o(n)，如果使用原地归并排序，可以将空间复杂度降为o(1)。

 */