package Parcial.alicia;

public class Account implements Comparable<Account> {

    private char sucursal;
    private int code;

    Account(char sucursal, int code) {
        this.sucursal = sucursal;
        this.code = code;
    }

    char getSucursal() {
        return sucursal;
    }

    @Override
    public String toString() {
        return "|Account = " + sucursal + code + '|';
    }

    @Override
    public int compareTo(Account o) {
        return code - o.code;
    }

}
