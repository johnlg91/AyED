package lists;

public interface LinearList<T> {

    LinearList<T> add(T elem);

    LinearList<T> remove(T elem);

    void goNext();

    void prev();

    void goTo(int n);

    boolean contains(T elem);

    T getActual();

    int getActualPosition();

    int size();

    boolean isEmpty();

    boolean endList();

    LinearList<T> clone();

}
