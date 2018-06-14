package alogorithms.search;

/**
 * Created with IntelliJ IDEA
 * Author: aleng
 * Date  : 2018/4/16
 * Time  : 16:14
 * Description:矩阵中的路径
 **/
public class Code20180416_HasPath {
    public static boolean hasPath(char[] matrix, int rows, int cols, char[] str)
    {
        //        if (matrix == null){  //不加也行?
        //            return false;
        //        }
        boolean[] visited = new boolean[matrix.length];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++){
                if (helper(matrix,rows,cols,i,j,str,0,visited)){
                    return true;
                }
            }
        }
        return false;
    }
    private static boolean helper(char[] matrix, int rows, int cols, int i, int j, char[] str, int k, boolean[] visited) {
        int index = i * cols + j;
        //1、判断该节点是否符合情况
        if (i < 0 || i >= rows || j < 0 || j >= cols ||
                matrix[index] != str[k] || visited[index] == true){
            return false;
        }
        //2、如果符合情况并且当前字符串str已经匹配完
        if (k == str.length - 1){
            return true;
        }
        //3、标记已经访问过改元素
        visited[index] = true;
        if (helper(matrix, rows, cols, i - 1, j, str, k + 1, visited)
                || helper(matrix, rows, cols, i + 1, j, str, k + 1, visited)
                || helper(matrix, rows, cols, i, j - 1, str, k + 1, visited)
                || helper(matrix, rows, cols, i, j + 1, str, k + 1, visited)) {
            return true;
        }

        visited[index] = false;//因为都不符合，从头再来。从下一个节点开始遍历时所有节点都没有被访问
        return false;
    }
}
/**
 *
 * 题目:矩阵中的路径
 * 请设计一个函数，用来判断在一个矩阵中是否存在一条包含某字符串所有字符的路径。路径可以从矩阵中的任意一格开始，
 * 每一步可以在矩阵中向左、右、上、下移动一格。如果一条路径经过了矩阵的某一格，那么该路径不能再次进去该格子。
 * 例如，在下面3*4的矩阵中包含一条字符串"bfce"的路径(路径中的字母用下划线标出)。但矩阵中不包含字符串"abfb"
 * 的路径，因为字符串的第一个字符b占据了矩阵中的第一行第二个格子之后，路径不能再次进入这个格子。
 * a b t g
 * c f c s
 * j d e h
 */