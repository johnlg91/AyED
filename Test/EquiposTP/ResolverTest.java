package EquiposTP;

import org.junit.Test;

import java.io.*;
import java.util.List;
import java.util.Map;

import static org.junit.Assert.*;

public class ResolverTest {
    @Test
    public void testSolve() throws IOException {
        test("test1.in", "test1.actual", "test1.expected");
        test("test6.in", "test6.actual", "test6.expected");
        test("test1.in", "test1.actual", "test1.expected");
    }

    private void test(String inName, String outName, String expectedName) throws IOException {
        File in = new File(inName);

        Reader reader = new Reader(in); // Crea un Reader para pedir los datos

        Map<String, Integer> points = reader.readPoints();// Llama un metodo del reader y recibe un mapa de equipos y sus puntos
        List<Match> matches = reader.readMatches();// LLama un metodo del Reader para recibir los partidos

        System.out.println("Testing " + inName);

        System.out.println("Brute Force");
        Resolver r = new ResolverBruteForce(points, matches);
        writeAlternatives(outName, r.solve());
        System.out.println("Time: " + r.getDuration());

        System.out.println("Backtracking");
        r = new ResolverBackTracking(points, matches);
        writeAlternatives(outName, r.solve());
        assertFiles(expectedName, outName);
        System.out.println("Time: " + r.getDuration());
        System.out.println("===================\n");
    }

    private void writeAlternatives(String outName, List<Alternative> alternatives) throws FileNotFoundException {
        File out = new File(outName);
        PrintWriter w = new PrintWriter(out);
        for (Alternative a : alternatives) {
            w.println(a);
        }
        w.close();
    }


    public static void assertFiles(String expectedName, String actualName) throws IOException {

        BufferedReader expected = new BufferedReader(new FileReader(expectedName));
        BufferedReader actual = new BufferedReader(new FileReader(actualName));
        String line;
        while ((line = expected.readLine()) != null) {
            assertEquals(line, actual.readLine());
        }

        assertNull("Actual had more lines then the expected.", actual.readLine());
        assertNull("Expected had more lines then the actual.", expected.readLine());
    }
}