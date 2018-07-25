package alogorithms.dynamic_programming;


import java.util.*;

/**
 * Created with IntelliJ IDEA
 * Author: aleng
 * Date  : 2018/7/19
 * Time  : 11:54
 * Description:
 **/
public class Code_102_WordBreakⅡ {

    /**
     *  递推公式：d(i) = d(i)||(d(j)&sub(i-j)), 其中j=0~i
     *  对这个题目无语了
     *
     *  测试用例:
     * "catsanddog",["cat","cats","and","sand","dog"]
     * 对应输出应该为:
     * ["cats and dog","cat sand dog"]
     * 你的输出为:
     * ["cat sand dog","cats and dog"]
     *
     * 顺序我怎么换都不对，每次都是和答案的顺序不一样，答案是在跟我开玩笑吗。。
     */
    public static ArrayList<String> wordBreak(String s, Set<String> dict) {
            ArrayList<String> res = new ArrayList<>();
            int[] len = new int[s.length()];
            String[][] hebing1 = new String[s.length()][s.length() * s.length()];
            boolean[] dp = new boolean[s.length()];
            for (int i = 0; i < s.length(); i++) {
                if (dict.contains(s.substring(0,i + 1))){
                    hebing1[i][len[i]++] = s.substring(0,i + 1);
                    dp[i] = true;
                }
                for (int j = 0; j < i; j++) {
                    dp[i] = true;
                    if (dp[j] && dict.contains(s.substring(j + 1 , i + 1))) {
                        for (int k = 0; k < len[j]; k++) {
                            hebing1[i][len[i]++] = hebing1[j][k] + " " + s.substring(j + 1,i + 1);
                        }
                    }
                }
            }
            for (int i = 0; i < len[s.length() - 1]; i++) {
                if (hebing1[s.length() -1][i] != null){
                    res.add(hebing1[s.length() -1][i]);
                }
            }
            Collections.sort(res);
            return res;
    }

    public static void main(String[] args) {
        Set<String> dict = Set.of("aaaa","aa","a");
        System.out.println(wordBreak("aaaaaaa", dict));
    }


}
/**
 * Given a string s and a dictionary of words dict,
 * add spaces in s to construct a sentence where each word is a valid dictionary word.
 * <p>
 * Return all such possible sentences.
 * <p>
 * For example, given
 * s ="catsanddog",
 * dict =["cat", "cats", "and", "sand", "dog"].
 * <p>
 * A solution is["cats and dog", "cat sand dog"].
 */
