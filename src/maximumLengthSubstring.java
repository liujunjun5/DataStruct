import java.util.HashMap;
import java.util.Map;

public class maximumLengthSubstring {
    // 给你一个字符串 s ，请找出满足每个字符最多出现两次的最长子字符串，并返回该子字符串的 最大 长度。
    // 示例 1：
    // 输入： s = "bcbbbcba"
    // 输出： 4
    // 解释：
    // 以下子字符串长度为 4，并且每个字符最多出现两次："bcbbbcba"。
    public int maximumLengthSubstring(String s) {
        char[] arr = s.toCharArray();
        Map<Character, Integer> cnt = new HashMap<>();
        int left = 0;
        int ans = 0;
        for (int right = 0; right < arr.length; right++) {
            cnt.merge(arr[right], 1, Integer::sum);
            while (cnt.get(arr[right]) > 2) {
                cnt.put(arr[left], cnt.get(arr[left]) - 1);
                left += 1;
            }
            ans = Math.max(ans, right - left + 1);
        }
        return ans;
    }

    public static void main(String[] args) {
        String s = "bcbbbcba";
        maximumLengthSubstring solution = new maximumLengthSubstring();
        System.out.println(solution.maximumLengthSubstring("bcbbbcba"));
    }
}
