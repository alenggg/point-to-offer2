package alogorithms.sort;

import alogorithms.A_newcoder.basic_class_03.Code_06_RandomPool;

import java.util.PriorityQueue;

/**
 * Created with IntelliJ IDEA
 * Author: aleng
 * Date  : 2018/7/2
 * Time  : 10:52
 * Description: 哈夫曼编码(小根堆结构)
 **/
public class Code_078_LessMoney {

    public static int lessMoney(int[] arr) {
        PriorityQueue<Integer> less = new PriorityQueue(); //默认小根堆
        if (arr == null) {
            return 0;
        }
        for (int i = 0; i < arr.length; i++) {
            less.add(arr[i]);
        }
        int res = 0;
        int cur = 0;
        while (less.size() > 1) {
            cur = less.poll() + less.poll();
            res += cur;
            less.add(cur);
        }
        return res;
    }

    public static void main(String[] args) {
        // solution
        int[] arr = { 6, 7, 8, 9 };
        System.out.println(lessMoney(arr));

        int[] arrForHeap = { 3, 5, 2, 7, 0, 1, 6, 4 };

        // min heap
        PriorityQueue<Integer> minQ1 = new PriorityQueue<>();
        for (int i = 0; i < arrForHeap.length; i++) {
            minQ1.add(arrForHeap[i]);
        }
        while (!minQ1.isEmpty()) {
            System.out.print(minQ1.poll() + " ");
        }
        System.out.println();

    }
}
/**
 * 一块金条切成两半， 是需要花费和长度数值一样的铜板的。 比如长度为20的
 * 金条， 不管切成长度多大的两半， 都要花费20个铜板。 一群人想整分整块金
 * 条， 怎么分最省铜板？
 * 例如,给定数组{10,20,30}， 代表一共三个人， 整块金条长度为10+20+30=60.
 * 金条要分成10,20,30三个部分。
 * 如果，
 * 先把长度60的金条分成10和50， 花费60
 * 再把长度50的金条分成20和30， 花费50
 * 一共花费110铜板。
 * 但是如果，
 * 先把长度60的金条分成30和30， 花费60
 * 再把长度30金条分成10和20， 花费30
 * 一共花费90铜板。
 * 输入一个数组， 返回分割的最小代价。
 */