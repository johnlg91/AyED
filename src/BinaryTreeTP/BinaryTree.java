package BinaryTreeTP;

class BinaryTree<T> {
    private DoubleNode<T> root;

    BinaryTree() {
        root = null;
    }

    BinaryTree(T o) {
        root = new DoubleNode<T>(o);
    }

    BinaryTree(T o, BinaryTree<T> tleft, BinaryTree<T> tright) {
        root = new DoubleNode<>(o, tleft.root, tright.root);
    }

    private boolean contains(T elem) {
        if (isEmpty()) return false;
        if (root.elem.equals(elem) || getLeft().contains(elem) || getRight().contains(elem)) return true;
        return false;
    }
    boolean isEmpty() {
        return root == null;
    }

    T getElement() {
        return root.elem;
    }

    BinaryTree<T> getLeft() {
        BinaryTree<T> t = new BinaryTree<>();
        t.root = root.left;
        return t;
    }

    BinaryTree<T> getRight() {
        BinaryTree<T> t = new BinaryTree<>();
        t.root = root.right;
        return t;
    }
}

