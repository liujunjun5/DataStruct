package LinkedList;

public class addTwoNumbers {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int carry = 0;
        ListNode dummy = new ListNode(-1, l1);
        ListNode cur = dummy;
        while (l1 != null || l2 != null) {
            int x = l1 == null ? 0 : l1.val, y = l2 == null ? 0 : l2.val;
            if (l1 != null) {
                l1 = l1.next;
            }
            if (l2 != null) {
                l2 = l2.next;
            }
            int s = x + y + carry;
            cur.next = new ListNode(s % 10);
            cur = cur.next;
            carry = s / 10;
        }
        cur.next = l1 == null ? l2 : l1;
        if (carry != 0) {
            cur.next = new ListNode(carry);
        }
        return dummy.next;
    }
}
