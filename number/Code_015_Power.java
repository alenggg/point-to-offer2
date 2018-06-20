package alogorithms.number;

/**
 * Created with IntelliJ IDEA
 * Author: aleng
 * Date  : 2018/4/20
 * Time  : 16:24
 * Description: 数值的整数次方
 **/
public class Code_015_Power {
    public static double power(double base,int exponent){
        double res = 0;
        if (equal(base,0.0)){
            return 0.0;
        }
        if (exponent == 0){
            return 1.0;
        }
        if (exponent > 0) {
            res = powerWithUnsignedExponent(base,exponent);
        }else {
            res = powerWithUnsignedExponent(1/base,-exponent);
        }
        return res;
    }
    public static double powerWithUnsignedExponent(double base,int exponent){
        double res = 1.0;
        for (int i = 0; i < exponent; i++) {
            res *= base;
        }
        return res;
    }
    public static boolean equal(double a, double b) {
        if (a - b < 0.000001 && a - b > -0.000001) {
            return true;
        }
        return false;
    }
}
/**
 *
 * 题目:数值的整数次方
 * 实现函数double Power(double base,int exponent),求base的expoent次方。
 * 不得使用库函数，同时不需要考虑大数问题。
 *
 * 不能用==比较两个浮点数是否相等，因为有误差。考虑输入值的多种情况
 *
 */