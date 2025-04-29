import java.util.Arrays;

public class maximumBeauty {
    public int maximumBeauty(int[] nums, int k) {
        //先排序？ 每一个变成一个区间
        Arrays.sort(nums);
        int l = 0, ans = 0, cur = 0;
        for (int r = 0; r < nums.length; r++) {
            //ans += 1;
            if (nums[r] - nums[l] <= 2*k) {
                cur += 1;
                ans = Math.max(ans, cur);
            } else {
                l += 1;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        maximumBeauty solution = new maximumBeauty();
        System.out.println(solution.maximumBeauty(new int[]{1, 1, 1, 1}, 10));
    }
}
