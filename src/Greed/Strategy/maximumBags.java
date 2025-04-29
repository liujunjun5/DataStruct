package Greed.Strategy;

import java.util.Arrays;

public class maximumBags {
    public int maximumBags(int[] capacity, int[] rocks, int additionalRocks) {
        // 算出当前的背包容量 把k分配 算出最大0个数 排序
        for (int i = 0; i < capacity.length; i++) {
            capacity[i] -= rocks[i];
        }
        Arrays.sort(capacity);
        int ans = 0;
        for (int i = 0; i < capacity.length; i++) {
            if (capacity[i]==0) {
                ans += 1;
                continue;
            }
            if (additionalRocks >= capacity[i]) {
                additionalRocks -= capacity[i];
                ans += 1;
            }
        }
        return ans;
    }
}
