public class longestSubarray {
    // 给你一个二进制数组 nums ，你需要从中删掉一个元素。
    // 请你在删掉元素的结果数组中，返回最长的且只包含 1 的非空子数组的长度。
    // 如果不存在这样的子数组，请返回 0 。
    // 输入：nums = [1,1,0,1]
    // 输出：3
    // 解释：删掉位置 2 的数后，[1,1,1] 包含 3 个 1 。
    //
    // 输入：nums = [0,1,1,1,0,1,1,0,1]
    // 输出：5
    // 解释：删掉位置 4 的数字后，[0,1,1,1,1,1,0,1] 的最长全 1 子数组为 [1,1,1,1,1] 。
    public int longestSubarray(int[] nums) {
        int l = 0;
        int ans = 0;
        int cur = 0;
        for (int r = 0; r < nums.length; r++) {
            if (nums[r] == 0) {
                cur += 1;
            }
            while (cur > 1) {
                if (nums[l] == 0) {
                    cur -= 1;
                }
                l += 1;
            }
            ans = Math.max(ans, r - l);
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{0,1,1,1,0,1,1,0,1};
        longestSubarray solution = new longestSubarray();
        System.out.println(solution.longestSubarray(arr));
    }
}
