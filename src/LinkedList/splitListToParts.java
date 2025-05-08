package LinkedList;

import java.util.Arrays;

public class splitListToParts {
    public ListNode[] splitListToParts(ListNode head, int k) {
        int n = 0;
        for (ListNode cur = head; cur != null; cur = cur.next, n += 1) ;
        int q = n / k, r = n % k;
        ListNode[] ans = new ListNode[k];
        ListNode cur = head;
        for (int i = 0; cur != null && i < k; i++) {
            ans[i] = cur;
            int size = q + (i >= r ? 0 : 1);
            for (int j = 1; j < size; j++) {
                cur = cur.next;
            }
            ListNode nxt = cur.next;
            cur.next = null;
            cur = nxt;
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new splitListToParts().splitListToParts(ListNode.createListNode(new int[]{1,2,3,4,5,6,7,8,9,10}), 3)));
    }
}
