package Parcial.alicia;

public class BankApi<T> {

    private SearchBinaryTree<Account> A;
    private SearchBinaryTree<Account> B;

    private BankApi() {
        this.A = new SearchBinaryTree<>();
        this.B = new SearchBinaryTree<>();
    }

    private void insertToAB(SearchBinaryTree<Account> tree) {
        if (!tree.isEmpty()) {
            Account e = tree.getElement();
            if (e.getSucursal() == 'A') A.insert(e);
            else if (e.getSucursal() == 'B') B.insert(e);
            insertToAB(tree.left());
            insertToAB(tree.right());
        }
    }

    public static void main(String[] args) {
        SearchBinaryTree<Account> sbt = new SearchBinaryTree<>();
        BankApi bank = new BankApi();

        Account a = new Account('A', 1);
        Account b = new Account('B', 4);
        Account c = new Account('B', 2);
        Account d = new Account('A', 7);
        Account e = new Account('B', 8);
        Account f = new Account('B', 43);
        Account g = new Account('A', 6);

        sbt.insert(a);
        sbt.insert(b);
        sbt.insert(c);
        sbt.insert(d);
        sbt.insert(e);
        sbt.insert(f);
        sbt.insert(g);


        bank.insertToAB(sbt);
        bank.A.printInOrder();
        System.out.println();
        bank.B.printInOrder();
    }
}

