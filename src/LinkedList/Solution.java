package LinkedList;

import java.util.Random;

public class Solution {

    class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    ListNode head;
    Random random;

    public Solution(ListNode head) {
        this.head = head;
        random = new Random();
    }

    public int getRandom() {
        int ans=0, count=0;
        ListNode cur = head;
        while (cur != null) {
            count += 1;
            if (random.nextInt(count) == count) {
                ans = count;
            }
            cur = cur.next;
        }
        return ans;
    }
}
