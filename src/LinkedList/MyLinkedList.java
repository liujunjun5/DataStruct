package LinkedList;

public class MyLinkedList {
    private Node dummy = null;
    private int size;

    class Node {
        private int val;
        private Node nxt;
        private Node prev;

        public Node(int val, Node nxt, Node prev) {
            this.val = val;
            this.nxt = nxt;
            this.prev = prev;
        }

        public Node(int val) {
            this.val = val;
        }

        public Node() {
        }

        public int getVal() {
            return val;
        }

        public Node getNxt() {
            return nxt;
        }
    }

    public MyLinkedList() {
        dummy = new Node(-1);
        dummy.nxt = dummy;
        dummy.prev = dummy;
    }

    public int get(int index) {
        if (index < 0 || index >= size) return -1;
        Node cur = dummy.nxt;
        for (int i = 0; i < index; i++) {
            cur = cur.nxt;
        }
        return cur.val;
    }

    public void addAtHead(int val) {
        Node newNode = new Node(val);
        newNode.nxt = dummy.nxt;
        newNode.prev = dummy;
        dummy.nxt.prev = newNode;
        dummy.nxt = newNode;
        size += 1;
    }

    public void addAtTail(int val) {
        Node newNode = new Node(val, dummy, dummy.prev);
        dummy.prev.nxt = newNode;
        dummy.prev = newNode;
        size += 1;
    }

    public void addAtIndex(int index, int val) {
        if (index < 0 || index > size) return;
        Node node = new Node(val);
        Node cur = dummy;
        for (int i = 0; i < index; i++) {
            cur = cur.nxt;
        }
        node.nxt = cur.nxt;
        node.prev = cur;
        cur.nxt.prev = node;
        cur.nxt = node;
        size += 1;
    }

    public void deleteAtIndex(int index) {
        if (index < 0 || index >= size) return;
        Node cur = dummy;
        for (int i = 0; i < index; i++) {
            cur = cur.nxt;
        }
//        cur.nxt.prev=null;
//        cur.nxt.nxt=null;
        size -= 1;
        cur.nxt = cur.nxt.nxt;
        if (index == size + 1) return;
        cur.nxt.prev = cur;

    }

    private boolean isRange(int index) {
        return index >= 0 && index <= size;
    }

    public static void main(String[] args) {
        MyLinkedList list = new MyLinkedList();
        list.addAtHead(1);
        list.addAtTail(3);
        list.addAtIndex(1, 2);
        list.get(1);
        list.deleteAtIndex(1);
        list.get(1);
    }
}
