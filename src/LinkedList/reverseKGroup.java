package LinkedList;

public class reverseKGroup {
    public ListNode reverseKGroup(ListNode head, int k) {
        // 先统计一个多少个节点
        // 每k个一次分组 翻转 中间的处理步骤需要留意
        ListNode cur = head;
        int n = 0;
        while (cur != null) {
            cur = cur.next;
            n += 1;
        }
        ListNode dummy = new ListNode(-1, head);
        ListNode p0 = dummy;
        while (n >= k) {
            n -= k;
            ListNode pre = null;
            cur = p0.next;
            for (int i = 0; i < k; i++) {
                ListNode nxt = cur.next;
                cur.next = pre;
                pre = cur;
                cur = nxt;
            }
            ListNode tail = p0.next;
            tail.next = cur;
            p0.next = pre;
            p0 = tail;
        }
        return dummy.next;
    }

    public static void main(String[] args) {
        ListNode head = new reverseKGroup().reverseKGroup(ListNode.createListNode(new int[]{1, 2, 3, 4, 5}), 2);
        ListNode.displayListNode(head);
    }
}
