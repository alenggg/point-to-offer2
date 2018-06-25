package alogorithms.bitwiseoperation;

/**
 * Created with IntelliJ IDEA
 * Author: aleng
 * Date  : 2018/6/20
 * Time  : 9:15
 * Description: 求1+2+3+...+n
 **/
public class Code_071_Sum {

    public static int sum(int n) {
        int t = 0;
        boolean b = (n > 0) && ((t = n + sum(n - 1)) > 0);
        return t;
    }

    public static void main(String[] args) {

        System.out.println(sum(0));
        System.out.println(sum(1));
        System.out.println(sum(5));
        System.out.println(sum(10));
    }
}
/**
 * 求1+2+3+...+n，要求不能使用乘除法、
 * for、while、if、else、switch、case等关键字及条件判断语句（A?B:C）。
 *
 * 省略if的一种方式：boolean b=判断条件&&待执行语句>0
 */