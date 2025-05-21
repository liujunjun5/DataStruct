package LinkedList;

public class reverseBetween {
    public ListNode reverseBetween(ListNode head, int left, int right) {
        //指针1指向left的前一个
        ListNode dummy = new ListNode(-1, head);
        ListNode l = dummy, r = dummy;
        while (left > 1) {
            l = l.next;
            r = r.next;
            right -= 1;
            left -= 1;
        }
        while (right >= 0) {
            r = r.next;
            right -= 1;
        }
        ListNode pre = l;
        ListNode cur = l.next;
        while (cur != r) {
            ListNode nxt = cur.next;
            cur.next = pre;
            pre = cur;
            cur = nxt;
        }
        l.next.next = r;
        l.next = pre;
        return  dummy.next;
    }

    public ListNode reverseBetweenII(ListNode head, int left, int right) {
        ListNode dummy = new ListNode(-1, head);
        ListNode p0 = dummy;
        for (int i = 0; i < left - 1; i++) {
            p0 = p0.next;
        }
        ListNode prev = null;
        ListNode cur = p0.next;
        for(int i = 0; i < right-left+1;i++) {
            ListNode nxt = cur.next;
            cur.next = prev;
            prev = cur;
            cur = nxt;
        }
        p0.next.next = cur;
        p0.next = prev;
        return dummy.next;
    }

    public static void main(String[] args) {
        ListNode listNode = new reverseBetween().reverseBetweenII(ListNode.createListNode(new int[]{1, 2, 3, 4, 5}), 2, 4);
        ListNode.displayListNode(listNode);
    }
}
