package alogorithms.stackqueue;

import java.util.LinkedList;

/**
 * Created with IntelliJ IDEA
 * Author: aleng
 * Date  : 2018/6/18
 * Time  : 19:35
 * Description: 滑动窗口的最大值
 **/
public class Code20180618_GetMaxWindow {

    public static int[] getMaxWindow(int[] arr, int w){
        if(arr == null || arr.length < w){
            return null;
        }
        LinkedList<Integer> qmax = new LinkedList<>(); //滑块用双端队列定义
        int[] res = new int[arr.length - w + 1]; //返回的最大值数组
        int index = 0;//最大值数组的下标
        for (int i = 0; i < arr.length; i++) {
            //如果滑块不空,滑块队尾元素小于等于数组当前元素
            while (!qmax.isEmpty() && arr[qmax.peekLast()] <= arr[i]){
                qmax.pollLast();
            }
            qmax.addLast(i);
            /***
             * 如果滑块qmax队头的下标 = i-w，说明当前qmax队头的下边已过期，弹出当前队头的下标即可。
             * 窗口的大小只是在这里起作用，是用来判断最大值是否过期。
             */
            if(qmax.peekFirst() == i - w){
                qmax.pollFirst();
            }

            //从第三位开始，开始计最大值的下标
            if(i >= w-1){
                res[index++] = arr[qmax.peekFirst()];
            }
        }
        return res;
    }

    public static int[] getMinWindow(int[] arr, int w){
        if (arr == null ||arr.length ==0){
            return null;
        }
        LinkedList<Integer> qmin = new LinkedList<>();
        int[] res = new int[arr.length - w + 1];
        int index = 0;//滑块的下标

        for (int i = 0; i < arr.length; i++) {
            while (!qmin.isEmpty() && arr[qmin.peekLast()] >= arr[i]){
                qmin.pollLast();
            }
            qmin.addLast(i);

            if (qmin.peekFirst() == i-w){
                qmin.pollFirst();
            }

            if (i >= w-1){
                res[index++] = arr[qmin.peekFirst()];
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] arr = new int[] {4,3,5,4,3,3,6,7};
        for (int i = 0; i < getMaxWindow(arr,3).length; i++) {
            System.out.print(getMaxWindow(arr,3)[i] + " ");
        }
        System.out.println("\n");
        for (int i = 0; i < getMinWindow(arr,3).length; i++) {
            System.out.print(getMinWindow(arr,3)[i]+ " ");
        }
    }
}

/**
 * 题目：有一个整形数组arr和大小为W的窗口从数组的最左边滑到最右边，窗口每次向右边滑一个位置。
 * 例如数组为{4,3,5,4,3,3,6,7},窗口大小为3时，返回的结果是{5,5,5,4,6,7}
 * @return：一个长度为n-w+1的数组res,res[i]表示每一种窗口状态下的最大值。
 * 每个下标最多进qmax一次，出qmax一次。所以遍历的过程中进出双端队列的操作的时间复杂度是O(n)，
 * 整体的时间复杂度也是O(N)。
 */