package EquiposTP;

import java.util.List;

public class Test {
    public static void main(String[] args) {
        Resolver r = new Resolver();
        List<Alternative> alternatives = r.solve();
        for (Alternative a : alternatives) {
            System.out.println(a);
        }
    }
}
