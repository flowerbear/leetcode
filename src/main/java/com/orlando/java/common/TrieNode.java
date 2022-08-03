package com.orlando.java.common;

public class TrieNode {

  boolean isLeaf;
  TrieNode[] childs;

  public TrieNode() {
    childs = new TrieNode[26];
  }
}
