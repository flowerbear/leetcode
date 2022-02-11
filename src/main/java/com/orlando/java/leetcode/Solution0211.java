package com.orlando.java.leetcode;

public class Solution0211 {

  class TrieNode {
    char val;
    boolean isWord;
    public TrieNode[] child = new TrieNode[26];

    TrieNode(char val) {
      this.val = val;
    }
  }

  TrieNode root = new TrieNode('#');

  public Solution0211() {

  }

  public void addWord(String word) {
    TrieNode node = this.root;

    for (int i = 0; i < word.length(); i++) {
      char key = word.charAt(i);
      if (node.child[key - 'a'] == null) {
        node.child[key - 'a'] = new TrieNode(key);
      }
      node = node.child[key - 'a'];
    }

    node.isWord = true;

  }

  public boolean search(String word) {
    return search(word, this.root, 0);
  }

  private boolean search(String word, TrieNode node, int pointer) {

    for (int i = pointer; i < word.length(); i++) {
      char key = word.charAt(i);

      if (key == '.') {
        for (TrieNode subChild : node.child) {
          if (subChild != null) {
            if (search(word, subChild, i + 1)) {
              return true;
            }
          }
        }
        return false;
      } else {
        if (node.child[key - 'a'] == null) {
          return false;
        }
        node = node.child[key - 'a'];
      }
    }
    return node.isWord;
  }

  public static void main(String[] args) {
    Solution0211 wordDictionary = new Solution0211();
    wordDictionary.addWord("a");
    wordDictionary.addWord("a");
    System.out.println(wordDictionary.search("."));
    System.out.println(wordDictionary.search("a"));
    System.out.println(wordDictionary.search("aa"));
    System.out.println(wordDictionary.search(".a"));
    System.out.println(wordDictionary.search("a."));
  }
}
