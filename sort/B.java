package alogorithms.sort;

/**
 * Created with IntelliJ IDEA
 * Author: aleng
 * Date  : 2018/7/3
 * Time  : 10:07
 * Description:
 **/
public class B
{
    public static B t1 = new B();
    public static B t2 = new B();
    public static int a = 1;
    {
        System.out.println("构造块");
        System.out.println("构造块" + a);
    }

    static
    {
        System.out.println("静态块");
        System.out.println("静态块" + a);
    }
    public  static int method(){
        int a = 2;
        int b = 3;
        try {
            return a;
        }finally {
            a = 1;
           // return b;
        }
    }
    public static void main(String[] args)
    {
        //B t = new B();
        System.out.println(B.method());

    }
}