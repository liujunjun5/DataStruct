package LinkedList;

public class isPalindrome {
    public boolean isPalindrome(ListNode head) {
        reverseList reverseList = new reverseList();
        middleNode middleNode = new middleNode();
        ListNode l2 = reverseList.reverseList(middleNode.middleNode(head));
        while (l2 != null && l2.next != null) {
            if (l2.val != head.val) return false;
            l2 = l2.next;
            head = head.next;
        }
        return true;
    }
}
