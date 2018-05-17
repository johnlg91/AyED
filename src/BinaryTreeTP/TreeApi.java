package BinaryTreeTP;

import java.io.*;
import java.util.ArrayList;

import static java.lang.Math.max;
import static java.lang.Math.pow;

public class TreeApi<T> {

    private int getSize(BinaryTree<T> a) {
        if (a.isEmpty()) return 0;
        else
            return 1 + getSize(a.getLeft()) + getSize(a.getRight());
    }

    int getWeight(BinaryTree<T> a) {
        return getSize(a);
    }


    int getLeaves(BinaryTree<T> a) {
        if (a.isEmpty()) return 0;
        if (a.getLeft().isEmpty() && a.getRight().isEmpty()) return 1;
        return getLeaves(a.getLeft()) + getLeaves(a.getRight());
    }

    int elementsAtLevel(BinaryTree<T> a, int level) {
        if (a.isEmpty()) return 0;
        if (level == 0) return 1;
        return elementsAtLevel(a.getLeft(), level - 1) + elementsAtLevel(a.getRight(), level - 1);
    }

    private int depth(BinaryTree<T> a) {
        if (a.isEmpty()) return 0;
        if (a.getRight().isEmpty() && a.getLeft().isEmpty()) return 0;
        return 1 + max(depth(a.getRight()), depth(a.getLeft()));
    }

    int completeNodes(BinaryTree<T> a) {
        if (a.isEmpty())
            return 0;
        if (a.getLeft().isEmpty())
            return completeNodes(a.getRight());
        if (a.getRight().isEmpty())
            return completeNodes(a.getLeft());
        return 1 + completeNodes(a.getRight()) + completeNodes(a.getLeft());

    }

    private int occurrences(BinaryTree<T> a, T o) {
        if (a.isEmpty()) return 0;
        int n = a.getElement().equals(o) ? 1 : 0;
        return n + occurrences(a.getLeft(), o) + occurrences(a.getRight(), o);
    }

    private void inOrder(BinaryTree<T> a) {
        if (!a.isEmpty()) {
            inOrder(a.getLeft());
            System.out.println(a.getElement());
            inOrder(a.getRight());
        }
    }

    void inOrder(BinaryTree<T> a, ArrayList<T> ar) {
        if (!a.isEmpty()) {
            inOrder(a.getLeft(), ar);
            ar.add(a.getElement());
            inOrder(a.getRight(), ar);
        }
    }

    void preOrder(BinaryTree<T> a, ArrayList<T> ar) {
        if (!a.isEmpty()) {
            ar.add(a.getElement());
            preOrder(a.getLeft(), ar);
            preOrder(a.getRight(), ar);
        }
    }

    private void preOrder(BinaryTree<T> a) {
        if (!a.isEmpty()) {
            System.out.println(a.getElement());
            preOrder(a.getLeft());
            preOrder(a.getRight());
        }
    }

    void postOrder(BinaryTree<T> a, ArrayList<T> ar) {
        if (!a.isEmpty()) {
            postOrder(a.getLeft(), ar);
            postOrder(a.getRight(), ar);
            ar.add(a.getElement());
        }
    }

    private void postOrder(BinaryTree<T> a) {
        if (!a.isEmpty()) {
            postOrder(a.getLeft());
            postOrder(a.getRight());
            System.out.println(a.getElement());
        }
    }

    boolean treeEquals(BinaryTree<T> t1, BinaryTree<T> t2) {
        if (t1.isEmpty() && t2.isEmpty()) return true;
        if (t1.isEmpty() || t2.isEmpty()) return false;
        if (!t1.getElement().equals(t2.getElement())) return false;
        return treeEquals(t1.getLeft(), t2.getLeft()) && treeEquals(t1.getRight(), t2.getRight());
    }

    boolean isIsomorph(BinaryTree<T> t1, BinaryTree<T> t2) {
        if (t1.isEmpty() && t2.isEmpty()) return true;
        if (t1.isEmpty() || t2.isEmpty()) return false;
        return isIsomorph(t1.getLeft(), t2.getLeft()) && isIsomorph(t1.getRight(), t2.getRight());
    }

    boolean exists(BinaryTree<T> t, T e) {
        if (t.isEmpty()) return false;
        if (t.getElement().equals(e)) return true;
        return exists(t.getRight(), e) || exists(t.getLeft(), e);
    }

    //si el arbol t1 existe en t2
    boolean allExist(BinaryTree<T> t1, BinaryTree<T> t2) {
        if (t1.isEmpty()) return true;
        if (!exists(t2, t1.getElement())) return false;
        return allExist(t1.getLeft(), t2) && allExist(t1.getRight(), t2);
    }

    boolean isSimilar(BinaryTree<T> t1, BinaryTree<T> t2) {
        return allExist(t1, t2) && allExist(t2, t1);
    }

    boolean isComplete(BinaryTree<T> t) {
        if (t.isEmpty() || t.getLeft().isEmpty() && t.getRight().isEmpty()) return true;
        if (t.getRight().isEmpty() || t.getRight().isEmpty()) return false;
        return isComplete(t.getLeft()) && isComplete(t.getRight());
    }

    boolean isFull(BinaryTree<T> t) {
        return getSize(t) + 1 == pow(2, depth(t) + 1);
    }

    boolean isIncluded(BinaryTree<T> t1, BinaryTree<T> t2) {
        if (treeEquals(t1,t2)) return true;
        return isIncluded(t1, t2.getLeft()) || isIncluded(t1, t2.getRight());
    }

    ArrayList<T> listBorder(BinaryTree<T> t) {
        ArrayList<T> list = new ArrayList<>();
        listBorder(t, list);
        return list;
    }

    private void listBorder(BinaryTree<T> a, ArrayList<T> list) {
        if (a.isEmpty()) return;
        if (a.getLeft().isEmpty() && a.getLeft().isEmpty()) {
            list.add(a.getElement());
            return;
        }
        listBorder(a.getLeft(), list);
        listBorder(a.getRight(), list);
    }

    public void printBorder(BinaryTree<T> t) {
        for (T e : listBorder(t)) {
            System.out.println(e);
        }
    }

    public void write(BinaryTree<T> t, String fName) throws IOException {
        try (
                FileOutputStream f = new FileOutputStream(fName);
                ObjectOutputStream o = new ObjectOutputStream(f)
        ) {
            o.writeObject(t);
        }
    }

    public BinaryTree<T> read(String fName) throws IOException, ClassNotFoundException {
        try (FileInputStream f = new FileInputStream(fName);
        ObjectInputStream o = new ObjectInputStream(f)) {
            return (BinaryTree<T>) o.readObject();
        }
    }

}
