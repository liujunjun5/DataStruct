package LinkedList;

public class middleNode {
    public ListNode middleNode(ListNode head) {
        ListNode fast = head, slow = head;
        while (fast != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }
}
