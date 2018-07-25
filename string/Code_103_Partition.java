package alogorithms.string;

import java.util.ArrayList;
import java.util.Collections;

/**
 * Created with IntelliJ IDEA
 * Author: aleng
 * Date  : 2018/7/19
 * Time  : 17:01
 * Description:Given a string s, partition s such that every substring of the partition is a palindrome.
 */
public class Code_103_Partition {

    public static ArrayList<ArrayList<String>> partition(String s) {
        ArrayList<ArrayList<String>> resultList = new ArrayList<ArrayList<String>>();
        ArrayList<String> current = new ArrayList<String>();
        findPalindrome(s, 0, current, resultList);
        return resultList;
    }

    private static void findPalindrome(String str, int left, ArrayList<String> current, ArrayList<ArrayList<String>> resultList) {
        //回溯返回条件，left指针已到最后，也就是回溯到底了
        if (current.size() > 0 && left >= str.length()) {
            ArrayList<String> tempList = new ArrayList<>(current);
            resultList.add(tempList);
        }
        for (int right = left; right < str.length(); right++) {
            //不是回文的话，直接right++；
            if (isPalindrome(str, left, right)) {
                //添加回文
                current.add(str.substring(left, right + 1));
                //进行回溯
                findPalindrome(str, right + 1,current,resultList);
                //移除刚刚添加的元素，也就是回到之前的状态，以便走其他分支
                current.remove(current.size() - 1);
            }
        }
    }

    public  static boolean isPalindrome(String str, int left, int right) {
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

    public static void main(String[] args) {
        System.out.println(partition("aab"));
        String a = "aaa";
        //System.out.println(a.substring(1));
    }
}
/**
 * Given a string s, partition s such that every substring of the partition is a palindrome.
 * <p>
 * Return all possible palindrome partitioning of s.
 * <p>
 * For example, given s ="aab",
 * Return
 * <p>
 * [
 * ["aa","b"],
 * ["a","a","b"]
 * ]
 */