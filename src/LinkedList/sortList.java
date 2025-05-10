package LinkedList;

import DataStruct.arrayList.List;

public class sortList {
    public ListNode sortList(ListNode head) {
        //归并算法 先归在并
        if (head == null || head.next == null) return head;
        ListNode mid = middleNode(head);
        ListNode right = mid.next, left = head;
        mid.next = null;
        left=sortList(left);
        right=sortList(right);

        ListNode dummy = new ListNode(-1), tmp = dummy;
        while(left != null && right != null) {
            if (left.val < right.val) {
                tmp.next = left;
                left = left.next;
            } else {
                tmp.next= right;
                right = right.next;
            }
            tmp = tmp.next;
        }
        tmp.next = left == null ? right : left;
        return dummy.next;
    }

    public ListNode middleNode(ListNode head) {
        ListNode fast = head, slow = head;
        while (fast.next != null && fast.next.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }

    public static void main(String[] args) {
        ListNode head = new sortList().sortList(ListNode.createListNode(new int[]{4, 2, 1, 3}));
        ListNode.displayListNode(head);
    }
}
