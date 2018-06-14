package alogorithms.number;

import java.util.ArrayList;

/**
 * Created with IntelliJ IDEA
 * Author: aleng
 * Date  : 2018/6/15
 * Time  : 21:06
 * Description:和为s的连续整数序列
 **/
public class Code20180615_FindContinuousSequence {

    public static ArrayList<ArrayList<Integer>> findContinuousSequence(int sum) {
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        if (sum >= 3){
            int small = 1;
            int big = 2;
            while (small < (sum + 1)/2 && big < sum){
                if (sum(small,big) < sum){
                    big++;
                }else if (sum(small,big) > sum){
                    small++;
                }else {
                    ArrayList<Integer> arrayList = new ArrayList<>();
                    for (int i = small; i <= big; i++) {
                        arrayList.add(i);
                    }
                    res.add(arrayList);
                    big++;
                }
            }
        }
        return res;
    }
    public static int sum(int small,int big){
        int sum = 0;
        for (int i = small ; i <= big ; i++){
            sum += i;
        }
        return sum;
    }

    public static void main(String[] args) {
        ArrayList<ArrayList<Integer>> continuousSequence = findContinuousSequence(15);
        System.out.println(continuousSequence);
    }

}
