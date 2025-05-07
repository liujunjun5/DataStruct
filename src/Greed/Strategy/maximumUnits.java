package Greed.Strategy;

import java.util.Arrays;
import java.util.Comparator;

public class maximumUnits {
    public int maximumUnits(int[][] boxTypes, int truckSize) {
        // 优先放存放单元最多的箱子
        Arrays.sort(boxTypes, Comparator.comparingInt(o -> o[1]));
        int ans = 0;
        for (int i = boxTypes.length - 1; i >= 0; i--) {
            if (truckSize>=boxTypes[i][0]) {
                ans += boxTypes[i][0]*boxTypes[i][1];
                truckSize -= boxTypes[i][0];
            } else if (truckSize > 0) {
                ans += boxTypes[i][1] * truckSize;
                truckSize -= boxTypes[i][0];
            } else {
                return ans;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(new maximumUnits().maximumUnits(new int[][]{{1, 3}, {2, 2}, {3, 1}}, 4));
    }
}
