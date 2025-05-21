package LinkedList;

import java.util.HashMap;
import java.util.Map;

class LRUCache {
    private static class Node {
        private int key;
        private int value;
        private Node next;
        private Node prev;

        public Node(int key, int value, Node next, Node prev) {
            this.key = key;
            this.value = value;
            this.next = next;
            this.prev = prev;
        }

        public Node() {
        }

        public Node(int key, int value) {
            this.key = key;
            this.value = value;
        }

        public int getKey() {
            return key;
        }

        public int getValue() {
            return value;
        }

        public Node getNext() {
            return next;
        }

        public Node getPrev() {
            return prev;
        }

        public void setValue(int value) {
            this.value = value;
        }
    }

    int cap;
    Node dummy;
    Map<Integer, Node> keyToNode;

    public LRUCache(int capacity) {
        dummy = new Node();
        dummy.next = dummy;
        dummy.prev = dummy;
        this.cap = capacity;
        keyToNode = new HashMap<>();
    }

    public int get(int key) {
        Node node = getNode(key);
        if (node == null) {
            return -1;
        }
        return node.getValue();
    }

    public void put(int key, int value) {
        Node node = getNode(key);
        if (node!=null) {
            node.setValue(value);
            return;
        }
        Node newNode = new Node(key, value);
        this.keyToNode.put(key, newNode);
        putFront(newNode);
        if (this.keyToNode.size() > cap) {
            Node old = this.dummy.prev;
            remove(old);
            this.keyToNode.remove(old.getKey());
        }
    }

    private Node getNode(int key)  {
        Node node = this.keyToNode.get(key);
        if (node == null) {
            return null;
        }
        remove(node);
        putFront(node);
        return node;
    }

    private void putFront(Node node) {
        node.next = this.dummy.next;
        node.prev = this.dummy;
        this.dummy.next.prev=node;
        this.dummy.next = node;
    }

    private void remove(Node node) {
        node.next.prev = node.prev;
        node.prev.next = node.next;
    }
}