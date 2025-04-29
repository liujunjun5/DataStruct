public class numSubarrayProductLessThanK {
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        if (k<=1) return 0;
        int ans = 0, l = 0, mul = 1;
        for (int r = 0; r < nums.length; r++) {
            mul *= nums[r];
            while (mul >= k) {
                mul /= nums[l];
                l += 1;
            }
            ans += r-l+1;
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(new numSubarrayProductLessThanK().numSubarrayProductLessThanK(new int[]{1,2,3}, 0));
    }
}
