package LinkedList;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class nodesBetweenCriticalPoints {
    public int[] nodesBetweenCriticalPoints(ListNode head) {
        List<Integer> tmp = new ArrayList<>();
        ListNode cur = head.next;
        ListNode pre = head;
        int i = 1;
        while (cur != null && cur.next != null) {
            if (pre.val < cur.val && cur.val > cur.next.val || pre.val > cur.val && cur.val < cur.next.val) {
                tmp.add(i);
            }
            i++;
            pre = cur;
            cur = cur.next;
        }

        if (tmp.size() < 2) {
            return new int[]{-1, -1};
        }
        int[] ans = new int[]{100001, -1};
        ans[1] = tmp.get(tmp.size() - 1) - tmp.get(0);
        for (int j = 1; j < tmp.size(); j++) {
            ans[0] = Math.min(tmp.get(j) - tmp.get(j - 1), ans[0]);
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new nodesBetweenCriticalPoints().nodesBetweenCriticalPoints(ListNode.createListNode(new int[]{5, 3, 1, 2, 5, 1, 2}))));
    }
}
