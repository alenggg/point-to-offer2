package alogorithms.string;

/**
 * Created with IntelliJ IDEA
 * Author: aleng
 * Date  : 2018/6/18
 * Time  : 17:51
 * Description:翻转字符串(student. a am I -> i am a student.)
 **/
public class Code20180616_ReverseSentence {

    public static String reverseSentence(String str) {
        char[] chars = str.toCharArray();
        reverse(chars, 0, chars.length - 1);
        int blank = -1;
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] == ' ') {
                int nextBlank = i;
                reverse(chars, blank + 1, nextBlank - 1);
                blank = nextBlank;
            }
        }
        reverse(chars, blank + 1, chars.length - 1);//最后一个单词单独进行反转
        return new String(chars);
    }

    public static void reverse(char[] chars, int low, int high) {
        while (low < high) {
            char temp = chars[low];
            chars[low] = chars[high];
            chars[high] = temp;
            low++;
            high--;
        }
    }

    public static void main(String[] args) {

        String student_am_i = reverseSentence("student am i");
        System.out.println(student_am_i);
    }
}
/*
student. a am I -> i am a student.
 */
