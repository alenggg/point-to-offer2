package alogorithms.time_space_balance;

/**
 * Created with IntelliJ IDEA
 * Author: aleng
 * Date  : 2018/6/1
 * Time  : 15:31
 * Description:第一次只出现一次的字符
 **/
public class Code_049_FirstNotRepeatingChar {
    //暴力求解，时间复杂度o(n^2),空间复杂度o(1)
    public static char firstNotRepeatingChar(String str) {
        //此处，\77表示ascii为77的字符(即?),用于表征没有只出现一次的字符
        if (str == null || str.length() == 0)
            return '\77';
        for (int i = 0; i < str.length() - 1; i++) {
            char temp = str.charAt(i);
            for (int j = 0; j <= str.length(); j++) {
                if (j == i) continue;
                if (j == str.length())
                    return temp;
                if (temp == str.charAt(j))
                    break;
            }
        }
        return '\77';
    }

    public static char firstNotRepeatingChar2(String str) {
        //使用这个数组记录字符出现次数
        int[] times = new int[256];
        //第一遍遍历
        for (int i = 0; i < str.length(); i++) {
            times[str.charAt(i)]++;
        }
        //第二次遍历
        for (int i = 0; i < str.length(); i++) {
            if (times[str.charAt(i)] == 1)
                return str.charAt(i);
        }
        return '\77';
    }

    public static void main(String[] args) {
        System.out.println(firstNotRepeatingChar("abaccdeff"));
        System.out.println(firstNotRepeatingChar2("abaccdeff"));
    }
}
/**
 *
 * 题目要求：
 * 字符串中第一个只出现一次的字符。
 * 在字符串中找出第一个只出现一次的字符。
 * 如输入abaccdeff，则输出b。
 *
 * 解题思路：
 * 思路1：暴力求解，从前到后依次判断每个字符是否只出现一次，时间复杂度o(n^2)，空间复杂度o(1)；
 * 思路2：用空间换时间。
 * 这个思路可行的前提是题目中所说的“字符”指的是ascii编码的字符。
 * 0-127是7位ASCII码的范围，是国际标准。128-255称为扩展ASCII码，不是国际标准。
 * 在C++中，char是1字节（8bit），能表示256个不同的字符。
 * 而java中，char是unicode编码，2字节（16bit）。
 * 但本题中，假设所有字符都可用ascii表示（0-255）。
 * 在上述假设下，可以申请一个长度为256的int数组作为哈希表，占用空间1kB，用它来记录字符出现的次数。
 * 第一扫描字符串，修改对应字符的次数；
 * 第二遍扫描，当遇到在数组中对应值为1的字符，即得到所求，时间复杂度o(n)。
 *
 */
