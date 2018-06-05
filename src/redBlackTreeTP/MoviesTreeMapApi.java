package redBlackTreeTP;

import java.util.Scanner;
import java.util.function.Predicate;

public class MoviesTreeMapApi {

    private RedBlackTree<Movie> treeMap;
    private Scanner s;
    public MoviesTreeMapApi() {
        treeMap = null;
        s = new Scanner(System.in);
    }

    public void getFromKey(String key) {

        Movie m = treeMap.getElement(s.nextLine());
        m.toString();
    }

    public void getAmount() {
        System.out.println(treeMap.count());
    }
}
