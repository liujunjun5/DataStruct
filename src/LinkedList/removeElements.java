package LinkedList;

public class removeElements {
    public ListNode removeElements(ListNode head, int val) {
        ListNode dummy = new ListNode(head);
        ListNode cur = dummy;
        while (cur!= null && cur.next != null) {
            if (cur.next.val == val) {
                cur.next = cur.next.next;
            }
            cur = cur.next;
        }
        return dummy.next;
    }

    public static void main(String[] args) {
        System.out.println(new removeElements().removeElements(ListNode.createListNode(new int[]{1, 2, 6, 3, 4, 5, 6}), 6));
    }
    //输入：head = [1,2,6,3,4,5,6], val = 6
    //输出：[1,2,3,4,5]
    //示例 2：
    //
    //输入：head = [], val = 1
    //输出：[]
    //示例 3：
    //
    //输入：head = [7,7,7,7], val = 7
    //输出：[]
}
