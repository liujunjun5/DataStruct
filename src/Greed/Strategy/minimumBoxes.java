package Greed.Strategy;

import java.util.Arrays;

public class minimumBoxes {
    public int minimumBoxes(int[] apple, int[] capacity) {
        int total = Arrays.stream(apple).sum(), ans = 0, i = capacity.length-1;
        Arrays.sort(capacity);
        while (total > 0) {
            total -= capacity[i];
            i -= 1;
            ans += 1;
        }
        return ans;
    }
}
