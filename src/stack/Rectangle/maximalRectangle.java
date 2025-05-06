package stack.Rectangle;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

public class maximalRectangle {
    public int maximalRectangle(char[][] matrix) {
        int m = matrix.length, n = matrix[0].length;
        int[][] rows = new int[m + 2][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (j == 0) {
                    rows[i + 1][j] = matrix[i][j] == '1' ? 1 : 0;
                } else {
                    rows[i + 1][j] = matrix[i][j] == '0' ? 0 : rows[i+1][j - 1] + 1;
                }
            }
        }
        //带哨兵节点的矩形高度
        System.out.println(Arrays.deepToString(rows));
        int ans = 0;
        for (int j = 0; j < n; j++) {
            int curAns = 0;
            Deque<Integer> stack = new ArrayDeque<>();
            for (int i = 0; i < m+2; i++) {
                while (!stack.isEmpty() && rows[stack.peek()][j] > rows[i][j]) {
                    int width = i - stack.peek(), h = rows[stack.pop()][j];
                    curAns = Math.max(curAns, width * h);
                }
                stack.push(i);
            }
            ans = Math.max(ans, curAns);
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(new maximalRectangle().maximalRectangle(new char[][]{{'1', '0', '1', '0', '0'}, {'1', '0', '1', '1', '1'}, {'1', '1', '1', '1', '1'}, {'1', '0', '0', '1', '0'}}));
    }
}
