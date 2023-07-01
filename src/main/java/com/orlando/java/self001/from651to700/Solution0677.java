package com.orlando.java.self001.from651to700;

import java.util.HashMap;

public class Solution0677 {

    private TrieNode root = new TrieNode();
    private HashMap<String, Integer> map = new HashMap<>();

    public Solution0677() {
    }

    public void insert(String key, int val) {
        int diff = val - map.getOrDefault(key, 0);
        TrieNode node = root;
        for (char c : key.toCharArray()) {
            c -= 'a';
            if (node.children[c] == null) node.children[c] = new TrieNode();
            node = node.children[c];
            node.sum += diff;
        }
        map.put(key, val);
    }

    public int sum(String prefix) {
        TrieNode node = root;
        for (char c : prefix.toCharArray()) {
            c -= 'a';
            if (node.children[c] == null) return 0;
            node = node.children[c];
        }
        return node.sum;
    }

    class TrieNode {
        int val, sum;
        TrieNode[] children;
        boolean isEnd;

        public TrieNode() {
            this.children = new TrieNode[26];
        }
    }
}

