package com.orlando.java.self001.from201to250;

/*
 * Implement Trie (Prefix Tree)
 *
 * A trie (pronounced as "try") or prefix tree is a tree data structure used to efficiently store and retrieve
 * keys in a dataset of strings. There are various applications of this data structure, such as autocomplete and spellchecker.
 *
 * Implement the Trie class:
 *
 *   > Trie() Initializes the trie object.
 *   > void insert(String word) Inserts the string word into the trie.
 *   > boolean search(String word) Returns true if the string word is in the trie (i.e., was inserted before),
 *     and false otherwise.
 *   > boolean startsWith(String prefix) Returns true if there is a previously inserted string word that has the
 *     prefix prefix, and false otherwise.
 *
 */
public class Solution0208 {

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

    public void put(char ch, TrieNode node) {
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

  public Solution0208() {
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
    return node != null && node.isEnd;
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
