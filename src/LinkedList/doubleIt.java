package LinkedList;

public class doubleIt {
    public ListNode doubleIt(ListNode head) {
        head = rever(head);
        int carry = 0;
        ListNode dummy = new ListNode(-1), cur = dummy;
        while (head != null) {
            int x = head.val*2 + carry;
            cur.next = new ListNode(x%10);
            carry=x/10;
            cur =cur.next;
            head=head.next;
        }
        if (carry != 0) {
            cur.next = new ListNode(carry);
        }
        return dummy.next;
    }

    public ListNode rever(ListNode head) {
        ListNode pre = null, cur = head;
        while (cur != null) {
            ListNode nx = cur.next;
            cur.next = pre;
            pre = cur;
            cur = nx;
        }
        return pre;
    }
}
