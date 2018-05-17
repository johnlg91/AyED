package HuffmanTP;

import java.util.Comparator;

class HuffmanNode {

    int frequency;
    char c;

    HuffmanNode left;
    HuffmanNode right;
}

class HuffmanComparator implements Comparator<HuffmanNode> {
    @Override
    public int compare(HuffmanNode x, HuffmanNode y) {
        return x.frequency - y.frequency;
    }
}