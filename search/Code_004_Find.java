package alogorithms.search;

/**
 * Created with IntelliJ IDEA
 * Author: aleng
 * Date  : 2018/4/8
 * Time  : 11:55
 * Description: 二维数组中的查找
 **/
public class Code_004_Find {

    public static boolean Find(int[][] array,int target) {
        if (array == null) {
            return false;
        }
        int row = 0;
        int column = array[0].length - 1;//以二维数组右上角的数为基准遍历
        while (row < array.length && column >= 0) {
            if (array[row][column] == target) {
                return true;
            }
            if (array[row][column] > target){
                --column;
            }else{
                ++row;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[][] array = new int[][] {{1,2,8,9},
                                     {2,4,9,12},
                                     {4,7,10,13},
                                     {6,8,11,15}};
        System.out.println(Find(array,22));
    }
}
/**
 * 题目:在一个二维数组中，每一行都按照从左到右递增的顺序排序，每一列都按照从上到下递增的顺序排序
 * 请完成一个函数，输入这样的一个二维数组和一个整数，判断数组中是否含有该整数。
 * (1)如果该数字等于要查找的数字,则查找过程结束
 * (2)如果该数字大于要查找的数字,则剔除这个数字所在的列。
 * (3)如果该数字小于要查找的数字,则剔除这个数字所在的行。
 * 不能选择左上角或右下角的数字。因为数字是从左到右，从上到下递增，如果查找的值比左上角的值小
 * 则无法继续查找
 */