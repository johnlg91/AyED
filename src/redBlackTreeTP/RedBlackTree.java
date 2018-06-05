package redBlackTreeTP;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class RedBlackTree<T> {

    private static final boolean BLACK = false;
    private static final boolean RED = true;

    private DoubleNode<T> root;

    RedBlackTree() {
        root = null;
    }

    /*********************************************************************************
     * Primitive Methods
     *********************************************************************************/

    public boolean isEmpty() {
        return root == null;
    }

    // Number of Nodes in subtree; returns 0 if x == null
    private int size(DoubleNode<T> x) {
        if (x == null) return 0;
        return x.size;
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

    private boolean isRed(DoubleNode<T> x) {
        if (x == null) return false;
        return x.color == RED;
    }


    /*******************************************************************************
     * Rotation and Balancing
     *******************************************************************************/

    // Make a left-leaning link lean to the right
    private DoubleNode<T> rightRotation(DoubleNode<T> r) {
        DoubleNode<T> pivot = root.left;
        r.left = pivot.right;
        pivot.right = r;
        pivot.color = pivot.right.color;
        pivot.right.color = RED;
        pivot.size = r.size;
        r.size = size(r.left) + size(r.right) + 1;
        return pivot;
    }

    // Make a right-leaning link lean to the left
    private DoubleNode<T> leftRotation(DoubleNode<T> r) {
        DoubleNode<T> pivot = root.right;
        r.right = pivot.left;
        pivot.left = r;
        pivot.color = pivot.left.color;
        pivot.left.color = RED;
        pivot.size = r.size;
        r.size = size(r.right) + size(r.left) + 1;
        return pivot;
    }

    /**
     * flips the color of a Node and its two children
     *
     * @param t
     */
    private void flipColors(DoubleNode<T> t) {
        t.color = !t.color;
        t.left.color = !t.left.color;
        t.right.color = !t.right.color;
    }

    /**
     * Assuming that t is red and both t.left and t.left.left
     * are black, make t.left or one of its children red.
     *
     * @param t
     * @return
     */
    private DoubleNode<T> moveRedLeft(DoubleNode<T> t) {
        flipColors(t);
        if (isRed((t.right.left))) {
            t.right = rightRotation(t.right);
            t = leftRotation(t);
            flipColors(t);
        }
        return t;
    }

    /**
     * Assuming that t is red and both t.right and t.right.left
     * are black, make t.right or one of its children red.
     *
     * @param t
     * @return
     */
    private DoubleNode<T> moveRedRight(DoubleNode<T> t) {
        flipColors(t);
        if (isRed((t.left.left))) {
            t.left = rightRotation(t.left);
            t = rightRotation(t);
            flipColors(t);
        }
        return t;
    }


    private DoubleNode<T> balance(DoubleNode<T> t) {
        if (isRed(t.right)) t = leftRotation(t);
        if (isRed(t.left) && isRed(t.left.left)) t = rightRotation(t);
        if (isRed(t.left) && isRed(t.right)) flipColors(t);

        t.size = size(t.left) + size(t.right) + 1;
        return t;
    }

    /********************************************************************************
     * Public Methods
     *******************************************************************************/

    // Search----------------------------------
    public T getElement(String key) {
        nullKeyException(key);
        return getElement(root, key);
    }

    public boolean contains(String key) {
        return getElement(key) != null;
    }

    // Insertion--------------------------------
    public void insert(String key, T x) {
        nullKeyException(key);
        nullElementException(x);
        root = insert(root, key, x);
        root.color = BLACK;
    }

    // Delete-----------------------------------
    public void delete(String key) {
        nullKeyException(key);
        if (!contains(key)) return;
        //if both children are black, set root to red
        if (!isRed(root.left) && !isRed(root.right)) root.color = RED;
        root = delete(root, key);
        if (!isEmpty()) root.color = BLACK;
    }

    public void printInOrder() {
        for (T e : listInOrder())
            System.out.print(e);
    }

    public List<T> listInOrder() {
        ArrayList<T> list = new ArrayList<>();
        listInOrder(root, list);
        return list;
    }

    public int count() {
        return count(root);
    }

    // Count with condition
    public int count(Predicate<DoubleNode<T>> predicate) {
        return count(root, predicate);
    }

    /********************************************************************************
     * Private Methods
     *******************************************************************************/

    /**
     * Insertion
     *
     * @param t
     * @param x
     * @return
     */
    private DoubleNode<T> insert(DoubleNode<T> t, String key, T x) {
        if (t == null) t = new DoubleNode<>(key, x);
        int cmp = key.compareTo(t.key);
        if (cmp == 0) throw new IllegalStateException("Element already in tree");
        else if (cmp < 0) t.left = insert(t.left, key, x);
        else t.right = insert(t.right, key, x);
        // Balancing
        if (isRed(t.right) && !isRed(t.left)) t = leftRotation(t);
        if (isRed(t.left) && isRed(t.left.left)) t = rightRotation(t);
        t.size = size(t.left) + size(t.right) + 1;
        return t;
    }

    /**
     * Searches an element using a key
     *
     * @param t
     * @param key
     * @return element
     */
    private T getElement(DoubleNode<T> t, String key) {
        int cmp = key.compareTo(t.key);
        if (cmp < 0) return getElement(t.left, key);
        else if (cmp > 0) return getElement(t.right, key);
        else return t.element;
    }

    /**
     * Delete the key-value pair with the given key rooted at t
     *
     * @param t
     * @param key
     * @return a new Node to becomome the root
     */
    private DoubleNode<T> delete(DoubleNode<T> t, String key) {
        if (key.compareTo(t.key) < 0) {
            if (!isRed(t.left) && !isRed(t.left.left)) t = moveRedLeft(t);
            t.left = delete(t.left, key);
        } else {
            if (isRed(t.left)) t = rightRotation(t);
            if (key.compareTo(t.key) == 0 && t.right == null) return null;
            if (!isRed(t.right) && !isRed(t.right.left)) t = moveRedRight(t);
            if (key.compareTo(t.key) == 0) {
                DoubleNode<T> x = min(t.right);
                t.key = x.key;
                t.element = x.element;
                t.right = deleteMin(t.right);
            } else t.right = delete(t.right, key);
        }
        return balance(t);
    }

    private DoubleNode<T> deleteMin(DoubleNode<T> t) {
        if (t.left == null) return null;
        if (!isRed(t.left) && !isRed(t.left.left)) t = moveRedLeft(t);
        t.left = deleteMin(t.left);
        return balance(t);
    }

    private DoubleNode<T> min(DoubleNode<T> x) {
        if (x.left == null) return x;
        else return min(x.left);
    }

    private void listInOrder(DoubleNode<T> t, List<T> list) {
        if (t != null) {
            listInOrder(t.left, list);
            list.add(t.element);
            listInOrder(t.right, list);
        }
    }

    private static <T> int count(DoubleNode<T> node) {
        if (node == null) return 0;
        final int countLeft = count(node.left);
        final int countRight = count(node.right);
        return 1 + countLeft + countRight;
    }

    private static <T> int count(DoubleNode<T> node, Predicate<DoubleNode<T>> predicate) {
        if (node == null) return 0;
        final int countMe = predicate.test(node) ? 1 : 0;
        final int countLeft = count(node.left, predicate);
        final int countRight = count(node.right, predicate);
        return countMe + countLeft + countRight;
    }


    /********************************************************************************
     * Exceptions
     *******************************************************************************/

    private void emptyTreeException() {
        if (root == null) throw new IllegalStateException("Empty Tree");
    }

    private void nullElementException(T x) {
        if (x == null) throw new IllegalArgumentException("Null element");
    }

    private void elementNotOnTreeException(String key) {
        if (!contains(key)) throw new IllegalStateException("Element not on Tree");
    }

    private void nullKeyException(String key) {
        if (key == null) throw new IllegalArgumentException("Null key");
    }

    /********************************************************************************
     * Node Class
     * @param <T>
     */
    public static class DoubleNode<T> {


        private T element;
        private boolean color;//false = rojo true = black
        private String key;
        private int size;
        private DoubleNode<T> left;
        private DoubleNode<T> right;

        public DoubleNode(String key, T element) {
            this.element = element;
            this.key = key;
            size = 1;
            color = RED;
        }
    }
}
