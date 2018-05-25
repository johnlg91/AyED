package EquiposTP;

import java.util.HashMap;
import java.util.Map;

public class Alternative {

    private Map<String, Integer> points;
    private String results;

    Alternative() {
        this.points = new HashMap<>();
        results = "";
    }

    private Alternative(Alternative a) {
        points = new HashMap<>(a.points);
        results = a.results;
    }

    Alternative addDraw(String team1, String team2) {
        Alternative a = new Alternative(this);
        a.results += "X";
        a.addPoints(team1, 1);
        a.addPoints(team2, 1);
        return a;
    }

    Alternative addLocal(String team1, String team2) {
        Alternative a = new Alternative(this);
        a.results += "1";
        a.addPoints(team1, 3);
        a.addPoints(team2, 0);
        return a;
    }

    Alternative addVisitor(String team1, String team2) {
        Alternative a = new Alternative(this);
        a.results += "2";
        a.addPoints(team1, 0);
        a.addPoints(team2, 3);
        return a;
    }

    boolean isValid(Map<String, Integer> totalPoints) {
        for (String team : points.keySet()) {
            if (points.get(team) > totalPoints.get(team)) return false;
        }
        return true;
    }

    private void addPoints(String team, int i) {
        int n = points.getOrDefault(team, 0) + i;
        points.put(team, n);
    }


    boolean isEqual(Map<String, Integer> totalPoints) {
        return totalPoints.equals(points);
    }

    @Override
    public String toString() {
        return results;
    }
}
