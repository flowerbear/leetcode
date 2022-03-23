package com.orlando.java.self001.from201to250;

/*
 * Design Add and Search Words Data Structure
 *
 * Design a data structure that supports adding new words and finding if a string matches any previously added string.
 *
 * Implement the WordDictionary class:
 *
 *   > WordDictionary() Initializes the object.
 *   > void addWord(word) Adds word to the data structure, it can be matched later.
 *   > bool search(word) Returns true if there is any string in the data structure that matches word or false
 *     otherwise. word may contain dots '.' where dots can be matched with any letter.
 *
 */
public class Solution0211 {

  class TrieNode {
    char val;
    boolean isWord;
    TrieNode[] child = new TrieNode[26];

    TrieNode(char val) {
      this.val = val;
    }
  }

  TrieNode root = new TrieNode('#');

  public Solution0211() {}

  public void add(String word) {
    TrieNode node = this.root;
    for (char c : word.toCharArray()) {
      if (node.child[c - 'a'] == null) node.child[c - 'a'] = new TrieNode(c);
      node = node.child[c - 'a'];
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
            if (search(word, subChild, i + 1)) return true;
          }
        }
        return false;
      } else {
        if (node.child[key - 'a'] == null) return false;
        node = node.child[key - 'a'];
      }
    }
    return node.isWord;
  }
}
