package Greed.Strategy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class minSubsequence {
    public List<Integer> minSubsequence(int[] nums) {
        List<Integer> arr = Arrays.stream(nums).boxed().collect(Collectors.toList());
        arr.sort((a, b) -> b - a);
        List<Integer> ans = new ArrayList<>();
        int cur = 0, s = Arrays.stream(nums).sum();
        for (int i = 0; i < arr.size(); i++) {
            if (cur > s) return ans;
            cur += arr.get(i);
            s -= arr.get(i);
            ans.add(arr.get(i));
        }
        return ans;
    }
}
