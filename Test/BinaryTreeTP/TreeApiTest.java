package BinaryTreeTP;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class TreeApiTest {
    BinaryTreeApi<String> api = new BinaryTreeApi<>();

    BinaryTree<String> empty = new BinaryTree<>();

    BinaryTree<String> a1 = new BinaryTree<>("A");

    BinaryTree<String> a = new BinaryTree<>("A");
    BinaryTree<String> c = new BinaryTree<>("C");
    BinaryTree<String> e = new BinaryTree<>("E");
    BinaryTree<String> h = new BinaryTree<>("H");

    BinaryTree<String> cDe = new BinaryTree<>("D", c, e);
    BinaryTree<String> aBd = new BinaryTree<>("B", a, cDe);
    BinaryTree<String> hHem = new BinaryTree<>("I", h, empty);
    BinaryTree<String> emGi = new BinaryTree<>("G", empty, hHem);
    BinaryTree<String> bFg = new BinaryTree<>("F", aBd, emGi);


    @Test
    public void inOrden() {
        ArrayList<String> list1 = new ArrayList<>();
        api.inOrder(a, list1);
        assertEquals(list1, List.of("A"));

        ArrayList<String> list2 = new ArrayList<>();
        api.inOrder(aBd, list2);
        assertEquals(list2, List.of("A", "B", "C", "D", "E"));
    }

    @Test
    public void preOrder() {
        ArrayList<String> list1 = new ArrayList<>();
        api.preOrder(a, list1);
        assertEquals(list1, List.of("A"));

        ArrayList<String> list2 = new ArrayList<>();
        api.preOrder(aBd, list2);
        assertEquals(list2, List.of("B", "A", "D", "C", "E"));
    }

    @Test
    public void postOrder() {
        ArrayList<String> list1 = new ArrayList<>();
        api.postOrder(a, list1);
        assertEquals(list1, List.of("A"));

        ArrayList<String> list2 = new ArrayList<>();
        api.postOrder(aBd, list2);
        assertEquals(list2, List.of("A", "C", "E", "D", "B"));
    }

    @Test
    public void treeEquals() {
        Assert.assertFalse(api.treeEquals(a, aBd));
        Assert.assertTrue(api.treeEquals(a, a1));
    }

    @Test
    public void isIsomorph() {
        Assert.assertFalse(api.isIsomorph(aBd, emGi));
        Assert.assertTrue(api.isIsomorph(bFg, bFg));
    }

    @Test
    public void exists() {
        Assert.assertFalse(api.exists(bFg, "V"));
        Assert.assertTrue(api.exists(bFg, "A"));
    }

    @Test
    public void allExist() {
        Assert.assertFalse(api.allExist(aBd, emGi));
        Assert.assertTrue(api.allExist(aBd, bFg));
    }

    @Test
    public void isSimilar() {
        Assert.assertFalse(api.isSimilar(aBd, emGi));
        Assert.assertTrue(api.isSimilar(bFg, bFg));
    }

    @Test
    public void isComplete() {
        Assert.assertFalse(api.isComplete(bFg));
        Assert.assertTrue(api.isComplete(aBd));
    }

    @Test
    public void isFull() {
        Assert.assertFalse(api.isFull(bFg));
        Assert.assertTrue(api.isFull(cDe));
    }

    @Test
    public void isIncluded() {
        Assert.assertFalse(api.isIncluded(cDe, aBd));
        Assert.assertTrue(api.isIncluded(bFg, bFg));
    }

    @Test
    public void elementsAtLevel() {
        assertEquals(api.elementsAtLevel(bFg, 2), 3);
    }

    @Test
    public void completeNodes() {
        assertEquals(api.completeNodes(bFg), 3);
    }

    @Test
    public void getWeight() {
        assertEquals(api.getWeight(bFg), 9);
    }

    @Test
    public void getLeaves() {
        Assert.assertEquals(api.getLeaves(bFg), 4);
    }

    @Test
    public void listBorder() {
        ArrayList<String> list1 = api.listBorder(a);
        assertEquals(list1, List.of("A"));

        ArrayList<String> list2 = api.listBorder(bFg);
        assertEquals(list2, List.of("A", "C", "E", "G"));
    }
}
