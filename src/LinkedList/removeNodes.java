package LinkedList;

public class removeNodes {
    public ListNode removeNodes(ListNode head) {
        ListNode cur = head;
        while (cur.next !=null) {
            if (cur.next.val>cur.val){
                cur.next = cur.next.next;
            } else {
                cur = cur.next;
            }
        }
        return head;
    }
}
