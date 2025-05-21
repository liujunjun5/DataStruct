package LinkedList;

import java.util.HashMap;
import java.util.Map;

public class removeZeroSumSublists {
    public ListNode removeZeroSumSublists(ListNode head) {
        int preSum = 0;
        Map<Integer, ListNode> map = new HashMap<>();
        ListNode dummy = new ListNode(0, head);
        for (ListNode cur = dummy; cur != null; cur = cur.next){
            preSum += cur.val;
            map.put(preSum, cur);
        }
        preSum=0;
        for(ListNode cur=dummy;cur!=null;cur=cur.next) {
            preSum+=cur.val;
            cur.next=map.get(preSum).next;
        }
        return dummy.next;
    }
}
