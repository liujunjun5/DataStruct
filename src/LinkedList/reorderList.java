package LinkedList;

public class reorderList {
    public void reorderList(ListNode head) {
        ListNode listNode = middleNode(head);
        ListNode listNode1 = reverseList(listNode);
        ListNode cur = head;
        while (listNode1.next != null) {
            ListNode nxt = cur.next;
            ListNode nxt1 = listNode1.next;

            cur.next = listNode1;
            listNode1.next = nxt;

            cur = nxt;
            listNode1 = nxt1;
        }
    }

    ListNode reverseList(ListNode head) {
        ListNode prev = null;
        for (ListNode cur = head; cur != null; ) {
            ListNode nxt = cur.next;
            cur.next = prev;
            prev = cur;
            cur = nxt;
        }
        return prev;
    }

    public ListNode middleNode(ListNode head) {
        ListNode fast = head, slow = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }

    public static void main(String[] args) {
        reorderList reorderList = new reorderList();
        ListNode listNode = ListNode.createListNode(new int[]{1, 2, 3, 4, 5});
        reorderList.reorderList(listNode);
        ListNode.displayListNode(listNode);
    }
}
