package LinkedList;

public class deleteDuplicates {
    public ListNode deleteDuplicates(ListNode head) {
        if (head==null) return head;
        ListNode cur = head;
        //ListNode cur= dummy;
        while(cur.next!=null){
            if (cur.next.val == cur.val) {
                cur.next = cur.next.next;
            } else {
                cur = cur.next;
            }
        }
        return head;
    }
}
