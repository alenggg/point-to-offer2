package alogorithms.dynamic_programming;

/**
 * Created with IntelliJ IDEA
 * Author: aleng
 * Date  : 2018/7/24
 * Time  : 17:23
 * Description: A robot is located at the top-left corner of a m x n grid (marked 'Start' in the diagram below).
 **/
public class Code_118_UniquePaths {
    //回溯法
    public int sum;
    public int uniquePaths(int m, int n) {
        sum = 0;
        FindPath(0, 0, m, n);
        return sum;
    }

    private void FindPath(int x, int y, int m, int n) {
        if (x == m - 1 || y == n - 1) {
            sum++;
            return;
        }
        FindPath(x + 1, y, m, n);
        FindPath(x, y + 1, m, n);
    }

    //动态规划 dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
    public int uniquePaths2(int m, int n) {
        int[][] dp = new int[m + 1][n + 1];
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (i == 1 && j == 1)
                    dp[i][j] = 1;
                else
                    dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
            }
        }
        return dp[m][n];
    }

    public static void main(String[] args) {
        Code_118_UniquePaths test = new Code_118_UniquePaths();
        System.out.println(test.uniquePaths(3, 5));
        System.out.println(test.uniquePaths2(3, 5));
    }
}
/**
 * A robot is located at the top-left corner of a m x n grid (marked 'Start' in the diagram below).
 * <p>
 * The robot can only move either down or right at any point in time.
 * <p>
 * The robot is trying to reach the bottom-right corner of the grid (marked 'Finish' in the diagram below).
 * <p>
 * How many possible unique paths are there?
 * <p>
 * Note: m and n will be at most 100.
 */