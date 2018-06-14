package alogorithms.tree;

import alogorithms.structure.TreeNode;

/**
 * Created with IntelliJ IDEA
 * Author: aleng
 * Date  : 2018/5/3
 * Time  : 16:54
 * Description:树的子结构
 **/
public class Code20180503_HasSubtree {

    public static boolean hasSubtree(TreeNode root1, TreeNode root2) {
        boolean  res = false;
        if (root2 != null && root1 != null){
            if (root1.val == root2.val){
                res = doseTree1HavaTree2(root1,root2);
            }
            if (!res){
                return hasSubtree(root1.left,root2) ||
                        hasSubtree(root1.right,root2);
            }
        }
        return res;
    }
    private static boolean doseTree1HavaTree2(TreeNode root1, TreeNode root2) {

        if (root2 == null){
            return true;
        }
        if (root1 == null){
            return false;
        }
        if (root1.val != root2.val){
            return false;
        }
        return doseTree1HavaTree2(root1.left,root2.left)&&
                doseTree1HavaTree2(root1.right,root2.right);
    }
}
/**
 *
 * 题目:树的子结构
 * 输入两课二叉树A和B，判断B是不是A的子结构。
 * 我们约定空树不是任意一个树的子结构
 * 一、若根节点相等，利用递归比较他们的子树是否相等，
 * 二、若根节点不相等，则利用递归分别在左右子树中查找。
 */