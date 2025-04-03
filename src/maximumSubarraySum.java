import java.util.HashMap;
import java.util.Map;

public class maximumSubarraySum {
    // 给你一个整数数组 nums 和一个整数 k 。请你从 nums 中满足下述条件的全部子数组中找出最大子数组和：
    // 子数组的长度是 k，且
    // 子数组中的所有元素 各不相同 。
    // 返回满足题面要求的最大子数组和。如果不存在子数组满足这些条件，返回 0 。
    // 子数组 是数组中一段连续非空的元素序列。
    // 输入：nums = [1,5,4,2,9,9,9], k = 3
    // 输出：15
    // 解释：nums 中长度为 3 的子数组是：
    //         - [1,5,4] 满足全部条件，和为 10 。
    //         - [5,4,2] 满足全部条件，和为 11 。
    //         - [4,2,9] 满足全部条件，和为 15 。
    //         - [2,9,9] 不满足全部条件，因为元素 9 出现重复。
    //         - [9,9,9] 不满足全部条件，因为元素 9 出现重复。
    // 因为 15 是满足全部条件的所有子数组中的最大子数组和，所以返回 15 。
    public long maximumSubarraySum(int[] nums, int k) {
        long ans = 0;
        long s = 0;
        Map<Integer, Integer> cnt = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            s += nums[i];
            cnt.merge(nums[i], 1, Integer::sum);
            if (i<k-1) {
                continue;
            }
            if (cnt.size()==k) {
                ans = Math.max(ans, s);
            }
            s -= nums[i-k+1];
            int x = cnt.get(nums[i-k+1]);
            if (x>1) {
                cnt.put(nums[i-k+1], x-1);
            } else {
                cnt.remove(nums[i-k+1]);
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        maximumSubarraySum solution = new maximumSubarraySum();
        System.out.println(solution.maximumSubarraySum(new int[]{1,5,4,2,9,9,9}, 3));
    }
}
