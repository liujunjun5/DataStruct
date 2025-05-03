package stack.Rectangle;

import java.util.ArrayDeque;
import java.util.Deque;

//https://leetcode.cn/problems/largest-rectangle-in-histogram/
public class largestRectangleArea {
    public int largestRectangleArea(int[] heights) {
        int len = heights.length;
        int[] newHeights = new int[len + 2];
        newHeights[0] = 0;
        System.arraycopy(heights, 0, newHeights, 1, len);
        newHeights[len+1] = 0;
        heights = newHeights;
        len += 2;

        //单调递增栈 遇到较小的值更新答案
        Deque<Integer> stack = new ArrayDeque<>();
        int ans = 0;
        for (int i = 0; i < len; i++) {
            int x = heights[i];
            while (!stack.isEmpty() && heights[stack.peek()] > x) {
                int h = heights[stack.pop()], width = i - stack.peek() - 1;
                ans = Math.max(ans, width*h);
            }
            stack.push(i);
        }
        return ans;
    }
}
