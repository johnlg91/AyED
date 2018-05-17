package MorseTp;

class MorseApi {
    private BinaryTree<Character> morseTree;

    MorseApi() {
        BinaryTree<Character> empty = new BinaryTree<>();
        BinaryTree<Character> h = new BinaryTree<>('H', new BinaryTree<>('5'), new BinaryTree<>('4'));
        BinaryTree<Character> v = new BinaryTree<>('V', empty, new BinaryTree<>('3'));
        BinaryTree<Character> s = new BinaryTree<>('S', h, v);

        BinaryTree<Character> two = new BinaryTree<>(' ', empty, new BinaryTree<>('2'));
        BinaryTree<Character> f = new BinaryTree<>('F');

        BinaryTree<Character> u = new BinaryTree<>('U', f, two);
        BinaryTree<Character> i = new BinaryTree<>('I', s, u);


        BinaryTree<Character> l = new BinaryTree<>('L');
        BinaryTree<Character> plus = new BinaryTree<>(' ', new BinaryTree<>('+'), empty);

        BinaryTree<Character> r = new BinaryTree<>('R', l, plus);

        BinaryTree<Character> p = new BinaryTree<>('P');
        BinaryTree<Character> j = new BinaryTree<>('J', empty, new BinaryTree<>('1'));

        BinaryTree<Character> w = new BinaryTree<>('W', p, j);


        BinaryTree<Character> a = new BinaryTree<>('A', r, w);


        BinaryTree<Character> e = new BinaryTree<>('E', i, a);


        BinaryTree<Character> b = new BinaryTree<>('B', new BinaryTree<>('6'), new BinaryTree<>('='));
        BinaryTree<Character> x = new BinaryTree<>('X', new BinaryTree<>('/'), empty);

        BinaryTree<Character> d = new BinaryTree<>('D', b, x);


        BinaryTree<Character> k = new BinaryTree<>('K', new BinaryTree<>('C'), new BinaryTree<>('Y'));


        BinaryTree<Character> n = new BinaryTree<>('N', d, k);


        BinaryTree<Character> z = new BinaryTree<>('Z', new BinaryTree<>('7'), empty);

        BinaryTree<Character> g = new BinaryTree<>('G', z, new BinaryTree<>('Q'));


        BinaryTree<Character> eigth = new BinaryTree<>(' ', new BinaryTree<>('8'), empty);

        BinaryTree<Character> ninecero = new BinaryTree<>(' ', new BinaryTree<>('9'), new BinaryTree<>('0'));


        BinaryTree<Character> o = new BinaryTree<>('O', eigth, ninecero);


        BinaryTree<Character> m = new BinaryTree<>('M', g, o);


        BinaryTree<Character> t = new BinaryTree<>('T', n, m);


        morseTree = new BinaryTree<>(' ', e, t);


    }

    /**
     * Translate from morse to text
     * For example: "... --- ..." returns "SOS"
     *
     * @param morse The text in morse
     * @return The text in characters
     */
    String morseToText(String morse) {
        BinaryTree<Character> tree = morseTree;
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < morse.length(); i++) {
            char c = morse.charAt(i);

            switch (c) {
                case '.':
                    tree = tree.getLeft();
                    break;
                case '-':
                    tree = tree.getRight();
                    break;
                case ' ':
                    result.append(tree.getRoot());
                    tree = morseTree;
                    break;
                case '/':
                    result.append(' ');
                    break;
                default:
                    System.out.println("Illegal morse code: " + c);
            }

        }
        if (tree != morseTree) result.append(tree.getRoot());
        return result.toString();
    }

    /**
     * Translate from text to morse
     * For example: "SOS" returns "... --- ... "
     *
     * @param text The text in morse
     * @return The text in characters
     */
    String textToMorse(String text) {
        BinaryTree<Character> tree = morseTree;
        StringBuilder result = new StringBuilder();
        int i = 0;
        while (i < text.length()) {
            char c = text.charAt(i);
            if (c == ' ') {
                result.append('/');
                i++;
            }
            else if (c == tree.getRoot()) {
                result.append(' ');
                tree = morseTree;
                i++;
            }
            else if (tree.getLeft().contains(c)) {
                result.append('.');
                tree = tree.getLeft();
            }
            else if (tree.getRight().contains(c)) {
                result.append('-');
                tree = tree.getRight();
            }
        }
        return result.toString();
    }
}
