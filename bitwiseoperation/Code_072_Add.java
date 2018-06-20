package alogorithms.bitwiseoperation;

/**
 * Created with IntelliJ IDEA
 * Author: aleng
 * Date  : 2018/6/20
 * Time  : 10:11
 * Description: 不用加减乘除做加法
 **/
public class Code_072_Add {

    public static int add(int num1,int num2) {
        int sum = 0;
        int carry = 0;
        while ((num1 & num2) != 0){
            sum = num1 ^ num2;
            carry = (num1 & num2) << 1;

            num1 = sum;
            num2 = carry;
        }
        sum = num1 ^ num2 ;
        return sum;
    }

    public static void main(String[] args) {
        System.out.println(add(3,5)); //8
        System.out.println(add(3,-5)); //-2
        System.out.println(add(0,1));  //1

        System.out.println( 1 | 1);
        System.out.println( 1 | 0);
        System.out.println( 0 | 1);
        System.out.println( 0 | 0);
    }
}
/**
 * 第一步:不考虑进位对每一位相加
 * 第二步:考虑进位
 * 第三步:将不考虑进位对每一位相加得到的数+考虑进位得到的数
 * 一直到没有进位为止
 */
