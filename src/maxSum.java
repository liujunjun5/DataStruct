import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class maxSum {
    public long maxSum(List<Integer> nums, int m, int k) {
        // 给你一个整数数组 nums 和两个正整数 m 和 k 。
        // 请你返回 nums 中长度为 k 的 几乎唯一 子数组的 最大和 ，如果不存在几乎唯一子数组，请你返回 0 。
        // 如果 nums 的一个子数组有至少 m 个互不相同的元素，我们称它是 几乎唯一 子数组。
        // 子数组指的是一个数组中一段连续 非空 的元素序列。
        Integer[] arr = nums.toArray(Integer[]::new);
        long ans = 0;
        Map<Integer, Integer> cnt = new HashMap<>();
        long s = 0;
        for (int i = 0; i < arr.length; i++) {
            s += arr[i];
            cnt.merge(arr[i], 1, Integer::sum);
            if (i < k - 1) {
                continue;
            }
            if (cnt.size() >= m) {
                ans = Math.max(ans, s);
            }
            s -= arr[i-k+1];
            int x = cnt.get(arr[i - k + 1]);
            if (x > 1) {
                cnt.put(arr[i - k + 1], x - 1);
            } else {
                cnt.remove(arr[i - k + 1]);
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        maxSum solution = new maxSum();
        ArrayList<Integer> arr = new ArrayList<>(List.of(2, 6, 7, 3, 1, 7));
        System.out.println(solution.maxSum(arr, 3, 4));
    }
}
