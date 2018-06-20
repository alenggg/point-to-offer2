package alogorithms.string;

/**
 * Created with IntelliJ IDEA
 * Author: aleng
 * Date  : 2018/4/9
 * Time  : 16:04
 * Description:替换空格
 **/
public class Code_005_ReplaceSpace {

    public static String replaceSpace(StringBuffer str) {
        if (str == null){
            return null;
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < str.length(); i++) {
            if(String.valueOf(str.charAt(i)).equals(" ")){
                sb.append("%20");
            }else{
                sb.append(str.charAt(i));
            }
        }
        return String.valueOf(sb);
    }
    public static char[] replaceSpace2(String s,int length){
        if (s.length() <= 0 || s == null){
            return null;
        }
        char[] originalChars = s.toCharArray();
        char[] newChars = new char[length];
        for (int i = 0; i < originalChars.length; i++) {
            newChars[i] = originalChars[i];
        }

        int originaLength = originalChars.length;//字符串的初始长度
        int numberOfBlank = 0;//字符串中空格的个数
        for (int i = 0; i < originalChars.length; i++) {
            if(String.valueOf(originalChars[i]).equals(" ")){
                numberOfBlank++;
            }
        }
        int newLength = originaLength + numberOfBlank * 2;//新字符串的长度，因为一个空格1位，%20占3位
        if (newLength > length){
            return null;
        }

        int indexOfOriginal = originaLength; //指针
        int indexOfNew = newLength;  //指针

        while (indexOfOriginal >=0 && indexOfNew > indexOfOriginal){
            if(String.valueOf(newChars[indexOfOriginal]).equals(" ")){
                newChars[indexOfNew--] = '0';
                newChars[indexOfNew--] = '2';
                newChars[indexOfNew--] = '%';
            }else{
                newChars[indexOfNew--] = newChars[indexOfOriginal];
            }
            indexOfOriginal--;
        }
        return newChars;
    }
}
/**
 *
 * 题目:请实现一个函数，把字符串中的每个空格替换成”%20“。例如:输入”We are happy.“，
 * 则输出”We%20Are%20Happy.“
 * 时间复杂度O(n)
 * 有两种情况
 * (1)在原字符串操作
 * (2)创建一个新的字符串进行操作
 * 如果从头到尾遍历，每次遇到空格时，后面的字符都要往后移动，时间复杂度为O(N)
 * 所有从尾部开始遍历
 *
 */