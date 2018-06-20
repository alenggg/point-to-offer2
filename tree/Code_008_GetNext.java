package alogorithms.tree;

import alogorithms.structure.TreeLinkNode;

/**
 * Created with IntelliJ IDEA
 * Author: aleng
 * Date  : 2018/4/12
 * Time  : 16:53
 * Description:二叉树的下一个节点
 **/
public class Code_008_GetNext {

    public TreeLinkNode getNext(TreeLinkNode pNode)
    {
        if (pNode == null){
            return null;
        }
        //这个节点有有右子树,下一个节点就是右子树的最左节点
        if (pNode.right != null){
            TreeLinkNode node = pNode.right;
            while (node.left != null){
                node = node.left;
            }
            return node;
        }
        //这个节点没有右子树并且是父节点的左子节点，下一个节点就是父节点
        if(pNode.right == null && pNode.next !=null && pNode.next.left == pNode){
            return pNode.next;
        }
        //这个节点没有右子树并且是父节点的右子节点
        if(pNode.right == null && pNode.next !=null && pNode.next.right == pNode){
            TreeLinkNode node = pNode.next;//父节点
            while (node.next != null){
                if (node.next.left == node){
                    return node.next;
                }
                node = node.next;
            }
            return null;
        }
        //这个节点没有右子树也没有父节点，那么就有下一个节点
        if(pNode.right == null && pNode.next == null){
            return null;
        }
        return null;
    }
}
/**
 *
 * 二叉树的下一个节点
 * 题目:给定一课二叉树和其中一个节点，如何找出中序遍历序列的下一个节点？树中的节点除了有两个分别
 * 指向左、右节点的指针，还有一个指向父节点的指针
 * 在中序遍历中一个节点的下一个节点的可能性:
 * (1)这个节点有有右子树,下一个节点就是右子树的最左节点
 * (2)这个节点是父节点的左子节点，下一个节点就是父节点
 * (3)这个节点是父节点的右子节点，同时没有右子树。
 * 沿着父节点一直向上遍历，知道找到一个是它父节点的左子节点的节点，这就是下一个节点
 * 一共就三种可能
 */