package alogorithms.array;

import collection.NewJDK;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

/**
 * Created with IntelliJ IDEA
 * Author: aleng
 * Date  : 2018/7/23
 * Time  : 10:38
 * Description: Given a 2D board containing'X'and'O', capture all regions surrounded by'X'.
 **/
public class Code_114_Solve {
    /*
     * 所有与四条边相连的O都保留，其他O都变为X
     *
     * 遍历四条边上的O，并深度遍历与其相连的O，将这些O都转为*
     * 将剩余的O变为X
     * 将剩余的*变为O
     *
     * 就是O能找到出口的问题，然后从出口处的O反过来去找出来的路径。
     */
    public void solve(char[][] board) {
        if (board.length <= 0) return;
        int row = board.length;
        int col = board[0].length;
        for (int i = 0; i != row; i++) {
            DFS(board, i, col - 1);
            DFS(board, i, 0);
        }
        for (int i = 0; i != col; i++) {
            DFS(board, 0, i);
            DFS(board, row - 1, i);
        }
        for (int i = 0; i != row; i++)
            for (int j = 0; j != col; j++) {
                if (board[i][j] == 'O') board[i][j] = 'X';
                if (board[i][j] == '*') board[i][j] = 'O';
            }
    }

    public void DFS(char[][] board, int row, int col) {
        if (row < 0 || row > (board.length - 1) || col < 0 || col > (board[0].length - 1)) return;
        if (board[row][col] == 'O') {
            board[row][col] = '*';
            DFS(board, row - 1, col);
            DFS(board, row + 1, col);
            DFS(board, row, col - 1);
            DFS(board, row, col + 1);
        }
    }

    public static void main(String[] args) {
        Code_114_Solve test = new Code_114_Solve();
        char[][] board = {
                {'X', 'X', 'X', 'X'},
                {'X', 'O', 'O', 'X'},
                {'X', 'X', 'O', 'X'},
                {'X', 'O', 'X', 'X'}};
        test.solve(board);
        for (int i = 0; i < board.length; i++) {
            System.out.println(Arrays.toString(board[i]));
        }

    }


}
/**
 * Given a 2D board containing'X'and'O', capture all regions surrounded by'X'.
 * <p>
 * A region is captured by flipping all'O's into'X's in that surrounded region .
 * <p>
 * For example,
 * <p>
 * X X X X
 * X O O X
 * X X O X
 * X O X X
 * <p>
 * After running your function, the board should be:
 * <p>
 * X X X X
 * X X X X
 * X X X X
 * X O X X
 */