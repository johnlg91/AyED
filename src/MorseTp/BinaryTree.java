package MorseTp;

class BinaryTree<T> {
    private DoubleNode<T> root;

    BinaryTree() {
        root = null;
    }

    BinaryTree(T o) {
        root = new DoubleNode<T>(o);
    }

    BinaryTree(T o, BinaryTree<T> tleft, BinaryTree<T> tright) {
        root = new DoubleNode<T>(o, tleft.root, tright.root);
    }

    boolean contains(T elem) {
        if (isEmpty()) return false;
        if (root.elem.equals(elem) || getLeft().contains(elem) || getRight().contains(elem)) return true;
        return false;
    }

    boolean isEmpty() {
        return root == null;
    }

    T getRoot() {
        return root.elem;
    }

    BinaryTree<T> getLeft() {
        BinaryTree<T> t = new BinaryTree<T>();
        t.root = root.left;
        return t;
    }

    BinaryTree<T> getRight() {
        BinaryTree<T> t = new BinaryTree<T>();
        t.root = root.right;
        return t;
    }
}

