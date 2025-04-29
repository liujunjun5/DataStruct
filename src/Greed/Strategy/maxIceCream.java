package Greed.Strategy;

import java.util.Arrays;

public class maxIceCream {
    public int maxIceCream(int[] costs, int coins) {
        Arrays.sort(costs);
        int ans = 0;
        for (int i = 0; i < costs.length; i++) {
            if (coins >= costs[i]) {
                ans ++;
                coins -= costs[i];
            } else {
                return ans;
            }
        }
        return ans;
    }
}