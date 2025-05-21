package LinkedList;

import java.util.HashMap;
import java.util.Map;

public class copyRandomList {
    class Node {
        int val;
        Node next;
        Node random;

        public Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }
    }

        public Node copyRandomList(Node head) {
            Map<Node, Node> map = new HashMap<>();
            for (Node cur = head; cur != null; cur = cur.next) {
                map.put(cur, new Node(cur.val));
            }
            for (Node cur = head; cur != null; cur = cur.next) {
                if (cur.next != null) map.get(cur).next = map.get(cur.next);
                if (cur.random != null) map.get(cur).random = map.get(cur.random);
            }
            return map.get(head);
        }
}
