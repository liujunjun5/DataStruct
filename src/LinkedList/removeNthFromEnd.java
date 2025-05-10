package LinkedList;

public class removeNthFromEnd {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode(-1, head);
        ListNode p1 = dummy, p0 = dummy;
        for (int i = 0; i < n; i++) p1 = p1.next;
        while (p1 != null && p1.next != null) {
            p1 = p1.next;
            p0 = p0.next;
        }
        p0.next = p0.next.next;
        return dummy.next;
    }
}
