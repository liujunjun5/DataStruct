package LinkedList;

public class swapNodes {
    public ListNode swapNodes(ListNode head, int k) {
        ListNode fast = head, slow = head;
        for (int i = 1; i < k; i++) {
            fast = fast.next;
        }
        ListNode left = fast;
        while (fast.next != null) {
            fast = fast.next;
            slow = slow.next;
        }
        int tmp = slow.val;
        slow.val = left.val;
        left.val = tmp;
        return head;
    }
}
