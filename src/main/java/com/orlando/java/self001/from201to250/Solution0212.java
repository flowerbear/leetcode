package com.orlando.java.self001.from201to250;

import java.util.ArrayList;
import java.util.List;

/*
 * Word Search II
 *
 * Given an m x n board of characters and a list of strings words, return all words on the board.
 *
 * Each word must be constructed from letters of sequentially adjacent cells, where adjacent cells are horizontally
 * or vertically neighboring. The same letter cell may not be used more than once in a word.
 *
 */
public class Solution0212 {

  class TrieNode {
    TrieNode[] next = new TrieNode[26];
    String word;
  }

  private TrieNode buildTrie(String[] words) {
    TrieNode root = new TrieNode();
    for (String w : words) {
      TrieNode p = root;
      for (char c : w.toCharArray()) {
        int i = c - 'a';
        if (p.next[i] == null) p.next[i] = new TrieNode();
        p = p.next[i];
      }
      p.word = w;
    }
    return root;
  }

  public List<String> findWords(char[][] board, String[] words) {
    List<String> result = new ArrayList<>();
    TrieNode root = buildTrie(words);
    for (int i = 0; i < board.length; i++) {
      for (int j = 0; j < board[0].length; j++) {
        dfs(board, i, j, root, result);
      }
    }
    return result;
  }

  private void dfs(char[][] board, int i, int j, TrieNode p, List<String> result) {
    char c = board[i][j];
    if (c == '#' || p.next[c - 'a'] == null) return;
    p = p.next[c - 'a'];
    if (p.word != null) {
      result.add(p.word);
      p.word = null;
    }

    board[i][j] = '#';
    if (i > 0) dfs(board, i - 1, j , p, result);
    if (j > 0) dfs(board, i, j - 1, p, result);
    if (i < board.length - 1) dfs(board, i + 1, j, p, result);
    if (j < board[0].length - 1) dfs(board, i, j + 1, p, result);
    board[i][j] = c;
  }
}
