package Greed.Strategy;

import java.util.Arrays;

public class largestSumAfterKNegations {
    public int largestSumAfterKNegations(int[] nums, int k) {
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] >= 0 || k == 0) break;
            nums[i] = -nums[i];
            k -= 1;
        }
        int ans = Arrays.stream(nums).sum();
        if (k>0) {
            ans -= k % 2 == 1 ? 2*Arrays.stream(nums).min().getAsInt() : 0;
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(new largestSumAfterKNegations().largestSumAfterKNegations(new int[]{4, 2, 3}, 1));
    }
}
