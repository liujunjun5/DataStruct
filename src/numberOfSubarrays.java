public class numberOfSubarrays {
    // 输入：nums = [1,1,2,1,1], k = 3
    // 输出：2
    // 解释：包含 3 个奇数的子数组是 [1,1,2,1] 和 [1,2,1,1] 。
    public int numberOfSubarrays(int[] nums, int k) {
        int cur1 = 0, cur2 = 0;
        int ans = 0;
        int l1 = 0, l2 = 0;
        for (int r = 0; r < nums.length; r++) {
            cur1 += nums[r] & 1;
            cur2 += nums[r] & 1;
            while (cur1 >= k+1) {
                cur1 -= nums[l1++] & 1;
            }
            while (cur2 >= k) {
                cur2 -= nums[l2++] & 1;
            }
            ans += l2 - l1;
        }
        return ans;
    }

    public static void main(String[] args) {
        numberOfSubarrays solution = new numberOfSubarrays();
        System.out.println(solution.numberOfSubarrays(new int[]{1, 1, 2, 1, 1}, 3));
    }
}
