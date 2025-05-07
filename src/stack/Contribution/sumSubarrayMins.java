package stack.Contribution;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

public class sumSubarrayMins {
    private static final long MOD = (long) 1e9 + 7;
    public int sumSubarrayMins(int[] arr) {
    //目标 找到每一个数x的边界 边界定义：左边界小于x的第一个值的下标 右边界小于等于x的的一个值的下标
        Deque<Integer> stack = new ArrayDeque<>();
        long ans = 0;
        int n = arr.length;
        stack.push(-1);
        int[] left = new int[n];
        int[] right = new int[n];
        Arrays.fill(right, n);
        for (int i = 0; i < arr.length; i++) {
            while (stack.size() > 1 && arr[stack.peek()] > arr[i]) {
                right[stack.pop()] = i;
            }
            left[i] = stack.peek();
            stack.push(i);
        }

        for (int i = 0; i < n; i++) {
            ans += (long)arr[i] * ((right[i]-i)*(i-left[i]));
        }

        return (int)(ans%MOD);
    }
}
