package BinaryTreeTP;

public class IntBinaryTreeApi extends BinaryTreeApi<Integer> {

    private int sum(BinaryTree<Integer> t) {
        if (t.isEmpty()) return 0;
        return t.getElement() + sum(t.getLeft()) + sum(t.getRight());
    }

    int sum3(BinaryTree<Integer> t) {
        if (t.isEmpty()) return 0;
        int n = t.getElement();
        return (n % 3 == 0 ? n : 0) + sum(t.getLeft()) + sum(t.getRight());
    }

    private boolean isStable(BinaryTree<Integer> t) {
        if (t.isEmpty()) return true;
        if (t.getLeft().isEmpty() && t.getRight().isEmpty()) return true;
        if (!t.getLeft().isEmpty()) {
            if (t.getLeft().getElement() > t.getElement() || !isStable(t.getLeft())) return false;
        }
        if (!t.getRight().isEmpty()) {
            return t.getRight().getElement() <= t.getElement() && isStable(t.getRight());
        }
        return true;
    }

}
