import java.util.Arrays;

class maximumTastiness {
    public int maximumTastiness(int[] price, int k) {
        Arrays.sort(price);
        //left = 0， right = 最大-最小
        int left = 0, right = price[price.length - 1] - price[0];
        while (left <= right) {
            int mid = (left + right) / 2;
            if (check(price, k, mid)) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return right;
    }

    //price[i] 代表第i类糖果的价格 k类礼盒 甜蜜度是礼盒中任意两种糖果价格的最小绝对差 返回最大最大甜蜜度
    //最大化最小值 -- 二分 1 2 5 8 13 21 甜蜜度越大 距离越大 可能的分类数越少
    private boolean check(int[] price, int k, int mid) {
        int x = price[0], cnt = 1;
        for (int i = 1; i < price.length; i++) {
            // x + mid < price[i] 可以加cnt 且更新 x
            if (x + mid <= price[i]) {
                cnt++;
                x = price[i];
            }
        }
        return cnt >= k;
    }
}