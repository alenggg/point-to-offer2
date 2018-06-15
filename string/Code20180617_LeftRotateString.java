package alogorithms.string;

/**
 * Created with IntelliJ IDEA
 * Author: aleng
 * Date  : 2018/6/17
 * Time  : 19:51
 * Description:左旋转字符串
 **/
public class Code20180617_LeftRotateString {

    public static String leftRotateString(String str,int n) {
        if (str == null || n < 0 ){
            return null;
        }
        char[] chars = str.toCharArray();
        if (str.length() > n){
            reverse(chars, 0, chars.length - 1);
            reverse(chars,0,chars.length - n - 1);
            reverse(chars,chars.length - n,chars.length - 1);
        }
        return String.valueOf(chars);
    }

    public static void reverse(char[] chars, int l, int r) {
        while (l < r) {
            char temp = chars[l];
            chars[l] = chars[r];
            chars[r] = temp;
            r--;
            l++;
        }
    }

    public static void main(String[] args) {
        String a = "abcdefg";
        System.out.println(leftRotateString(a, 0));
        System.out.println(leftRotateString(a, 1));
        System.out.println(leftRotateString(a, 2));
        System.out.println(leftRotateString(a, 3));
        System.out.println(leftRotateString(a, 4));
        System.out.println(leftRotateString(a, 5));
        System.out.println(leftRotateString(a, 6));
        System.out.println(leftRotateString(a, 7));
        System.out.println(leftRotateString(a, 8));
        System.out.println(leftRotateString(a, 9));
        System.out.println(leftRotateString("", 9));

    }
}
