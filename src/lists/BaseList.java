package lists;

public class BaseList<T> implements LinearList<T> {

    protected T head;
    protected BaseList<T> tail;

    public BaseList() {
        head = null;
        tail = null;
    }

    public BaseList(T head, BaseList<T> tail) {
        this.head = head;
        this.tail = tail;
    }

    @Override
    public BaseList<T> add(T elem) {
        if (elem == null) throw new NullPointerException("Can't add null element");
        return new BaseList<T>(elem, this);
    }

    @Override
    public BaseList<T> remove(T elem) {
        if (this.head == null) return this;
        if (this.head.equals(elem)) return this.tail;
        this.tail = this.tail.remove(elem);
        return this;
    }

    @Override
    public void goNext() {
        this.head =tail.head;
        this.tail = tail.tail;
    }

    @Override
    public void prev() {
    }

    @Override
    public void goTo(int n) {

    }

    @Override
    public boolean contains(T elem) {
        if (this.head == null) return false;
        if (this.head.equals(elem)) return true;
        return this.tail.contains(elem);
    }

    @Override
    public T getActual() {
        if (this.head == null) throw new NullPointerException("Lista vacia");
        return head;
    }

    @Override
    public int getActualPosition() {
        return 0;
    }

    @Override
    public int size() {
        return 0;
    }

    @Override
    public boolean isEmpty() {
        return this.head == null;
    }

    @Override
    public boolean endList() {
        return false;
    }

    @Override
    public BaseList<T> clone() {
        return null;
    }

    private static class Node<T> {
        T elem;
        Node<T> tail;

        private Node(T elem, Node<T> tail) {
            this.elem = elem;
            this.tail = tail;
        }
    }
}
