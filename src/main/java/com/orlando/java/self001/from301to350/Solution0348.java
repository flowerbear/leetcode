package com.orlando.java.self001.from301to350;

/*
 * Design Tic-Tac-Toe
 *
 * Design a Tic-tac-toe game that is played between two players on a n x n grid.
 *
 * You may assume the following rules:
 *
 *   > A move is guaranteed to be valid and is placed on an empty block.
 *   > Once a winning condition is reached, no more moves is allowed.
 *   > A player who succeeds in placing n of their marks in a horizontal, vertical, or diagonal row wins the game.
 *
 */
public class Solution0348 {

  public static class TicTacToe {
    private int diagonal;
    private int antidiagonal;
    private int[] rows;
    private int[] cols;

    public TicTacToe(int n) {
      rows = new int[n];
      cols = new int[n];
    }

    public int move(int row, int col, int player) {
      int toAdd = player == 1 ? 1 : -1;
      rows[row] += toAdd;
      cols[col] += toAdd;
      int size = rows.length;

      if (row == col) {
        diagonal += toAdd;
      }
      if (col == (size - row - 1)) {
        antidiagonal += toAdd;
      }

      if (Math.abs(rows[row]) == size || Math.abs(cols[col]) == size
      || Math.abs(antidiagonal) == size || Math.abs(diagonal) == size) {
        return player;
      }
      return 0;
    }
  }
}

