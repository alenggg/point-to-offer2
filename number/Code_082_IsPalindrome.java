package alogorithms.number;

/**
 * Created with IntelliJ IDEA
 * Author: aleng
 * Date  : 2018/7/10
 * Time  : 10:53
 * Description: 给定一个整数， 判断该数是否是回文数
 **/
public class Code_082_IsPalindrome {

    public static boolean isPalindrome(int n) {
        if (n < 0) {
            return false;
        }
        int help = 1;
        while (n / help >= 10) {
            help *= 10;
        }
        while (n != 0) {
            if (n / help != n % 10) {
                return false;
            }
            n = (n % help) / 10;
            help /= 100;
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(isPalindrome(10001));
        System.out.println(isPalindrome(10101));
        System.out.println(isPalindrome(1221));
        System.out.println(isPalindrome(12345));
    }
}
