package alogorithms.structure;

/**
 * Created with IntelliJ IDEA
 * Author: aleng
 * Date  : 2018/6/25
 * Time  : 16:12
 * Description: RandomListNode
 **/
public class RandomListNode {
    public int label;
    public RandomListNode next;
    public RandomListNode random;

    public RandomListNode(int val) {
        this.label = val;
    }

    @Override
    public String toString() {
        StringBuilder ret = new StringBuilder();
        RandomListNode cur = this;
        while (cur != null) {
            ret.append(cur.label);
            if (cur.random != null)
                ret.append("(" + cur.random.label + ")");
            else {
                ret.append("(_)");
            }
            ret.append('\t');
            cur = cur.next;
        }
        return ret.toString();
    }
}
