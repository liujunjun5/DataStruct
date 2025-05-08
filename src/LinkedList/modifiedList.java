package LinkedList;

import java.util.HashSet;
import java.util.Set;

public class modifiedList {
    public ListNode modifiedList(int[] nums, ListNode head) {
        int n = nums.length;
        Set<Integer> set = new HashSet<>(n);
        for (int i = 0; i < n; i++) {
            set.add(nums[i]);
        }
        ListNode dummy = new ListNode(0, head);
        ListNode cur = dummy;
        while (cur.next != null) {
            if (set.contains(cur.next.val)) {
                cur.next = cur.next.next;
            } else {
                cur = cur.next;
            }
        }
        return dummy.next;
    }
}
