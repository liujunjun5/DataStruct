package LinkedList;

public class deleteMiddle {
    public ListNode deleteMiddle(ListNode head) {
        ListNode dummy = new ListNode(-1, head);
        ListNode fast = dummy, slow = dummy;
        while (fast.next != null && fast.next.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        slow.next = slow.next.next;
        return dummy.next;
    }
}
