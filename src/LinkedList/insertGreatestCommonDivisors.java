package LinkedList;

public class insertGreatestCommonDivisors {
    public ListNode insertGreatestCommonDivisors(ListNode head) {
        ListNode cur = head;
        while (cur.next != null) {
            cur.next = new ListNode(gbc(cur.val, cur.next.val), cur.next);
            cur = cur.next.next;
        }
        return head;
    }

    private int gbc(int a, int b) {
        while(a!=0){
            int tmp = a;
            a = b % a;
            b = tmp;
        }
        return b;
    }
}
