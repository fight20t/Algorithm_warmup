package GreedyAlgorithm;

import java.util.*;

class HuffmanNode {
    char ch;
    int freq;
    HuffmanNode left, right;

    HuffmanNode(char ch, int freq) {
        this.ch = ch;
        this.freq = freq;
        this.left = null;
        this.right = null;
    }
}

public class HuffmanEncoding {

    public HuffmanNode buildHuffmanTree(Map<Character, Integer> frequencyMap) {
        PriorityQueue<HuffmanNode> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a.freq));
        for (Map.Entry<Character, Integer> entry : frequencyMap.entrySet()) {
            pq.add(new HuffmanNode(entry.getKey(), entry.getValue()));
        }

        while (pq.size() > 1) {
            HuffmanNode left = pq.poll();
            HuffmanNode right = pq.poll();
            HuffmanNode parent = new HuffmanNode('\0', left.freq + right.freq);
            parent.left = left;
            parent.right = right;
            pq.add(parent);
        }
        return pq.poll();
    }

    public Map<Character, String> buildCodeTable(HuffmanNode root) {
        Map<Character, String> codeTable = new HashMap<>();
        buildCodeTableHelper(root, "", codeTable);
        return codeTable;
    }

    private void buildCodeTableHelper(HuffmanNode node, String code, Map<Character, String> codeTable) {
        if (node == null) {
            return;
        }
        if (node.left == null && node.right == null) {
            codeTable.put(node.ch, code);
        }
        buildCodeTableHelper(node.left, code + "0", codeTable);
        buildCodeTableHelper(node.right, code + "1", codeTable);
    }

    public String encode(String input, Map<Character, String> codeTable) {
        StringBuilder encoded = new StringBuilder();
        for (char c : input.toCharArray()) {
            encoded.append(codeTable.get(c));
        }
        return encoded.toString();
    }

    public static void main(String[] args) {
        String input = "this is an example for huffman encoding";
        Map<Character, Integer> frequencyMap = new HashMap<>();
        for (char c : input.toCharArray()) {
            frequencyMap.put(c, frequencyMap.getOrDefault(c, 0) + 1);
        }

        HuffmanEncoding huffmanEncoding = new HuffmanEncoding();
        HuffmanNode root = huffmanEncoding.buildHuffmanTree(frequencyMap);
        Map<Character, String> codeTable = huffmanEncoding.buildCodeTable(root);
        String encodedString = huffmanEncoding.encode(input, codeTable);

        System.out.println("Encoded String: " + encodedString);
    }
}