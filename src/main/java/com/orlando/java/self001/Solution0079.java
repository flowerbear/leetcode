package com.orlando.java.self001;

/*
 * Word Search
 *
 * Given an m x n grid of characters board and a string word, return true if word exists in the grid.
 *
 * The word can be constructed from letters of sequentially adjacent cells, where adjacent cells are horizontally or
 * vertically neighboring. The same letter cell may not be used more than once.
 *
 */
public class Solution0079 {

  public boolean exist(char[][] board, String word) {
    char[] w = word.toCharArray();
    for (int y = 0; y < board.length; y++)
      for (int x = 0; x < board[0].length; x++) {
        if (exist(board, y, x, w, 0)) return true;
      }
    return false;
  }

  private boolean exist(char[][] board, int y, int x, char[] word, int i) {
    if (i == word.length) return true;

    if (y < 0 || x < 0 || y >= board.length || x >= board[y].length) return false;
    if (board[y][x] != word[i]) return false;
    board[y][x] ^= 256;
    boolean exist = exist(board, y, x + 1, word, i + 1) ||
      exist(board, y, x - 1, word, i + 1) ||
      exist(board, y + 1, x, word, i + 1) ||
      exist(board, y - 1, x, word, i + 1);
    board[y][x] ^= 256;
    return exist;
  }
}
