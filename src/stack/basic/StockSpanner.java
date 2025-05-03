package stack.basic;

import java.util.ArrayDeque;
import java.util.Deque;

class StockSpanner {
    int curDay = -1;
    Deque<int[]> stack = new ArrayDeque<>();

    public StockSpanner() {
        stack.push(new int[]{-1, Integer.MAX_VALUE});
    }

    public int next(int price) {
        while (price >= stack.peek()[1]) {
            stack.pop();
        }
        int ans = ++curDay - stack.peek()[0];
        stack.push(new int[]{curDay, price});
        return ans;
    }
}