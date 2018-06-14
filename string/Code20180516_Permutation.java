package alogorithms.string;

import java.util.ArrayList;

/**
 * Created with IntelliJ IDEA
 * Author: aleng
 * Date  : 2018/5/16
 * Time  : 16:31
 * Description:字符串的排列
 **/
public class Code20180516_Permutation {

    public static ArrayList<String> permutation(String str) {
        ArrayList<String> res = new ArrayList<>();
        if (str.length() > 0){
            char[] chars = str.toCharArray();
            permutation(chars,0,res);
        }
        return res;
    }

    public static void permutation(char[] chars, int index,ArrayList<String> res) {
        if (index >= chars.length){
            return;
        }
        for (int i = index; i < chars.length; i++) {

            char temp = chars[i];
            chars[i] = chars[index];
            chars[index] = temp;

            permutation(chars,index+1,res);

            temp = chars[index];
            chars[index] = chars[i];
            chars[i] = temp;

            if (!res.contains(String.valueOf(chars))){
                res.add(String.valueOf(chars)); //加进去
            }
        }
    }
}
/**
 *
 * 题目:字符串的排列
 * 输入一个字符串，打印出该字符串中字符的所有排列。
 * 例如输入abc，打印abc,acb,bac,bca,cab,aba
 */
