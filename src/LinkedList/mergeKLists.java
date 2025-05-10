package LinkedList;

import java.util.PriorityQueue;

public class mergeKLists {
    public ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<ListNode> queue = new PriorityQueue<>((a, b) -> a.val - b.val);
        for (ListNode node : lists) if (node != null) queue.add(node);
        ListNode dummy = new ListNode(-1), cur = dummy;
        while (!queue.isEmpty()) {
            ListNode node = queue.poll();
            if (node.next != null) queue.add(node.next);
            cur.next = node;
            cur = cur.next;
        }
        return dummy.next;
    }
}
