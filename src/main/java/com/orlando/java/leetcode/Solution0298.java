package com.orlando.java.leetcode;

public class Solution0298 {

  class TrieNode {
    private TrieNode[] links;
    private final int R = 26;
    private boolean isEnd;

    public TrieNode() {
      links = new TrieNode[R];
    }

    public boolean containsKey(char ch) {
      return links[ch - 'a'] != null;
    }

    public TrieNode get(char ch) {
      return links[ch - 'a'];
    }

    public void put (char ch, TrieNode node) {
      links[ch - 'a'] = node;
    }

    public void setEnd() {
      isEnd = true;
    }

    public boolean isEnd() {
      return isEnd;
    }
  }
  private TrieNode root;

  public Solution0298() {
    root = new TrieNode();
  }

  public void insert(String word) {
    TrieNode node = root;
    for (char c : word.toCharArray()) {
      if (!node.containsKey(c)) {
        node.put(c, new TrieNode());
      }
      node = node.get(c);
    }
    node.setEnd();
  }

  public boolean search(String word) {
    TrieNode node = searchPrefix(word);
    return node != null && node.isEnd();
  }

  private TrieNode searchPrefix(String word) {
    TrieNode node = root;
    for (char c : word.toCharArray()) {
      if (node.containsKey(c)) {
        node = node.get(c);
      } else {
        return null;
      }
    }
    return node;
  }

  public boolean startsWith(String prefix) {
    TrieNode node = searchPrefix(prefix);
    return node != null;
  }
}
