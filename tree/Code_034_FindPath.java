package alogorithms.tree;

import alogorithms.structure.TreeNode;

import java.util.ArrayList;

/**
 * Created with IntelliJ IDEA
 * Author: aleng
 * Date  : 2018/5/12
 * Time  : 17:02
 * Description:二叉树中和为某一值的路径
 **/
public class Code_034_FindPath {

    public static ArrayList<ArrayList<Integer>> findPath(TreeNode<Integer> root, int target) {
        ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
        if(root == null || root.val > target)
            return res;
        ArrayList<Integer> path = new ArrayList<>();
        findPath(root,target,res,path);
        return res;
    }

    public static void findPath(TreeNode<Integer> root, int target, ArrayList<ArrayList<Integer>> res, ArrayList<Integer> path) {
        if(root == null)
            return;
        path.add(root.val);
        target -= root.val;

        if(target == 0 && root.left == null && root.right == null){
            res.add(new ArrayList<>(path));
        }else {
            findPath(root.left,target,res,path);
            findPath(root.right,target,res,path);
        }
        //每返回上一层一次就要回退一个节点
        path.remove(path.size()-1);
        return;
    }
}
/**
 *
 * 题目:二叉树中和为某一值的路径
 * 输入一颗二叉树和一个整数，打印出二叉树中节点值的和为输入整数的所有路径。
 * 从树的根节点开始往下一直到叶节点所经过的节点形成一条路径。
 */