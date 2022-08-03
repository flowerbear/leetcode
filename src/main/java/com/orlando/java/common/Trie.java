package com.orlando.java.common;

public class Trie {
  TrieNode root;

  public Trie() {
    root = new TrieNode();
  }

  public void insert(String word) {
    TrieNode temp = root;
    for (char c : word.toCharArray()) {
      int cI = c - 'a';
      if (temp.childs[cI] == null)
        temp.childs[cI] = new TrieNode();
      temp = temp.childs[cI];
    }
    temp.isLeaf = true;
  }

  public boolean containers(String word) {
    TrieNode temp = root;
    for (char c : word.toCharArray()) {
      int cI = c - 'a';
      if (temp.childs[cI] == null) return false;
      temp = temp.childs[cI];
    }
    return temp.isLeaf;
  }

  public boolean hasPrefix(String word) {
    TrieNode temp = root;
    for (char c : word.toCharArray()) {
      int cI = c - 'a';
      if (temp.childs[cI] == null) return false;
      temp = temp.childs[cI];
    }
    return true;
  }
}
