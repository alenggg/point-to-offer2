package alogorithms.number;

/**
 * Created with IntelliJ IDEA
 * Author: aleng
 * Date  : 2018/6/20
 * Time  : 16:25
 * Description: 扑克牌中的顺子(4个大小王)
 **/
public class Code_067_IsContinuous {

    public static boolean isContinuous(int[] numbers) {
        if (numbers == null || numbers.length != 5){
            return false;
        }
        int[] pokers = new int[14];
        for (int i = 0; i < numbers.length; i++) {
            if (numbers[i] > 13 || numbers[i] < 0) {
                return false;
            }
            pokers[numbers[i]]++;
        }
        int start = 1;   //start是从第一个不为0的开始
        while (pokers[start] == 0) {
            start++;
        }
        int king = pokers[0];
        for (int i = start; i < start + 5; i++) {
            if (i > 13)
                break;
            if (pokers[i] > 1) {
                return false;
            } else if (pokers[i] == 0) {
                if (king == 0) {
                    return false;
                }
                king--;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        int[] data1 = new int[]{4,2,7,12,1}; //false
        int[] data2 = new int[]{0,5,6,12,0}; //false
        int[] data3 = new int[]{6,5,8,7,4};  //true
        int[] data4 = new int[]{0,5,6,9,8};  //true
        int[] data5 = new int[]{0,13,0,12,0}; //true
        int[] data6 = new int[]{0,0,11,12,13};//true
        System.out.println(isContinuous(data1));
        System.out.println(isContinuous(data2));
        System.out.println(isContinuous(data3));
        System.out.println(isContinuous(data4));
        System.out.println(isContinuous(data5));
        System.out.println(isContinuous(data6));
    }
}
