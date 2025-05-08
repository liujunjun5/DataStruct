package LinkedList;

public class insertionSortList {
    public ListNode insertionSortList(ListNode head) {
        ListNode tail = head;
        ListNode dummy = new ListNode(-1, head);

        for (ListNode cur = head.next; cur != null; cur = tail.next) {
            if (cur.val >= tail.val) {
                tail = cur;
            } else {
                ListNode tmp = dummy;
                while(tmp.next.val <= cur.val) {
                    tmp = tmp.next;
                }
                tail.next = cur.next;
                cur.next = tmp.next;
                tmp.next = cur;
            }
        }
        return dummy.next;
    }

    public static void main(String[] args) {
        ListNode head = new insertionSortList().insertionSortList(ListNode.createListNode(new int[]{4, 2, 1, 3}));
        ListNode.displayListNode(head);
    }
}
