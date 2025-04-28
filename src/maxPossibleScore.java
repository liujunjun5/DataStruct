import java.util.Arrays;

public class maxPossibleScore {
    public int maxPossibleScore(int[] start, int d) {
        // 分数是 选的区间中的整数之间 最小的 绝对差  要找这些绝对差的最大值
        // 二分分数 分数越大 右区间越大 越不可能满足 要找最极限的分数使得可以满足在区间内
        Arrays.sort(start);
        int left = 0, right = start[start.length - 1] - start[0] + d ;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            // 最大化最小值
            if (check(start, mid, d)) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return right;
    }

    private boolean check(int[] start, int mid, int d) {
        // check 的思路： mid 是分数 第一个是 x0 = start[0] 第二个是 x1 = max(start[1], start[0]+mid) x1 <= start[1]+d 如果不能满足就说明mid需要减小
        // 第 i 个 xi = max(start[i], x(i-1) + d )
        long s = Long.MIN_VALUE;
        for (int i = 0; i < start.length; i++) {
            s = Math.max(start[i], s + mid);
            if (s > start[i] + d) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        int[] start = {6, 0, 3};
        int d = 2;
        maxPossibleScore solution = new maxPossibleScore();
        System.out.println(solution.maxPossibleScore(start, d));
    }
}
