import java.util.Arrays;

public class smallestDivisor {
    //示例 1：
    //
    //输入：nums = [1,2,5,9], threshold = 6
    //输出：5
    //解释：如果除数为 1 ，我们可以得到和为 17 （1+2+5+9）。
    //如果除数为 4 ，我们可以得到和为 7 (1+1+2+3) 。如果除数为 5 ，和为 5 (1+1+1+2)。
    //示例 2：
    //
    //输入：nums = [2,3,5,7,11], threshold = 11
    //输出：3
    //示例 3：
    //
    //输入：nums = [19], threshold = 5
    //输出：4
    public int smallestDivisor(int[] nums, int threshold) {
        int l = 1, r = Arrays.stream(nums).max().getAsInt();
        while (l <= r) {
            int mid = l + (r - l) / 2;
            if (check(nums, nums[mid], threshold)) {
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        return l;
    }

    public boolean check(int[] nums, int x, int threshold) {
        int s = 0;
        for (int i = 0; i < nums.length; i++) {
            s += (nums[i]+x-1)/x;
            if (s > threshold) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        smallestDivisor solution = new smallestDivisor();
        System.out.println(solution.smallestDivisor(new int[]{19}, 5));
    }
}
