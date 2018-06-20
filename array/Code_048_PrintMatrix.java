package alogorithms.array;

import enumeration.Color;
import org.junit.Test;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created with IntelliJ IDEA
 * Author: aleng
 * Date  : 2018/5/31
 * Time  : 21:08
 * Description: 顺时针打印矩阵
 **/
public class Code_048_PrintMatrix {

    public ArrayList<Integer> printMatrix(int [][] matrix) {
        ArrayList<Integer> res = new ArrayList<>();
        int topRow = 0;
        int topCol = 0;
        int downRow = matrix.length - 1;
        int downCol = matrix[0].length - 1;
        while (topRow <= downRow && topCol <= downCol){
            printMatrix(matrix,topRow++,topCol++,downRow--,downCol--,res);
        }
        return res;
    }

    private void printMatrix(int [][] matrix,int row1, int col1, int row2, int col2,ArrayList<Integer> res) {

        if (row1 == row2){
            for (int i = col1; i <= col2 ; i++) {
                res.add(matrix[row1][i]);
            }
        }else if (col1 == col2){
            for (int i = row1; i <= row2 ; i++) {
                res.add(matrix[i][col1]);
            }
        }else {
            for (int i = col1; i < col2; i++) {
                res.add(matrix[row1][i]);
            }
            for (int i = row1; i < row2; i++) {
                res.add(matrix[i][col2]);
            }
            for (int i = col2; i > col1; i--) {
                res.add(matrix[row2][i]);
            }
            for (int i = row2; i > row1; i--) {
                res.add(matrix[i][col1]);
            }
        }
    }

    @Test
    public void test() throws UnsupportedEncodingException {
        String str="I am 高兴";
        System.out.println(str);
    }

    public static void main(String[] args) throws UnsupportedEncodingException {
//        String str = "abc";
//        System.out.println(str.charAt(0));
//        int[] times = new int[256];
//        System.out.println(times[str.charAt(0)]);
//        str = "a";
//        System.out.println(times['a']);

        Character a = 'a';
        System.out.println(a.toString().getBytes("utf-8").length);
    }
}
/**
 * 输入一个矩阵，按照从外向里以顺时针的顺序依次打印出每一个数字，
 * 例如，如果输入如下矩阵：
 * 1   2  3  4
 * 5   6  7  8
 * 9  10 11 12
 * 13 14 15 16
 * 则依次打印出数字1,2,3,4,8,12,16,15,14,13,9,5,6,7,11,10.
 */
