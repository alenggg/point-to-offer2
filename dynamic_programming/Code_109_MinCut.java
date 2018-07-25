package alogorithms.dynamic_programming;

import java.util.ArrayList;

/**
 * Created with IntelliJ IDEA
 * Author: aleng
 * Date  : 2018/7/21
 * Time  : 22:08
 * Description: Given a string s, partition s such that every substring of the partition is a palindrome.
 * Return the minimum cuts needed for a palindrome partitioning of s.
 **/
public class Code_109_MinCut {
    /**
     *  回文的最小分割数
     *  1.dp[i]表示当前i到len-1这段的最小分割数
     *  2.dp[i]=min{dp[j+1]+1}（i=<j<len）其中str[i..j]必须是回文、
     *  3.p[i][j]=true表示str[i..j]是回文
     *  4.p[i][j]=s.charAt(i)==s.charAt(j) && (j-i<2||p[i+1][j-1])
     */
    public int minCut(String s) {
        int dp[] = new int[s.length() + 1];
        dp[s.length()] = -1;
        for (int i = s.length() - 1; i >= 0; i--) {
            dp[i] = Integer.MAX_VALUE;
            for (int j = i; j < s.length(); j++) {
                if (isPalindrome(s, i, j)) {
                    dp[i] = Math.min(dp[i], dp[j + 1] + 1);
                }
            }
        }
        return dp[0];
    }


    public static boolean isPalindrome(String str, int left, int right) {
        if (left == right) {
            return true;
        }
        while (left < right) {
            if (str.charAt(left) != str.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }


    public int minCut2(String s) {
        int[] dp = new int[s.length() + 1];
        boolean[][] p = new boolean[s.length()][s.length()];
        dp[s.length()] = -1;//确保dp[s.length()-1]=0
        for (int i = s.length() - 1; i >= 0; i--) {
            dp[i] = Integer.MAX_VALUE;
            for (int j = i; j < s.length(); j++) {
                if (s.charAt(i) == s.charAt(j) && (j - i < 2 || p[i + 1][j - 1])) {
                    p[i][j] = true;
                    dp[i] = Math.min(dp[i], dp[j + 1] + 1);
                }
            }
        }
        return dp[0];
    }

    public static void main(String[] args) {
        Code_109_MinCut test = new Code_109_MinCut();
        System.out.println(test.minCut("abab"));
        System.out.println(test.minCut2("abab"));
    }
}

/**
 * Given a string s, partition s such that every substring of the partition is a palindrome.
 *
 * Return the minimum cuts needed for a palindrome partitioning of s.
 *
 * For example, given s ="aab"
 *
 * Return1since the palindrome partitioning["aa","b"]could be produced using 1 cut.
 */
