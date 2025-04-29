import java.util.Arrays;

public class countSubarrays {
    public long countSubarrays(int[] nums, int k) {
        int l = 0, cnt = 0, maxVal = Arrays.stream(nums).max().getAsInt();
        long ans = 0;
        for (int r = 0; r < nums.length; r++) {
            if (nums[r]==maxVal) {
                cnt += 1;
            }
            while (cnt >= k) {
                if (nums[l]==maxVal) {
                    cnt -= 1;
                }
                l += 1;
            }
            ans += l;
        }
        return ans;
    }
}
