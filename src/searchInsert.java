public class searchInsert {
    //给定一个排序数组和一个目标值，在数组中找到目标值，并返回其索引。如果目标值不存在于数组中，返回它将会被按顺序插入的位置。
    // 请必须使用时间复杂度为 O(log n) 的算法。
    // 输入: nums = [1,3,5,6], target = 5
    // 输出: 2
    // 输入: nums = [1,3,5,6], target = 2
    // 输出: 1
    // 输入: nums = [1,3,5,6], target = 7
    // 输出: 4
    public int searchInsert(int[] nums, int target) {
        int l = 0, r = nums.length;
        while (l <= r) {
            int mid = l + (r - l)/2;
            if (target > nums[mid]) {
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        return l;
    }
}
