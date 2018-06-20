package alogorithms.search;

/**
 * Created with IntelliJ IDEA
 * Author: aleng
 * Date  : 2018/5/24
 * Time  : 16:41
 * Description:数字序列中某一位的数字
 **/
public class Code_042_DigitAtIndex {

    private static int digitAtIndex(int index)
    {
        if (index < 0) return -1;
        int digits = 1;
        while (true)
        {
            int digitNumbers = countOfNumbersFor(digits); //当前位数的数值个数
            //数值乘上它的位数等于数字个数，
            //比如，两位数有90个（10~99），每个数值有2个数字，总数字个数为180
            int countOfNumbers = digits * digitNumbers;
            if (countOfNumbers <= index){
                index -= countOfNumbers;
                digits++; //循环找
            }else {
                return digitAtIndex(index, digits);
            }
        }
    }
    //两位数有9*10=90个（10~99），三位数有9*100=900个（100~999）
    private static int countOfNumbersFor(int digits)
    {
        if (digits == 1)
            return 10;

        int count = (int) Math.pow(10, digits - 1);
        return 9 * count;
    }
    private static int digitAtIndex(int index, int digits)
    {
        int round = index / digits;
        int weight = index % digits;
        //要找的那个数
        int number = digits == 1 ? round : (int)Math.pow(10,digits - 1) + round;

        //从数值右边开始算的位置
        int indexFromRight = digits - weight;
        //去除右边的indexFromRight-1个数字
        for (int i = 1; i < indexFromRight; i++)
            number /= 10;
        //求个位数字
        return number % 10;
    }
}
/**
 *
 * 题目：数字序列中某一位的数字
 * 数字以0123456789101112131415…的格式序列化到一个字符序列中。
 * 在这个序列中，第5位（从0开始计数）是5，第13位是1，第19位是4，等等。
 * 在这个序列中，下标为5的是5，下标为13位是1，下标19位是4，等等。
 * 请写一个函数求任意位对应的数字。
 *
 */