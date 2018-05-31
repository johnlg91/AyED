package Parcial.marcelo;

public class Ej2 {

    private String s;
    private char[] stack;
    private int lengh;
    private int arrayPos;


    public Ej2(String s) {
        this.s = s;
        stack = new char[s.length()];
        lengh = s.length();
        arrayPos = 0;
    }

    public void conditions(char c, int pos) {
        switch (stack[arrayPos]) {
            case '{':
                if (c == '}') {
                    stack[arrayPos] = ' ';
                    arrayPos--;
                    break;
                }
                arrayPos++;
                stack[arrayPos] = c;
                break;
            case '[':
                if (c == ']') {
                    stack[arrayPos] = ' ';
                    arrayPos--;
                    break;
                }
                arrayPos++;
                stack[arrayPos] = c;
                break;
            case '(':
                if (c == ')') {
                    stack[arrayPos] = ' ';
                    arrayPos--;
                    break;
                }
                arrayPos++;
                stack[arrayPos] = c;
                break;
        }

    }

    public boolean checker() {
        stack[0] = s.charAt(0);
        for (int i = 1; i < lengh; i++) {
            conditions(s.charAt(i), i);
        }
        return stack[0] == ' ';
    }

    public static void main(String[] args) {
        String s = "{{";
        Ej2 ej = new Ej2(s);
        if (ej.checker()) System.out.println("OK!");
        else System.out.println("not ok");


    }
}
