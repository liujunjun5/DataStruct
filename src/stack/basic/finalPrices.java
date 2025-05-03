package stack.basic;

import java.util.ArrayDeque;
import java.util.Deque;

public class finalPrices {
    public int[] finalPrices(int[] prices) {
        Deque<Integer> stack = new ArrayDeque<>();
        for (int i = 0; i < prices.length; i++) {
            int p = prices[i];
            while (!stack.isEmpty() && p <= prices[stack.peek()]) {
                int j = stack.pop();
                prices[j] -= p;
            }
            stack.push(i);
        }
        return prices;
    }
    //price 第i个商品的价格
}
