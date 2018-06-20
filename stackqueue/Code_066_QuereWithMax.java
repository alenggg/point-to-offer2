package alogorithms.stackqueue;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * Created with IntelliJ IDEA
 * Author: aleng
 * Date  : 2018/6/19
 * Time  : 17:03
 * Description: 队列的最大值
 **/
public class Code_066_QuereWithMax {

    public static class QueueWithMax<T extends Comparable> {
        private Deque<T> queueData; //双端队列
        private Deque<T> queueMax;

        public QueueWithMax() {
            this.queueData = new ArrayDeque<>();
            this.queueMax = new ArrayDeque<>();
        }

        public T max() {
            if (queueMax.isEmpty())
                return null;
            return queueMax.getFirst();
        }

        public void pushBack(T value) {
            while (!queueMax.isEmpty() && value.compareTo(queueMax.getLast()) > 0){
                queueMax.removeLast();
            }
            queueMax.addLast(value);
            queueData.addLast(value);
        }

        public T popFront() {
            if (queueData.isEmpty())
                return null;
            if ( queueData.peekFirst() == queueMax.peekFirst())
                queueMax.removeFirst();
            return queueData.pollFirst();
        }
    }

    public static void main(String[] args) {
        QueueWithMax<Integer> queue = new QueueWithMax<>();
        queue.pushBack(3);
        System.out.println(queue.max());
        queue.pushBack(5);
        System.out.println(queue.max());
        queue.pushBack(1);
        System.out.println(queue.max());
        System.out.println("开始出队后，调用max");

        System.out.println(queue.max());
        queue.popFront();

        System.out.println(queue.max());
        queue.popFront();

        System.out.println(queue.max());
        queue.popFront();

        System.out.println(queue.max());

    }
}
/**
 * 假设辅助队列为空。那么，当数据入队列的时候就须要同一时候放入队列和辅助队列中；
 * 假设辅助队列不为空，可是入队列的那个元素比辅助队列的队首元素大或者相等。
 * 那么。也是须要同一时候放入两个队列中；其它情况，仅仅须要放入队列中就能够了。
 * 当出队列的时候，假设队列的队首元素和辅助队列的队首元素同样，那么须要队列和辅助队列同一时候删掉队首元素。
 *
 */