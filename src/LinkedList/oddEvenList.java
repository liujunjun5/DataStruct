package LinkedList;

import DataStruct.arrayList.List;

public class oddEvenList {
    public ListNode oddEvenList(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode odd = head, even = head.next;
        ListNode tmp = even;
        while (even != null && even.next != null) {
            odd.next = even.next;
            odd = odd.next;
            even.next = odd.next;
            even = even.next;
        }
        odd.next = tmp;
        return head;
    }
}
