package com.orlando.java.self001.from601to650;

import java.util.List;

public class Solution0648 {

    public String replaceWords(List<String> dictionary, String sentence) {
        TrieNode trie = buildTrie(dictionary);
        String[] tokens = sentence.split(" ");
        return helper(tokens, trie);
    }

    private String helper(String[] tokens, TrieNode trie) {
        StringBuilder sb = new StringBuilder();
        for (String token : tokens) {
            sb.append(getShortestReplacement(token, trie)).append(" ");
        }
        return sb.substring(0, sb.length() - 1);
    }

    private String getShortestReplacement(String token, TrieNode trie) {
        TrieNode node = trie;
        StringBuilder sb = new StringBuilder();
        for (char c : token.toCharArray()) {
            sb.append(c);
            if (node.children[c - 'a'] == null) return token;
            else {
                if (node.children[c - 'a'].isEnd) return sb.toString();
            }
            node = node.children[c - 'a'];
        }
        return token;
    }

    private TrieNode buildTrie(List<String> dict) {
        TrieNode root = new TrieNode();
        for (String s : dict) {
            TrieNode node = root;
            for (char c : s.toCharArray()) {
                if (node.children[c - 'a'] == null) node.children[c - 'a'] = new TrieNode();
                node = node.children[c - 'a'];
            }
            node.isEnd = true;
        }
        return root;
    }

    class TrieNode {
        TrieNode[] children;
        boolean isEnd;

        public TrieNode() {
            this.children = new TrieNode[26];
        }
    }
}

