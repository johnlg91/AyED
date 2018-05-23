package SearchBinaryTreeTP;

import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;

public class SearchBinaryTreeLampsApiTest {
    SearchBinaryTreeLampsApi sbt = new SearchBinaryTreeLampsApi();
    Lamp a = new Lamp("a", 22, "n", 33);
    Lamp b = new Lamp("b", 256, "o", 14);
    Lamp c = new Lamp("c", 41, "p", 104);
    Lamp d = new Lamp("d", 60, "q", 55);
    Lamp e = new Lamp("e", 26, "r", 36);
    Lamp f = new Lamp("f", 53, "s", 84);
    Lamp g = new Lamp("g", 72, "t", 92);
    Lamp h = new Lamp("h", 43, "o", 82);
    List<Lamp> lamps = List.of(a, b, c, d, e, f, g);

    @Test
    public void insertList() {
        sbt.insertList(lamps);
        assertEquals(sbt.listInOrder(), List.of(a, b, c, d, e, f, g));
    }

    @Test
    public void insertLamp() {
        sbt.insertList(lamps);
        sbt.insertLamp(h);
        assertEquals(sbt.listInOrder(), List.of(a, b, c, d, e, f, g, h));
    }

    @Test
    public void updateLampAmount() {
        sbt.insertList(lamps);
        assertEquals(33, sbt.getLamp("a").getAmount());
        sbt.updateLampAmount("a", 26);
        assertEquals(26, sbt.getLamp("a").getAmount());
    }

    @Test
    public void removeLamp() {
        sbt.insertList(lamps);
        sbt.removeLamp("d");
        assertEquals(sbt.listInOrder(), List.of(a, b, c, e, f, g));
    }

    @Test
    public void getLamp() {
        sbt.insertList(lamps);
        assertEquals(sbt.getLamp("c"), c);
    }

    @Test
    public void listInOrder() {
        sbt.insertList(lamps);
        assertEquals(sbt.listInOrder(), List.of(a, b, c, d, e, f, g));
    }
}

