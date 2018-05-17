package SearchBinaryTreeTP;

import java.util.List;

public class SearchBinaryTreeLampsApi {

    private SearchBinaryTree<Lamp> sbt;

    SearchBinaryTreeLampsApi() {
        this.sbt = new SearchBinaryTree<>();
    }

    /**
     * Inserta la lista de lamparas en el arbol binario de busqueda
     *
     * @param lamps
     * @return SearchBinaryTree
     */
    void insertList(List<Lamp> lamps) {
        for (Lamp l : lamps) {
            sbt.insert(l);
        }
    }

    /**
     * Inserta una nueva lampara al arbol
     * @param l
     */
    void insertLamp(Lamp l) {
        sbt.insert(l);
    }

    /**
     * Con un codigo busca la lampara q quiere y le actualiza la cantidad
     * @param code
     * @param amount
     */
    void updateLampAmount(String code, int amount) {
        Lamp l = getLamp(code);
        l.setAmount(amount);
    }

    /**
     * Con un codigo busca la lampara q quiere y la borra del arbol
     * @param code
     */
    void removeLamp(String code) {
        Lamp l = getLamp(code);
        sbt.delete(l);
    }

    /**
     * Crea una nueva lampara q solo tiene el codigo en el constructor
     * de esa manera puede buscar la otra lamoara ya se usa el codigo para
     * compararlas entre si
     * @param code
     * @return
     */
    Lamp getLamp(String code) {
        Lamp l = new Lamp(code);
        return sbt.search(l);
    }


    /**
     *    Imprime el arbol en orden de menor a mayor
     */
    public void printInOrder() {
        sbt.printInOrder();
    }

    /**
     *  Devuelve una lista de elementos del arbol en orden de menor a mayor
     * @return la lista de elementos en el arbol en 'in order'
     */
    List<Lamp> listInOrder() {
        return sbt.listInOrder();
    }

}
