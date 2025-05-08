package stack.Rectangle;

import java.util.ArrayDeque;
import java.util.Deque;


public class maximumScore {
        public int maximumScore(int[] nums, int k) {
            int n = nums.length;
            int[] newNums = new int[n + 2];
            System.arraycopy(nums, 0, newNums, 1, n);
            Deque<Integer> stack = new ArrayDeque<>();
            //stack.push(-1); // 初始化哨兵
            int ans = 0;

            for (int i = 0; i < newNums.length; i++) {
                while (!stack.isEmpty() && newNums[stack.peek()] > newNums[i]) {
                    int height = newNums[stack.pop()];
                    int width = i - stack.peek() - 1;
                    // 判断区间是否包含k+1的位置
                    if (stack.peek() <= k + 1 && k + 1 <= i) {
                        ans = Math.max(ans, height * width);
                    }
                }
                stack.push(i);
            }
            return ans;
        }

    public static void main(String[] args) {
        System.out.println(new maximumScore().maximumScore(new int[]{1, 4, 3, 7, 4, 5}, 3)); // 输出应为 15
    }
}