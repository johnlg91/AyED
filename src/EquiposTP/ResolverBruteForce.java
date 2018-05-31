package EquiposTP;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

class ResolverBruteForce extends Resolver {
    private List<Alternative> alternatives;


    ResolverBruteForce(Map<String, Integer> points, List<Match> matches) {
        super(matches, points);
        alternatives = new ArrayList<>();
        alternatives.add(new Alternative());
    }

    @Override
    List<Alternative> solve() {
        long start = System.nanoTime();
        // Generate all Alternatives
        for (Match match : matches)
            alternatives = addAlternatives(match.team1, match.team2);
        // Now filter only the valid ones
        alternatives = filterValid();
        duration = System.nanoTime() - start;
        return alternatives;
    }

    private List<Alternative> filterValid() {
        List<Alternative> result = new ArrayList<>();
        for (Alternative a : alternatives) {
            if (a.isEqual(real)) result.add(a);
            comparisons++;
        }
        return result;
    }

    private List<Alternative> addAlternatives(String team1, String team2) {
        List<Alternative> result = new ArrayList<>();
        for (Alternative a : alternatives) {
            for (int type = 0; type < 3; type++) {
                Alternative newAlternative = a.generate(type, team1, team2);
                alternativesCount++;
                if (newAlternative.isValid(real)) result.add(a);
                comparisons++;
            }
        }
        return result;
    }
}
