package alogorithms.sort;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * Created with IntelliJ IDEA
 * Author: aleng
 * Date  : 2018/7/3
 * Time  : 15:28
 * Description: 求最大利润
 **/
public class Code_079_IPO {

    public static class Node {
        public int p;
        public int c;

        public Node(int c, int p) {
            this.p = p;
            this.c = c;
        }
    }
    public static class MinCostComparator implements Comparator<Node> {
        @Override
        public int compare(Node o1, Node o2) {
            return o1.c - o2.c ;
        }
    }
    public static class MaxProfitComparator implements Comparator<Node> {
        @Override
        public int compare(Node o1, Node o2) {
            return o2.p - o1.p ;
        }
    }

    public static int findMaximizedCapital(int k, int W, int[] Profits, int[] Capital) {

        Node[] nodes = new Node[Profits.length];
        for (int i = 0; i < Profits.length; i++) {
            nodes[i] = new Node(Capital[i],Profits[i]);//花费，利润
        }
        PriorityQueue<Node> less = new PriorityQueue<Node>(new MinCostComparator()); //小根堆
        PriorityQueue<Node> more = new PriorityQueue<Node>(new MaxProfitComparator());//大根堆
        for (int i = 0; i < Capital.length; i++) {
            less.add(nodes[i]);
        }
        for (int i = 0; i < k; i++) {
            while (!less.isEmpty() && less.peek().c <= W) {
                more.add(less.poll());
            }
            if (more.isEmpty()) {
                return W;
            }
            W += more.poll().p;
        }
        return W;
    }

    public static void main(String[] args) {

    }
}
/**
 * 输入：
 * 参数1， 正数数组costs
 * 参数2， 正数数组profits
 * 参数3， 正数k
 * 参数4， 正数m
 * costs[i]表示i号项目的花费
 * profits[i]表示i号项目在扣除花费之后还能挣到的钱(利润)
 * k表示你不能并行、 只能串行的最多做k个项目
 * m表示你初始的资金
 * 说明： 你每做完一个项目， 马上获得的收益， 可以支持你去做下一个
 * 项目。
 * 输出：
 * 你最后获得的最大钱数
 */