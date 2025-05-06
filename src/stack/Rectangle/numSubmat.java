package stack.Rectangle;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

//https://leetcode.cn/problems/count-submatrices-with-all-ones/description/
public class numSubmat {
    public int numSubmat(int[][] mat) {
        //枚举
        int m = mat.length, n = mat[0].length;
        int[][] row = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (j == 0) {
                    row[i][j] = mat[i][j];
                } else {
                    row[i][j] = mat[i][j] == 0 ? mat[i][j] : row[i][j - 1] + 1;
                }
            }
        }
        System.out.println(Arrays.deepToString(row));
        int ans = 0;
//        for (int i = 0; i < m; i++) {
//
//            //  int[] r = row[i];
//            for (int j = 0; j < n; j++) {
//                int c = row[i][j];
//                for (int k = i; k >= 0; k--) {
//                    c = Math.min(c, row[k][j]);
//                    if (c == 0) break;
//                    ans += c;
//                }
//            }
//        }
        for (int j = 0; j < n; j++) {
            int height = 1, s = 0;
            Deque<int[]> stack = new ArrayDeque<>();
            for (int i = 0; i < m; i++) {
                while (!stack.isEmpty() && row[i][j] < stack.peek()[0]) {
                    s -= stack.peek()[1] * (stack.peek()[0] - row[i][j]);
                    height += stack.pop()[1];
                }
                s += row[i][j];
                ans += s;
                stack.push(new int[]{row[i][j], height});
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(new numSubmat().numSubmat(new int[][]{{1, 0, 1}, {1, 1, 0}, {1, 1, 0}}));
//        System.out.println(new numSubmat().numSubmat(new int[][]{{2}, {3}, {2}, {1}}));
    }
}
