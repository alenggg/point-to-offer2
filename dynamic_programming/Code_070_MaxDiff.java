package alogorithms.dynamic_programming;

/**
 * Created with IntelliJ IDEA
 * Author: aleng
 * Date  : 2018/6/22
 * Time  : 21:41
 * Description: 股票的最大利润
 **/
public class Code_070_MaxDiff {

    public static int maxDiff(int[] data){
        if (data == null || data.length <= 1){
            return 0;
        }
        int min = data[0];
        int maxDiff = 0; //记录最大利润
        for (int i = 0; i < data.length; i++) {
            int diff = data[i] - min;  //当前利润
            if (diff > maxDiff){
                maxDiff = diff;   //判断当前利润和最大利润
            }
            if (min > data[i]){
                min = data[i];    //判断最小值和当前数
            }
        }
        return maxDiff;
    }

    public static void main(String[] args) {
        int[] data1 = new int[]{9,11,8,5,7,12,16,14};
        int[] data2 = new int[]{9,8,7,6,5,4,3,1};
        System.out.println(maxDiff(data1)); //11
        System.out.println(maxDiff(data2)); //-1

    }
}
