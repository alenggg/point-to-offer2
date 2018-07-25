package alogorithms.array;

import java.util.HashSet;

/**
 * Created with IntelliJ IDEA
 * Author: aleng
 * Date  : 2018/7/20
 * Time  : 9:51
 * Description: Given an unsorted array of integers, find the length of the longest consecutive elements sequence.
 **/
public class Code_104_longestConsecutive {

    public static int longestConsecutive(int[] num) {
        HashSet<Integer> hs = new HashSet<>();
        for (int i : num) {
            hs.add(i);
        }
        int max = 1;
        for (int i : num) {
            if (hs.remove(i)) {
                int val = i;
                int sum = 1;
                int val_big = i + 1;
                int val_small = i - 1;
                while (hs.remove(val_small)) {
                    sum++;
                    val_small--;
                }
                while (hs.remove(val_big)) {
                    sum++;
                    val_big++;
                }
                max = max > sum ? max : sum;
            }

        }
        return max;
    }

    public static void main(String[] args) {
        int[] a = new int[]{1, 2, 2, 2, 3};
        System.out.println(longestConsecutive(a));
    }
}
/**
 * Given an unsorted array of integers, find the length of the longest consecutive elements sequence.
 * <p>
 * For example,
 * Given[100, 4, 200, 1, 3, 2],
 * The longest consecutive elements sequence is[1, 2, 3, 4]. Return its length:4.
 * <p>
 * Your algorithm should run in O(n) complexity.
 */
