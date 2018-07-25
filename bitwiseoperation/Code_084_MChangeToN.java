package alogorithms.bitwiseoperation;

/**
 * Created with IntelliJ IDEA
 * Author: aleng
 * Date  : 2018/7/12
 * Time  : 16:28
 * Description: 输入两个整数m和n，计算需要改变m的二进制表示中的多少位才能得到n?
 **/
public class Code_084_MChangeToN {

    public static int mChangeToN(int m,int n){
        int temp = m ^ n;
        int count = 0;
        while (temp != 0){
            count++;
            temp = temp & (temp - 1);
        }
        return count;
    }

    public static void main(String[] args) {
        System.out.println(mChangeToN(10,13));
    }
}
