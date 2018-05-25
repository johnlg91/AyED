package EquiposTP;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

class Resolver {
    private final Map<String, Integer> total;
    private final List<Match> matches;
    private List<Alternative> alternatives;


    Resolver() {
        Reader reader = new Reader(); // Crea un Reader para pedir los datos
        total = reader.readPoints();// Llama un metodo del reader y recibe un mapa de equipos y sus puntos
        matches = reader.readMatches();// LLama un metodo del Reader para recibir los partidos
        alternatives = new ArrayList<>();
        alternatives.add(new Alternative());
    }

    List<Alternative> solve() {
        for (Match match : matches)
            alternatives = addAlternatives(match.team1, match.team2);
        alternatives = filterValid();
        return alternatives;
    }

    private List<Alternative> filterValid() {
        List<Alternative> result = new ArrayList<>();
        for (Alternative a : alternatives)
            if (a.isEqual(total)) result.add(a);
        return result;
    }

    private List<Alternative> addAlternatives(String team1, String team2) {
        List<Alternative> result = new ArrayList<>();
        for (Alternative a : alternatives) {
            Alternative draw = a.addDraw(team1, team2);
            if (draw.isValid(total)) result.add(draw);
            Alternative local = a.addLocal(team1, team2);
            if (local.isValid(total)) result.add(local);
            Alternative visitor = a.addVisitor(team1, team2);
            if (visitor.isValid(total)) result.add(visitor);
        }
        return result;
    }
}
