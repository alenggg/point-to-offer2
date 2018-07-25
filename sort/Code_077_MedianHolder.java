package alogorithms.sort;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * Created with IntelliJ IDEA
 * Author: aleng
 * Date  : 2018/6/26
 * Time  : 19:23
 * Description: 数据流中的中位数
 **/
public class Code_077_MedianHolder {

    private PriorityQueue<Integer> maxHeap = new PriorityQueue<Integer>(new MaxHeapComparator());
    private PriorityQueue<Integer> minHeap = new PriorityQueue<Integer>();
    //前面2/n放在大根堆
    //后面2/n放在小根堆
    public void insert(Integer num) {
        if (this.maxHeap.isEmpty()) {
            this.maxHeap.add(num);
            return;
        }
        if (this.maxHeap.peek() >= num) {
            this.maxHeap.add(num);
        } else {
            if (this.minHeap.isEmpty()) {
                this.minHeap.add(num);
                return;
            }
            if (this.minHeap.peek() > num) {
                this.maxHeap.add(num);
            } else {
                this.minHeap.add(num);
            }
        }
       if (maxHeap.size() == minHeap.size() + 2){
           minHeap.add(maxHeap.poll());
       }
       if (minHeap.size() == maxHeap.size() + 2){
           maxHeap.add(minHeap.poll());
       }
    }

    public Double getMedian() {
        int maxHeapSize = maxHeap.size();
        int minHeapSize = minHeap.size();
        if (maxHeapSize + minHeapSize == 0) {
            return null;
        }
        if (maxHeapSize == 0 || minHeapSize == 0){
            return (double)maxHeapSize == 0 ? (double)minHeap.peek() : (double)maxHeap.peek();
        }
        double maxHeapHead = maxHeap.peek();
        double minHeapHead = minHeap.peek();
        if (maxHeapSize == minHeapSize) {
            return (maxHeapHead + minHeapHead) / 2;
        }
        return maxHeapSize > minHeapSize ? maxHeapHead : minHeapHead;
    }

    public static class MaxHeapComparator implements Comparator<Integer> {
        @Override
        public int compare(Integer o1, Integer o2) {
            return o2 - o1;
        }
    }

    public static void main(String[] args) {
        //[5,2,3,4,1,6,7,0,8]
        Code_077_MedianHolder test = new Code_077_MedianHolder();
        test.insert(5);
        System.out.println(test.getMedian());
        test.insert(2);
        System.out.println(test.getMedian());
        test.insert(3);
        System.out.println(test.getMedian());
        test.insert(4);
        System.out.println(test.getMedian());
        test.insert(1);
        System.out.println(test.getMedian());
        test.insert(6);
        System.out.println(test.getMedian());
        test.insert(7);
        System.out.println(test.getMedian());
        test.insert(0);
        System.out.println(test.getMedian());
        test.insert(8);
        System.out.println(test.getMedian());

    }
}
/**
 *
 * 前面2/n放在大根堆，后面2/n放在小根堆
 * 小根堆的数一定比大根堆的数要大！！
 */
