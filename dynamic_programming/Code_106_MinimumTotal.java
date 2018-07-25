package alogorithms.dynamic_programming;

import java.util.ArrayList;

/**
 * Created with IntelliJ IDEA
 * Author: aleng
 * Date  : 2018/7/20
 * Time  : 10:46
 * Description: Given a triangle, find the minimum path sum from top to bottom.
 **/
public class Code_106_MinimumTotal {

    public static int minimumTotal(ArrayList<ArrayList<Integer>> triangle) {
        for (int i = triangle.size() - 2; i >= 0; i--) {
            for (int j = 0; j < triangle.get(i + 1).size() - 1; j++) {
                int min = Math.min(triangle.get(i + 1).get(j), triangle.get(i + 1).get(j + 1));
                triangle.get(i).set(j, triangle.get(i).get(j) + min);
            }
        }
        return triangle.get(0).get(0);
    }

    public static void main(String[] args) {
        ArrayList<ArrayList<Integer>> triangle = new ArrayList<>();
        ArrayList<Integer> a = new ArrayList<>();
        a.add(-1);

        ArrayList<Integer> b = new ArrayList<>();
        b.add(2);
        b.add(3);

        ArrayList<Integer> c = new ArrayList<>();
        c.add(1);
        c.add(-1);
        c.add(-3);

        triangle.add(a);
        triangle.add(b);
        triangle.add(c);
        System.out.println(minimumTotal(triangle));
    }
}
/**
 * Given a triangle, find the minimum path sum from top to bottom.
 * <p>
 * Each step you may move to adjacent numbers on the row below.
 * <p>
 * For example, given the following triangle
 * <p>
 * [
 * [2],
 * [3,4],
 * [6,5,7],
 * [4,1,8,3]
 * ]
 * <p>
 * The minimum path sum from top to bottom is11(i.e., 2 + 3 + 5 + 1 = 11).
 * <p>
 * Note:
 * Bonus point if you are able to do this using only O(n) extra space, where n is the total number of rows in the triangle.
 */