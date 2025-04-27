public class searchRange {
    private int lowerBound(int target, int[] nums) {
        int l = 0, r = nums.length-1;
        while (l <= r) {
            int mid = l + (r - l)/2;
            if (nums[mid] < target) {
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        return l;
    }

    public int[] searchRange(int[] nums, int target) {
        int start = lowerBound(target, nums);
        if (start == nums.length || nums[start] != target) {
            return new int[]{-1, -1}; // nums 中没有 target
        }
        // 如果 start 存在，那么 end 必定存在
        int end = lowerBound(target+1, nums) - 1;
        return new int[]{start, end};
    }
}
