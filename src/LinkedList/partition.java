package LinkedList;

import DataStruct.arrayList.List;

public class partition {
    public ListNode partition(ListNode head, int x) {
        ListNode small = new ListNode(-1), big = new ListNode(-1);
        ListNode s = small, b = big;
        for (ListNode cur = head; cur != null; ) {
            if (cur.val < x) {
                s.next = cur;
                s = s.next;
            } else {
                b.next = cur;
                b = b.next;
            }
            cur = cur.next;
        }
        s.next = big.next;
        b.next = null;
        return small.next;
    }

    public static void main(String[] args) {
        ListNode partition = new partition().partition(ListNode.createListNode(new int[]{1}), 2);
        ListNode.displayListNode(partition);
    }
}
