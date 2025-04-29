public class maxSatisfied {
    //输入：customers = [1,0,1,2,1,1,7,5], grumpy = [0,1,0,1,0,1,0,1], minutes = 3
    // 输出：16
    // 解释：书店老板在最后 3 分钟保持冷静。
    // 感到满意的最大客户数量 = 1 + 1 + 1 + 1 + 7 + 5 = 16.
    public int maxSatisfied(int[] customers, int[] grumpy, int minutes) {
        //把原来没生气的时刻全部加上，
        int ans = 0;
        int base = 0;
        for (int r = 0; r < grumpy.length; r++) {
            if (grumpy[r] == 0) {
                base += customers[r];
            }
        }
        int s = 0;
        for (int r = 0; r < customers.length; r++) {
            if (grumpy[r] == 1){
                s += customers[r];
            }
            if (r < minutes - 1) {
                continue;
            }
            ans = Math.max(ans, s);
            if (grumpy[r-minutes+1] == 1){
            s -= customers[r-minutes+1];
            }
        }
        return ans + base;
    }

    //public static void main(String[] args) {
    //    maxSatisfied solution = new maxSatisfied();
    //    System.out.println(solution.maxSatisfied(new int[]{3, 2, 5}, new int[]{0, 1, 1}, 2));
    //}
}
