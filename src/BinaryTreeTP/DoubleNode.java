package BinaryTreeTP;

class DoubleNode <T> {
    T elem;

    DoubleNode<T> right, left;

    DoubleNode(T o) {
        elem = o;
    }

    DoubleNode(T o, DoubleNode<T> left, DoubleNode<T> right) {
        elem = o;
        this.right =right;
        this.left =left;
    }
}
