package LinkedList;

public class swapPairs {
    public ListNode swapPairs(ListNode head) {
        ListNode dummy = new ListNode(-1, head);
        ListNode p0 = dummy;
        ListNode p1 = head;
        while (p1 != null && p1.next != null) {
            ListNode p2 = p1.next;
            ListNode p3 = p2.next;

            p2.next = p1;
            p1.next = p3;
            p0.next = p2;

            p0 = p1;
            p1 = p3;
        }
        return dummy.next;
    }

    public static void main(String[] args) {
        ListNode head = new swapPairs().swapPairs(ListNode.createListNode(new int[]{1, 2, 3, 4}));
        ListNode.displayListNode(head);
    }
}
