package alogorithms.structure;

/**
 * Created with IntelliJ IDEA
 * Author: aleng
 * Date  : 2018/5/30
 * Time  : 15:27
 * Description: 链表节点
 **/
public class ListNode<T> {
    public T val;
    public ListNode<T> next;
    public ListNode(T val){
        this.val = val;
        this.next = null;
    }
    @Override
    public String toString() {
        StringBuilder ret = new StringBuilder();
        ret.append("[");
        for(ListNode cur = this;;cur=cur.next){
            if(cur==null){
                ret.deleteCharAt(ret.lastIndexOf(" "));
                ret.deleteCharAt(ret.lastIndexOf(","));
                break;
            }
            ret.append(cur.val);
            ret.append(", ");
        }
        ret.append("]");
        return ret.toString();
    }
}
