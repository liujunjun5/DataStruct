package stack.basic;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

public class nextGreaterElements {
    public int[] nextGreaterElements(int[] nums) {
        int n = nums.length;
        int[] ans = new int[nums.length];
        Arrays.fill(ans, -1);
        Deque<Integer> stack = new ArrayDeque<>();
        for (int i = 0; i < n * 2; i++) {
            int x = nums[i % n];
            while (!stack.isEmpty() && x > nums[stack.peek()]) {
                ans[stack.pop()] = x;
            }
            if (i < n) {
                stack.push(i);
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new nextGreaterElements().nextGreaterElements(new int[]{1, 2, 1})));
    }
}
