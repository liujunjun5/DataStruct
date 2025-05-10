package LinkedList;

import java.util.ArrayDeque;
import java.util.Deque;

public class nextLargerNodes {
    public int[] nextLargerNodes(ListNode head) {
        int n = 0;
        for (ListNode cur = head; cur != null; cur = cur.next) {
            n += 1;
        }
        int[] ans = new int[n];
        int i = 0;
        Deque<int[]> stack = new ArrayDeque<>();
        for (ListNode cur = head; cur != null; cur = cur.next) {
            while(!stack.isEmpty()&&cur.val>stack.peek()[1]) {
                ans[stack.pop()[0]] = cur.val;
            }
            stack.push(new int[]{i++, cur.val});
        }
        return ans;
    }
}
