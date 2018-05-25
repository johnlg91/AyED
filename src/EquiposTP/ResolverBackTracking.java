package EquiposTP;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

class ResolverBackTracking extends Resolver {
    private List<Alternative> alternatives;


    ResolverBackTracking(Map<String, Integer> points, List<Match> matches) {
        super(matches, points);
        alternatives = new ArrayList<>();
        alternatives.add(new Alternative());
    }

    @Override
    List<Alternative> solve() {
        long start = System.nanoTime();
        for (Match match : matches)
            alternatives = addAlternatives(match.team1, match.team2);
        alternatives = filterValid();
        duration = System.nanoTime() - start;
        return alternatives;
    }

    private List<Alternative> filterValid() {
        List<Alternative> result = new ArrayList<>();
        for (Alternative a : alternatives)
            if (a.isEqual(real)) result.add(a);
        return result;
    }

    private List<Alternative> addAlternatives(String team1, String team2) {
        List<Alternative> result = new ArrayList<>();
        for (Alternative a : alternatives) {
            Alternative draw = a.addDraw(team1, team2);
            if (draw.isValid(real)) result.add(draw);
            Alternative local = a.addLocal(team1, team2);
            if (local.isValid(real)) result.add(local);
            Alternative visitor = a.addVisitor(team1, team2);
            if (visitor.isValid(real)) result.add(visitor);
        }
        return result;
    }
}
