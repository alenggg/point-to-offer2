package alogorithms.tree;

import alogorithms.structure.TreeNode;

import java.util.LinkedList;

/**
 * Created with IntelliJ IDEA
 * Author: aleng
 * Date  : 2018/7/16
 * Time  : 10:32
 * Description: Given a binary tree, find its maximum depth.
 **/
public class Code_090_MaxDepth {
    public static int maxDepth1(TreeNode root) {
        int depth = 0;
        LinkedList<TreeNode> s1 = new LinkedList<>();
        if (root == null){
            return 0;
        }
        s1.add(root);
        int start = 0;
        int end = 1;
        while (!s1.isEmpty()){
            TreeNode pop = s1.pollFirst();
            start++;
            if (pop.left != null){
                s1.add(pop.left);
            }
            if (pop.right != null){
                s1.add(pop.right);
            }
            if (start == end){
                depth++;
                start = 0;
                end = s1.size();
            }
        }
        return depth;
   }

    public int maxDepth2(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return maxDepth2(root.left) > maxDepth2(root.right) ? maxDepth2(root.left) + 1 : maxDepth2(root.right) + 1;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(8);
        root.left = new TreeNode(6);
        root.right = new TreeNode(10);
        root.left.left = new TreeNode(5);
        root.left.right = new TreeNode(7);
        root.right.left = new TreeNode(9);
        root.right.right = new TreeNode(11);
        System.out.println(maxDepth1(root));
    }
}
/**
 * Given a binary tree, find its maximum depth.
 * <p>
 * The maximum depth is the number of nodes along the longest path from the root node down to the farthest leaf node.
 */