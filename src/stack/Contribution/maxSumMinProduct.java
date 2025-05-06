package stack.Contribution;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

public class maxSumMinProduct {
    private static final long MOD = (long) (1e9 + 7);

    public int maxSumMinProduct(int[] nums) {
        // 先求前缀和
        int n = nums.length;
        long[] pre = new long[n+1];
        pre[0] = nums[0];
        for (int i = 0; i < n; i++) {
            pre[i+1] = pre[i] + nums[i];
        }
        System.out.println(Arrays.toString(pre));
        long ans = 0;
        Deque<Integer> stack = new ArrayDeque<>();
        stack.push(-1);
        int[] left = new int[n], right = new int[n];
        Arrays.fill(right, n);
        for (int i = 0; i < n; i++) {
            //大于等于直接进栈了
            while (stack.size() > 1 && nums[stack.peek()] >= nums[i]) {
                right[stack.pop()] = i;
            }
            left[i] = stack.peek();
            stack.push(i);
        }
        System.out.println(Arrays.toString(left));
        System.out.println(Arrays.toString(right));
        for (int i = 0; i < n; i++) {
            ans = Math.max(ans, (pre[right[i]] - pre[left[i]+1]) * (long) nums[i]);
        }
        return (int) (ans % (MOD));
    }

    public static void main(String[] args) {
        System.out.println(new maxSumMinProduct().maxSumMinProduct(new int[]{1, 2, 3, 2}));
    }
}
