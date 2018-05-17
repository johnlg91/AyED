package HuffmanTP;

import java.util.PriorityQueue;
import java.util.Scanner;

public class Huffman {

    private static void printCode(HuffmanNode root, String s) {
        if (root.left == null && root.right == null && Character.isLetter(root.c)) {
            System.out.println(root.c + ":" + s);
            return;
        }
        printCode(root.left, s + 0);
        printCode(root.right, s + 0);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = 6;
        char[] chars = {'a', 'b', 'c', 'd', 'e', 'f'};
        int[] frequencys = {5, 9, 12, 13, 16, 45};

        PriorityQueue<HuffmanNode> q = new PriorityQueue<>(n, new HuffmanComparator());

        for (int i = 0; i < n; i++) {
            HuffmanNode hn = new HuffmanNode();
            hn.c = chars[i];
            hn.frequency = frequencys[i];
            q.add(hn);
        }

        HuffmanNode root = null;
        while (q.size() > 1) {
            HuffmanNode x = q.peek();
            q.poll();
            HuffmanNode y = q.peek();
            q.poll();
            HuffmanNode f = new HuffmanNode();
            f.frequency = x.frequency + y.frequency;
            f.c = '-';
            f.left = x;
            f.right = y;
            root = f;
            q.add(f);
        }

        printCode(root, "");
    }
}
