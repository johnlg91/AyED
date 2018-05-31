package SearchBinaryTreeTP;

import java.util.ArrayList;
import java.util.List;

public class SearchBinaryTree<T extends Comparable<T>> {

    private DoubleNode<T> root;

    SearchBinaryTree() {
        root = null;
    }

    List<T> vipList(T x) {
        ArrayList<T> list = new ArrayList<>();
        vipList(root, list, x);
        return list;
    }

    void printInOrder() {
        for (T e : listInOrder())
            System.out.print(e);
    }

    List<T> listInOrder() {
        ArrayList<T> list = new ArrayList<>();
        listInOrder(root, list);
        return list;
    }

    T search(T x) {
        return search(root, x).elem;
    }

    void insert(T x) {
        root = insert(root, x);
    }

    private boolean exists(T x) {
        return exists(root, x);
    }

    void delete(T x) {
        root = delete(root, x);
    }

    public T getMax() {
        if (root == null) throw new IllegalStateException("Empty Tree");
        return getMax(root).elem;
    }

    public T getMin() {
        if (root == null) throw new IllegalStateException("Empty Tree");
        return getMin(root).elem;
    }


    //Primitive Methods

    public boolean isEmpty() {
        return root == null;
    }

    public T getRoot() {
        if (root == null) throw new IllegalStateException("Empty Tree");
        return root.elem;
    }

    public SearchBinaryTree<T> left() {
        if (root == null) throw new IllegalStateException("Empty Tree");
        SearchBinaryTree s = new SearchBinaryTree();
        s.root = root.left;
        return s;
    }

    public SearchBinaryTree<T> right() {
        if (root == null) throw new IllegalStateException("Empty Tree");
        SearchBinaryTree s = new SearchBinaryTree();
        s.root = root.right;
        return s;
    }


    // Private Methods

    private DoubleNode<T> getMax(DoubleNode<T> t) {
        if (root == null) throw new IllegalStateException("Empty Tree");
        if (t.right == null) return t;
        return getMax(t.right);
    }

    private DoubleNode<T> getMin(DoubleNode<T> t) {
        if (root == null) throw new IllegalStateException("Empty Tree");
        if (t.left == null) return t;
        return getMin(t.left);
    }

    private boolean exists(DoubleNode<T> t, T x) {
        if (t == null) return false;
        if (x.compareTo(t.elem) == 0) return true;
        else if (x.compareTo(t.elem) < 0) return exists(t.left,x);
        else return exists(t.right, x);

    }

    private DoubleNode<T> insert(DoubleNode<T> t, T x) {
        if (t == null) t = new DoubleNode<>(x);
        else if (x.compareTo(t.elem) == 0) throw new IllegalStateException("Element already in tree");
        else if (x.compareTo(t.elem) < 0) {
            t.left = insert(t.left, x);
        } else t.right = insert(t.right, x);
        return t;
    }

    private DoubleNode<T> search(DoubleNode<T> t, T x) {
        if (root == null || t == null) throw new IllegalStateException("Empty Tree");
        if (!exists(x)) throw new IllegalStateException("Element not on Tree");
        if (x.compareTo(t.elem) == 0) return t;
        else if (x.compareTo(t.elem) > 0) return search(t.right, x);
        else return search(t.left, x);


    }

    private DoubleNode<T> delete(DoubleNode<T> t, T x) {
        if (!exists(x)) throw new IllegalStateException("Element not on Tree");
        if (x.compareTo(t.elem) < 0) t.left = delete(t.left, x);
        else if (x.compareTo(t.elem) > 0) t.right = delete(t.right, x);
        else {
            if (t.left != null && t.right != null) {
                t.elem = getMin(t.right).elem;
                t.right = getMinOfRight(t.right);
            } else if (t.left != null) return t.left;
            return t.right;
        }
        return t;
    }

    private DoubleNode<T> getMinOfRight(DoubleNode<T> t) {
        if (t.left != null) t.left = getMinOfRight(t.left);
        else return t.right;
        return t;
    }

    private void listInOrder(DoubleNode<T> t, List<T> list) {
        if (t != null) {
            listInOrder(t.left, list);
            list.add(t.elem);
            listInOrder(t.right, list);
        }
    }

    private void vipList(DoubleNode<T> t, List<T> list, T x) {
        if (t != null) {
            listInOrder(t.left, list);
            if (t.elem.equals(x)) list.add(t.elem);
            listInOrder(t.right, list);
        }
    }

}
