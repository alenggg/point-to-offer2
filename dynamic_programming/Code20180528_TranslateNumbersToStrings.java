package alogorithms.dynamic_programming;

/**
 * Created with IntelliJ IDEA
 * Author: aleng
 * Date  : 2018/5/28
 * Time  : 21:29
 * Description:把数字翻译成字符串
 **/
public class Code20180528_TranslateNumbersToStrings {

    public int GetTranslationCount(int number) {
        if(number < 0){
            return 0;
        }

        if(number == 1){
            return 1;
        }
        return GetTranslationCount(Integer.toString(number));
    }

    private  int GetTranslationCount(String number) {
        int[] count = new int[number.length() + 1];
        count[0] = 0;
        count[1] = 1;
        int g = 0;
        for (int i = 2; i <= number.length(); i++) {
            if (Integer.parseInt(number.charAt(i - 1) + "" + number.charAt(i - 2)) < 26) {
                g = 1;
            }
            count[i] = count[i - 1] + g * count[i - 2];
        }
        return count[number.length()];
    }

    public static void main(String[] args) {

    }
}

/**
 * 题目:把数字翻译成字符串
 * 给定一个数字，按照如下规则翻译成字符串：0翻译成“a”，1翻译成“b”...25翻译成“z”。
 * 一个数字有多种翻译可能
 * 例如12258一共有5种，分别是bccfi，bwfi，bczi，mcfi，mzi。
 * 实现一个函数，用来计算一个数字有多少种不同的翻译方法。
 *
 * f(i)表示从右往左第i位开始能翻译成字符串的种数
 * g(i-1,i-2) = 1 当i-1，i-2的两位数可以翻译成字符串
 * g(i-1,i-2) = 0 当i-1，i-2的两位数不可以翻译成字符串
 * f(0) = 0
 * f(1) = 1
 * 思路:f(i) = f(i-1) + g(i-1,i-2)f(i-2) i>=2
 */