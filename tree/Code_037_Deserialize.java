package alogorithms.tree;

import alogorithms.structure.TreeNode;

/**
 * Created with IntelliJ IDEA
 * Author: aleng
 * Date  : 2018/5/15
 * Time  : 17:06
 * Description:反序列化二叉树
 **/
public class Code_037_Deserialize {
    public static TreeNode deserialize(String str) {
        String[] strr = str.split(","); //前序遍历的序列
        return deserialize(strr);
    }
    static int index = -1;
    public static TreeNode deserialize(String[] strr) {
        index++;
        TreeNode node = null;
        if (index >= strr.length)
            return null;
        if (!strr[index].equals("$")){
            node = new TreeNode(Integer.valueOf(strr[index]));
            node.left = deserialize(strr);
            node.right = deserialize(strr);
        }
        return node;
    }

    public static void main(String[] args) {
        String str = "8,$,$,4,$,$,10,9,$,$,11,$,$";
        TreeNode deserialize = deserialize(str);//生成根节点
    }
}
