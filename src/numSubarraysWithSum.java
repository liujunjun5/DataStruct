import java.util.HashMap;

public class numSubarraysWithSum {
    public int numSubarraysWithSum1(int[] nums, int goal) {
        // 前缀和的做法
        HashMap<Integer, Integer> cnt = new HashMap<>();
        cnt.put(0, 1);
        int s = 0, ans = 0;
        for (int i = 0; i < nums.length; i++) {
            s += nums[i];
            ans += cnt.getOrDefault(s - goal, 0);
            cnt.merge(s, 1, Integer::sum);
        }
        return ans;
    }

    public int numSubarraysWithSum(int[] nums, int goal) {
        // 滑动窗口的做法
        // 找大于等于 k 的 减去 大于等于 k+1 的
        return helper(nums, goal) - helper(nums, goal + 1);
    }

    // 找
    private int helper(int[] nums, int goal) {
        int ans = 0, l = 0, cur = 0;
        for (int r = 0; r < nums.length; r++) {
            cur += nums[r];
            while (l <= r && cur >= goal) {
                cur -= nums[l];
                l += 1;
            }
            ans += l;
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(new numSubarraysWithSum().numSubarraysWithSum(new int[]{0,0,0,0,0}, 0));
    }
}
