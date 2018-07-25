package alogorithms.dynamic_programming;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * Created with IntelliJ IDEA
 * Author: aleng
 * Date  : 2018/7/17
 * Time  : 14:38
 * Description:Given a string s and a dictionary of words dict,
 *             determine if s can be segmented into a space-separated sequence of one or more dictionary words.
 **/
public class Code_097_WordBreak {

    public static boolean wordBreak(String s, Set<String> dict) {
        boolean[] dp = new boolean[s.length()];
        for (int i = 0; i < s.length(); i++) {
            if (dict.contains(s.substring(0,i + 1))){
                dp[i] = true;
            }
            for (int j = 0; j < i; j++) {
                if (dp[j] && dict.contains(s.substring(j + 1 , i + 1))) {
                    dp[i] = true;
                }
            }
        }
        return dp[s.length() - 1];
    }

    public static boolean wordBreak2(String s, Set<String> dict) {
        int length = s.length();
        if (length < 1)
            return true;
        boolean[] dp = new boolean[length + 1];//默认值为false
        dp[0] = true;
        for (int i = 0; i < length; i++) {
            if (dp[i]) {
                for (int j = i; j < length; j++) {
                    if (dict.contains(s.substring(i, j + 1))) {
                        dp[j + 1] = true;
                    }
                }
            }
        }
        return dp[length];
    }

    public static void main(String[] args) {
        Set<String> dict = Set.of("cat", "cats", "and", "sand", "dog");
        System.out.println(wordBreak("catsanddog", dict));
    }

}
/**
 * Given a string s and a dictionary of words dict,
 * determine if s can be segmented into a space-separated sequence of one or more dictionary words.
 * <p>
 * For example, given
 * s ="leetcode",
 * dict =["leet", "code"].
 * <p>
 * Return true because"leetcode"can be segmented as"leet code".
 *
 *
 * 出发点：给定字符串s的每个字符i
 * 最优解：对于每个i之前的字符序列，分为j(0<=j<=i)前面的序列和j后面的序列，求解i转化为求解j和i-j
 * 状态d(i)：i之前的字符序列分段后的字符串能不能在字典中找到
 * 递推公式：d(i) = d(i)||(d(j)&sub(i-j)), 其中j=0~i
 */
