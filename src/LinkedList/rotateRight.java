package LinkedList;

public class rotateRight {
    public ListNode rotateRight(ListNode head, int k) {
        // 算总长度 需要取模
        int n = 1;
        ListNode cur = head;
        for (; cur.next != null; cur = cur.next) n += 1;
        cur.next = head;
        for (int i = 0; i < n - k % n - 1; i++) head = head.next;
        ListNode ans = head.next;
        head.next = null;
        return ans;
    }

    public static void main(String[] args) {
        rotateRight rotateRight = new rotateRight();
        ListNode listNode = rotateRight.rotateRight(ListNode.createListNode(new int[]{1, 2, 3, 4, 5}), 2);
        ListNode.displayListNode(listNode);
    }
}
