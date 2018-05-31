package EquiposTP;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

class ResolverBackTracking extends Resolver {
    private List<Alternative> alternatives;


    ResolverBackTracking(Map<String, Integer> points, List<Match> matches) {
        super(matches, points);
        alternatives = new ArrayList<>();
    }

    @Override
    List<Alternative> solve() {
        long start = System.nanoTime();
        solve(new Alternative(), 0);
        duration = System.nanoTime() - start;
        return alternatives;
    }

    private void solve(Alternative alternative, int matchNumber) {
        if (matchNumber >= matches.size()) {
            if (alternative.isEqual(real)) alternatives.add(alternative);
            comparisons++;
        } else {
            Match match = matches.get(matchNumber);
            for (int type = 0; type < 3; type++) {
                Alternative a = alternative.generate(type, match.team1, match.team2);
                alternativesCount++;
                if (a.isValid(real)) solve(a, matchNumber + 1);
                comparisons++;
            }
        }
    }

}
