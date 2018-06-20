package alogorithms.number;

import java.util.ArrayList;

/**
 * Created with IntelliJ IDEA
 * Author: aleng
 * Date  : 2018/6/14
 * Time  : 19:51
 * Description:和为s的数字
 **/
public class Code_062_FindNumbersWithSum{

    public static ArrayList<Integer> findNumbersWithSum(int[] array, int sum){
        ArrayList<Integer> res = new ArrayList<>();
        if (array != null && array.length >= 2 ){
            int l = 0;
            int r = array.length - 1;
            while (l < r){
                if (array[l] + array[r] > sum){
                    r--;
                }else if (array[l] + array[r] < sum){
                    l++;
                }else {
                    res.add(array[l]);
                    res.add(array[r]);
                    break;
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] data = new int[]{1,2,4,7,11,15};
        System.out.println(findNumbersWithSum(data, 15));


    }
}

