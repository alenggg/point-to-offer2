package alogorithms.tree;

import alogorithms.structure.TreeNode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Stack;

/**
 * Created with IntelliJ IDEA
 * Author: aleng
 * Date  : 2018/7/18
 * Time  : 9:42
 * Description: Find the total sum of all root-to-leaf numbers.
 **/
public class Code_098_SumNumbers {

    public static int sumNumbers(TreeNode root) {
        int sum = 0;
        if (root == null) {
            return sum;
        }
        return preorderSumNumbers(root, sum);
    }

    public static int preorderSumNumbers(TreeNode<Integer> root, int sum) {
        if (root == null)
            return 0;
        sum = sum * 10 + root.val;
        if (root.left == null && root.right == null) {
            return sum;
        }
        return preorderSumNumbers(root.left, sum) + preorderSumNumbers(root.right, sum);
    }
//    public static ArrayList sumNumbers(TreeNode<Integer> root) {
//        ArrayList<String> res = new ArrayList<>();
//        StringBuilder sb = new StringBuilder();
//        Stack<TreeNode> s1 = new Stack();
//        HashMap<TreeNode<Integer>, Boolean> hashMap = new HashMap<>();
//        hashMap.put(null, true);
//        if (root == null) {
//            return res;
//        }
//        s1.push(root);
//        while (!s1.isEmpty()) {
//            TreeNode pop = s1.pop();
//            hashMap.put(pop, true);
//            sb.append(pop.val);
//            if (pop.left == null && pop.right == null) {
//                res.add(sb.toString());
//                //sb.deleteCharAt(sb.length() - 1);
//            }
//            if (hashMap.containsKey(pop.left) && hashMap.containsKey(pop.right)) {
//                sb.deleteCharAt(sb.length() - 1);
//            }
//            if (pop.right != null) {
//                s1.push(pop.right);
//            }
//            if (pop.left != null) {
//                s1.push(pop.left);
//            }
//        }
//        return res;
//

    public static void main(String[] args) {
        TreeNode root = new TreeNode(8);
        root.left = new TreeNode(6);
        root.right = new TreeNode(4);
        root.left.left = new TreeNode(5);
        root.left.right = new TreeNode(7);
        root.right.left = new TreeNode(9);
        root.right.right = new TreeNode(2);

        System.out.println(sumNumbers(root));
    }
}
/**
 * Given a binary tree containing digits from 0-9only, each root-to-leaf path could represent a number.
 * <p>
 * An example is the root-to-leaf path1->2->3 which represents the number123.
 * <p>
 * Find the total sum of all root-to-leaf numbers.
 * <p>
 * For example,
 * <p>
 * 1
 * / \
 * 2   3
 * <p>
 * The root-to-leaf path1->2represents the number12.
 * The root-to-leaf path1->3represents the number13.
 * <p>
 * Return the sum = 12 + 13 =25.
 */
