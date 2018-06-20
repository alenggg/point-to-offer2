package alogorithms.tree;

import alogorithms.structure.TreeNode;

import java.util.Arrays;

/**
 * Created with IntelliJ IDEA
 * Author: aleng
 * Date  : 2018/4/11
 * Time  : 16:50
 * Description:重建二叉树
 **/
public class Code_007_ReConstructBinaryTree {

    public static TreeNode reConstructBinaryTree(int [] pre, int [] in) {
        if ((pre == null || pre.length == 0) && (in == null||in.length == 0)){
            return null;
        }

        TreeNode treeNode;

        int preLength = pre.length;
        int inLengrh = in.length;
        int root = pre[0];  //根节点
        treeNode = new TreeNode(root);
        int rootIndex = 0;  //根节点在中序遍历的下标
        for (int i = 0; i < inLengrh; i++) {
            if (root == in[i]){
                rootIndex = i;
                break;
            }
        }

        int[] leftPre = Arrays.copyOfRange(pre,1,rootIndex + 1);
        int[] leftIn = Arrays.copyOfRange(in,0,rootIndex);
        treeNode.left = reConstructBinaryTree(leftPre,leftIn);

        int[] rightIn = Arrays.copyOfRange(in,rootIndex + 1,inLengrh);
        int[] rightPre = Arrays.copyOfRange(pre,rootIndex + 1,preLength);
        treeNode.right = reConstructBinaryTree(rightPre,rightIn);

        return treeNode;
    }

    public static void main(String[] args) {
        int pre3[] = {8,6,5,4,10,9,11};
        int in3[] = {5,6,7,8,9,10,11};
        TreeNode root3 = reConstructBinaryTree(pre3, in3);
    }
}
/**
 *
 * 题目:重建二叉树
 * 题目:输入某二叉树的前序遍历和中序遍历的结果，请重建该二叉树。
 * 假设输入的前序遍历和中序遍历的结果中都不包含重复的数字。
 * 例如，输入前序遍历序列{1，2，4，7，3，5，6，8}，中序遍历序列{4,7,2,1,5,3,8,6}
 * 则重建二叉树并输出它的头节点。
 */