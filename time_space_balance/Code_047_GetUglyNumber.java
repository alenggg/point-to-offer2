package alogorithms.time_space_balance;


/**
 * Created with IntelliJ IDEA
 * Author: aleng
 * Date  : 2018/5/30
 * Time  : 9:36
 * Description:丑数
 **/
public class Code_047_GetUglyNumber {
    //空间换取时间，用较小的空间消耗换取了时间效率的提升
    public static int GetUglyNumber_Solution(int index) {
        if(index <= 0){
            return 0;
        }
        int[] uglyNumber = new int[index];
        uglyNumber[0] = 1;
        int uglyIndex = 1;
        int multiply2 = 0;
        int multiply3 = 0;
        int multiply5 = 0;
        while (uglyIndex < index) {
            //2*3=6，3*2=6，会有重复值，因此下面需要使用if，而不能用if-else
            uglyNumber[uglyIndex] = min(uglyNumber[multiply2] * 2, uglyNumber[multiply3] * 3, uglyNumber[multiply5] * 5);
            if (uglyNumber[multiply2] * 2 == uglyNumber[uglyIndex]) multiply2++;
            if (uglyNumber[multiply3] * 3 == uglyNumber[uglyIndex]) multiply3++;
            if (uglyNumber[multiply5] * 5 == uglyNumber[uglyIndex]) multiply5++;
            uglyIndex++;
        }
        return uglyNumber[index - 1];
    }

    public static int min(int number1, int number2, int number3){

        int min = number1 < number2 ? number1 : number2;
        return number3 < min ? number3 : min;
    }

    public static void main(String[] args) {
        System.out.println(GetUglyNumber_Solution(10));
    }
}

/*
题目要求：
我们把只包含因子2,3,5的数成为丑数。求按照从小到大的顺序第1500个丑数。
1作为第一个丑数。

因为丑数是按顺序存放在数组中的。
对于乘以2而言，肯定存在某一个丑数T2，排在它之前的每一个丑数乘以2得到的结果都会小于已有的最大的丑数，
在它之后的每个丑数乘以2得到的结果都会太大，我们只需要记下这个丑数的位置然后更新它即可。
对于乘以3和5而言，也存在同样的T3和T5。
开始都从第一位开始

计算出丑数：因为每个丑数都可以看成是由1去乘以2、3、5，再乘以2、3、5而衍生出来的。
可以用三个指针指向第一个丑数1，三个指针分别表示乘2，乘3，乘5，
将三个指针计算出来的最小的丑数放在数组中，并将该指针向后移动一个位置。
为了得到第1500个丑数，需要一个长度1500的数组来记录已经计算出来的丑数。
因此这个思路也可以说是用空间换时间。

 */


