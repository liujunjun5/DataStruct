package Shujujiegou;

public class linkList<E> {

    Node<E> first;
    Node<E> last;
    int size = 0;

    

    // 节点
    class Node<E> {
        E item;
        Node<E> prev;
        Node<E> nxt;

        public Node(E item, Node<E> prev, Node<E> nxt) {
            this.item = item;
            this.prev = prev;
            this.nxt = nxt;
        }
    }

    // 头插
    public void addFront(E e) {
        // 找到第一个节点

    }
}
