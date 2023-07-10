package com.orlando.java.self001.from601to650;

import com.orlando.java.common.Trie;

public class Solution0616 {

    private class TrieNode {
        TrieNode children[] = new TrieNode[128];
        boolean isWord = false;
    }

    private TrieNode root = new TrieNode();

    private void insert(String word) {
        TrieNode node = this.root;
        for (char c : word.toCharArray()) {
            if (node.children[c] == null) node.children[c] = new TrieNode();
            node = node.children[c];
        }
        node.isWord = true;
    }

    private int find(String s, int i) {
        TrieNode node = root;
        int res = -1;
        for (int j = i; j < s.length(); j++) {
            if (node.children[s.charAt(j)] == null) return res;
            node = node.children[s.charAt(j)];
            if (node .isWord) res = j;
        }
        return res;
    }
    public String addBoldTag(String s, String[] words) {
        int n = s.length();
        StringBuilder sb = new StringBuilder();
        boolean bold[] = new boolean[n];

        for (String word : words) insert(word);

        int boldEnd = -1;
        for (int i = 0; i < n; i++) {
            boldEnd = Math.max(boldEnd, find(s, i));
            bold[i] = boldEnd >= i;
        }

        int i = 0;
        while (i < n) {
            if (bold[i]) {
                int j = i;
                while (j < n && bold[j]) j++;
                sb.append("<b>").append(s.substring(i, j)).append("</b>");
                i = j;
            } else {
                sb.append(s.charAt(i++));
            }
        }
        return sb.toString();
    }
}

