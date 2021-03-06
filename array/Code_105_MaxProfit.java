package alogorithms.array;

/**
 * Created with IntelliJ IDEA
 * Author: aleng
 * Date  : 2018/7/20
 * Time  : 10:37
 * Description: maxProfit
 **/
public class Code_105_MaxProfit {

    public int maxProfit(int[] prices) {
        int res = 0;
        for(int i = 1;i< prices.length; i++){
            if(prices[i] > prices[i - 1]){
                res += prices[i] - prices[i - 1];
            }
        }
        return res;
    }
}
/**
 * Say you have an array for which the i th element is the price of a given stock on day i.
 *
 * Design an algorithm to find the maximum profit.
 *
 * You may complete as many transactions as you like (ie, buy one and sell one share of the stock multiple times).
 *
 * However, you may not engage in multiple transactions at the same time (ie, you must sell the stock before you buy again).
 */