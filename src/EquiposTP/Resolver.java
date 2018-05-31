package EquiposTP;

import java.util.List;
import java.util.Map;

public abstract class Resolver {
    protected final Map<String, Integer> real;
    protected final List<Match> matches;
    protected long duration;
    protected long comparisons;
    protected long alternativesCount;

    public Resolver(List<Match> matches, Map<String, Integer> points) {
        this.matches = matches;
        this.real = points;
    }

    abstract List<Alternative> solve();

    public long getAlternativesCount() {
        return alternativesCount;
    }

    public long getComparisons() {
        return comparisons;
    }

    public long getDuration() {
        return duration;
    }
}
