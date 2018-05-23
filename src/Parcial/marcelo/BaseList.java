package Parcial.marcelo;

public class BaseList<T> {

    Node<T> first;

    public BaseList() {
        first = null;
    }

    public boolean insertAfter(T elem, T newElem) {
        for (Node<T> node = first.tail; node.tail != null; node = node.tail) {
            if (node.head.equals(elem)) {
                node.tail = new Node<>(newElem, node.tail);
                return true;
            }
        }
        return false;
    }

    public boolean insertBefore(T elem, T newElem) {
        for (Node<T> node = first.tail; node.tail != null; node = node.tail) {
            if (node.tail.head.equals(elem)) {
                Node<T> newNode = new Node<>(newElem, node.tail);
                node.tail = newNode;
                return true;
            }
        }
        return false;
    }

    public int count(Condition<T> c) {
        int counter = 0;
        return count(first, c, counter);
    }

    private int count(Node<T> node, Condition<T> c, int counter) {
        if (c.something(node.head)) return count(node.tail, c, counter + 1);
        if (node.tail == null) return counter;
        return count(node.tail, c, counter);
    }

    public void inject(Function<T> f) {
        inject(f, first);
    }

    private void inject(Function<T> f, Node<T> node) {
        node.head = f.something(node.head);
        if (node.tail == null) return;
        inject(f, node.tail);
    }

    private static class Node<T> {

        T head;
        Node<T> tail;

        public Node(T head, Node<T> tail) {
            this.head = head;
            this.tail = tail;
        }
    }
}

interface Function<T> {
    public T something(T t);
}

interface Condition<T> {
    public boolean something(T t);
}