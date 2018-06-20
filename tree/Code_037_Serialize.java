package alogorithms.tree;

import alogorithms.structure.TreeNode;

/**
 * Created with IntelliJ IDEA
 * Author: aleng
 * Date  : 2018/5/15
 * Time  : 17:05
 * Description:序列化二叉树
 **/
public class Code_037_Serialize {

    public static String serialize(TreeNode root) {
        StringBuffer sb = new StringBuffer();
        serialize(root,sb);
        sb.deleteCharAt(sb.length()-1);
        return sb.toString();
    }

    public static void serialize(TreeNode root, StringBuffer sb) {
        if (root == null){
            sb.append("$,");
            return;
        }
        sb.append(root.val + ",");
        serialize(root.left,sb);
        serialize(root.right,sb);
    }

    public static void main(String[] args) {
        String str = "8,$,$,4,$,$,10,9,$,$,11,$,$";

    }
}
/**
 *
 * 题目:序列化二叉树
 * 请实现两个函数，分别用来序列化和反序列化二叉树
 *
 * 序列化：前序遍历二叉树存入字符串中；反序列化：根据前序遍历重建二叉树。
 */