package LinkedList;

public class reverseList {
    public ListNode reverseList(ListNode head) {
        ListNode prev = null;
        for (ListNode cur = head; cur != null; ) {
            ListNode nxt = cur.next;
            cur.next = prev;
            prev = cur;
            cur = nxt;
        }
        return prev;
    }

    public static void main(String[] args) {
        ListNode.displayListNode(new reverseList().reverseList(ListNode.createListNode(new int[]{1, 2, 3, 4, 5})));
    }
}
