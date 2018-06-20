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
}
/**
 *
 * 题目:二叉搜索树与双向链表
 * 输入一棵二叉搜索树，将该二叉搜索树转换成一个排序的双向链表。
 * 要求不能创建任何新的节点，只能调整数中的节点指针的指向。
 *
 * 思路:定义一个链表的尾节点，递归处理左右子树，最后返回链表的头节点
 * 考虑递归，先考虑最小的情况就是一个节点的时候的特殊情况容易理解
 *
 * 找最小规模，然后在变成递归
 */