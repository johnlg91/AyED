package lists;

import java.util.Iterator;

public interface SortedLinearLinkedList<T extends Comparable<? super T>> {

    void add(T t);

    void remove(T elem);

    boolean isEmpty();

    boolean contains(T elem);

    public Iterator<T> iterator();

    public Object[] toArray();

    T getHead();

    SortedLinearLinkedList<T> getTail();

    int size();
}
