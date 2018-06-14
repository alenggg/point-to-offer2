package alogorithms.dynamic_programming;

/**
 * Created with IntelliJ IDEA
 * Author: aleng
 * Date  : 2018/5/29
 * Time  : 21:12
 * Description:最长不含重复字符的子字符串
 **/
public class Code20180529_LongestSubstringWithoutDup {

    public static int longestSubstringWithoutDup(String str){
        if (str == null || str.length() <= 0){
            return 0;
        }
        char[] chars = str.toCharArray();
        int l = 0;
        int max = l ;
        for (int i = 0; i < chars.length; i++) {
            if (longestSubstringWithoutDup(chars,i) <= l ){
                l = longestSubstringWithoutDup(chars,i);
            }else {
                l += 1;
            }
            if (max < l){
                max = l ;
            }
        }
        return max;
    }

    private static int longestSubstringWithoutDup(char[] chars, int index) {

        int l = index + 1;
        for (int i = 0; i < index; i++) {
            if (chars[i] == chars[index]){
                l = index - i;
            }
        }
        return l;
    }

    public static void main(String[] args) {
        System.out.println(longestSubstringWithoutDup("abcdfeg"));
        System.out.println(longestSubstringWithoutDup("a"));
        System.out.println(longestSubstringWithoutDup("ababbcdef"));
    }
}

/**
 *
 * 题目要求：
 * 输入一个字符串（只包含a~z的字符），求其最长不含重复字符的子字符串的长度。
 * 例如对于arabcacfr，最长不含重复字符的子字符串为acfr，长度为4。
 *
 * 解题思路：
 * 动态规划。用dp[]记录状态，dp[i]表示以下标为i的字符结尾不包含重复字符的最长子字符串长度。
 * 初始化dp[0] = 1，求maxdp。每次可以根据dp的前一个状态推导出后一个状态，
 * 因此可以省略dp数组，使用一个变量记录dp值，使用maxdp记录最大的dp值。
 *
 */
