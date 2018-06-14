package alogorithms.search;

/**
 * Created with IntelliJ IDEA
 * Author: aleng
 * Date  : 2018/4/17
 * Time  : 18:15
 * Description: 机器人的运动范围
 **/
public class Code20180417_MovingCount {

    public static int movingCount(int threshold, int rows, int cols)
    {
        int count = 0 ;
        boolean[] visited = new boolean[rows * cols];
        movingCore(threshold,rows,cols,0,0,visited);
        for (boolean b:visited){
            if (b){
                count++;
            }
        }
        return count;
    }
    private static void movingCore(int threshold, int rows, int cols, int row, int col, boolean[] visited) {
        if (row >= 0 && row < rows && col >= 0 && col < cols && !visited[row * cols + col] && (numSum(row) + numSum(col)) <= threshold){
            visited[row * cols + col] = true;
            movingCore(threshold,rows,cols,row + 1,col,visited);
            movingCore(threshold,rows,cols,row,col + 1,visited);
            movingCore(threshold,rows,cols,row - 1,col,visited);
            movingCore(threshold,rows,cols,row,col - 1,visited);
        }else {
            return;
        }
        return;
    }
    private static int numSum(int i) {
        int sum = 0;
        while (i > 0) {
            sum += i % 10;
            i = i / 10;
        }
        return sum;
    }
}
/**
 *
 * 题目:机器人的运动范围
 * 地上有一个m行n列的方格。一个机器人从坐标(0,0)的格子开始移动，
 * 它每次可以向左、右、上、下移动一格，但不能进入行坐标和列坐标的数位之和大于K的格子。
 * 例如，当k为18时，机器人能狗进入方格(35.37)，因为3+5+3+7=18.但它不能进去方格(35,38),
 * 因为3+5+3+8=19.请问该机器人能够到达多少个格子？
 *
 */