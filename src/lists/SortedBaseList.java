package lists;

import java.util.Comparator;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class SortedBaseList<T extends Comparable<? super T>> implements SortedLinearLinkedList<T> {

    private Node<T> first;
    private Node<T> last;
    private Node<T> prev;
    private Comparator<T> comparator;
    private int size;

    public SortedBaseList(Comparator<T> comparator) {
        size = 0;
        first = null;
        last = null;
        this.comparator = comparator;
    }

    @Override
    public void add(T t) {

    }

    @Override
    public void remove(T elem) {
    }

    @Override
    public boolean isEmpty() {
        return first == null;
    }

    @Override
    @SuppressWarnings("unchecked")
    public boolean contains(T elem) {
        return elem != null && comparator.compare(elem, last.t) <= 0 && contains(elem, first);
    }

    private boolean contains(T elem, Node<T> current) {
        return current != null && (current.t == elem || contains(elem, current.next));
    }

    @Override
    public Iterator<T> iterator() {
        return new Iterator<>() {
            Node<T> current = first;

            @Override
            public boolean hasNext() {
                return current != null;
            }

            @Override
            public T next() {
                if (current == null) throw new NoSuchElementException();
                current = current.next;
                return current.t;
            }
        };
    }

    @Override
    public Object[] toArray() {
        Node<T> current = first;
        Object[] result = new Object[size];
        for (int i = 0; i < size; i++) {
            result[i] = current.t;
            current = current.next;
        }
        return result;
    }

    @Override
    public T getHead() {
        return null;
    }

    @Override
    public SortedLinearLinkedList<T> getTail() {
        return null;
    }

    @Override
    public int size() {
        return size;
    }

    private static class Node<T> {
        T t;
        Node<T> next;

        public Node(T elem, Node<T> next) {
            t = elem;
            this.next = next;
        }
    }
}
