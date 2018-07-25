package alogorithms.tree;

/**
 * Created with IntelliJ IDEA
 * Author: aleng
 * Date  : 2018/5/11
 * Time  : 17:00
 * Description:二叉搜索树的后序遍历序列
 **/
public class Code_033_VerifySquenceOfBST {

    public static boolean verifySquenceOfBST(int [] sequence) {
        if (sequence == null || sequence.length == 0){
            return false;
        }
        return help(sequence,0,sequence.length - 1);
    }
    private static boolean help(int[] sequence, int start, int end) {
        if (start == end){
            return true;
        }
        int i = start;
        for(; i <= end ; i++){
            if (sequence[i] > sequence[end]){
                break;
            }
        }
        if (i > end){
            return true;
        }
        for(int j = i; j <= end ; j++ ){
            if (sequence[j] < sequence[end]){
                return false;
            }
        }
        return help(sequence,start,i - 1)&&help(sequence,i,end - 1);
    }
}
/**
 *
 * 题目:二叉搜索树的后序遍历序列
 * 输入一个整数数组，判断数组是不是某二叉搜索树的后序遍历。
 * 如果是返回true,否则false.
 * 假如输入的数组的任意两个数字互不相同。
 *
 *
 * 二叉搜索树的中序遍历是有序的，而此题是后序遍历。
 * 后序遍历可以很容易找到根节点，然后根据二叉搜索树的性质（左子树小于根节点，右子树大于根节点），
 * 可以将序列分为根节点的左子树部分与右子树部分，而后递归判断两个子树。
 */