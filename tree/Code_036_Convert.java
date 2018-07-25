package alogorithms.tree;

import alogorithms.structure.TreeNode;


/**
 * Created with IntelliJ IDEA
 * Author: aleng
 * Date  : 2018/5/14
 * Time  : 17:03
 * Description:二叉搜索树与双向链表
 **/
public class Code_036_Convert {

    public static TreeNode convert(TreeNode pRootOfTree) {
        //lastlist记录当前节点的上一个节点
        TreeNode lastlist = covertNode(pRootOfTree,null);

        TreeNode pHead = lastlist;

        while (pHead != null && pHead.left != null) {
            pHead = pHead.left;
        }
        return pHead;
    }
    //是中序遍历的加工
    public static TreeNode covertNode(TreeNode root, TreeNode lastlist) {
        if (root == null){
            return null;
        }
        TreeNode cur = root;//记录当前节点
        //左
        if (root.left != null){
            lastlist = covertNode(root.left,lastlist);
        }
        //中
        cur.left = lastlist;
        if (lastlist != null){
            lastlist.right = cur;
        }
        lastlist = cur;
        //右
        if (root.right!= null){
            lastlist = covertNode(root.right,lastlist);
        }
        return lastlist;
    }

    public static void main(String[] args) {

    }
}
/**
 *
 * 题目:二叉搜索树与双向链表
 * 输入一棵二叉搜索树，将该二叉搜索树转换成一个排序的双向链表。
 * 要求不能创建任何新的节点，只能调整数中的节点指针的指向。
 *
 * 由于二叉树的中序遍历具有可以实现递增的功能，同时二叉树的每一个节点都有两个指针，左指针和右指针，
 * 因此我们可以用这些特点将二叉树转换成一个双向链表，每次在递归遍历的时候设置一个pre，记录中序遍历时当前节点的前节点，
 * 然后将当前节点的左指针指向pre节点，然后如果pre节点不为空则将pre的右节点指向当前节点，
 * 由此就形成了一个双向链表的前后指针。每次递归重复这两步，则可以形成一个完整的双向链表。
 *
 * 最后一步就是双向链表已经构建完成了，而题目要求返回双向链表，则从原二叉树的root节点往前遍历找到双向链表的头返回即可。
 *
 * 思路:定义一个链表的尾节点，递归处理左右子树，最后返回链表的头节点
 * 考虑递归，先考虑最小的情况就是一个节点的时候的特殊情况容易理解
 *
 * 找最小规模，然后在变成递归
 */