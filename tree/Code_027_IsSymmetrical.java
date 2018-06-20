package alogorithms.tree;

import alogorithms.structure.TreeNode;

/**
 * Created with IntelliJ IDEA
 * Author: aleng
 * Date  : 2018/5/5
 * Time  : 9:50
 * Description: 对称的二叉树
 **/
public class Code_027_IsSymmetrical {

    public boolean isSymmetrical(TreeNode pRoot){
        if (pRoot == null)
            return true;
        return isCommon(pRoot.left, pRoot.right);
    }
    public boolean isCommon(TreeNode leftNode, TreeNode rightNode) {
        if (leftNode == null && rightNode == null)
            return true;
        if (leftNode != null && rightNode != null)
            return leftNode.val == rightNode.val &&
                    isCommon(leftNode.left,rightNode.right) &&
                    isCommon(leftNode.right,rightNode.left);
        return false;
    }

    public boolean isSymmetrical2(TreeNode pRoot)
    {
        return isSymmetrical2(pRoot,pRoot);
    }

    private boolean isSymmetrical2(TreeNode pRoot1, TreeNode pRoot2) {
        if(pRoot1 == null && pRoot2 == null){
            return true;
        }
        if (pRoot1 == null || pRoot2 == null){
            return false;
        }
        if (pRoot1.val != pRoot2.val){
            return false;
        }
        return isSymmetrical2(pRoot1.left,pRoot2.right) && isSymmetrical2(pRoot1.right,pRoot2.left);
    }

    public static void main(String[] args) {

    }
    /**
     * bool isSymmetric(TreeNode* root) {
     *         if(root==NULL) return true;
     *         queue<TreeNode*> q1,q2;
     *         TreeNode *left,*right;
     *         q1.push(root->left);
     *         q2.push(root->right);
     *         while(!q1.empty() and !q2.empty())
     *         {
     *             left = q1.front();
     *             q1.pop();
     *             right = q2.front();
     *             q2.pop();
     *             //两边都是空
     *             if(NULL==left && NULL==right)
     *                 continue;
     *             //只有一边是空
     *             if(NULL==left||NULL==right)
     *                 return false;
     *              if (left->val != right->val)
     *                 return false;
     *             q1.push(left->left);
     *             q1.push(left->right);
     *             q2.push(right->right);
     *             q2.push(right->left);
     *         }
     *         return true;
     *     }
     */
}
/**
 * 5月5号
 * 题目:对称的二叉树
 * 请实现一个函数，用来判断一颗二叉树是不是对称的。如果一颗二叉树和它的镜像一样，那么它是对称的。
 *
 * 思路1：
 * 利用递归进行判断，若左子树的左孩子等于右子树的右孩子且左子树的右孩子等于右子树的左孩子，并
 * 且左右子树节点的值相等，则是对称的。
 *
 * 思路2：
 * 如果先序遍历的顺序分为两种先左后右和先右后左两种顺序遍历，如果两者相等说明二叉树是对称的二叉树
 *
 */