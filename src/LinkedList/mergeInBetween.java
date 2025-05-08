package LinkedList;

public class mergeInBetween {
    public ListNode mergeInBetween(ListNode list1, int a, int b, ListNode list2) {
        //指针1指向a的前一个走a-1步 指针2走b步
        ListNode slow = list1, fast = list1;
        for (int i = 1; i < a; i++) {
            slow = slow.next;
        }
        for (int i = 1; i <= b; i++) {
            fast = fast.next;
        }
        slow.next = list2;
        while(list2.next!=null) {
            list2 = list2.next;
        }
        list2.next = fast;
        return list1;
    }
    //输入：list1 = [10,1,13,6,9,5], a = 3, b = 4, list2 = [1000000,1000001,1000002]
    //输出：[10,1,13,1000000,1000001,1000002,5]
    //解释：我们删除 list1 中下标为 3 和 4 的两个节点，并将 list2 接在该位置。上图中蓝色的边和节点为答案链表。
}
