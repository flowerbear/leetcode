package com.orlando.java.self001.from401to450;

import java.util.ArrayList;
import java.util.List;

public class Solution0425_New {

    public class TrieNode {
        public TrieNode[] children = new TrieNode[26];
        public List<String> startsWith = new ArrayList<>();
    }

    public class Trie {

        private TrieNode root = new TrieNode();

        public Trie(final String[] words) {
            for (final String word : words) {
                insert(word);
            }
        }

        private void insert(final String word) {
            TrieNode node = this.root;
            for (final char c : word.toCharArray()) {
                final int i = c - 'a';
                if (node.children[i] == null) {
                    node.children[i] = new TrieNode();
                }
                node = node.children[i];
                node.startsWith.add(word);
            }
        }

        public List<String> findBy(final String prefix) {
            TrieNode node = root;
            for (final char c : prefix.toCharArray()) {
                final int i = c - 'a';
                if (node.children[i] == null) {
                    return new ArrayList<>();
                }
                node = node.children[i];
            }
            return node.startsWith;
        }
    }
    public List<List<String>> wordSquares(String[] words) {
        List<List<String>> res = new ArrayList<>();
        if (words.length == 0) return res;
        final int n = words[0].length();
        List<String> path = new ArrayList<>();
        Trie trie = new Trie(words);

        for (final String word : words) {
            path.add(word);
            dfs(trie, n, path, res);
            path.remove(path.size() - 1);
        }

        return res;
    }

    private void dfs(Trie trie, final int n, List<String> path, List<List<String>> res) {
        if (path.size() == n) {
            res.add(new ArrayList<>(path));
            return;
        }
        final String prefix = getPrefix(path);
        for (final String s : trie.findBy(prefix)) {
            path.add(s);
            dfs(trie, n, path, res);
            path.remove(path.size() - 1);
        }
    }

    private String getPrefix(List<String> path) {
        StringBuilder sb = new StringBuilder();
        final int index = path.size();
        for (final String s : path) {
            sb.append(s.charAt(index));
        }
        return sb.toString();
    }
}
