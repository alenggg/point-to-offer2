package alogorithms.array;

import java.util.Arrays;

/**
 * Created with IntelliJ IDEA
 * Author: aleng
 * Date  : 2018/6/21
 * Time  : 19:53
 * Description: 构建乘积数组
 **/
public class Code_074_Multiply {

    public int[] multiply(int[] A) {
        int length = A.length;
        int[] B = new int[length];
        if (length != 0) {
            B[0] = 1;
            //计算下三角连乘
            for (int i = 1; i < length; i++) {
                B[i] = B[i - 1] * A[i - 1];
            }
            int temp = 1;
            //计算上三角
            for (int j = length - 2; j >= 0; j--) {
                temp *= A[j + 1];
                B[j] *= temp;
            }
        }
        return B;
    }

    public static int[] multiply2(int[] A) {
        if (A == null || A.length <= 0) {
            return null;
        }
        int[] C = new int[A.length];
        int[] D = new int[A.length];
        int[] res = new int[A.length];
        C[0] = 1;
        //计算下三角
        for (int i = 1; i < A.length; i++) {
            C[i] = C[i - 1] * A[i - 1];
        }
        //计算上三角
        D[A.length - 1] = 1;
        for (int i = A.length - 2; i >= 0; i--) {
            D[i] = D[i + 1] * A[i + 1];
        }
        for (int i = 0; i < A.length; i++) {
            res[i] = C[i] * D[i];
        }
        return res;
    }

    public static void main(String[] args) {
        int[] res = multiply2(new int[]{1, 2, 3, 4, 5});
        System.out.println(Arrays.toString(res));
    }
}

/**
 * 给定一个数组A[0,1,...,n-1],请构建一个数组B[0,1,...,n-1],
 * 其中B中的元素B[i]=A[0]*A[1]*...*A[i-1]*A[i+1]*...*A[n-1]。
 * 不能使用除法
 */
