package MorseTp;

import java.util.ArrayList;

public class TreeApi<T> {
    private int size(BinaryTree<T> a) {
        if (a.isEmpty()) return 0;
        else
            return 1 + size(a.getLeft()) + size(a.getRight());
    }

    private int completeNodes(BinaryTree<T> a) {
        if (a.isEmpty())
            return 0;
        if (a.getLeft().isEmpty())
            return completeNodes(a.getRight());
        if (a.getRight().isEmpty())
            return completeNodes(a.getLeft());
        return 1 + completeNodes(a.getRight()) + completeNodes(a.getLeft());

    }

    private int ocurrencias(BinaryTree<T> a, T o) {
        if (a.isEmpty())
            return 0;
        if (a.getRoot().equals(o))
            return 1 + ocurrencias(a.getLeft(), o) + ocurrencias(a.getRight(), o);
        else
            return ocurrencias(a.getLeft(), o) + ocurrencias(a.getRight(), o);
    }

    private void inorden(BinaryTree<T> a) {
        if (!a.isEmpty()) {
            inorden(a.getLeft());
            System.out.println(a.getRoot());
            inorden(a.getRight());
        }
    }

    private void inorden(BinaryTree<T> a, ArrayList<T> ar) {
        if (!a.isEmpty()) {
            inorden(a.getLeft(),ar);
            ar.add(a.getRoot());
            inorden(a.getRight(),ar);
        }
    }

}
