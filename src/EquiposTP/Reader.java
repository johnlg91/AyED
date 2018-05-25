package EquiposTP;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.InputStreamReader;
import java.util.*;

class Reader {

    private final Scanner scanner;
    private final int nTeams;
    private final int nMatches;

    /**
     * Constructor del Reader q pide y recibe los numeros de equipos
     * y su cantidad de partidos
     */
    Reader(File file) throws FileNotFoundException {
        scanner = new Scanner(file);
        nTeams = scanner.nextInt();
        nMatches = scanner.nextInt();
        scanner.nextLine();
    }

    /**
     * Recibe los inputs
     * Crea un mapa con el equipo de key y el puntaje de valor
     * @return devuelve el mapa
     */
    Map<String, Integer> readPoints() {
        HashMap<String, Integer> result = new HashMap<>();
        for (int i = 0; i < nTeams; i++) {
            String team = scanner.next();
            int point = scanner.nextInt();
            result.put(team, point);
        }
        return result;
    }

    /**
     * Recibe los inputs
     * Crea una lista de Matche(team1,team2)
     * @return devuelve la lista
     */
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
