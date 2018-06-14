package alogorithms.sort;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created with IntelliJ IDEA
 * Author: aleng
 * Date  : 2018/5/22
 * Time  : 16:38
 * Description:最小的k个数
 **/
public class Code20180522_GetLeastNumbers {

    public static ArrayList<Integer> getLeastNumbers_Solution(int[] input, int k) {
        ArrayList<Integer> res = new ArrayList<>();
        if (input == null || k <= 0 || k > input.length) {
            return res;
        }
        int[] temp = Arrays.copyOfRange(input, 0, k);
        //创建大根堆
        for (int i = 0; i < temp.length; i++) {
            while (temp[i] > temp[(i - 1) / 2]) {
                swap(temp, i, (i - 1) / 2);
                i = (i - 1) / 2;
            }
        }
        for(int i = k; i < input.length; i++) {
            if(input[i] < temp[0]) {
                temp[0] = input[i];
                //替换完以后调整大根堆
                maxHeap(temp, 0);
            }
        }
        for (int i = temp.length - 1; i >= 0; i--) {
            res.add(temp[i]);
        }
        return res;
    }

    private static void maxHeap(int[] arr, int index) {

        int size = arr.length;
        int left = 2 * index + 1;

        while (left < size) {
            int largest = left + 1 < size && arr[left] <= arr[left + 1] ? left + 1 : left;
            largest = arr[largest] >= arr[index] ? largest : index;
            if (index == largest) {
                break;
            }
            swap(arr,index,largest);

            index = largest;
            left = 2 * index + 1;
        }

    }

    private static void swap(int[] array, int x, int y) {
        int temp = array[x];
        array[x] = array[y];
        array[y] = temp;
    }
}
/**
 *
 * 题目:最小的k个数
 * 输入n个整数,找出其中最小的k个数。
 * 例如，输入4,5,1,6,2,7,3,8这8个数字,则最小的4个数字是1,2,3,4
 *
 * O(nlogk)的算法，特别适用处理海量数据
 * 我们可以先创建一个大小为k的数据容器来存储最小的k个数字，接下来我们每次从输入的n个整数中读入一个数。
 * 如果容器中已有数字少于k个，则直接把这次读入的整数放入容器中；
 * 如果容器中已有k个数字了，也就是容器已满，此时我们不能再插入新的数字了而只能替换已有的数字。
 * 找出这已有的k个数中的最大值，然后拿这次待插入的整数和最大值进行比较。
 * 如果待插入的值比当前已有的最小值小，则用这个数替换当前已有的最大值；
 * 如果待插入的值比当前已有的最大值还大，那么这个数不可能是最小的k个整数之一，于是我们可以抛弃这个整数。
 *
 * 因此当容器满了之后，我们要做3件事；
 * 一是在k个整数中找到最大数；
 * 二是有可能在这个容器中删除最大数；
 * 三是有可能要插入一个新的数字。
 * 如果用一个二叉树来实现这个容器，那么我们能在O(logk）时间内实现这三步操作。
 * 因此对于n个输入的数字而言，总的时间效率是O(nlogk).
 *
 * 我们可以选择用不同的二叉树来实现这个数据容器。由于每次都需要找到k个整数中的最大数字，我们很容易想到用最大堆。
 * 在最大堆中，根节点的值总是大于它的子树中的任意结点的值。
 * 于是我们每次可以在O(1）得到已有的k个数字中的最大值，但需要O(logk)时间完成删除及插入操作。
 */