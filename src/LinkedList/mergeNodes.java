package LinkedList;

public class mergeNodes {
    public ListNode mergeNodes(ListNode head) {
        ListNode tail = head;
        for (ListNode cur = head.next; cur.next != null; cur = cur.next) {
            if (cur.val!=0) {
                tail.val += cur.val;
            } else {
                tail = tail.next;
                tail.val = 0;
            }
        }
        tail.next = null;
        return head;
    }
}
