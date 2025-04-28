import java.util.Arrays;

public class minimizedMaximum {
    // 分配商品数量越小 需要的商店越多 符合单调性 -> 二分
    //
    public int minimizedMaximum(int n, int[] quantities) {
        //  找出上下界
        int left = 1, right = Arrays.stream(quantities).max().getAsInt();
        while (left <= right) {
            // mid 代表分配到产品的最大数量
            int mid = left + (right - left) / 2;
            if (check(quantities, mid, n)) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }

    private boolean check(int[] quantities, int mid, int n) {
        // cnt 代表分配的商店数目
        int cnt = 0;
        for (int x : quantities) {
            cnt += (x+mid-1)/mid;
        }
        return cnt <= n;
    }
    //给你一个整数 n ，表示有 n 间零售商店。总共有 m 种产品，每种产品的数目用一个下标从 0 开始的整数数组 quantities 表示，其中 quantities[i] 表示第 i 种商品的数目。
    //你需要将 所有商品 分配到零售商店，并遵守这些规则：
    //一间商店 至多 只能有 一种商品 ，但一间商店拥有的商品数目可以为 任意 件。
    //分配后，每间商店都会被分配一定数目的商品（可能为 0 件）。用 x 表示所有商店中分配商品数目的最大值，你希望 x 越小越好。也就是说，你想 最小化 分配给任意商店商品数目的 最大值 。
    //请你返回最小的可能的 x 。
    //示例 1：
    //输入：n = 6, quantities = [11,6]
    //输出：3
    //解释： 一种最优方案为：
    //- 11 件种类为 0 的商品被分配到前 4 间商店，分配数目分别为：2，3，3，3 。
    //- 6 件种类为 1 的商品被分配到另外 2 间商店，分配数目分别为：3，3 。
    //分配给所有商店的最大商品数目为 max(2, 3, 3, 3, 3, 3) = 3 。
    //示例 2：
    //输入：n = 7, quantities = [15,10,10]
    //输出：5
    //解释：一种最优方案为：
    //- 15 件种类为 0 的商品被分配到前 3 间商店，分配数目为：5，5，5 。
    //- 10 件种类为 1 的商品被分配到接下来 2 间商店，数目为：5，5 。
    //- 10 件种类为 2 的商品被分配到最后 2 间商店，数目为：5，5 。
    //分配给所有商店的最大商品数目为 max(5, 5, 5, 5, 5, 5, 5) = 5 。
}
