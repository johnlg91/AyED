package redBlackTreeTP;

import java.util.ArrayList;
import java.util.List;

public class RedBlackTree<T extends Comparable<T>> {


    private DoubleNode<T> root;

    RedBlackTree() {
        root = null;
    }

    //Primitive Methods

    public boolean isEmpty() {
        return root == null;
    }

    public RedBlackTree<T> left() {
        emptyTreeException();
        RedBlackTree<T> rb = new RedBlackTree<>();
        rb.root = root.left;
        return rb;
    }

    public RedBlackTree<T> right() {
        emptyTreeException();
        RedBlackTree<T> rb = new RedBlackTree<>();
        rb.root = root.right;
        return rb;
    }

    //Rotations

    private void rightRightRotation() {
        DoubleNode<T> r = root;
        root = root.right;
        r.right = root.left;
        root.left = r;
    }

    private void leftLeftRotation() {
        DoubleNode<T> r = root;
        root = root.left;
        r.left = root.right;
        root.right = r;
    }

    private void leftRightRotation() {
        DoubleNode<T> r = root.left;
        DoubleNode<T> pivot = r.right;
        r.right = pivot.left;
        pivot.left = r;
        root.left = pivot;
        leftLeftRotation();
    }

    private void rightLeftRotation() {
        DoubleNode<T> r = root.right;
        DoubleNode<T> pivot = r.left;
        r.left = pivot.right;
        pivot.right = r;
        root.right = pivot;
        rightRightRotation();
    }


    //Public Methods

    public void printInOrder() {
        for (T e : listInOrder())
            System.out.print(e);
    }

    public List<T> listInOrder() {
        ArrayList<T> list = new ArrayList<>();
        listInOrder(root, list);
        return list;
    }

    public boolean exists(T x) {
        return exists(root, x);
    }

    //Private Methods

    private DoubleNode<T> insert(DoubleNode<T> t, T x){
        if (t == null) {
            t = new DoubleNode<>(x);
            t.color = true;
        }


    }

    private boolean exists(DoubleNode<T> t, T x) {
        if (t == null) return false;
        if (x.compareTo(t.element) == 0) return true;
        else if (x.compareTo(t.element) < 0) return exists(t.left, x);
        else return exists(t.right, x);
    }

    private void listInOrder(DoubleNode<T> t, List<T> list) {
        if (t != null) {
            listInOrder(t.left, list);
            list.add(t.element);
            listInOrder(t.right, list);
        }
    }

    private void emptyTreeException() {
        if (root == null) throw new IllegalStateException("Empty Tree");
    }

    private void elementNotOnTreeException(T x) {
        if (!exists(x)) throw new IllegalStateException("Element not on Tree");
    }


    /**
     * Node Class
     *
     * @param <T>
     */
    public static class DoubleNode<T> {

        T element;
        boolean color;//false = rojo true = black
        DoubleNode<T> left;
        DoubleNode<T> right;

        public DoubleNode(T element) {
            this.element = element;
            color = false;
        }

        public DoubleNode(T element, DoubleNode<T> left, DoubleNode<T> right) {
            this.element = element;
            color = false;
            this.left = left;
            this.right = right;
        }
    }
}
