package DataStruct.linklist;

/**
 * 双向链表的简单实现
 *
 * @param <E>
 */
public class linkList<E> implements list<E> {

    Node<E> first;
    Node<E> last;
    int size = 0;

    public linkList() {
    }

    /**
     * 头插法
     *
     * @param e
     */
    void linkFirst(E e) {
        Node<E> f = first;
        Node<E> newNode = new Node<>(e, null, f);
        first = newNode;
        if (f == null) {
            last = newNode;
        } else {
            f.prev = newNode;
        }
        size += 1;
    }

    void linkLast(E e) {
        Node<E> l = last;
        Node<E> newNode = new Node<>(e, last, null);
        last = newNode;
        if (l == null) {
            first = newNode;
        } else {
            l.nxt = newNode;
        }
        size += 1;
    }

    E unlink(Node<E> node) {
        E element = node.item;
        Node<E> prev = node.prev;
        Node<E> nxt = node.nxt;

        if (prev == null) {
            first = last;
        } else {
            prev.nxt = nxt;
            node.prev = null;
        }

        if (nxt == null) {
            last = first;
        } else {
            nxt.prev = prev;
            node.nxt = null;
        }

        size -= 1;
        return element;
    }

    @Override
    public boolean add(E e) {
        linkLast(e);
        return true;
    }

    @Override
    public boolean addFirst(E e) {
        linkFirst(e);
        return true;
    }

    @Override
    public boolean addLast(E e) {
        linkLast(e);
        return true;
    }

    @Override
    public boolean remove(Object o) {
        Node<E> curNode = first;
        while (curNode != null) {
            if (curNode.item.equals(o)) {
                break;
            }
            curNode = curNode.nxt;
        }
        if (curNode != null) {
            unlink(curNode);
        }
        return true;
    }

    @Override
    public E get(int index) {
        if (index < 0 || index >= size) {
            throw new RuntimeException("范围不合理");
        }
        Node cur = first;
        for (int i = 0; i < index; i++) {
            cur = cur.nxt;
        }
        return (E) cur.item;
    }

    @Override
    public void printLinkList() {
        Node cur = first;
        for (int i = 0; i < size; i++) {
            System.out.println(cur.item);
            cur = cur.nxt;
        }
    }


    // 节点
    private static class Node<E> {
        E item;
        Node<E> prev;
        Node<E> nxt;

        public Node(E item, Node<E> prev, Node<E> nxt) {
            this.item = item;
            this.prev = prev;
            this.nxt = nxt;
        }
    }

    public static void main(String[] args) {
        list<Integer> list = new linkList<>();
        list.add(1);
        list.add(2);
        Integer x = list.get(1);
        System.out.println(x);
        list.printLinkList();
    }
}
