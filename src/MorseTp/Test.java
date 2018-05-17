package MorseTp;

public class Test {
    public static void main(String[] args) {
        MorseApi m = new MorseApi();
        System.out.println(m.morseToText("... --- ..."));
        String n = "SOS";
        System.out.println(m.textToMorse(n));
    }
}
