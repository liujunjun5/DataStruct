package daily;

import java.util.Arrays;

public class findNumbers {
    public int findNumbers(int[] nums) {
        int ans = 0;
        for (int num : nums) {
            while (num >= 100) {
                num /= 10;
            }
            if (10 <= num) {
                ans += 1;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(new findNumbers().findNumbers(new int[]{41, 2, 1, 1515, 11}));
    }
}
