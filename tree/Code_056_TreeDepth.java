package alogorithms.tree;

import alogorithms.structure.TreeNode;

/**
 * Created with IntelliJ IDEA
 * Author: aleng
 * Date  : 2018/6/8
 * Time  : 17:36
 * Description: 二叉树的深度
 **/
public class Code_056_TreeDepth {

    public static int treeDepth(TreeNode<Integer> pRoot){
        if (pRoot == null){
            return 0;
        }
        return treeDepth(pRoot.left) > treeDepth(pRoot.right)?
                treeDepth(pRoot.left) + 1
                :treeDepth(pRoot.right) + 1;
    }

    public static void main(String[] args) {

    }
}
