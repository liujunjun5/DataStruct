package LinkedList;

public class getDecimalValue {
    public int getDecimalValue(ListNode head) {
        int ans = 0;
        while(head!=null) {
            ans = ans * 2 + head.val;
            head = head.next;
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(new getDecimalValue().getDecimalValue(ListNode.createListNode(new int[]{1,0,0,1,0,0,1,1,1,0,0,0,0,0,0})));
    }
}
