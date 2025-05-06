package stack.Contribution;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

public class subArrayRanges {
    public long subArrayRanges(int[] nums) {
        long maxVal = helper(nums);
        System.out.println(maxVal);
        Arrays.setAll(nums, i -> -nums[i]);
        System.out.println(helper(nums));
        return -(maxVal + helper(nums));
    }

    private long helper(int[] nums) {
        long ans = 0;
        Deque<Integer> stack = new ArrayDeque<>();
        stack.push(-1);
        int n = nums.length;
        int[] left = new int[n], right = new int[n];
        Arrays.fill(right, n);
        for (int i = 0; i < n; i++) {
            while (stack.size() > 1 && nums[stack.peek()] <= nums[i]) {
                right[stack.pop()] = i;
            }
            left[i] = stack.peek();
            stack.push(i);
        }
//        System.out.println(Arrays.toString(left));
//        System.out.println(Arrays.toString(right));
        for (int i = 0; i < n; i++) {
            ans += (long) nums[i] * (i - left[i]) * (right[i] - i);
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(new subArrayRanges().subArrayRanges(new int[]{1,2,3}));
    }
}
