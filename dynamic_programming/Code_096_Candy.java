package alogorithms.dynamic_programming;

import java.io.Reader;
import java.util.Arrays;

/**
 * Created with IntelliJ IDEA
 * Author: aleng
 * Date  : 2018/7/17
 * Time  : 11:15
 * Description: What is the minimum candies you must give?
 **/
public class Code_096_Candy {
    public static int candy(int[] ratings) {
        int[] res = new int[ratings.length];
        Arrays.fill(res, 1);
        for (int i = 1; i < ratings.length; i++) {
            if (ratings[i] > ratings[i - 1]) {
                res[i] = res[i - 1] + 1;
            }
        }
        int sum = 0;
//        for (int i = ratings.length - 2; i >= 0; i--) {
//            if (ratings[i] > ratings[i + 1] && res[i] <= res[i + 1]) {
//                res[i] = res[i + 1] + 1;
//            }
//        }
        for (int i = 0; i < res.length; i++) {
            sum += res[i];
        }
        return sum;
    }

    public static void main(String[] args) {
        System.out.println(candy(new int[]{1, 2,1}));
    }

}
/**
 * There are N children standing in a line. Each child is assigned a rating value.
 * <p>
 * You are giving candies to these children subjected to the following requirements:
 * <p>
 * Each child must have at least one candy.
 * Children with a higher rating get more candies than their neighbors.
 * What is the minimum candies you must give?
 * <p>
 * 有n个孩子站成一排。每个孩子都被分配一个评级值。
 * 你给糖果的孩子们有以下要求：
 * 每个孩子必须至少有一个糖果。
 * 具有较高评级的孩子比邻居得到更多糖果。
 * 你必须给的最小糖果是多少？
 */