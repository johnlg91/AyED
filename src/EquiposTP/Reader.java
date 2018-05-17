package EquiposTP;

import java.util.*;

class Reader {

    private final Scanner scanner;
    private final int nTeams;
    private final int nMatches;

    Reader() {
        scanner = new Scanner(System.in);
        nTeams = scanner.nextInt();
        nMatches = scanner.nextInt();
        scanner.nextLine();
    }

    Map<String, Integer> readPoints() {
        HashMap<String, Integer> result = new HashMap<>();
        for (int i = 0; i < nTeams; i++) {
            String team = scanner.next();
            int point = scanner.nextInt();
            result.put(team, point);
        }
        return result;
    }

    List<Match> readMatches() {
        List<Match> results = new ArrayList<>();
        for (int i = 0; i < nMatches; i++) {
            String t1 = scanner.next();
            String t2 = scanner.next();
            Match m = new Match(t1, t2);
            results.add(m);
        }
        return results;
    }
}
