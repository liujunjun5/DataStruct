package stack.basic;

import DataStruct.arrayList.List;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

public class nextLargerNodes {
    public int[] nextLargerNodes(ListNode head) {
        int n = 0;
        for (ListNode cur = head; cur != null; cur = cur.next){
            n += 1;
        }
        int[] ans = new int[n];
        int i = 0;
        Deque<int[]> stack = new ArrayDeque<>();
        for (ListNode cur = head; cur != null; cur = cur.next) {
            int x = cur.val;
            while (!stack.isEmpty() && stack.peek()[1] < x) {
                ans[stack.pop()[0]] = x;
            }
            stack.push(new int[]{i++, x});
        }
        return ans;
    }

    public static void main(String[] args) {
        ListNode head = creatHead(new int[]{2,7,4,3,5});
        System.out.println(Arrays.toString(new nextLargerNodes().nextLargerNodes(head)));
    }

    private static ListNode creatHead(int[] ints) {
        ListNode dummy = new ListNode();
        ListNode cur = dummy;
        for (int i = 0; i < ints.length; i++) {
            cur.next = new ListNode(ints[i]);
            cur = cur.next;
        }
        return dummy.next;
    }
}

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