package SearchBinaryTreeTP;

public class Lamp implements Comparable<Lamp> {

    private final String code;

    private int watts;

    private String type;

    private int amount;

    /**
     * Constructor de lampara solo con codigo
     * se usa nada mas para encontrar una lampara ya existente
     *
     * @param code
     */
    Lamp(String code) {
        this.code = code;
    }

    /**
     * Constructor de la lampara
     *
     * @param code
     * @param watts
     * @param type
     * @param amount
     */
    Lamp(String code, int watts, String type, int amount) {
        this.code = code;
        this.watts = watts;
        this.type = type;
        this.amount = amount;
    }

    void setAmount(int amount) {
        this.amount = amount;
    }

    int getAmount() {
        return amount;
    }

    /**
     * El comparator de la la lampara usando el codigo como para parametro
     */
    @Override
    public int compareTo(Lamp o) {
        return code.compareTo(o.code);
    }

    /**
     * @return el codigo
     */
    @Override
    public String toString() {
        return code;
    }
}
