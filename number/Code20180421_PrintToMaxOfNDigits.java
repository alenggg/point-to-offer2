package alogorithms.number;

/**
 * Created with IntelliJ IDEA
 * Author: aleng
 * Date  : 2018/4/21
 * Time  : 16:26
 * Description:打印从1到最大的n位数
 **/
public class Code20180421_PrintToMaxOfNDigits {

    public static void printToMaxOfNDigits(int n) {
        if(n <= 0) {
            return;
        }
        int[] array = new int[n];
        createArray(array, 0);//从数组的0位开始
    }
    private static void createArray(int[] array, int n) {
        for (int i = 0; i < 10; i++) {
            if (n < array.length){
                array[n] = i;
                createArray(array,n + 1);
            }else {
                printArray(array);
                return;
            }
        }
        return;
    }
    private static void printArray(int[] array) {
        boolean isFirstNo0 = false;
        for (int i = 0; i < array.length; i++) {
            if (array[i] != 0){
                isFirstNo0 = true;
                System.out.print(array[i]);
            }else if (isFirstNo0){
                System.out.print(array[i]);
            }
        }
        System.out.println();
        return;
    }
}
/**
 *
 * 题目:打印从1到最大的n位数
 * 输入数字n,按顺序打印从1到最大的n位数
 *
 */