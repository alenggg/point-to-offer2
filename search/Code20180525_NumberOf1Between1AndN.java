package alogorithms.search;

/**
 * Created with IntelliJ IDEA
 * Author: aleng
 * Date  : 2018/5/25
 * Time  : 16:44
 * Description:从1到n整数中1出现的次数
 **/
public class Code20180525_NumberOf1Between1AndN {
    public static int numberOf1Between1AndN_Solution(int n) {
        if (n < 1) {
            return 0;
        }
        int count = 0;

        int base = 1;
        int round = n;
        //先算个位数，再算十位数...
        while (round > 0) {
            int weight = round % 10;  //第一次是个位数，然后是十位数，百位数...
            round /= 10;
            count += round * base;
            if (weight == 1){
                count += (n % base) + 1;
            } else if (weight > 1){
                count += base;
            }
            base *= 10;   //权重第一次是1,然后是10,100...
        }
        return count;
    }
}
/**
 *
 * 题目:从1到n整数中1出现的次数
 * 输入一个整数n，求从1到n这n个整数的十进制表示中1出现的次数。
 * 例如输入12，从1到12这些整数中包含1的数字有1，10，11和12，1一共出现了5次。
 *
 * 以256为例:
 * 考虑将n的十进制的每一位单独拿出讨论，每一位的值记为weight。
 * (1)个位数有多少个1
 * round = 25
 * weight = 6
 * 个位数每走一个周期(从0到9)，个位数为1的数就多一个，256从个位数来看一共走了25个周期，
 * 第26个周期走到6，但是个位数为1的仍然多了一个，所以个位数为1的一共有25+1=26个
 *
 * (2)十位数有多少个1
 * round = 2
 * weight = 5
 * 十位数每走一个周期(从0到9)和个位数相同，
 * 不同点在于：从0到9，每增加10，十位的weight才会增加1，
 * 所以，一轮0-9周期内，1会出现10次。即rount*10。
 * 256从十位数来看一共走了2个周期，第3个周期走到5，十位数仍然多了10个，
 * 所以十位数为1的一个是20+10=30个
 * (因为每走一个周期，十位数就会多出10,11,12,13,14,15,16,17,18,19，即rount*10)
 *
 * (3)之后和十位数一样
 *
 * 所以256个数为为1有26个，十位数为1有30个，百位数为1有100个
 * 出现的1的次数为26+30+100=156
 *
 */