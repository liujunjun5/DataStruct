package stack.Rectangle;

import java.util.ArrayDeque;
import java.util.Deque;

public class trap {
    public int trap(int[] height) {
        Deque<Integer> stack = new ArrayDeque<>();
        int ans = 0;
        for (int i = 0; i < height.length; i++) {
            while (!stack.isEmpty() && height[stack.peek()] < height[i]) {
                int h = height[stack.pop()];
                if (stack.isEmpty()) {
                    break;
                }
                int l = stack.peek();
                ans += (i - l - 1) * (Math.min(height[l], height[i]) - h);
            }
            stack.push(i);
        }
        return ans;
    }
}
