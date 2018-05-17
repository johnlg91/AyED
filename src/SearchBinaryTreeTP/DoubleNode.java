package SearchBinaryTreeTP;

public class DoubleNode<T> {
    T elem;

    DoubleNode<T> right, left;

    DoubleNode(T o) {
        elem = o;
    }

    public DoubleNode(T o, DoubleNode<T> left, DoubleNode<T> right) {
        elem = o;
        this.right = right;
        this.left = left;
    }
}
