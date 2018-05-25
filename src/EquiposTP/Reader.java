package EquiposTP;

import java.util.*;

class Reader {

    private final Scanner scanner;
    private final int nTeams;
    private final int nMatches;

    /**
     * Constructor del Reader q pide y recibe los numeros de equipos
     * y su cantidad de partidos
     */
    Reader() {
        scanner = new Scanner(System.in);
        System.out.println("Ingrese el numero de equipos");
        nTeams = scanner.nextInt();
        System.out.println("Ingrese el numero de partidos");
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
        System.out.println("Ingrese el equipo y sus puntos");
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
        System.out.println("Ingrese los dos euipos del partido");
        for (int i = 0; i < nMatches; i++) {
            String t1 = scanner.next();
            String t2 = scanner.next();
            Match m = new Match(t1, t2);
            results.add(m);
        }
        return results;
    }
}
