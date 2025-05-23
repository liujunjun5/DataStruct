import java.util.Arrays;

public class splitArray {
    //给定一个非负整数数组 nums 和一个整数 k ，你需要将这个数组分成 k 个非空的连续子数组，使得这 k 个子数组各自和的最大值 最小。
    //返回分割后最小的和的最大值。
    //子数组 是数组中连续的部份。
    //示例 1：
    //输入：nums = [7,2,5,10,8], k = 2
    //输出：18
    //解释：
    //一共有四种方法将 nums 分割为 2 个子数组。
    //其中最好的方式是将其分为 [7,2,5] 和 [10,8] 。
    //因为此时这两个子数组各自的和的最大值为18，在所有情况中最小。
    //示例 2：
    //输入：nums = [1,2,3,4,5], k = 2
    //输出：9
    //示例 3：
    //输入：nums = [1,4,4], k = 3
    //输出：4
    //提示：
    //1 <= nums.length <= 1000
    //0 <= nums[i] <= 106
    //1 <= k <= min(50, nums.length)
    public int splitArray(int[] nums, int k) {
        int l = Arrays.stream(nums).max().getAsInt(), r = Arrays.stream(nums).sum();
        while (l <= r) {
            int mid = l + (r - l) / 2;
            if (check(nums, mid, k)) {
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        return l;
    }

    private boolean check(int[] nums, int mid, int k) {
        int s = 0, cnt = 1;
        for (int num : nums) {
            if (s + num > mid) {
                s = num;
                cnt += 1;
            } else {
                s += num;
            }
        }
        return cnt <= k;
    }
}
